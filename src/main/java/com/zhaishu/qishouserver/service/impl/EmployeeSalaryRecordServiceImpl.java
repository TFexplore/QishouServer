package com.zhaishu.qishouserver.service.impl;

import com.zhaishu.qishouserver.entity.EmployeeSalaryRecord;
import com.zhaishu.qishouserver.dao.EmployeeSalaryRecordDao;
import com.zhaishu.qishouserver.service.EmployeeSalaryRecordService;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import javax.annotation.Resource;
import java.util.List;

/**
 * (EmployeeSalaryRecord)表服务实现类
 *
 * @author makejava
 * @since 2022-07-14 12:18:46
 */
@Service("employeeSalaryRecordService")
public class EmployeeSalaryRecordServiceImpl implements EmployeeSalaryRecordService {
    @Resource
    private EmployeeSalaryRecordDao employeeSalaryRecordDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public EmployeeSalaryRecord queryById(Integer id) {
        return this.employeeSalaryRecordDao.queryById(id);
    }

    /**
     * 分页查询
     *
     * @param employeeSalaryRecord 筛选条件
     * @param
     * @return 查询结果
     */
    @Override
    public List<EmployeeSalaryRecord> queryByPage(EmployeeSalaryRecord employeeSalaryRecord, Integer offset, Integer limit) {
      
        return this.employeeSalaryRecordDao.queryAllByLimit(employeeSalaryRecord, offset,limit);
    }

    /**
     * 新增数据
     *
     * @param employeeSalaryRecord 实例对象
     * @return 实例对象
     */
    @Override
    public EmployeeSalaryRecord insert(EmployeeSalaryRecord employeeSalaryRecord) {
        this.employeeSalaryRecordDao.insert(employeeSalaryRecord);
        return employeeSalaryRecord;
    }

    /**
     * 修改数据
     *
     * @param employeeSalaryRecord 实例对象
     * @return 实例对象
     */
    @Override
    public EmployeeSalaryRecord update(EmployeeSalaryRecord employeeSalaryRecord) {
        this.employeeSalaryRecordDao.update(employeeSalaryRecord);
        return this.queryById(employeeSalaryRecord.getId());
    }
    @Override
    public int count(EmployeeSalaryRecord employeeSalaryRecord) {
        
        return this.employeeSalaryRecordDao.count(employeeSalaryRecord); 
    }
    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.employeeSalaryRecordDao.deleteById(id) > 0;
    }
}
