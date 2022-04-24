package com.zhaishu.qishouserver.service.impl;

import com.zhaishu.qishouserver.entity.EmployeeWallet;
import com.zhaishu.qishouserver.dao.EmployeeWalletDao;
import com.zhaishu.qishouserver.service.EmployeeWalletService;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import javax.annotation.Resource;

/**
 * (EmployeeWallet)表服务实现类
 *
 * @author makejava
 * @since 2022-04-18 19:22:40
 */
@Service("employeeWalletService")
public class EmployeeWalletServiceImpl implements EmployeeWalletService {
    @Resource
    private EmployeeWalletDao employeeWalletDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public EmployeeWallet queryById(Integer id) {
        return this.employeeWalletDao.queryById(id);
    }

    /**
     * 分页查询
     *
     * @param employeeWallet 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @Override
    public Page<EmployeeWallet> queryByPage(EmployeeWallet employeeWallet, PageRequest pageRequest) {
        long total = this.employeeWalletDao.count(employeeWallet);
        return new PageImpl<>(this.employeeWalletDao.queryAllByLimit(employeeWallet, pageRequest), pageRequest, total);
    }

    /**
     * 新增数据
     *
     * @param employeeWallet 实例对象
     * @return 实例对象
     */
    @Override
    public EmployeeWallet insert(EmployeeWallet employeeWallet) {
        this.employeeWalletDao.insert(employeeWallet);
        return employeeWallet;
    }

    /**
     * 修改数据
     *
     * @param employeeWallet 实例对象
     * @return 实例对象
     */
    @Override
    public EmployeeWallet update(EmployeeWallet employeeWallet) {
        this.employeeWalletDao.update(employeeWallet);
        return this.queryById(employeeWallet.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.employeeWalletDao.deleteById(id) > 0;
    }
}
