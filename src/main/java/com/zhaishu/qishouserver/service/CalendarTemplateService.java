package com.zhaishu.qishouserver.service;

import com.zhaishu.qishouserver.entity.CalendarTemplate;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.List;

/**
 * (CalendarTemplate)表服务接口
 *
 * @author makejava
 * @since 2022-07-28 22:35:54
 */
public interface CalendarTemplateService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    CalendarTemplate queryById(Integer id);

    /**
     * 分页查询
     *
     * @param calendarTemplate 筛选条件
     * @return 查询结果
     */
    List<CalendarTemplate> queryByPage(CalendarTemplate calendarTemplate, Integer offset, Integer limit);

    /**
     * 新增数据
     *
     * @param calendarTemplate 实例对象
     * @return 实例对象
     */
    CalendarTemplate insert(CalendarTemplate calendarTemplate);

    /**
     * 修改数据
     *
     * @param calendarTemplate 实例对象
     * @return 实例对象
     */
    CalendarTemplate update(CalendarTemplate calendarTemplate);
    
    int count(CalendarTemplate calendarTemplate);
    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Integer id);
    
    

}
