package com.zhaishu.qishouserver.controller;

import com.zhaishu.qishouserver.common.ResultResponse;
import com.zhaishu.qishouserver.entity.EmployeeWallet;
import com.zhaishu.qishouserver.service.EmployeeWalletService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
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
@Api(tags = "钱包表", description = "钱包表")
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
    @ApiOperation(value = "通过id获取钱包", notes = "获取钱包")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "token", value = "Token", required = true, dataTypeClass = String.class, paramType = "header")
    })
    public ResultResponse queryById(@PathVariable("id") Integer id) {
        //参数校验

        EmployeeWallet wallet=this.employeeWalletService.queryById(id);
        if (wallet==null){
            return ResultResponse.error("404","不存在的钱包记录");
        }

        return ResultResponse.resultSuccess(wallet);
    }




    @PostMapping("/editWallet")
    @ApiOperation(value = "编辑钱包", notes = "编辑钱包")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "token", value = "Token", required = true, dataTypeClass = String.class, paramType = "header")
    })
    public ResultResponse edit(@RequestBody EmployeeWallet employeeWallet) {
        if (employeeWallet.getEmployeeId()==null){
            return ResultResponse.error("400","缺少必要参数：工号");
        }
        this.employeeWalletService.update(employeeWallet);

        return ResultResponse.resultSuccess("success");
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

