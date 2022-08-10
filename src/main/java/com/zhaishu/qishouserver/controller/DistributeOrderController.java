package com.zhaishu.qishouserver.controller;

import com.zhaishu.qishouserver.Security.UserToken;
import com.zhaishu.qishouserver.Vo.OrderVo;
import com.zhaishu.qishouserver.common.ResultResponse;
import com.zhaishu.qishouserver.common.RuntimeExceptions;
import com.zhaishu.qishouserver.entity.ConfigBRider;
import com.zhaishu.qishouserver.entity.DistributeOrder;
import com.zhaishu.qishouserver.entity.TGoodsSs;
import com.zhaishu.qishouserver.service.DistributeOrderService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * 骑手配送信息表(DistributeOrder)表控制层
 *
 * @author makejava
 * @since 2022-04-18 19:22:40
 */
@RestController
@RequestMapping("distributeOrder")
@Api(tags = "AA配送订单表", description = "")
public class DistributeOrderController {
    /**
     * 服务对象
     */
    @Resource
    private DistributeOrderService distributeOrderService;

    @PostMapping("/getOrders")
    @ApiOperation(value = "获取订单列表", notes = "传入orderVo 进行筛选：可筛选项：{\n" +
            "  \"apartmentId\": 27,\n" +
            "  \"buyerName\": \"张海军\",\n" +
            "  \"buyerPhone\": \"4725\",\n" +
            "  \"completeTime\": 1653915382000,\n" +
            "  \"payTime\": 1653130500000,\n" +
            "  \"rider\": {\n" +
            "    \"riderId\": 28\n" +
            "  },\n" +
            "  \"statusCode\": 12\n" +
            "}\n状态码：12待支付，13代认领，14待出库，15正在出库，16配送中，17已完成，18已失效，702待商家接单，703待骑手接单，707待收货，710待评价")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "token", value = "Token", required = true, dataTypeClass = String.class, paramType = "header")
    })
    @UserToken.Sales
    public ResultResponse getOrders(@RequestBody OrderVo orderVo,Integer limit,Integer offset){
        if (orderVo.getPayTime()!=null&&orderVo.getCompleteTime()==null){
            return ResultResponse.error("400","请传入结束时间：completeTime");
        }
        if (orderVo.getRider()!=null&&orderVo.getRider().getRiderId()==null){
            return ResultResponse.error("400","请传入骑手工号 rider.riderId");
        }
        //参数校验
        if (limit==null||offset==null){
            return ResultResponse.error("400","缺少参数:limit ,offset");
        }


        return  ResultResponse.resultMap(this.distributeOrderService.countOrders(orderVo),
                                distributeOrderService.getOrdersAll(orderVo, limit, offset));
    }
    @PostMapping("/editOrders")
    @ApiOperation(value = "修改订单信息", notes = "传入orderId,statusCode 指派传入riderId，商家接单传入shopId，" +
            "必须以list的形式传入，支持批量更新," +
            "\n状态码：12待支付，13代认领，14待出库，15正在出库，16配送中，17已完成，18已失效，702待商家接单，703待骑手接单，707待收货，710待评价")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "token", value = "Token", required = true, dataTypeClass = String.class, paramType = "header")
    })
    @UserToken.Sales
    public ResultResponse editOrders(@RequestBody List<OrderVo> orderVos){
        int i=0;
        OrderVo org,vo;
        vo=new OrderVo();
        StringBuilder res= new StringBuilder();
        for (OrderVo orderVo:
        orderVos) {
            if (orderVo.getOrderId()==null){
                return ResultResponse.error("400","请传入订单编号 orderId,index="+i);
            }
            if (orderVo.getRider()!=null&&orderVo.getRider().getRiderId()==null){
                return ResultResponse.error("400","请传入骑手工号 rider.riderId,index="+i);
            }
            vo.setOrderId(orderVo.getOrderId());
            org=distributeOrderService.getOrdersAll(vo,1,0).get(0);
            if (org==null){

                res.append("订单:").append(orderVo.getOrderId()).append("不存在\n");
                continue;
            }
            if (orderVo.getRider()!=null){//指派骑手

                if(org.getRider()!=null){
                    res.append("订单:").append(orderVo.getOrderId()).append("状态已发生改变，更新失败\n");
                continue;
                }
            }
            if (orderVo.getShopId()!=null){//认领订单
                if (org.getShopId()!=null){
                    res.append("订单:").append(orderVo.getOrderId()).append("状态已发生改变，更新失败\n");
                    continue;
                }

            }
            if (distributeOrderService.updateOrders(orderVo)!=1){
                res.append("订单:").append(orderVo.getOrderId()).append("更新失败,系统错误\n");
                continue;
            }
            i++;

        }
        return ResultResponse.resultSuccess("更新成功: "+i+" "+res);
    }

    @PostMapping("/getOrderDetail")
    @ApiOperation(value = "获取订单商品列表", notes = "传入orderId")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "token", value = "Token", required = true, dataTypeClass = String.class, paramType = "header")
    })
    @UserToken.Sales
    public ResultResponse getOrderDetail(Integer orderId){
        List<TGoodsSs> list=distributeOrderService.getGoodsList(orderId);
        if (list.size()==0){
            throw new RuntimeExceptions("404","未查询到相关订单信息，请确认订单id或者联系管理员");
        }
    return ResultResponse.resultSuccess(list);
    }
    @GetMapping("/getDistribute")
    @ApiOperation(value = "获取配送消息", notes = "传入orderId，整型，不是订单编号")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "token", value = "Token", required = true, dataTypeClass = String.class, paramType = "header")
    })
    @UserToken.Sales
    public ResultResponse getDistribute(Integer orderId){
        DistributeOrder order=distributeOrderService.queryById(orderId);
        if (order==null){
            return ResultResponse.error("404","not found");

        }
        return ResultResponse.resultSuccess(order);
    }
    @PostMapping("/refund")
    @ApiOperation(value = "退款处理", notes = "传入orderId,是否同意退款：1同意，0拒绝")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "token", value = "Token", required = true, dataTypeClass = String.class, paramType = "header")
    })
    @UserToken.Sales
    public ResultResponse refund(Integer orderId,Boolean bool){




        return ResultResponse.resultSuccess("success");
    }
    @PostMapping("/award")
    @ApiOperation(value = "纳入奖惩", notes = "传入orderId,奖惩类型：1超时/准时，2好评/差评")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "token", value = "Token", required = true, dataTypeClass = String.class, paramType = "header")
    })
    @UserToken.Sales
    public ResultResponse award(Integer orderId,Integer type){




        return ResultResponse.resultSuccess("success");
    }


    @PostMapping("/pushCancel")
    @ApiOperation(value = "取消订单通知", notes = "传入orderId")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "token", value = "Token", required = true, dataTypeClass = String.class, paramType = "header")
    })
    @UserToken.PassToken
    public ResultResponse pushCancel(Integer orderId){




        return ResultResponse.resultSuccess("");
    }
    @PostMapping("/messages")
    @ApiOperation(value = "消息通知接口", notes = "传入消息Id")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "token", value = "Token", required = true, dataTypeClass = String.class, paramType = "header")
    })
    @UserToken.PassToken
    public ResultResponse messages(Integer messagesId){




        return ResultResponse.resultSuccess("");
    }
    @PostMapping("/orderIn")
    @ApiOperation(value = "订单通知", notes = "传入订单Id")
    @UserToken.PassToken
    public ResultResponse orderIn(String orderCode){
        OrderVo orderVo=new OrderVo();
        orderVo.setOrderId(orderCode);
        orderVo.setStatusCode(703);
        distributeOrderService.updateOrders(orderVo);

        return ResultResponse.resultSuccess("success");
    }


}

