package com.zhaishu.qishouserver.service.impl;

import com.google.gson.Gson;
import com.zhaishu.qishouserver.Vo.OrderVo;
import com.zhaishu.qishouserver.Vo.ShipRiderVo;
import com.zhaishu.qishouserver.common.Result;
import com.zhaishu.qishouserver.common.Utils;
import com.zhaishu.qishouserver.dao.ConfigBRiderDao;
import com.zhaishu.qishouserver.dao.RiderDao;
import com.zhaishu.qishouserver.dao.TOrderRecordDao;
import com.zhaishu.qishouserver.entity.*;
import com.zhaishu.qishouserver.dao.DistributeOrderDao;
import com.zhaishu.qishouserver.http.OkHttpCli;
import com.zhaishu.qishouserver.service.DistributeOrderService;
import com.zhaishu.qishouserver.service.MessageService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.RandomUtils;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * 骑手配送信息表(DistributeOrder)表服务实现类
 *
 * @author makejava
 * @since 2022-04-18 19:22:40
 */
@Service("distributeOrderService")
@Slf4j
public class DistributeOrderServiceImpl implements DistributeOrderService {
    @Resource
    private DistributeOrderDao distributeOrderDao;
    @Resource
    private TOrderRecordDao recordDao;
    @Resource
    private ConfigBRiderDao configDao;

    @Resource
    private RiderDao riderDao;

    @Resource
    private MessageService messageService;
    @Resource
    private OkHttpCli okHttp;

    @Override
    public List<TGoodsSs> getGoodsList(Integer orderId) {
        return distributeOrderDao.getGoodsList(orderId);
    }

    @Override
    public List<OrderVo> getOrdersAll(OrderVo orderVo, Integer limit, Integer offset) {
        return distributeOrderDao.getOrdersAll(orderVo, limit, offset);
    }

    @Override
    public int countOrders(OrderVo orderVo) {

        return distributeOrderDao.countOrders(orderVo);
    }
    @Override
    public int countOrdersOnDeal(OrderVo orderVo){
        return distributeOrderDao.countOrdersOnDeal(orderVo);

    }
    @Override
    @Transactional
    public int updateOrders(OrderVo orderVo) {
        OrderVo orgOrder = new OrderVo();
        orgOrder.setOrderId(orderVo.getOrderId());
        orgOrder = distributeOrderDao.getOrdersAll(orgOrder, 1, 0).get(0);
        if (orderVo.getStatusCode() != null) {

            TOrderRecord record = new TOrderRecord();
            record.setOrderCode(orderVo.getOrderId());
            record.setCreateTime(System.currentTimeMillis());
            record.setStatus(orderVo.getStatusCode().longValue());

            //查询是否自动指派骑手
            ConfigBRider config = new ConfigBRider();
            config.setShopId(100101);
            config.setCode(1005);
           ConfigBRider configBRider= configDao.queryByLimit(config).get(0);
            if (orderVo.getStatusCode() == 703) {//商家接单后改状态为待骑手接单，指派订单
                record.setStatus(703L);
                record.setDetail("商家指派订单");
                if (configBRider.getValue().intValue() == 1//自动指派骑手
                        ||orgOrder.getRider()!=null) {//拒单再指派
                    Rider rider = new Rider();
                    rider.setIsOnline(8);
                    rider.setIsDelete(0);
                    rider.setLocationId(orgOrder.getApartmentId());
                    List<Rider> list = riderDao.queryByLimit(rider);//获取楼栋上班骑手列表
                    if (list.size()>1){
                        rider = list.get(RandomUtils.nextInt(0, list.size()));//随机获得指派骑手
                        if (orgOrder.getRider()!=null
                                && orgOrder.getRider().getRiderId().equals(rider.getEmployeeId())){//拒单再指派 orgOrder.getRider().getRiderId().intValue()==rider.getEmployeeId().intValue()
                           do {
                               rider = list.get(RandomUtils.nextInt(0, list.size()));

                           }while (rider.getEmployeeId().equals(orgOrder.getRider().getRiderId()));


                        }//避免拒单重复指派
                        ShipRiderVo vo = new ShipRiderVo();
                        vo.setRiderId(rider.getEmployeeId());
                        orderVo.setRider(vo);
                        createMessage(orgOrder,orderVo);  //生成推送消息
                    }else if (list.size()==1){//只有一个上班骑手
                        rider=list.get(0);
                        ShipRiderVo vo = new ShipRiderVo();
                        vo.setRiderId(rider.getEmployeeId());
                        orderVo.setRider(vo);
                        createMessage(orgOrder,orderVo);  //生成推送消息
                    }else if (orderVo.getRider()!=null){//手动指派
                        createMessage(orgOrder,orderVo);
                    }

                }

            }else if (orderVo.getStatusCode()==13){
                //商家选择出库后转为待认领状态，生成出库记录
                createMessage(orgOrder,orderVo);//生成推送消息
                record.setStatus(14L);
                record.setDetail("商品出库");

            }else if (orderVo.getStatusCode()==16){
                record.setStatus(13L);
                record.setDetail("骑手认领");

            }else if (orderVo.getStatusCode()==707){
                record.setStatus(16L);
                record.setDetail("骑手已送达");
            }else if (orderVo.getStatusCode()==710){
                record.setStatus(710L);
                record.setDetail("买家确认收货");
            }else if (orderVo.getStatusCode()==17){
                record.setStatus(17L);
                record.setDetail("订单已完成");
            }

            recordDao.insert(record);//生成接单记录
        }


        return this.distributeOrderDao.updateOrders(orderVo);
    }
    void createMessage(OrderVo orgOrder,OrderVo orderVo){
        //生成接单推送信息
        Message message=new Message();

        if (orderVo.getStatusCode()==703){
            message.setEmployeeId(orderVo.getRider().getRiderId());
            message.setContent("尾号" + orgOrder.getBuyerPhone().substring(7) + "买家已经下单，请前往接单中心进行操作"
            );
        }else if (orderVo.getStatusCode()==13){
            message.setEmployeeId(orgOrder.getRider().getRiderId());
            message.setContent("尾号" + orgOrder.getBuyerPhone().substring(7) + "买家订单已出库，请前往接单中心进行操作");
        }

        message.setOrderCode(orderVo.getOrderId());
        message.setMessageType(2);
        message.setPushTime(System.currentTimeMillis());
        message.setTitle("【订单消息】");
        message.setStatus(0);
        message.setMessageId(Utils.getShortId(8));
        if (messageService.queryById(message.getMessageId())!=null){
            message.setMessageId(Utils.getShortId(8)+1);
        }
        messageService.insert(message);
        messageService.pushMessage(message.getMessageId());


    }


    @Override
    public List<DistributeOrder> queryAllByMap(DistributeOrder distributeOrder){

        return distributeOrderDao.queryAllByMap(distributeOrder);
    }
    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public DistributeOrder queryById(Integer id) {
        return this.distributeOrderDao.queryById(id);
    }

    /**
     * 分页查询
     *
     * @param distributeOrder 筛选条件
     * @param pageRequest     分页对象
     * @return 查询结果
     */
    @Override
    public Page<DistributeOrder> queryByPage(DistributeOrder distributeOrder, PageRequest pageRequest) {
        long total = this.distributeOrderDao.count(distributeOrder);
        return new PageImpl<>(this.distributeOrderDao.queryAllByLimit(distributeOrder, pageRequest), pageRequest, total);
    }

    /**
     * 新增数据
     *
     * @param distributeOrder 实例对象
     * @return 实例对象
     */
    @Override
    public DistributeOrder insert(DistributeOrder distributeOrder) {
        this.distributeOrderDao.insert(distributeOrder);
        return distributeOrder;
    }

    /**
     * 修改数据
     *
     * @param distributeOrder 实例对象
     * @return 实例对象
     */
    @Override
    public DistributeOrder update(DistributeOrder distributeOrder) {


        this.distributeOrderDao.update(distributeOrder);
        return this.queryById(distributeOrder.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.distributeOrderDao.deleteById(id) > 0;
    }
}
