package com.zhaishu.qishouserver.controller;

import com.zhaishu.qishouserver.entity.ApplyWithdraw;
import com.zhaishu.qishouserver.service.ApplyWithdrawService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (ApplyWithdraw)表控制层
 *
 * @author makejava
 * @since 2022-04-18 19:15:49
 */
@RestController
@RequestMapping("applyWithdraw")
public class ApplyWithdrawController {
    /**
     * 服务对象
     */
    @Resource
    private ApplyWithdrawService applyWithdrawService;

    /**
     * 分页查询
     *
     * @param applyWithdraw 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @GetMapping
    public ResponseEntity<Page<ApplyWithdraw>> queryByPage(ApplyWithdraw applyWithdraw, PageRequest pageRequest) {
        return ResponseEntity.ok(this.applyWithdrawService.queryByPage(applyWithdraw, pageRequest));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public ResponseEntity<ApplyWithdraw> queryById(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(this.applyWithdrawService.queryById(id));
    }

    /**
     * 新增数据
     *
     * @param applyWithdraw 实体
     * @return 新增结果
     */
    @PostMapping
    public ResponseEntity<ApplyWithdraw> add(ApplyWithdraw applyWithdraw) {
        return ResponseEntity.ok(this.applyWithdrawService.insert(applyWithdraw));
    }

    /**
     * 编辑数据
     *
     * @param applyWithdraw 实体
     * @return 编辑结果
     */
    @PutMapping
    public ResponseEntity<ApplyWithdraw> edit(ApplyWithdraw applyWithdraw) {
        return ResponseEntity.ok(this.applyWithdrawService.update(applyWithdraw));
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @DeleteMapping
    public ResponseEntity<Boolean> deleteById(Integer id) {
        return ResponseEntity.ok(this.applyWithdrawService.deleteById(id));
    }

}

