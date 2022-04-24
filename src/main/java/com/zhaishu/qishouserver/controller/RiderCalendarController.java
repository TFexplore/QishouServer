package com.zhaishu.qishouserver.controller;

import com.zhaishu.qishouserver.entity.RiderCalendar;
import com.zhaishu.qishouserver.service.RiderCalendarService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * 骑手日历表(RiderCalendar)表控制层
 *
 * @author makejava
 * @since 2022-04-18 19:22:41
 */
@RestController
@RequestMapping("riderCalendar")
public class RiderCalendarController {
    /**
     * 服务对象
     */
    @Resource
    private RiderCalendarService riderCalendarService;

    /**
     * 分页查询
     *
     * @param riderCalendar 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @GetMapping
    public ResponseEntity<Page<RiderCalendar>> queryByPage(RiderCalendar riderCalendar, PageRequest pageRequest) {
        return ResponseEntity.ok(this.riderCalendarService.queryByPage(riderCalendar, pageRequest));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public ResponseEntity<RiderCalendar> queryById(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(this.riderCalendarService.queryById(id));
    }

    /**
     * 新增数据
     *
     * @param riderCalendar 实体
     * @return 新增结果
     */
    @PostMapping
    public ResponseEntity<RiderCalendar> add(RiderCalendar riderCalendar) {
        return ResponseEntity.ok(this.riderCalendarService.insert(riderCalendar));
    }

    /**
     * 编辑数据
     *
     * @param riderCalendar 实体
     * @return 编辑结果
     */
    @PutMapping
    public ResponseEntity<RiderCalendar> edit(RiderCalendar riderCalendar) {
        return ResponseEntity.ok(this.riderCalendarService.update(riderCalendar));
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @DeleteMapping
    public ResponseEntity<Boolean> deleteById(Integer id) {
        return ResponseEntity.ok(this.riderCalendarService.deleteById(id));
    }

}

