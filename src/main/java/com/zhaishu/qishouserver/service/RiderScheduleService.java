package com.zhaishu.qishouserver.service;

import com.zhaishu.qishouserver.Vo.RiderVo;
import com.zhaishu.qishouserver.Vo.ScheduleVo;
import com.zhaishu.qishouserver.Vo.WorkRecordVo;
import com.zhaishu.qishouserver.entity.RiderSchedule;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.List;

/**
 * 骑手排班表(RiderSchedule)表服务接口
 *
 * @author makejava
 * @since 2022-04-18 19:22:41
 */
public interface RiderScheduleService {

    RiderSchedule  getScheduleById(RiderSchedule schedule);

    List<WorkRecordVo> getWorkRecord(WorkRecordVo rider, Integer limit, Integer offset);


    int countWorkRecord(WorkRecordVo recordVo);

    List<RiderVo> getRiders( RiderVo rider, Integer limit, Integer offset);

    int countRiders(RiderVo rider);

    List<ScheduleVo> getSchedules(Integer id);

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    List<RiderSchedule> queryById(Integer id);


    /**
     * 新增数据
     *
     * @param riderSchedule 实例对象
     * @return 实例对象
     */
    int insert(RiderSchedule riderSchedule);

    int count(RiderSchedule schedule);

    /**
     * 修改数据
     *
     * @param riderSchedule 实例对象
     * @return 实例对象
     */
    RiderSchedule update(RiderSchedule riderSchedule);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Integer id);

    int deleteRider(Integer id, Integer employeeId);
}
