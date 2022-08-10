package com.zhaishu.qishouserver.dao;

import com.zhaishu.qishouserver.entity.SalaryCondition;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;
import java.util.List;

/**
 * (SalaryCondition)表数据库访问层
 *
 * @author makejava
 * @since 2022-07-08 15:24:32
 */
public interface SalaryConditionDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    SalaryCondition queryById(Integer id);

    /**
     * 查询指定行数据
     *
     * @param salaryCondition 查询条件
     * @param pageable         分页对象
     * @return 对象列表
     */
    List<SalaryCondition> queryAllByLimit( @Param("condition")SalaryCondition salaryCondition,Integer limit,Integer offset);

    /**
     * 统计总行数
     *
     * @param salaryCondition 查询条件
     * @return 总行数
     */
    int count(SalaryCondition salaryCondition);

    /**
     * 新增数据
     *
     * @param salaryCondition 实例对象
     * @return 影响行数
     */
    int insert(SalaryCondition salaryCondition);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<SalaryCondition> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<SalaryCondition> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<SalaryCondition> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<SalaryCondition> entities);

    /**
     * 修改数据
     *
     * @param salaryCondition 实例对象
     * @return 影响行数
     */
    int update(SalaryCondition salaryCondition);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Integer id);

}

