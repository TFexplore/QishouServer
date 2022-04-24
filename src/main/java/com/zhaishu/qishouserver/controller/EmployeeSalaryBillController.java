package com.zhaishu.qishouserver.controller;

import com.zhaishu.qishouserver.entity.EmployeeSalaryBill;
import com.zhaishu.qishouserver.service.EmployeeSalaryBillService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (EmployeeSalaryBill)表控制层
 *
 * @author makejava
 * @since 2022-04-18 19:22:40
 */
@RestController
@RequestMapping("employeeSalaryBill")
public class EmployeeSalaryBillController {
    /**
     * 服务对象
     */
    @Resource
    private EmployeeSalaryBillService employeeSalaryBillService;

    /**
     * 分页查询
     *
     * @param employeeSalaryBill 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @GetMapping
    public ResponseEntity<Page<EmployeeSalaryBill>> queryByPage(EmployeeSalaryBill employeeSalaryBill, PageRequest pageRequest) {
        return ResponseEntity.ok(this.employeeSalaryBillService.queryByPage(employeeSalaryBill, pageRequest));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public ResponseEntity<EmployeeSalaryBill> queryById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(this.employeeSalaryBillService.queryById(id));
    }

    /**
     * 新增数据
     *
     * @param employeeSalaryBill 实体
     * @return 新增结果
     */
    @PostMapping
    public ResponseEntity<EmployeeSalaryBill> add(EmployeeSalaryBill employeeSalaryBill) {
        return ResponseEntity.ok(this.employeeSalaryBillService.insert(employeeSalaryBill));
    }

    /**
     * 编辑数据
     *
     * @param employeeSalaryBill 实体
     * @return 编辑结果
     */
    @PutMapping
    public ResponseEntity<EmployeeSalaryBill> edit(EmployeeSalaryBill employeeSalaryBill) {
        return ResponseEntity.ok(this.employeeSalaryBillService.update(employeeSalaryBill));
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @DeleteMapping
    public ResponseEntity<Boolean> deleteById(Long id) {
        return ResponseEntity.ok(this.employeeSalaryBillService.deleteById(id));
    }

}

