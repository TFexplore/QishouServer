package com.zhaishu.qishouserver.service;

import com.zhaishu.qishouserver.Vo.RiderVo;
import com.zhaishu.qishouserver.Vo.TemplateVo;
import com.zhaishu.qishouserver.entity.ScheduleTemplate;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.List;

/**
 * (ScheduleTemplate)表服务接口
 *
 * @author makejava
 * @since 2022-05-13 21:24:40
 */
public interface ScheduleTemplateService {

    List<TemplateVo> getTempletes();

    List<RiderVo> getRiders(Integer ID);

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    ScheduleTemplate queryById(Integer id);

    /**
     * 分页查询
     *
     * @param scheduleTemplate 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    Page<ScheduleTemplate> queryByPage(ScheduleTemplate scheduleTemplate, PageRequest pageRequest);

    /**
     * 新增数据
     *
     * @param scheduleTemplate 实例对象
     * @return 实例对象
     */
    ScheduleTemplate insert(ScheduleTemplate scheduleTemplate);

    /**
     * 修改数据
     *
     * @param scheduleTemplate 实例对象
     * @return 实例对象
     */
    ScheduleTemplate update(ScheduleTemplate scheduleTemplate);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Integer id);

}
