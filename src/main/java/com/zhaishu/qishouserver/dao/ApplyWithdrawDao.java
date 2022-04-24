package com.zhaishu.qishouserver.dao;

import com.zhaishu.qishouserver.entity.ApplyWithdraw;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;
import java.util.List;

/**
 * (ApplyWithdraw)表数据库访问层
 *
 * @author makejava
 * @since 2022-04-18 19:15:57
 */
public interface ApplyWithdrawDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    ApplyWithdraw queryById(Integer id);

    /**
     * 查询指定行数据
     *
     * @param applyWithdraw 查询条件
     * @param pageable         分页对象
     * @return 对象列表
     */
    List<ApplyWithdraw> queryAllByLimit(ApplyWithdraw applyWithdraw, @Param("pageable") Pageable pageable);

    /**
     * 统计总行数
     *
     * @param applyWithdraw 查询条件
     * @return 总行数
     */
    long count(ApplyWithdraw applyWithdraw);

    /**
     * 新增数据
     *
     * @param applyWithdraw 实例对象
     * @return 影响行数
     */
    int insert(ApplyWithdraw applyWithdraw);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<ApplyWithdraw> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<ApplyWithdraw> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<ApplyWithdraw> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<ApplyWithdraw> entities);

    /**
     * 修改数据
     *
     * @param applyWithdraw 实例对象
     * @return 影响行数
     */
    int update(ApplyWithdraw applyWithdraw);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Integer id);

}

