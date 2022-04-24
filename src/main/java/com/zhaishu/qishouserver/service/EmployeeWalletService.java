package com.zhaishu.qishouserver.service;

import com.zhaishu.qishouserver.entity.EmployeeWallet;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

/**
 * (EmployeeWallet)表服务接口
 *
 * @author makejava
 * @since 2022-04-18 19:22:40
 */
public interface EmployeeWalletService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    EmployeeWallet queryById(Integer id);

    /**
     * 分页查询
     *
     * @param employeeWallet 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    Page<EmployeeWallet> queryByPage(EmployeeWallet employeeWallet, PageRequest pageRequest);

    /**
     * 新增数据
     *
     * @param employeeWallet 实例对象
     * @return 实例对象
     */
    EmployeeWallet insert(EmployeeWallet employeeWallet);

    /**
     * 修改数据
     *
     * @param employeeWallet 实例对象
     * @return 实例对象
     */
    EmployeeWallet update(EmployeeWallet employeeWallet);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Integer id);

}
