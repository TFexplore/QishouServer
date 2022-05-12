package com.zhaishu.qishouserver.service;

import com.zhaishu.qishouserver.Vo.DateVo;
import com.zhaishu.qishouserver.entity.RiderCalendar;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.List;

/**
 * 骑手日历表(RiderCalendar)表服务接口
 *
 * @author makejava
 * @since 2022-04-18 19:22:41
 */
public interface RiderCalendarService {


    List<DateVo> getCalendars(RiderCalendar riderCalendar, Integer limit, Integer offset);

    RiderCalendar queryById(Integer id);


    List<RiderCalendar> queryByPage(@Param("c") RiderCalendar riderCalendar, Integer limit, Integer offset);

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
