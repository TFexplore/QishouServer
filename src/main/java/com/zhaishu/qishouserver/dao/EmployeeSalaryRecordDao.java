package com.zhaishu.qishouserver.dao;

import com.zhaishu.qishouserver.entity.EmployeeSalaryRecord;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;
import java.util.List;

/**
 * (EmployeeSalaryRecord)表数据库访问层
 *
 * @author makejava
 * @since 2022-07-14 12:18:46
 */
public interface EmployeeSalaryRecordDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    EmployeeSalaryRecord queryById(Integer id);

    /**
     * 查询指定行数据
     *
     * @param employeeSalaryRecord 查询条件

     * @return 对象列表
     */
    List<EmployeeSalaryRecord> queryAllByLimit(@Param("param") EmployeeSalaryRecord employeeSalaryRecord,  Integer offset,Integer limit);

    /**
     * 统计总行数
     *
     * @param employeeSalaryRecord 查询条件
     * @return 总行数
     */
    int count(EmployeeSalaryRecord employeeSalaryRecord);

    /**
     * 新增数据
     *
     * @param employeeSalaryRecord 实例对象
     * @return 影响行数
     */
    int insert(EmployeeSalaryRecord employeeSalaryRecord);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<EmployeeSalaryRecord> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<EmployeeSalaryRecord> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<EmployeeSalaryRecord> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<EmployeeSalaryRecord> entities);

    /**
     * 修改数据
     *
     * @param employeeSalaryRecord 实例对象
     * @return 影响行数
     */
    int update(EmployeeSalaryRecord employeeSalaryRecord);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Integer id);

}

