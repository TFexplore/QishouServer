package com.zhaishu.qishouserver.service.impl;

import com.zhaishu.qishouserver.entity.CalendarTemplate;
import com.zhaishu.qishouserver.dao.CalendarTemplateDao;
import com.zhaishu.qishouserver.service.CalendarTemplateService;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import javax.annotation.Resource;
import java.util.List;

/**
 * (CalendarTemplate)表服务实现类
 *
 * @author makejava
 * @since 2022-07-28 22:35:54
 */
@Service("calendarTemplateService")
public class CalendarTemplateServiceImpl implements CalendarTemplateService {
    @Resource
    private CalendarTemplateDao calendarTemplateDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public CalendarTemplate queryById(Integer id) {
        return this.calendarTemplateDao.queryById(id);
    }

    /**
     * 分页查询
     *
     * @param calendarTemplate 筛选条件
     * @return 查询结果
     */
    @Override
    public List<CalendarTemplate> queryByPage(CalendarTemplate calendarTemplate, Integer offset, Integer limit) {
      
        return this.calendarTemplateDao.queryAllByLimit(calendarTemplate, offset,limit);
    }

    /**
     * 新增数据
     *
     * @param calendarTemplate 实例对象
     * @return 实例对象
     */
    @Override
    public CalendarTemplate insert(CalendarTemplate calendarTemplate) {
        this.calendarTemplateDao.insert(calendarTemplate);
        return calendarTemplate;
    }

    /**
     * 修改数据
     *
     * @param calendarTemplate 实例对象
     * @return 实例对象
     */
    @Override
    public CalendarTemplate update(CalendarTemplate calendarTemplate) {
        this.calendarTemplateDao.update(calendarTemplate);
        return this.queryById(calendarTemplate.getId());
    }
    @Override
    public int count(CalendarTemplate calendarTemplate) {
        
        return this.calendarTemplateDao.count(calendarTemplate); 
    }
    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.calendarTemplateDao.deleteById(id) > 0;
    }
}
