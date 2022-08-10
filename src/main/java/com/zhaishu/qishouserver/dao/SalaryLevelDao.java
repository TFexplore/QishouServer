package com.zhaishu.qishouserver.dao;

import com.zhaishu.qishouserver.entity.SalaryLevel;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;
import java.util.List;

/**
 * 员工薪酬奖罚条件模板(SalaryLevel)表数据库访问层
 *
 * @author makejava
 * @since 2022-07-08 15:21:18
 */
public interface SalaryLevelDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    SalaryLevel queryById(Integer id);
    SalaryLevel queryByEmId(Integer id);

    List<SalaryLevel> getList(@Param("s") SalaryLevel salaryLevel, Integer limit,Integer offset);

    /**
     * 统计总行数
     *
     * @param salaryLevel 查询条件
     * @return 总行数
     */
    int count(SalaryLevel salaryLevel);

    /**
     * 新增数据
     *
     * @param salaryLevel 实例对象
     * @return 影响行数
     */
    int insert(SalaryLevel salaryLevel);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<SalaryLevel> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<SalaryLevel> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<SalaryLevel> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<SalaryLevel> entities);

    /**
     * 修改数据
     *
     * @param salaryLevel 实例对象
     * @return 影响行数
     */
    int update(SalaryLevel salaryLevel);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Integer id);

}

