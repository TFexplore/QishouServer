package com.zhaishu.qishouserver.controller;

import com.zhaishu.qishouserver.entity.InApplication;
import com.zhaishu.qishouserver.service.InApplicationService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * 入职申请表(InApplication)表控制层
 *
 * @author makejava
 * @since 2022-04-18 19:22:40
 */
@RestController
@RequestMapping("inApplication")
public class InApplicationController {
    /**
     * 服务对象
     */
    @Resource
    private InApplicationService inApplicationService;

    /**
     * 分页查询
     *
     * @param inApplication 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @GetMapping
    public ResponseEntity<Page<InApplication>> queryByPage(InApplication inApplication, PageRequest pageRequest) {
        return ResponseEntity.ok(this.inApplicationService.queryByPage(inApplication, pageRequest));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public ResponseEntity<InApplication> queryById(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(this.inApplicationService.queryById(id));
    }

    /**
     * 新增数据
     *
     * @param inApplication 实体
     * @return 新增结果
     */
    @PostMapping
    public ResponseEntity<InApplication> add(InApplication inApplication) {
        return ResponseEntity.ok(this.inApplicationService.insert(inApplication));
    }

    /**
     * 编辑数据
     *
     * @param inApplication 实体
     * @return 编辑结果
     */
    @PutMapping
    public ResponseEntity<InApplication> edit(InApplication inApplication) {
        return ResponseEntity.ok(this.inApplicationService.update(inApplication));
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @DeleteMapping
    public ResponseEntity<Boolean> deleteById(Integer id) {
        return ResponseEntity.ok(this.inApplicationService.deleteById(id));
    }

}

