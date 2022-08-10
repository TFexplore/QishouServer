package com.zhaishu.qishouserver.dao;

import com.zhaishu.qishouserver.Vo.WorkRecordVo;
import com.zhaishu.qishouserver.Vo.RiderVo;
import com.zhaishu.qishouserver.entity.Rider;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;
import java.util.List;

/**
 * 骑手信息表(Rider)表数据库访问层
 *
 * @author makejava
 * @since 2022-04-18 19:22:41
 */
public interface RiderDao {

    WorkRecordVo getWorkInfo(Integer id, Long startTime, Long endTime);

    long getWorkTime(Integer id);
    int getUnWorkTimes(Integer id);
    long getTimes();
    List<RiderVo> getAllRiders(Integer offset, Integer limit,@Param("rider")RiderVo riderVo);
    List<RiderVo> getAllRidersIn(Integer offset, Integer limit,@Param("rider")RiderVo riderVo);
    List<RiderVo> getAllRidersSe(Integer offset, Integer limit,@Param("rider")RiderVo riderVo);
    int countAllRiders(@Param("rider") RiderVo riderVo);
    int countAllRidersIn(@Param("rider") RiderVo riderVo);
    int countAllRidersSe(@Param("rider") RiderVo riderVo);
    Rider queryByEmployeeId(Integer id);
    List<Rider> queryByLimit(Rider rider);
    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    RiderVo getRiderById(Integer id);
    Rider queryById(Integer id);
    /**
     * 查询指定行数据
     *
     * @param rider 查询条件
     * @param pageable         分页对象
     * @return 对象列表
     */
    List<Rider> queryAllByLimit(Rider rider, @Param("pageable") Pageable pageable);

    /**
     * 统计总行数
     *
     * @param rider 查询条件
     * @return 总行数
     */
    long count(Rider rider);

    /**
     * 新增数据
     *
     * @param rider 实例对象
     * @return 影响行数
     */
    int insert(Rider rider);



    /**
     * 修改数据
     *
     * @return 影响行数
     */
    int update(RiderVo riderVo);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Integer id);

}

