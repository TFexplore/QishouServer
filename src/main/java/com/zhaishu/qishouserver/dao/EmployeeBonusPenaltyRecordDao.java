package com.zhaishu.qishouserver.dao;

import com.zhaishu.qishouserver.entity.EmployeeBonusPenaltyRecord;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;
import java.util.List;

/**
 * 奖罚记录表(EmployeeBonusPenaltyRecord)表数据库访问层
 *
 * @author makejava
 * @since 2022-04-18 19:22:40
 */
public interface EmployeeBonusPenaltyRecordDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    EmployeeBonusPenaltyRecord queryById(Integer id);

    /**
     * 查询指定行数据
     *
     * @param employeeBonusPenaltyRecord 查询条件
     * @param pageable         分页对象
     * @return 对象列表
     */
    List<EmployeeBonusPenaltyRecord> queryAllByLimit(EmployeeBonusPenaltyRecord employeeBonusPenaltyRecord, @Param("pageable") Pageable pageable);

    /**
     * 统计总行数
     *
     * @param employeeBonusPenaltyRecord 查询条件
     * @return 总行数
     */
    long count(EmployeeBonusPenaltyRecord employeeBonusPenaltyRecord);

    /**
     * 新增数据
     *
     * @param employeeBonusPenaltyRecord 实例对象
     * @return 影响行数
     */
    int insert(EmployeeBonusPenaltyRecord employeeBonusPenaltyRecord);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<EmployeeBonusPenaltyRecord> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<EmployeeBonusPenaltyRecord> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<EmployeeBonusPenaltyRecord> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<EmployeeBonusPenaltyRecord> entities);

    /**
     * 修改数据
     *
     * @param employeeBonusPenaltyRecord 实例对象
     * @return 影响行数
     */
    int update(EmployeeBonusPenaltyRecord employeeBonusPenaltyRecord);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Integer id);

}

