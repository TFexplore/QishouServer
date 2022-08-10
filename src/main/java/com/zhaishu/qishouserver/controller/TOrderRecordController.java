package com.zhaishu.qishouserver.controller;

import com.zhaishu.qishouserver.Security.UserToken;
import com.zhaishu.qishouserver.common.ResultResponse;
import com.zhaishu.qishouserver.entity.TOrderRecord;
import com.zhaishu.qishouserver.service.TOrderRecordService;
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
 * (TOrderRecord)表控制层
 *
 * @author makejava
 * @since 2022-07-18 11:54:53
 */
@RestController
@RequestMapping("tOrderRecord")
@Api(tags = "AAA订单状态表", description = "表")
public class TOrderRecordController {
    /**
     * 服务对象
     */
    @Resource
    private TOrderRecordService tOrderRecordService;

    /**
     * 分页查询
     *
     * @param tOrderRecord 筛选条件
     * @param      
     * @return 查询结果
     */
    @PostMapping("/getStatus")
        @ApiOperation(value = "获取订单全部状态", notes = "传入筛选字段等必要信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "token", value = "Token", required = true, dataTypeClass = String.class, paramType = "header")
    })
    @UserToken.Admin
    public ResultResponse getStatus(@RequestBody TOrderRecord tOrderRecord) {

        if(tOrderRecord.getOrderCode()==null){
        return ResultResponse.error("400","please input the limit key");
        }
        
        return ResultResponse.resultSuccess(this.tOrderRecordService.queryByPage(tOrderRecord, 0,20));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("/queryById")
        @ApiOperation(value = "查询单条", notes = "传入id")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "token", value = "Token", required = true, dataTypeClass = String.class, paramType = "header")
    })
    @UserToken.Admin
    public ResultResponse queryById(Long id) {
        TOrderRecord q=this.tOrderRecordService.queryById(id);
        if(q==null){
         return ResultResponse.error("404","not found the record");
        }
    
    
        return ResultResponse.resultSuccess(q);
    }

    /**
     * 新增数据
     *
     * @param tOrderRecord 实体
     * @return 新增结果
     */
    @PostMapping("/add")
        @ApiOperation(value = "新增", notes = "传入必要信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "token", value = "Token", required = true, dataTypeClass = String.class, paramType = "header")
    })
    @UserToken.Admin
    public ResultResponse add(@RequestBody TOrderRecord tOrderRecord) {
        return ResultResponse.resultSuccess(this.tOrderRecordService.insert(tOrderRecord));
    }

    /**
     * 编辑数据
     *
     * @param tOrderRecord 实体
     * @return 编辑结果
     */
    @PostMapping("/edit")
        @ApiOperation(value = "修改编辑", notes = "传入唯一字段和需要修改的字段")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "token", value = "Token", required = true, dataTypeClass = String.class, paramType = "header")
    })
    @UserToken.Admin
    public ResultResponse edit(@RequestBody TOrderRecord tOrderRecord) {
        if(tOrderRecord.getOrderCode()==null){
        return ResultResponse.error("400","please input the key");
        }
        
        return ResultResponse.resultSuccess(this.tOrderRecordService.update(tOrderRecord));
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @DeleteMapping
    public ResultResponse deleteById(Long id) {
        if(!this.tOrderRecordService.deleteById(id)){
        
        return  ResultResponse.error("500","删除失败，请联系管理员");
        
        }
    
        return ResultResponse.resultSuccess("操作成功");
    }

}

