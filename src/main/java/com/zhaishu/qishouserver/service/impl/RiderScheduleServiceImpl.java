package com.zhaishu.qishouserver.service.impl;

import com.zhaishu.qishouserver.Vo.RiderVo;
import com.zhaishu.qishouserver.Vo.ScheduleVo;
import com.zhaishu.qishouserver.Vo.WorkRecordVo;
import com.zhaishu.qishouserver.common.RuntimeExceptions;
import com.zhaishu.qishouserver.entity.RiderSchedule;
import com.zhaishu.qishouserver.dao.RiderScheduleDao;
import com.zhaishu.qishouserver.service.RiderScheduleService;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 骑手排班表(RiderSchedule)表服务实现类
 *
 * @author makejava
 * @since 2022-04-18 19:22:41
 */
@Service("riderScheduleService")
public class RiderScheduleServiceImpl implements RiderScheduleService {
    @Resource
    private RiderScheduleDao riderScheduleDao;


    @Override
    public RiderSchedule  getScheduleById(RiderSchedule schedule){
        return riderScheduleDao.getScheduleById(schedule);
    }
    @Override
    public List<WorkRecordVo> getWorkRecord(WorkRecordVo rider, Integer limit, Integer offset){

       return riderScheduleDao.getWorkRecord(rider, limit, offset);
    }
    @Override
    public int countWorkRecord(WorkRecordVo recordVo){
        return riderScheduleDao.countWorkRecord(recordVo);
    }

    @Override
    public List<RiderVo> getRiders(@Param("rider") RiderVo rider, Integer limit, Integer offset){
        return this.riderScheduleDao.getRiders(rider,limit,offset);
    }
    @Override
    public int countRiders(RiderVo rider){
        return this.riderScheduleDao.countRiders(rider);
    }
    @Override
    public List<ScheduleVo> getSchedules(Integer id){
        return this.riderScheduleDao.getSchedules(id);
    }
    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public List<RiderSchedule> queryById(Integer id) {
        return this.riderScheduleDao.queryById(id);
    }



    /**
     * 新增数据
     *
     * @param riderSchedule 实例对象
     * @return 实例对象
     */
    @Override
    public int insert(RiderSchedule riderSchedule) {
        if (this.count(riderSchedule)!=0){
            throw new RuntimeExceptions("400","重复添加");
        }
        Integer id=this.riderScheduleDao.getNextId(riderSchedule.getWorktimeId());
        if (id==null){
            id=0;
        }
        System.out.println("id: "+id);
        riderSchedule.setScheduleId(id+1);
        return  this.riderScheduleDao.insert(riderSchedule);
    }
    @Override
    public int count(RiderSchedule schedule){

        return this.riderScheduleDao.count(schedule);
    }

    /**
     * 修改数据
     *
     * @param riderSchedule 实例对象
     * @return 实例对象
     */
    @Override
    public RiderSchedule update(RiderSchedule riderSchedule) {
        this.riderScheduleDao.update(riderSchedule);
        return riderSchedule;
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.riderScheduleDao.deleteById(id) > 0;
    }
    @Override
    public int deleteRider(Integer id, Integer employeeId){
        return riderScheduleDao.deleteRider(id, employeeId);
    }
}
