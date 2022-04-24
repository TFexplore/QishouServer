package com.zhaishu.qishouserver.dao;

import com.zhaishu.qishouserver.entity.RejectRecord;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;
import java.util.List;

/**
 * 拒接与超时记录表(RejectRecord)表数据库访问层
 *
 * @author makejava
 * @since 2022-04-19 11:08:13
 */
public interface RejectRecordDao {

    /**
     * 通过ID查询单条数据
     *
     * @param goodsOrderId 主键
     * @return 实例对象
     */
    RejectRecord queryById(Integer goodsOrderId);

    /**
     * 查询指定行数据
     *
     * @param rejectRecord 查询条件
     * @param pageable         分页对象
     * @return 对象列表
     */
    List<RejectRecord> queryAllByLimit(RejectRecord rejectRecord, @Param("pageable") Pageable pageable);

    /**
     * 统计总行数
     *
     * @param rejectRecord 查询条件
     * @return 总行数
     */
    long count(RejectRecord rejectRecord);

    /**
     * 新增数据
     *
     * @param rejectRecord 实例对象
     * @return 影响行数
     */
    int insert(RejectRecord rejectRecord);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<RejectRecord> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<RejectRecord> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<RejectRecord> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<RejectRecord> entities);

    /**
     * 修改数据
     *
     * @param rejectRecord 实例对象
     * @return 影响行数
     */
    int update(RejectRecord rejectRecord);

    /**
     * 通过主键删除数据
     *
     * @param goodsOrderId 主键
     * @return 影响行数
     */
    int deleteById(Integer goodsOrderId);

}

