package com.zhaishu.qishouserver.service;

import com.zhaishu.qishouserver.Vo.RiderSalaryVo;
import com.zhaishu.qishouserver.entity.EmployeeSalary;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.List;

/**
 * 员工薪资表(EmployeeSalary)表服务接口
 *
 * @author makejava
 * @since 2022-07-11 15:58:00
 */
public interface EmployeeSalaryService {


    EmployeeSalary queryByMonth(Integer monthId, Integer employeeId);

    List<RiderSalaryVo> getRiderSalaryList(RiderSalaryVo salaryVo, Integer limit, Integer offset);

    int countList(RiderSalaryVo salaryVo);

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    EmployeeSalary queryById(Integer id);

    /**
     * 分页查询
     *
     * @param employeeSalary 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    Page<EmployeeSalary> queryByPage(EmployeeSalary employeeSalary, PageRequest pageRequest);

    /**
     * 新增数据
     *
     * @param employeeSalary 实例对象
     * @return 实例对象
     */
    EmployeeSalary insert(EmployeeSalary employeeSalary);

    /**
     * 修改数据
     *
     * @param employeeSalary 实例对象
     * @return 实例对象
     */
    EmployeeSalary update(EmployeeSalary employeeSalary);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Integer id);

}
