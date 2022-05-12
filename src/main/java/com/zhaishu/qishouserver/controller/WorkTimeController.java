package com.zhaishu.qishouserver.controller;

import com.zhaishu.qishouserver.entity.WorkTime;
import com.zhaishu.qishouserver.service.WorkTimeService;
import io.swagger.annotations.Api;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * 工作时段表(WorkTime)表控制层
 *
 * @author makejava
 * @since 2022-04-18 19:22:41
 */
@RestController
@RequestMapping("workTime")
@Api(tags = "工作时段表", description = "")
public class WorkTimeController {
    /**
     * 服务对象
     */
    @Resource
    private WorkTimeService workTimeService;

    /**
     * 分页查询
     *
     * @param workTime 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @GetMapping
    public ResponseEntity<Page<WorkTime>> queryByPage(WorkTime workTime, PageRequest pageRequest) {
        return ResponseEntity.ok(this.workTimeService.queryByPage(workTime, pageRequest));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public ResponseEntity<WorkTime> queryById(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(this.workTimeService.queryById(id));
    }


    /**
     * 编辑数据
     *
     * @param workTime 实体
     * @return 编辑结果
     */
    @PutMapping
    public ResponseEntity<WorkTime> edit(WorkTime workTime) {
        return ResponseEntity.ok(this.workTimeService.update(workTime));
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @DeleteMapping
    public ResponseEntity<Boolean> deleteById(Integer id) {
        return ResponseEntity.ok(this.workTimeService.deleteById(id));
    }

}

