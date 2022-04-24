package com.zhaishu.qishouserver.controller;

import com.zhaishu.qishouserver.entity.ReceiptOfTransfer;
import com.zhaishu.qishouserver.service.ReceiptOfTransferService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * 转账回执单(ReceiptOfTransfer)表控制层
 *
 * @author makejava
 * @since 2022-04-18 19:22:41
 */
@RestController
@RequestMapping("receiptOfTransfer")
public class ReceiptOfTransferController {
    /**
     * 服务对象
     */
    @Resource
    private ReceiptOfTransferService receiptOfTransferService;

    /**
     * 分页查询
     *
     * @param receiptOfTransfer 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @GetMapping
    public ResponseEntity<Page<ReceiptOfTransfer>> queryByPage(ReceiptOfTransfer receiptOfTransfer, PageRequest pageRequest) {
        return ResponseEntity.ok(this.receiptOfTransferService.queryByPage(receiptOfTransfer, pageRequest));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public ResponseEntity<ReceiptOfTransfer> queryById(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(this.receiptOfTransferService.queryById(id));
    }

    /**
     * 新增数据
     *
     * @param receiptOfTransfer 实体
     * @return 新增结果
     */
    @PostMapping
    public ResponseEntity<ReceiptOfTransfer> add(ReceiptOfTransfer receiptOfTransfer) {
        return ResponseEntity.ok(this.receiptOfTransferService.insert(receiptOfTransfer));
    }

    /**
     * 编辑数据
     *
     * @param receiptOfTransfer 实体
     * @return 编辑结果
     */
    @PutMapping
    public ResponseEntity<ReceiptOfTransfer> edit(ReceiptOfTransfer receiptOfTransfer) {
        return ResponseEntity.ok(this.receiptOfTransferService.update(receiptOfTransfer));
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @DeleteMapping
    public ResponseEntity<Boolean> deleteById(Integer id) {
        return ResponseEntity.ok(this.receiptOfTransferService.deleteById(id));
    }

}

