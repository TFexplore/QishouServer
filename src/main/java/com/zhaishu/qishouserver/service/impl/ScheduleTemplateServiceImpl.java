package com.zhaishu.qishouserver.service.impl;

import com.zhaishu.qishouserver.Vo.RiderVo;
import com.zhaishu.qishouserver.Vo.TemplateVo;
import com.zhaishu.qishouserver.entity.ScheduleTemplate;
import com.zhaishu.qishouserver.dao.ScheduleTemplateDao;
import com.zhaishu.qishouserver.service.ScheduleTemplateService;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

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

    @Override
    public List<TemplateVo> getTempletes(){
        return this.scheduleTemplateDao.getTempletes();
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
     * 分页查询
     *
     * @param scheduleTemplate 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @Override
    public Page<ScheduleTemplate> queryByPage(ScheduleTemplate scheduleTemplate, PageRequest pageRequest) {
        long total = this.scheduleTemplateDao.count(scheduleTemplate);
        return new PageImpl<>(this.scheduleTemplateDao.queryAllByLimit(scheduleTemplate, pageRequest), pageRequest, total);
    }

    /**
     * 新增数据
     *
     * @param scheduleTemplate 实例对象
     * @return 实例对象
     */
    @Override
    public ScheduleTemplate insert(ScheduleTemplate scheduleTemplate) {
        scheduleTemplate.setId(this.scheduleTemplateDao.count(new ScheduleTemplate()) + 1);
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
