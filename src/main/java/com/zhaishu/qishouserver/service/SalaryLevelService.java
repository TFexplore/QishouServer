package com.zhaishu.qishouserver.service;

import com.zhaishu.qishouserver.entity.SalaryLevel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.List;

/**
 * 员工薪酬奖罚条件模板(SalaryLevel)表服务接口
 *
 * @author makejava
 * @since 2022-07-08 15:21:32
 */
public interface SalaryLevelService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    SalaryLevel queryById(Integer id);


    SalaryLevel queryByEmId(Integer id);

    List<SalaryLevel> getList(SalaryLevel salaryLevel, Integer limit, Integer offset);

    int count(SalaryLevel salaryLevel);

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
