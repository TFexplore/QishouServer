package com.zhaishu.qishouserver.service;

import com.zhaishu.qishouserver.entity.SalaryLevel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

/**
 * 员工薪酬等级表(SalaryLevel)表服务接口
 *
 * @author makejava
 * @since 2022-04-18 19:22:41
 */
public interface SalaryLevelService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    SalaryLevel queryById(Integer id);

    /**
     * 分页查询
     *
     * @param salaryLevel 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    Page<SalaryLevel> queryByPage(SalaryLevel salaryLevel, PageRequest pageRequest);

    /**
     * 新增数据
     *
     * @param salaryLevel 实例对象
     * @return 实例对象
     */
    SalaryLevel insert(SalaryLevel salaryLevel);

    /**
     * 修改数据
     *
     * @param salaryLevel 实例对象
     * @return 实例对象
     */
    SalaryLevel update(SalaryLevel salaryLevel);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Integer id);

}
