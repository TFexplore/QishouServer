package com.zhaishu.qishouserver.controller;

import com.zhaishu.qishouserver.entity.DistributeBill;
import com.zhaishu.qishouserver.service.DistributeBillService;
import io.swagger.annotations.Api;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * 骑手配送账单表(DistributeBill)表控制层
 *
 * @author makejava
 * @since 2022-04-18 19:21:34
 */
@RestController
@RequestMapping("distributeBill")
@Api(tags = "配送账单表", description = "")
public class DistributeBillController {
    /**
     * 服务对象
     */
    @Resource
    private DistributeBillService distributeBillService;

    /**
     * 分页查询
     *
     * @param distributeBill 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @GetMapping
    public ResponseEntity<Page<DistributeBill>> queryByPage(DistributeBill distributeBill, PageRequest pageRequest) {
        return ResponseEntity.ok(this.distributeBillService.queryByPage(distributeBill, pageRequest));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public ResponseEntity<DistributeBill> queryById(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(this.distributeBillService.queryById(id));
    }

    /**
     * 新增数据
     *
     * @param distributeBill 实体
     * @return 新增结果
     */
    @PostMapping
    public ResponseEntity<DistributeBill> add(DistributeBill distributeBill) {
        return ResponseEntity.ok(this.distributeBillService.insert(distributeBill));
    }

    /**
     * 编辑数据
     *
     * @param distributeBill 实体
     * @return 编辑结果
     */
    @PutMapping
    public ResponseEntity<DistributeBill> edit(DistributeBill distributeBill) {
        return ResponseEntity.ok(this.distributeBillService.update(distributeBill));
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @DeleteMapping
    public ResponseEntity<Boolean> deleteById(Integer id) {
        return ResponseEntity.ok(this.distributeBillService.deleteById(id));
    }

}

