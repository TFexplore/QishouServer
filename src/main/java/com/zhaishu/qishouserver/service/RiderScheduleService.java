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

    List<WorkRecordVo> getWorkRecord( WorkRecordVo rider,Integer limit, Integer offset);


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
    RiderSchedule queryById(Integer id);

    /**
     * 分页查询
     *
     * @param riderSchedule 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    Page<RiderSchedule> queryByPage(RiderSchedule riderSchedule, PageRequest pageRequest);

    /**
     * 新增数据
     *
     * @param riderSchedule 实例对象
     * @return 实例对象
     */
    int insert(RiderSchedule riderSchedule);

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

}
