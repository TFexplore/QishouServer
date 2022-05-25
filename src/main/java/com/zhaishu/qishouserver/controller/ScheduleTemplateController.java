package com.zhaishu.qishouserver.controller;

import com.zhaishu.qishouserver.entity.ScheduleTemplate;
import com.zhaishu.qishouserver.service.ScheduleTemplateService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (ScheduleTemplate)表控制层
 *
 * @author makejava
 * @since 2022-05-13 21:24:40
 */
@RestController
@RequestMapping("scheduleTemplate")
public class ScheduleTemplateController {
    /**
     * 服务对象
     */
    @Resource
    private ScheduleTemplateService scheduleTemplateService;

    /**
     * 分页查询
     *
     * @param scheduleTemplate 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @GetMapping
    public ResponseEntity<Page<ScheduleTemplate>> queryByPage(ScheduleTemplate scheduleTemplate, PageRequest pageRequest) {
        return ResponseEntity.ok(this.scheduleTemplateService.queryByPage(scheduleTemplate, pageRequest));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public ResponseEntity<ScheduleTemplate> queryById(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(this.scheduleTemplateService.queryById(id));
    }

    /**
     * 新增数据
     *
     * @param scheduleTemplate 实体
     * @return 新增结果
     */
    @PostMapping
    public ResponseEntity<ScheduleTemplate> add(ScheduleTemplate scheduleTemplate) {
        return ResponseEntity.ok(this.scheduleTemplateService.insert(scheduleTemplate));
    }

    /**
     * 编辑数据
     *
     * @param scheduleTemplate 实体
     * @return 编辑结果
     */
    @PutMapping
    public ResponseEntity<ScheduleTemplate> edit(ScheduleTemplate scheduleTemplate) {
        return ResponseEntity.ok(this.scheduleTemplateService.update(scheduleTemplate));
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @DeleteMapping
    public ResponseEntity<Boolean> deleteById(Integer id) {
        return ResponseEntity.ok(this.scheduleTemplateService.deleteById(id));
    }

}

