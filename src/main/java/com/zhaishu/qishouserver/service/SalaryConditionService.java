package com.zhaishu.qishouserver.service;

import com.zhaishu.qishouserver.entity.SalaryCondition;
import org.springframework.data.domain.PageRequest;

import java.util.List;

/**
 * (SalaryCondition)表服务接口
 *
 * @author makejava
 * @since 2022-07-08 15:24:32
 */
public interface SalaryConditionService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    SalaryCondition queryById(Integer id);

    /**
     * 分页查询
     *
     * @param salaryCondition 筛选条件
     * @return 查询结果
     */
    List<SalaryCondition> queryByPage(SalaryCondition salaryCondition,Integer limit,Integer offset);

    int count(SalaryCondition salaryCondition);

    /**
     * 新增数据
     *
     * @param salaryCondition 实例对象
     * @return 实例对象
     */
    SalaryCondition insert(SalaryCondition salaryCondition);

    /**
     * 修改数据
     *
     * @param salaryCondition 实例对象
     * @return 实例对象
     */
    SalaryCondition update(SalaryCondition salaryCondition);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Integer id);

}
