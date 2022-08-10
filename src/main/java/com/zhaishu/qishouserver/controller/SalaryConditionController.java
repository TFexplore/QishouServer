package com.zhaishu.qishouserver.controller;

import com.zhaishu.qishouserver.Security.UserToken;
import com.zhaishu.qishouserver.common.ResultResponse;
import com.zhaishu.qishouserver.entity.SalaryCondition;
import com.zhaishu.qishouserver.service.SalaryConditionService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (SalaryCondition)表控制层
 *
 * @author makejava
 * @since 2022-07-08 15:24:32
 */
@RestController
@RequestMapping("salaryCondition")
@Api(tags = "AAA奖罚模板表", description = "")
public class SalaryConditionController {
    /**
     * 服务对象
     */
    @Resource
    private SalaryConditionService salaryConditionService;


    @GetMapping("/id")
    @ApiOperation(value = "id单个查询", notes = "传入id")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "token", value = "Token", required = true, dataTypeClass = String.class, paramType = "header")
    })
    @UserToken.HR
    public ResultResponse id(Integer id){

        SalaryCondition salaryCondition=salaryConditionService.queryById(id);
        if (salaryCondition==null){
            return ResultResponse.error("404","没有找到相关记录");
        }

        return ResultResponse.resultSuccess(salaryCondition);
    }

    @PostMapping("/list")
    @ApiOperation(value = "获取列表", notes = "传入空，单独获取罚金模板或奖金模板列表时请设置resultsType值 结果类型：1.加，2.罚")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "token", value = "Token", required = true, dataTypeClass = String.class, paramType = "header")
    })
    public ResultResponse list(@RequestBody SalaryCondition salaryCondition,Integer limit,Integer offset){

        //校验参数
        if (limit==null||offset==null){
            return ResultResponse.error("400","请传入正确的limit和offset");
        }


        return ResultResponse.resultMap(salaryConditionService.count(salaryCondition),salaryConditionService.queryByPage(salaryCondition,limit,offset));
    }
    @PostMapping("/add")
    @ApiOperation(value = "新增", notes = "传入orderId")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "token", value = "Token", required = true, dataTypeClass = String.class, paramType = "header")
    })
    @UserToken.HR
    public ResultResponse add(@RequestBody SalaryCondition salaryCondition){

        if (salaryCondition.getName()==null){

            return ResultResponse.error("400","请传入模板名称");
        }


        return ResultResponse.resultSuccess(salaryConditionService.insert(salaryCondition));
    }
    @PostMapping("/edit")
    @ApiOperation(value = "修改", notes = "传入orderId")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "token", value = "Token", required = true, dataTypeClass = String.class, paramType = "header")
    })
    @UserToken.HR
    public ResultResponse edit(@RequestBody SalaryCondition salaryCondition){
        if (salaryCondition.getId()==null){

            return ResultResponse.error("400","请传入模板id");
        }

        return ResultResponse.resultSuccess(salaryConditionService.update(salaryCondition));
    }
    @DeleteMapping("/delete")
    @ApiOperation(value = "新增", notes = "传入orderId")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "token", value = "Token", required = true, dataTypeClass = String.class, paramType = "header")
    })
    @UserToken.HR
    public ResultResponse delete(Integer id){

        if (!salaryConditionService.deleteById(id)){
            return ResultResponse.error("500","删除失败，请联系管理员");
        }
        return ResultResponse.resultSuccess("删除成功");
    }
}

