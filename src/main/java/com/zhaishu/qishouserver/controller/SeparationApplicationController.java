package com.zhaishu.qishouserver.controller;

import com.zhaishu.qishouserver.entity.SeparationApplication;
import com.zhaishu.qishouserver.service.SeparationApplicationService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * 离职申请表(SeparationApplication)表控制层
 *
 * @author makejava
 * @since 2022-04-18 19:22:41
 */
@RestController
@RequestMapping("separationApplication")
public class SeparationApplicationController {
    /**
     * 服务对象
     */
    @Resource
    private SeparationApplicationService separationApplicationService;

    /**
     * 分页查询
     *
     * @param separationApplication 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @GetMapping
    public ResponseEntity<Page<SeparationApplication>> queryByPage(SeparationApplication separationApplication, PageRequest pageRequest) {
        return ResponseEntity.ok(this.separationApplicationService.queryByPage(separationApplication, pageRequest));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public ResponseEntity<SeparationApplication> queryById(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(this.separationApplicationService.queryById(id));
    }

    /**
     * 新增数据
     *
     * @param separationApplication 实体
     * @return 新增结果
     */
    @PostMapping
    public ResponseEntity<SeparationApplication> add(SeparationApplication separationApplication) {
        return ResponseEntity.ok(this.separationApplicationService.insert(separationApplication));
    }

    /**
     * 编辑数据
     *
     * @param separationApplication 实体
     * @return 编辑结果
     */
    @PutMapping
    public ResponseEntity<SeparationApplication> edit(SeparationApplication separationApplication) {
        return ResponseEntity.ok(this.separationApplicationService.update(separationApplication));
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @DeleteMapping
    public ResponseEntity<Boolean> deleteById(Integer id) {
        return ResponseEntity.ok(this.separationApplicationService.deleteById(id));
    }

}

