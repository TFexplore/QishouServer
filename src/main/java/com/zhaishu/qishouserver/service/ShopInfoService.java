package com.zhaishu.qishouserver.service;

import com.zhaishu.qishouserver.entity.ShopInfo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.List;

/**
 * 商铺信息表(ShopInfo)表服务接口
 *
 * @author makejava
 * @since 2022-05-26 11:13:09
 */
public interface ShopInfoService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    ShopInfo queryById(Integer id);


    List<ShopInfo> queryAllByLimit(ShopInfo shopInfo, Integer limit, Integer offset);

    int count(ShopInfo info);

    /**
     * 新增数据
     *
     * @param shopInfo 实例对象
     * @return 实例对象
     */
    ShopInfo insert(ShopInfo shopInfo);

    /**
     * 修改数据
     *
     * @param shopInfo 实例对象
     * @return 实例对象
     */
    ShopInfo update(ShopInfo shopInfo);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Integer id);

}
