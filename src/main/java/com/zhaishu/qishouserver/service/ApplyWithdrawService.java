package com.zhaishu.qishouserver.service;

import com.zhaishu.qishouserver.entity.ApplyWithdraw;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

/**
 * (ApplyWithdraw)表服务接口
 *
 * @author makejava
 * @since 2022-04-18 19:15:59
 */
public interface ApplyWithdrawService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    ApplyWithdraw queryById(Integer id);

    /**
     * 分页查询
     *
     * @param applyWithdraw 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    Page<ApplyWithdraw> queryByPage(ApplyWithdraw applyWithdraw, PageRequest pageRequest);

    /**
     * 新增数据
     *
     * @param applyWithdraw 实例对象
     * @return 实例对象
     */
    ApplyWithdraw insert(ApplyWithdraw applyWithdraw);

    /**
     * 修改数据
     *
     * @param applyWithdraw 实例对象
     * @return 实例对象
     */
    ApplyWithdraw update(ApplyWithdraw applyWithdraw);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Integer id);

}
