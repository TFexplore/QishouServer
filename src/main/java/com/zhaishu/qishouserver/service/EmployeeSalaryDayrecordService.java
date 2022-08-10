package com.zhaishu.qishouserver.service;

import com.zhaishu.qishouserver.entity.EmployeeSalaryDayrecord;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.List;

/**
 * 奖罚记录表(EmployeeSalaryDayrecord)表服务接口
 *
 * @author makejava
 * @since 2022-07-23 09:56:08
 */
public interface EmployeeSalaryDayrecordService {

    /**
     * 通过ID查询单条数据
     *
     * @return 实例对象
     */
    EmployeeSalaryDayrecord queryById(Integer dateId,Integer employeeId);

    /**
     * 分页查询
     *
     * @param employeeSalaryDayrecord 筛选条件
     * @return 查询结果
     */
    List<EmployeeSalaryDayrecord> queryByPage(EmployeeSalaryDayrecord employeeSalaryDayrecord, Integer offset, Integer limit);

    /**
     * 新增数据
     *
     * @param employeeSalaryDayrecord 实例对象
     * @return 实例对象
     */
    EmployeeSalaryDayrecord insert(EmployeeSalaryDayrecord employeeSalaryDayrecord);

    /**
     * 修改数据
     *
     * @param employeeSalaryDayrecord 实例对象
     * @return 实例对象
     */
    EmployeeSalaryDayrecord update(EmployeeSalaryDayrecord employeeSalaryDayrecord);
    
    int count(EmployeeSalaryDayrecord employeeSalaryDayrecord);
    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Integer id);
    
    

}
