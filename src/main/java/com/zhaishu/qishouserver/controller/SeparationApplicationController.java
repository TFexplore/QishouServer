package com.zhaishu.qishouserver.controller;

import com.zhaishu.qishouserver.common.ResultResponse;
import com.zhaishu.qishouserver.entity.SeparationApplication;
import com.zhaishu.qishouserver.service.SeparationApplicationService;
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
 * 离职申请表(SeparationApplication)表控制层
 *
 * @author makejava
 * @since 2022-04-18 19:22:41
 */
@RestController
@RequestMapping("separationApplication")
@Api(tags = "离职申请表", description = "离职申请表")
public class SeparationApplicationController {
    /**
     * 服务对象
     */
    @Resource
    private SeparationApplicationService separationApplicationService;


    @GetMapping("{id}")
    @ApiOperation(value = "获取", notes = "获取")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "token", value = "Token", required = true, dataTypeClass = String.class, paramType = "header")
    })
    public ResultResponse queryById(@PathVariable("id") Integer id) {
        SeparationApplication separationApplication=this.separationApplicationService.queryById(id);
        if (separationApplication==null){
            return ResultResponse.error("404","not found");
        }

        return ResultResponse.resultSuccess(separationApplication);
    }
    @PutMapping
    @ApiOperation(value = "编辑", notes = "编辑 传入id和需要的字段")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "token", value = "Token", required = true, dataTypeClass = String.class, paramType = "header")
    })
    public ResultResponse edit(@RequestBody SeparationApplication separationApplication) {
        if (separationApplication.getEmployeeId()==null){
            return ResultResponse.error("400","miss id");
        }
        this.separationApplicationService.update(separationApplication);
        return ResultResponse.resultSuccess("success");
    }
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

