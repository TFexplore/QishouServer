package com.zhaishu.qishouserver.service;

import com.zhaishu.qishouserver.entity.EmployeeWalletBill;

import java.util.List;

/**
 * (EmployeeWalletBill)表服务接口
 *
 * @author makejava
 * @since 2022-08-03 18:11:35
 */
public interface EmployeeWalletBillService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    EmployeeWalletBill queryById(Long id);

    /**
     * 分页查询
     *
     * @param employeeWalletBill 筛选条件
     * @return 查询结果
     */
    List<EmployeeWalletBill> queryByPage(EmployeeWalletBill employeeWalletBill, Integer offset, Integer limit);

    /**
     * 新增数据
     *
     * @param employeeWalletBill 实例对象
     * @return 实例对象
     */
    EmployeeWalletBill insert(EmployeeWalletBill employeeWalletBill);

    /**
     * 修改数据
     *
     * @param employeeWalletBill 实例对象
     * @return 实例对象
     */
    EmployeeWalletBill update(EmployeeWalletBill employeeWalletBill);
    
    int count(EmployeeWalletBill employeeWalletBill);
    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Long id);
    
    

}
