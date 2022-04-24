package com.zhaishu.qishouserver.dao;

import com.zhaishu.qishouserver.entity.EmployeeSalaryBill;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;
import java.util.List;

/**
 * (EmployeeSalaryBill)表数据库访问层
 *
 * @author makejava
 * @since 2022-04-18 19:22:40
 */
public interface EmployeeSalaryBillDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    EmployeeSalaryBill queryById(Long id);

    /**
     * 查询指定行数据
     *
     * @param employeeSalaryBill 查询条件
     * @param pageable         分页对象
     * @return 对象列表
     */
    List<EmployeeSalaryBill> queryAllByLimit(EmployeeSalaryBill employeeSalaryBill, @Param("pageable") Pageable pageable);

    /**
     * 统计总行数
     *
     * @param employeeSalaryBill 查询条件
     * @return 总行数
     */
    long count(EmployeeSalaryBill employeeSalaryBill);

    /**
     * 新增数据
     *
     * @param employeeSalaryBill 实例对象
     * @return 影响行数
     */
    int insert(EmployeeSalaryBill employeeSalaryBill);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<EmployeeSalaryBill> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<EmployeeSalaryBill> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<EmployeeSalaryBill> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<EmployeeSalaryBill> entities);

    /**
     * 修改数据
     *
     * @param employeeSalaryBill 实例对象
     * @return 影响行数
     */
    int update(EmployeeSalaryBill employeeSalaryBill);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Long id);

}

