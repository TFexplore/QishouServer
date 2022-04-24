package com.zhaishu.qishouserver.controller;

import com.zhaishu.qishouserver.entity.RejectRecord;
import com.zhaishu.qishouserver.service.RejectRecordService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * 拒接与超时记录表(RejectRecord)表控制层
 *
 * @author makejava
 * @since 2022-04-19 11:08:13
 */
@RestController
@RequestMapping("rejectRecord")
public class RejectRecordController {
    /**
     * 服务对象
     */
    @Resource
    private RejectRecordService rejectRecordService;

    /**
     * 分页查询
     *
     * @param rejectRecord 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @GetMapping
    public ResponseEntity<Page<RejectRecord>> queryByPage(RejectRecord rejectRecord, PageRequest pageRequest) {
        return ResponseEntity.ok(this.rejectRecordService.queryByPage(rejectRecord, pageRequest));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public ResponseEntity<RejectRecord> queryById(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(this.rejectRecordService.queryById(id));
    }

    /**
     * 新增数据
     *
     * @param rejectRecord 实体
     * @return 新增结果
     */
    @PostMapping
    public ResponseEntity<RejectRecord> add(RejectRecord rejectRecord) {
        return ResponseEntity.ok(this.rejectRecordService.insert(rejectRecord));
    }

    /**
     * 编辑数据
     *
     * @param rejectRecord 实体
     * @return 编辑结果
     */
    @PutMapping
    public ResponseEntity<RejectRecord> edit(RejectRecord rejectRecord) {
        return ResponseEntity.ok(this.rejectRecordService.update(rejectRecord));
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @DeleteMapping
    public ResponseEntity<Boolean> deleteById(Integer id) {
        return ResponseEntity.ok(this.rejectRecordService.deleteById(id));
    }

}

