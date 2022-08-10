package com.zhaishu.qishouserver.service.impl;

import com.zhaishu.qishouserver.entity.EmployeeWalletBill;
import com.zhaishu.qishouserver.dao.EmployeeWalletBillDao;
import com.zhaishu.qishouserver.service.EmployeeWalletBillService;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;

/**
 * (EmployeeWalletBill)表服务实现类
 *
 * @author makejava
 * @since 2022-08-03 18:11:36
 */
@Service("employeeWalletBillService")
public class EmployeeWalletBillServiceImpl implements EmployeeWalletBillService {
    @Resource
    private EmployeeWalletBillDao employeeWalletBillDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public EmployeeWalletBill queryById(Long id) {
        return this.employeeWalletBillDao.queryById(id);
    }

    /**
     * 分页查询
     *
     * @param employeeWalletBill 筛选条件
     * @return 查询结果
     */
    @Override
    public List<EmployeeWalletBill> queryByPage(EmployeeWalletBill employeeWalletBill, Integer offset, Integer limit) {
      
        return this.employeeWalletBillDao.queryAllByLimit(employeeWalletBill, offset,limit);
    }

    /**
     * 新增数据
     *
     * @param employeeWalletBill 实例对象
     * @return 实例对象
     */
    @Override
    public EmployeeWalletBill insert(EmployeeWalletBill employeeWalletBill) {
        this.employeeWalletBillDao.insert(employeeWalletBill);
        return employeeWalletBill;
    }

    /**
     * 修改数据
     *
     * @param employeeWalletBill 实例对象
     * @return 实例对象
     */
    @Override
    public EmployeeWalletBill update(EmployeeWalletBill employeeWalletBill) {
        this.employeeWalletBillDao.update(employeeWalletBill);
        return this.queryById(employeeWalletBill.getId());
    }
    @Override
    public int count(EmployeeWalletBill employeeWalletBill) {
        
        return this.employeeWalletBillDao.count(employeeWalletBill); 
    }
    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Long id) {
        return this.employeeWalletBillDao.deleteById(id) > 0;
    }
}
