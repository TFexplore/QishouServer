package com.zhaishu.qishouserver.service.impl;

import com.zhaishu.qishouserver.entity.EmployeeSalaryDayrecord;
import com.zhaishu.qishouserver.dao.EmployeeSalaryDayrecordDao;
import com.zhaishu.qishouserver.service.EmployeeSalaryDayrecordService;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import javax.annotation.Resource;
import java.util.List;

/**
 * 奖罚记录表(EmployeeSalaryDayrecord)表服务实现类
 *
 * @author makejava
 * @since 2022-07-23 09:56:08
 */
@Service("employeeSalaryDayrecordService")
public class EmployeeSalaryDayrecordServiceImpl implements EmployeeSalaryDayrecordService {
    @Resource
    private EmployeeSalaryDayrecordDao employeeSalaryDayrecordDao;

    /**
     * 通过ID查询单条数据
     *

     * @return 实例对象
     */
    @Override
    public EmployeeSalaryDayrecord queryById(Integer dateId,Integer employeeId) {
        return this.employeeSalaryDayrecordDao.queryById( dateId, employeeId);
    }

    /**
     * 分页查询
     *
     * @param employeeSalaryDayrecord 筛选条件
     * @return 查询结果
     */
    @Override
    public List<EmployeeSalaryDayrecord> queryByPage(EmployeeSalaryDayrecord employeeSalaryDayrecord, Integer offset, Integer limit) {
      
        return this.employeeSalaryDayrecordDao.queryAllByLimit(employeeSalaryDayrecord, offset,limit);
    }

    /**
     * 新增数据
     *
     * @param employeeSalaryDayrecord 实例对象
     * @return 实例对象
     */
    @Override
    public EmployeeSalaryDayrecord insert(EmployeeSalaryDayrecord employeeSalaryDayrecord) {
        this.employeeSalaryDayrecordDao.insert(employeeSalaryDayrecord);
        return employeeSalaryDayrecord;
    }

    /**
     * 修改数据
     *
     * @param employeeSalaryDayrecord 实例对象
     * @return 实例对象
     */
    @Override
    public EmployeeSalaryDayrecord update(EmployeeSalaryDayrecord employeeSalaryDayrecord) {
        this.employeeSalaryDayrecordDao.update(employeeSalaryDayrecord);
        return employeeSalaryDayrecord;
    }
    @Override
    public int count(EmployeeSalaryDayrecord employeeSalaryDayrecord) {
        
        return this.employeeSalaryDayrecordDao.count(employeeSalaryDayrecord); 
    }
    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.employeeSalaryDayrecordDao.deleteById(id) > 0;
    }
}
