package com.zhaishu.qishouserver.service;

import com.zhaishu.qishouserver.entity.DistributeBill;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

/**
 * 骑手配送账单表(DistributeBill)表服务接口
 *
 * @author makejava
 * @since 2022-04-18 19:21:34
 */
public interface DistributeBillService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    DistributeBill queryById(Integer id);

    /**
     * 分页查询
     *
     * @param distributeBill 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    Page<DistributeBill> queryByPage(DistributeBill distributeBill, PageRequest pageRequest);

    /**
     * 新增数据
     *
     * @param distributeBill 实例对象
     * @return 实例对象
     */
    DistributeBill insert(DistributeBill distributeBill);

    /**
     * 修改数据
     *
     * @param distributeBill 实例对象
     * @return 实例对象
     */
    DistributeBill update(DistributeBill distributeBill);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Integer id);

}
