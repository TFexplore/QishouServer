package com.zhaishu.qishouserver.dao;

import com.zhaishu.qishouserver.entity.TOrderRecord;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;
import java.util.List;

/**
 * (TOrderRecord)表数据库访问层
 *
 * @author makejava
 * @since 2022-07-18 11:54:53
 */
public interface TOrderRecordDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    TOrderRecord queryById(Long id);

    /**
     * 查询指定行数据
     *
     * @param tOrderRecord 查询条件
     * @return 对象列表
     */
    List<TOrderRecord> queryAllByLimit(@Param("param") TOrderRecord tOrderRecord,  Integer offset,Integer limit);

    /**
     * 统计总行数
     *
     * @param tOrderRecord 查询条件
     * @return 总行数
     */
    int count(TOrderRecord tOrderRecord);

    /**
     * 新增数据
     *
     * @param tOrderRecord 实例对象
     * @return 影响行数
     */
    int insert(TOrderRecord tOrderRecord);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<TOrderRecord> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<TOrderRecord> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<TOrderRecord> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<TOrderRecord> entities);

    /**
     * 修改数据
     *
     * @param tOrderRecord 实例对象
     * @return 影响行数
     */
    int update(TOrderRecord tOrderRecord);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Long id);

}

