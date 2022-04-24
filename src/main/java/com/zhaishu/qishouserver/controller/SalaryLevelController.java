package com.zhaishu.qishouserver.controller;

import com.zhaishu.qishouserver.entity.SalaryLevel;
import com.zhaishu.qishouserver.service.SalaryLevelService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * 员工薪酬等级表(SalaryLevel)表控制层
 *
 * @author makejava
 * @since 2022-04-18 19:22:41
 */
@RestController
@RequestMapping("salaryLevel")
public class SalaryLevelController {
    /**
     * 服务对象
     */
    @Resource
    private SalaryLevelService salaryLevelService;

    /**
     * 分页查询
     *
     * @param salaryLevel 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @GetMapping
    public ResponseEntity<Page<SalaryLevel>> queryByPage(SalaryLevel salaryLevel, PageRequest pageRequest) {
        return ResponseEntity.ok(this.salaryLevelService.queryByPage(salaryLevel, pageRequest));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public ResponseEntity<SalaryLevel> queryById(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(this.salaryLevelService.queryById(id));
    }

    /**
     * 新增数据
     *
     * @param salaryLevel 实体
     * @return 新增结果
     */
    @PostMapping
    public ResponseEntity<SalaryLevel> add(SalaryLevel salaryLevel) {
        return ResponseEntity.ok(this.salaryLevelService.insert(salaryLevel));
    }

    /**
     * 编辑数据
     *
     * @param salaryLevel 实体
     * @return 编辑结果
     */
    @PutMapping
    public ResponseEntity<SalaryLevel> edit(SalaryLevel salaryLevel) {
        return ResponseEntity.ok(this.salaryLevelService.update(salaryLevel));
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @DeleteMapping
    public ResponseEntity<Boolean> deleteById(Integer id) {
        return ResponseEntity.ok(this.salaryLevelService.deleteById(id));
    }

}

