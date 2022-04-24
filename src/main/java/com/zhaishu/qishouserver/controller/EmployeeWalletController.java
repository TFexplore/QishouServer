package com.zhaishu.qishouserver.controller;

import com.zhaishu.qishouserver.entity.EmployeeWallet;
import com.zhaishu.qishouserver.service.EmployeeWalletService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (EmployeeWallet)表控制层
 *
 * @author makejava
 * @since 2022-04-18 19:22:40
 */
@RestController
@RequestMapping("employeeWallet")
public class EmployeeWalletController {
    /**
     * 服务对象
     */
    @Resource
    private EmployeeWalletService employeeWalletService;

    /**
     * 分页查询
     *
     * @param employeeWallet 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @GetMapping
    public ResponseEntity<Page<EmployeeWallet>> queryByPage(EmployeeWallet employeeWallet, PageRequest pageRequest) {
        return ResponseEntity.ok(this.employeeWalletService.queryByPage(employeeWallet, pageRequest));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public ResponseEntity<EmployeeWallet> queryById(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(this.employeeWalletService.queryById(id));
    }

    /**
     * 新增数据
     *
     * @param employeeWallet 实体
     * @return 新增结果
     */
    @PostMapping
    public ResponseEntity<EmployeeWallet> add(EmployeeWallet employeeWallet) {
        return ResponseEntity.ok(this.employeeWalletService.insert(employeeWallet));
    }

    /**
     * 编辑数据
     *
     * @param employeeWallet 实体
     * @return 编辑结果
     */
    @PutMapping
    public ResponseEntity<EmployeeWallet> edit(EmployeeWallet employeeWallet) {
        return ResponseEntity.ok(this.employeeWalletService.update(employeeWallet));
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @DeleteMapping
    public ResponseEntity<Boolean> deleteById(Integer id) {
        return ResponseEntity.ok(this.employeeWalletService.deleteById(id));
    }

}

