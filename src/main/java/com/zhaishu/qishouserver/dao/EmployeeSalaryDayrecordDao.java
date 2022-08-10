package com.zhaishu.qishouserver.dao;

import com.zhaishu.qishouserver.entity.EmployeeSalaryDayrecord;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;
import java.util.List;

/**
 * 奖罚记录表(EmployeeSalaryDayrecord)表数据库访问层
 *
 * @author makejava
 * @since 2022-07-23 09:56:08
 */
public interface EmployeeSalaryDayrecordDao {

    /**
     * 通过ID查询单条数据
     *
     * @return 实例对象
     */
    EmployeeSalaryDayrecord queryById(Integer dateId,Integer employeeId);

    /**
     * 查询指定行数据
     *
     * @param employeeSalaryDayrecord 查询条件
     * @return 对象列表
     */
    List<EmployeeSalaryDayrecord> queryAllByLimit(@Param("param") EmployeeSalaryDayrecord employeeSalaryDayrecord,  Integer offset,Integer limit);

    /**
     * 统计总行数
     *
     * @param employeeSalaryDayrecord 查询条件
     * @return 总行数
     */
    int count(EmployeeSalaryDayrecord employeeSalaryDayrecord);

    /**
     * 新增数据
     *
     * @param employeeSalaryDayrecord 实例对象
     * @return 影响行数
     */
    int insert(EmployeeSalaryDayrecord employeeSalaryDayrecord);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<EmployeeSalaryDayrecord> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<EmployeeSalaryDayrecord> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<EmployeeSalaryDayrecord> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<EmployeeSalaryDayrecord> entities);

    /**
     * 修改数据
     *
     * @param employeeSalaryDayrecord 实例对象
     * @return 影响行数
     */
    int update(EmployeeSalaryDayrecord employeeSalaryDayrecord);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Integer id);

}

