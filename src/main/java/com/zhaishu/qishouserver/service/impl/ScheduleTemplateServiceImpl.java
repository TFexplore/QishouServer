package com.zhaishu.qishouserver.service.impl;

import com.zhaishu.qishouserver.Vo.RiderVo;
import com.zhaishu.qishouserver.Vo.TemplateVo;
import com.zhaishu.qishouserver.entity.ScheduleTemplate;
import com.zhaishu.qishouserver.dao.ScheduleTemplateDao;
import com.zhaishu.qishouserver.entity.WorkTime;
import com.zhaishu.qishouserver.service.ScheduleTemplateService;
import com.zhaishu.qishouserver.service.WorkTimeService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (ScheduleTemplate)表服务实现类
 *
 * @author makejava
 * @since 2022-05-13 21:24:40
 */
@Service("scheduleTemplateService")
public class ScheduleTemplateServiceImpl implements ScheduleTemplateService {
    @Resource
    private ScheduleTemplateDao scheduleTemplateDao;
    @Resource
    private WorkTimeService workTimeService;

    @Override
    public List<TemplateVo> getTempletes(Integer limit,Integer offset){
        return this.scheduleTemplateDao.getTempletes(limit,offset);
    }
    @Override
    public int count(){
        return scheduleTemplateDao.count();
    }


    @Override
    public List<RiderVo> getRiders(Integer ID){
        return this.scheduleTemplateDao.getRiders(ID);
    }
    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public ScheduleTemplate queryById(Integer id) {
        return this.scheduleTemplateDao.queryById(id);
    }


    /**
     * 新增数据
     *
     * @param scheduleTemplate 实例对象
     * @return 实例对象
     */
    @Override
    public ScheduleTemplate insert(ScheduleTemplate scheduleTemplate) {
        WorkTime workTime=new WorkTime();
        workTime.setDateId(20000101);
        workTime=workTimeService.insert(workTime);
        scheduleTemplate.setId(workTime.getWorktimeId());
        this.scheduleTemplateDao.insert(scheduleTemplate);
        return scheduleTemplate;
    }

    /**
     * 修改数据
     *
     * @param scheduleTemplate 实例对象
     * @return 实例对象
     */
    @Override
    public ScheduleTemplate update(ScheduleTemplate scheduleTemplate) {
        this.scheduleTemplateDao.update(scheduleTemplate);
        return this.queryById(scheduleTemplate.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.scheduleTemplateDao.deleteById(id) > 0;
    }
}
