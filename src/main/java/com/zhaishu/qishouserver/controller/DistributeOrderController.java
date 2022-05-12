package com.zhaishu.qishouserver.controller;

import com.zhaishu.qishouserver.entity.DistributeOrder;
import com.zhaishu.qishouserver.service.DistributeOrderService;
import io.swagger.annotations.Api;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * 骑手配送信息表(DistributeOrder)表控制层
 *
 * @author makejava
 * @since 2022-04-18 19:22:40
 */
@RestController
@RequestMapping("distributeOrder")
@Api(tags = "配送订单表", description = "")
public class DistributeOrderController {
    /**
     * 服务对象
     */
    @Resource
    private DistributeOrderService distributeOrderService;

    /**
     * 分页查询
     *
     * @param distributeOrder 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @GetMapping
    public ResponseEntity<Page<DistributeOrder>> queryByPage(DistributeOrder distributeOrder, PageRequest pageRequest) {
        return ResponseEntity.ok(this.distributeOrderService.queryByPage(distributeOrder, pageRequest));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public ResponseEntity<DistributeOrder> queryById(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(this.distributeOrderService.queryById(id));
    }

    /**
     * 新增数据
     *
     * @param distributeOrder 实体
     * @return 新增结果
     */
    @PostMapping
    public ResponseEntity<DistributeOrder> add(DistributeOrder distributeOrder) {
        return ResponseEntity.ok(this.distributeOrderService.insert(distributeOrder));
    }

    /**
     * 编辑数据
     *
     * @param distributeOrder 实体
     * @return 编辑结果
     */
    @PutMapping
    public ResponseEntity<DistributeOrder> edit(DistributeOrder distributeOrder) {
        return ResponseEntity.ok(this.distributeOrderService.update(distributeOrder));
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @DeleteMapping
    public ResponseEntity<Boolean> deleteById(Integer id) {
        return ResponseEntity.ok(this.distributeOrderService.deleteById(id));
    }

}

