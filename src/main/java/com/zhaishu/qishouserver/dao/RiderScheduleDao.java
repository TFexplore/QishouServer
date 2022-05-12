package com.zhaishu.qishouserver.dao;

import com.zhaishu.qishouserver.Vo.RiderVo;
import com.zhaishu.qishouserver.Vo.ScheduleVo;
import com.zhaishu.qishouserver.entity.Rider;
import com.zhaishu.qishouserver.entity.RiderSchedule;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;
import java.util.List;

/**
 * 骑手排班表(RiderSchedule)表数据库访问层
 *
 * @author makejava
 * @since 2022-04-18 19:22:41
 */
public interface RiderScheduleDao {

    List<RiderVo> getRiders(@Param("rider")RiderVo rider,Integer limit,Integer offset);

    List<ScheduleVo> getSchedules(Integer id);
    Integer getNextId(Integer id);

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    RiderSchedule queryById(Integer id);

    /**
     * 查询指定行数据
     *
     * @param riderSchedule 查询条件
     * @param pageable         分页对象
     * @return 对象列表
     */
    List<RiderSchedule> queryAllByLimit(RiderSchedule riderSchedule, @Param("pageable") Pageable pageable);

    /**
     * 统计总行数
     *
     * @param riderSchedule 查询条件
     * @return 总行数
     */
    long count(RiderSchedule riderSchedule);

    /**
     * 新增数据
     *
     * @param riderSchedule 实例对象
     * @return 影响行数
     */
    int insert(RiderSchedule riderSchedule);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<RiderSchedule> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<RiderSchedule> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<RiderSchedule> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<RiderSchedule> entities);

    /**
     * 修改数据
     *
     * @param riderSchedule 实例对象
     * @return 影响行数
     */
    int update(RiderSchedule riderSchedule);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Integer id);

}

