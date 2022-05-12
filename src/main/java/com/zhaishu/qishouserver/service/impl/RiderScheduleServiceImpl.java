package com.zhaishu.qishouserver.service.impl;

import com.zhaishu.qishouserver.Vo.RiderVo;
import com.zhaishu.qishouserver.Vo.ScheduleVo;
import com.zhaishu.qishouserver.entity.RiderSchedule;
import com.zhaishu.qishouserver.dao.RiderScheduleDao;
import com.zhaishu.qishouserver.service.RiderScheduleService;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

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
    public List<RiderVo> getRiders(@Param("rider") RiderVo rider, Integer limit, Integer offset){
        return this.riderScheduleDao.getRiders(rider,limit,offset);
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
    public RiderSchedule queryById(Integer id) {
        return this.riderScheduleDao.queryById(id);
    }

    /**
     * 分页查询
     *
     * @param riderSchedule 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @Override
    public Page<RiderSchedule> queryByPage(RiderSchedule riderSchedule, PageRequest pageRequest) {
        long total = this.riderScheduleDao.count(riderSchedule);
        return new PageImpl<>(this.riderScheduleDao.queryAllByLimit(riderSchedule, pageRequest), pageRequest, total);
    }

    /**
     * 新增数据
     *
     * @param riderSchedule 实例对象
     * @return 实例对象
     */
    @Override
    public int insert(RiderSchedule riderSchedule) {
        Integer id=this.riderScheduleDao.getNextId(riderSchedule.getWorktimeId());
        if (id==null){
            id=riderSchedule.getWorktimeId()*100;
        }
        riderSchedule.setScheduleId(id+1);
        return  this.riderScheduleDao.insert(riderSchedule);
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
        return this.queryById(riderSchedule.getScheduleId());
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
}
