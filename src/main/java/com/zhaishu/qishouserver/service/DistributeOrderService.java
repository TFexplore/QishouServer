package com.zhaishu.qishouserver.service;

import com.zhaishu.qishouserver.entity.DistributeOrder;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

/**
 * 骑手配送信息表(DistributeOrder)表服务接口
 *
 * @author makejava
 * @since 2022-04-18 19:22:40
 */
public interface DistributeOrderService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    DistributeOrder queryById(Integer id);

    /**
     * 分页查询
     *
     * @param distributeOrder 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    Page<DistributeOrder> queryByPage(DistributeOrder distributeOrder, PageRequest pageRequest);

    /**
     * 新增数据
     *
     * @param distributeOrder 实例对象
     * @return 实例对象
     */
    DistributeOrder insert(DistributeOrder distributeOrder);

    /**
     * 修改数据
     *
     * @param distributeOrder 实例对象
     * @return 实例对象
     */
    DistributeOrder update(DistributeOrder distributeOrder);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Integer id);

}
