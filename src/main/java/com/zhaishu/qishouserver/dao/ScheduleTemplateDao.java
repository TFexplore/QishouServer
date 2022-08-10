package com.zhaishu.qishouserver.dao;

import com.zhaishu.qishouserver.Vo.RiderVo;
import com.zhaishu.qishouserver.Vo.TemplateVo;
import com.zhaishu.qishouserver.entity.ScheduleTemplate;
import io.swagger.models.auth.In;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;
import java.util.List;

/**
 * (ScheduleTemplate)表数据库访问层
 *
 * @author makejava
 * @since 2022-05-13 21:24:40
 */
public interface ScheduleTemplateDao {

    List<TemplateVo> getTempletes(Integer limit,Integer offset);
    List<RiderVo> getRiders(Integer ID);

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    ScheduleTemplate queryById(Integer id);

    /**
     * 查询指定行数据
     *
     * @param scheduleTemplate 查询条件
     * @param pageable         分页对象
     * @return 对象列表
     */
    List<ScheduleTemplate> queryAllByLimit(ScheduleTemplate scheduleTemplate, @Param("pageable") Pageable pageable);


    int count();

    /**
     * 新增数据
     *
     * @param scheduleTemplate 实例对象
     * @return 影响行数
     */
    int insert(ScheduleTemplate scheduleTemplate);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<ScheduleTemplate> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<ScheduleTemplate> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<ScheduleTemplate> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<ScheduleTemplate> entities);

    /**
     * 修改数据
     *
     * @param scheduleTemplate 实例对象
     * @return 影响行数
     */
    int update(ScheduleTemplate scheduleTemplate);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Integer id);

}

