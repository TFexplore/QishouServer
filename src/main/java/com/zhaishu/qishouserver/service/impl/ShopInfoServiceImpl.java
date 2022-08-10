package com.zhaishu.qishouserver.service.impl;

import com.zhaishu.qishouserver.entity.ShopInfo;
import com.zhaishu.qishouserver.dao.ShopInfoDao;
import com.zhaishu.qishouserver.service.ShopInfoService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 商铺信息表(ShopInfo)表服务实现类
 *
 * @author makejava
 * @since 2022-05-26 11:13:09
 */
@Service("shopInfoService")
public class ShopInfoServiceImpl implements ShopInfoService {
    @Resource
    private ShopInfoDao shopInfoDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public ShopInfo queryById(Integer id) {
        return this.shopInfoDao.queryById(id);
    }

    /**
     * 分页查询
     *
     * @param shopInfo 筛选条件
     * @return 查询结果
     */
    @Override
    public List<ShopInfo> queryAllByLimit(ShopInfo shopInfo, Integer limit, Integer offset){

        return this.shopInfoDao.queryAllByLimit(shopInfo, limit, offset);
    }
    @Override
    public int count(ShopInfo info){
        return this.shopInfoDao.count(info);
    }

    /**
     * 新增数据
     *
     * @param shopInfo 实例对象
     * @return 实例对象
     */
    @Override
    public ShopInfo insert(ShopInfo shopInfo) {
        Integer no=this.shopInfoDao.maxId();
        if (no==null){
            no=100100;
        }
        no=no+1;
        shopInfo.setShopId(no);
        this.shopInfoDao.insert(shopInfo);
        return shopInfo;
    }

    /**
     * 修改数据
     *
     * @param shopInfo 实例对象
     * @return 实例对象
     */
    @Override
    public ShopInfo update(ShopInfo shopInfo) {
        this.shopInfoDao.update(shopInfo);
        return this.queryById(shopInfo.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.shopInfoDao.deleteById(id) > 0;
    }
}
