package com.zhaishu.qishouserver.controller;

import com.zhaishu.qishouserver.common.ResultResponse;
import com.zhaishu.qishouserver.entity.InApplication;
import com.zhaishu.qishouserver.entity.Rider;
import com.zhaishu.qishouserver.service.EmployeeService;
import com.zhaishu.qishouserver.service.InApplicationService;
import com.zhaishu.qishouserver.service.RiderService;
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
 * 入职申请表(InApplication)表控制层
 *
 * @author makejava
 * @since 2022-04-18 19:22:40
 */
@RestController
@RequestMapping("inApplication")
@Api(tags = "入职申请表", description = "入职申请表")
public class InApplicationController {
    /**
     * 服务对象
     */
    @Resource
    private InApplicationService inApplicationService;
    @Resource
    private EmployeeService employeeService;
    @Resource
    private RiderService riderService;



    @PostMapping("/edit")
    @ApiOperation(value = "编辑", notes = "编辑")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "token", value = "Token", required = true, dataTypeClass = String.class, paramType = "header")
    })
    public ResultResponse edit(@RequestBody InApplication inApplication) {
        if (inApplication.getEmployeeId()==null){
            return ResultResponse.error("400","缺少必要参数");
        }
        this.inApplicationService.update(inApplication);
        return ResultResponse.resultSuccess("success");
    }

    @GetMapping("{id}")
    @ApiOperation(value = "查询", notes = "查询")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "token", value = "Token", required = true, dataTypeClass = String.class, paramType = "header")
    })
        public ResultResponse queryById(@PathVariable("id") Integer id) {
        InApplication inApplication=this.inApplicationService.queryById(id);
        if (inApplication==null){
            return ResultResponse.error("404","没有找到相关记录");
        }

        return ResultResponse.resultSuccess(inApplication);
    }



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

