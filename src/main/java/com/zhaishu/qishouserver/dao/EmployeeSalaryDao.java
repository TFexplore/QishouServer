package com.zhaishu.qishouserver.dao;

import com.zhaishu.qishouserver.Vo.RiderSalaryVo;
import com.zhaishu.qishouserver.entity.EmployeeSalary;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;
import java.util.List;

/**
 * 员工薪资表(EmployeeSalary)表数据库访问层
 *
 * @author makejava
 * @since 2022-07-11 15:58:00
 */
public interface EmployeeSalaryDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    EmployeeSalary queryById(Integer id);
    EmployeeSalary queryByMonth(Integer monthId,Integer employeeId);

    int countList(@Param("salary")RiderSalaryVo salaryVo);
    List<RiderSalaryVo> getRiderSalaryList(@Param("salary")RiderSalaryVo salaryVo,Integer limit,Integer offset);
    /**
     * 查询指定行数据
     *
     * @param employeeSalary 查询条件
     * @param pageable         分页对象
     * @return 对象列表
     */
    List<EmployeeSalary> queryAllByLimit(EmployeeSalary employeeSalary, @Param("pageable") Pageable pageable);

    /**
     * 统计总行数
     *
     * @param employeeSalary 查询条件
     * @return 总行数
     */
    long count(EmployeeSalary employeeSalary);

    /**
     * 新增数据
     *
     * @param employeeSalary 实例对象
     * @return 影响行数
     */
    int insert(EmployeeSalary employeeSalary);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<EmployeeSalary> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<EmployeeSalary> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<EmployeeSalary> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<EmployeeSalary> entities);

    /**
     * 修改数据
     *
     * @param employeeSalary 实例对象
     * @return 影响行数
     */
    int update(EmployeeSalary employeeSalary);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Integer id);

}

