package com.zhaishu.qishouserver.service.impl;

import com.zhaishu.qishouserver.entity.RiderCalendar;
import com.zhaishu.qishouserver.dao.RiderCalendarDao;
import com.zhaishu.qishouserver.service.RiderCalendarService;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import javax.annotation.Resource;

/**
 * 骑手日历表(RiderCalendar)表服务实现类
 *
 * @author makejava
 * @since 2022-04-18 19:22:41
 */
@Service("riderCalendarService")
public class RiderCalendarServiceImpl implements RiderCalendarService {
    @Resource
    private RiderCalendarDao riderCalendarDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public RiderCalendar queryById(Integer id) {
        return this.riderCalendarDao.queryById(id);
    }

    /**
     * 分页查询
     *
     * @param riderCalendar 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @Override
    public Page<RiderCalendar> queryByPage(RiderCalendar riderCalendar, PageRequest pageRequest) {
        long total = this.riderCalendarDao.count(riderCalendar);
        return new PageImpl<>(this.riderCalendarDao.queryAllByLimit(riderCalendar, pageRequest), pageRequest, total);
    }

    /**
     * 新增数据
     *
     * @param riderCalendar 实例对象
     * @return 实例对象
     */
    @Override
    public RiderCalendar insert(RiderCalendar riderCalendar) {
        this.riderCalendarDao.insert(riderCalendar);
        return riderCalendar;
    }

    /**
     * 修改数据
     *
     * @param riderCalendar 实例对象
     * @return 实例对象
     */
    @Override
    public RiderCalendar update(RiderCalendar riderCalendar) {
        this.riderCalendarDao.update(riderCalendar);
        return this.queryById(riderCalendar.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.riderCalendarDao.deleteById(id) > 0;
    }
}
