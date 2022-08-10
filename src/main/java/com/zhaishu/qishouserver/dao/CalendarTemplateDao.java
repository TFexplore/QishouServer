package com.zhaishu.qishouserver.dao;

import com.zhaishu.qishouserver.entity.CalendarTemplate;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;
import java.util.List;

/**
 * (CalendarTemplate)表数据库访问层
 *
 * @author makejava
 * @since 2022-07-28 22:35:54
 */
public interface CalendarTemplateDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    CalendarTemplate queryById(Integer id);

    /**
     * 查询指定行数据
     *
     * @param calendarTemplate 查询条件
     * @return 对象列表
     */
    List<CalendarTemplate> queryAllByLimit(@Param("param") CalendarTemplate calendarTemplate,  Integer offset,Integer limit);

    /**
     * 统计总行数
     *
     * @param calendarTemplate 查询条件
     * @return 总行数
     */
    int count(CalendarTemplate calendarTemplate);

    /**
     * 新增数据
     *
     * @param calendarTemplate 实例对象
     * @return 影响行数
     */
    int insert(CalendarTemplate calendarTemplate);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<CalendarTemplate> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<CalendarTemplate> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<CalendarTemplate> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<CalendarTemplate> entities);

    /**
     * 修改数据
     *
     * @param calendarTemplate 实例对象
     * @return 影响行数
     */
    int update(CalendarTemplate calendarTemplate);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Integer id);

}

