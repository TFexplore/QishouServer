package com.zhaishu.qishouserver.service;

import com.zhaishu.qishouserver.Vo.ApplyDrawVo;
import com.zhaishu.qishouserver.entity.ApplyWithdraw;
import java.util.List;

/**
 * (ApplyWithdraw)表服务接口
 *
 * @author makejava
 * @since 2022-08-06 11:21:07
 */
public interface ApplyWithdrawService {

    Double getAmountByDate(Integer flag, Long startTime, Long endTime);

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    ApplyWithdraw queryById(String id);

    /**
     * 分页查询
     *
     * @param applyWithdraw 筛选条件
     * @return 查询结果
     */
    List<ApplyDrawVo> queryByPage(ApplyDrawVo applyWithdraw, Integer offset, Integer limit);

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
    
    int count(ApplyWithdraw applyWithdraw);
    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Integer id);
    
    

}
