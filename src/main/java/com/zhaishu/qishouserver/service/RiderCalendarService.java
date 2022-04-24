package com.zhaishu.qishouserver.service;

import com.zhaishu.qishouserver.entity.RiderCalendar;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

/**
 * 骑手日历表(RiderCalendar)表服务接口
 *
 * @author makejava
 * @since 2022-04-18 19:22:41
 */
public interface RiderCalendarService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    RiderCalendar queryById(Integer id);

    /**
     * 分页查询
     *
     * @param riderCalendar 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    Page<RiderCalendar> queryByPage(RiderCalendar riderCalendar, PageRequest pageRequest);

    /**
     * 新增数据
     *
     * @param riderCalendar 实例对象
     * @return 实例对象
     */
    RiderCalendar insert(RiderCalendar riderCalendar);

    /**
     * 修改数据
     *
     * @param riderCalendar 实例对象
     * @return 实例对象
     */
    RiderCalendar update(RiderCalendar riderCalendar);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Integer id);

}
