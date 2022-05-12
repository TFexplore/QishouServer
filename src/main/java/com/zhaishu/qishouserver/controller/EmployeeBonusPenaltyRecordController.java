package com.zhaishu.qishouserver.controller;

import com.zhaishu.qishouserver.entity.EmployeeBonusPenaltyRecord;
import com.zhaishu.qishouserver.service.EmployeeBonusPenaltyRecordService;
import io.swagger.annotations.Api;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * 奖罚记录表(EmployeeBonusPenaltyRecord)表控制层
 *
 * @author makejava
 * @since 2022-04-18 19:22:40
 */
@RestController
@RequestMapping("employeeBonusPenaltyRecord")
@Api(tags = "骑手记录赏罚表", description = "")
public class EmployeeBonusPenaltyRecordController {
    /**
     * 服务对象
     */
    @Resource
    private EmployeeBonusPenaltyRecordService employeeBonusPenaltyRecordService;

    /**
     * 分页查询
     *
     * @param employeeBonusPenaltyRecord 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @GetMapping
    public ResponseEntity<Page<EmployeeBonusPenaltyRecord>> queryByPage(EmployeeBonusPenaltyRecord employeeBonusPenaltyRecord, PageRequest pageRequest) {
        return ResponseEntity.ok(this.employeeBonusPenaltyRecordService.queryByPage(employeeBonusPenaltyRecord, pageRequest));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public ResponseEntity<EmployeeBonusPenaltyRecord> queryById(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(this.employeeBonusPenaltyRecordService.queryById(id));
    }

    /**
     * 新增数据
     *
     * @param employeeBonusPenaltyRecord 实体
     * @return 新增结果
     */
    @PostMapping
    public ResponseEntity<EmployeeBonusPenaltyRecord> add(EmployeeBonusPenaltyRecord employeeBonusPenaltyRecord) {
        return ResponseEntity.ok(this.employeeBonusPenaltyRecordService.insert(employeeBonusPenaltyRecord));
    }

    /**
     * 编辑数据
     *
     * @param employeeBonusPenaltyRecord 实体
     * @return 编辑结果
     */
    @PutMapping
    public ResponseEntity<EmployeeBonusPenaltyRecord> edit(EmployeeBonusPenaltyRecord employeeBonusPenaltyRecord) {
        return ResponseEntity.ok(this.employeeBonusPenaltyRecordService.update(employeeBonusPenaltyRecord));
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @DeleteMapping
    public ResponseEntity<Boolean> deleteById(Integer id) {
        return ResponseEntity.ok(this.employeeBonusPenaltyRecordService.deleteById(id));
    }

}

