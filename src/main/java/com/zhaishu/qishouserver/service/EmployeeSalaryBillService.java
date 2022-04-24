package com.zhaishu.qishouserver.service;

import com.zhaishu.qishouserver.entity.EmployeeSalaryBill;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

/**
 * (EmployeeSalaryBill)表服务接口
 *
 * @author makejava
 * @since 2022-04-18 19:22:40
 */
public interface EmployeeSalaryBillService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    EmployeeSalaryBill queryById(Long id);

    /**
     * 分页查询
     *
     * @param employeeSalaryBill 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    Page<EmployeeSalaryBill> queryByPage(EmployeeSalaryBill employeeSalaryBill, PageRequest pageRequest);

    /**
     * 新增数据
     *
     * @param employeeSalaryBill 实例对象
     * @return 实例对象
     */
    EmployeeSalaryBill insert(EmployeeSalaryBill employeeSalaryBill);

    /**
     * 修改数据
     *
     * @param employeeSalaryBill 实例对象
     * @return 实例对象
     */
    EmployeeSalaryBill update(EmployeeSalaryBill employeeSalaryBill);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Long id);

}
