package com.zhaishu.qishouserver.controller;

import com.zhaishu.qishouserver.entity.RiderSchedule;
import com.zhaishu.qishouserver.service.RiderScheduleService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * 骑手排班表(RiderSchedule)表控制层
 *
 * @author makejava
 * @since 2022-04-18 19:22:41
 */
@RestController
@RequestMapping("riderSchedule")
public class RiderScheduleController {
    /**
     * 服务对象
     */
    @Resource
    private RiderScheduleService riderScheduleService;

    /**
     * 分页查询
     *
     * @param riderSchedule 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @GetMapping
    public ResponseEntity<Page<RiderSchedule>> queryByPage(RiderSchedule riderSchedule, PageRequest pageRequest) {
        return ResponseEntity.ok(this.riderScheduleService.queryByPage(riderSchedule, pageRequest));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public ResponseEntity<RiderSchedule> queryById(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(this.riderScheduleService.queryById(id));
    }

    /**
     * 新增数据
     *
     * @param riderSchedule 实体
     * @return 新增结果
     */
    @PostMapping
    public ResponseEntity<RiderSchedule> add(RiderSchedule riderSchedule) {
        return ResponseEntity.ok(this.riderScheduleService.insert(riderSchedule));
    }

    /**
     * 编辑数据
     *
     * @param riderSchedule 实体
     * @return 编辑结果
     */
    @PutMapping
    public ResponseEntity<RiderSchedule> edit(RiderSchedule riderSchedule) {
        return ResponseEntity.ok(this.riderScheduleService.update(riderSchedule));
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @DeleteMapping
    public ResponseEntity<Boolean> deleteById(Integer id) {
        return ResponseEntity.ok(this.riderScheduleService.deleteById(id));
    }

}

