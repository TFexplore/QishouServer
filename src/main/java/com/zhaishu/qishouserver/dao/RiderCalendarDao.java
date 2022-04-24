package com.zhaishu.qishouserver.dao;

import com.zhaishu.qishouserver.entity.RiderCalendar;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;
import java.util.List;

/**
 * 骑手日历表(RiderCalendar)表数据库访问层
 *
 * @author makejava
 * @since 2022-04-18 19:22:41
 */
public interface RiderCalendarDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    RiderCalendar queryById(Integer id);

    /**
     * 查询指定行数据
     *
     * @param riderCalendar 查询条件
     * @param pageable         分页对象
     * @return 对象列表
     */
    List<RiderCalendar> queryAllByLimit(RiderCalendar riderCalendar, @Param("pageable") Pageable pageable);

    /**
     * 统计总行数
     *
     * @param riderCalendar 查询条件
     * @return 总行数
     */
    long count(RiderCalendar riderCalendar);

    /**
     * 新增数据
     *
     * @param riderCalendar 实例对象
     * @return 影响行数
     */
    int insert(RiderCalendar riderCalendar);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<RiderCalendar> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<RiderCalendar> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<RiderCalendar> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<RiderCalendar> entities);

    /**
     * 修改数据
     *
     * @param riderCalendar 实例对象
     * @return 影响行数
     */
    int update(RiderCalendar riderCalendar);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Integer id);

}

