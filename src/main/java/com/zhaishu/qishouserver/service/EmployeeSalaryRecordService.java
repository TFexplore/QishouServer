package com.zhaishu.qishouserver.service;

import com.zhaishu.qishouserver.entity.EmployeeSalaryRecord;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.List;

/**
 * (EmployeeSalaryRecord)表服务接口
 *
 * @author makejava
 * @since 2022-07-14 12:18:46
 */
public interface EmployeeSalaryRecordService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    EmployeeSalaryRecord queryById(Integer id);

    /**
     * 分页查询
     *
     * @param employeeSalaryRecord 筛选条件
     * @param
     * @return 查询结果
     */
    List<EmployeeSalaryRecord> queryByPage(EmployeeSalaryRecord employeeSalaryRecord, Integer offset, Integer limit);

    /**
     * 新增数据
     *
     * @param employeeSalaryRecord 实例对象
     * @return 实例对象
     */
    EmployeeSalaryRecord insert(EmployeeSalaryRecord employeeSalaryRecord);

    /**
     * 修改数据
     *
     * @param employeeSalaryRecord 实例对象
     * @return 实例对象
     */
    EmployeeSalaryRecord update(EmployeeSalaryRecord employeeSalaryRecord);
    
    int count(EmployeeSalaryRecord employeeSalaryRecord);
    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Integer id);
    
    

}
