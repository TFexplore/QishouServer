package com.zhaishu.qishouserver.service;

import com.zhaishu.qishouserver.entity.AddrShop;
import java.util.List;

/**
 * (AddrShop)表服务接口
 *
 * @author makejava
 * @since 2022-08-10 09:37:53
 */
public interface AddrShopService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    AddrShop queryById(Integer id);

    /**
     * 分页查询
     *
     * @param addrShop 筛选条件
     * @return 查询结果
     */
    List<AddrShop> queryByPage(AddrShop addrShop, Integer offset,Integer limit);

    /**
     * 新增数据
     *
     * @param addrShop 实例对象
     * @return 实例对象
     */
    AddrShop insert(AddrShop addrShop);

    /**
     * 修改数据
     *
     * @param addrShop 实例对象
     * @return 实例对象
     */
    AddrShop update(AddrShop addrShop);
    
    int count(AddrShop addrShop);
    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Integer id);
    
    

}
