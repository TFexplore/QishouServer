package com.zhaishu.qishouserver.service.impl;

import com.zhaishu.qishouserver.entity.EmployeeSalaryBill;
import com.zhaishu.qishouserver.dao.EmployeeSalaryBillDao;
import com.zhaishu.qishouserver.service.EmployeeSalaryBillService;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import javax.annotation.Resource;

/**
 * (EmployeeSalaryBill)表服务实现类
 *
 * @author makejava
 * @since 2022-04-18 19:22:40
 */
@Service("employeeSalaryBillService")
public class EmployeeSalaryBillServiceImpl implements EmployeeSalaryBillService {
    @Resource
    private EmployeeSalaryBillDao employeeSalaryBillDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public EmployeeSalaryBill queryById(Long id) {
        return this.employeeSalaryBillDao.queryById(id);
    }

    /**
     * 分页查询
     *
     * @param employeeSalaryBill 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @Override
    public Page<EmployeeSalaryBill> queryByPage(EmployeeSalaryBill employeeSalaryBill, PageRequest pageRequest) {
        long total = this.employeeSalaryBillDao.count(employeeSalaryBill);
        return new PageImpl<>(this.employeeSalaryBillDao.queryAllByLimit(employeeSalaryBill, pageRequest), pageRequest, total);
    }

    /**
     * 新增数据
     *
     * @param employeeSalaryBill 实例对象
     * @return 实例对象
     */
    @Override
    public EmployeeSalaryBill insert(EmployeeSalaryBill employeeSalaryBill) {
        this.employeeSalaryBillDao.insert(employeeSalaryBill);
        return employeeSalaryBill;
    }

    /**
     * 修改数据
     *
     * @param employeeSalaryBill 实例对象
     * @return 实例对象
     */
    @Override
    public EmployeeSalaryBill update(EmployeeSalaryBill employeeSalaryBill) {
        this.employeeSalaryBillDao.update(employeeSalaryBill);
        return this.queryById(employeeSalaryBill.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Long id) {
        return this.employeeSalaryBillDao.deleteById(id) > 0;
    }
}
