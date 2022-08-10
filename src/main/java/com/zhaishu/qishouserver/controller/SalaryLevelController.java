package com.zhaishu.qishouserver.controller;

import com.zhaishu.qishouserver.Security.UserToken;
import com.zhaishu.qishouserver.common.ResultResponse;
import com.zhaishu.qishouserver.common.Utils;
import com.zhaishu.qishouserver.entity.Employee;
import com.zhaishu.qishouserver.entity.EmployeeSalary;
import com.zhaishu.qishouserver.entity.SalaryLevel;
import com.zhaishu.qishouserver.service.EmployeeSalaryService;
import com.zhaishu.qishouserver.service.EmployeeService;
import com.zhaishu.qishouserver.service.SalaryLevelService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * 员工薪酬奖罚条件模板(SalaryLevel)表控制层
 *
 * @author makejava
 * @since 2022-07-08 15:21:18
 */
@RestController
@RequestMapping("salaryLevel")
@Api(tags = "AAA薪资模板表", description = "")
public class SalaryLevelController {
    /**
     * 服务对象
     */
    @Resource
    private SalaryLevelService salaryLevelService;
    @Resource
    private EmployeeService employeeService;
    @Resource
    private EmployeeSalaryService salaryService;

    @PostMapping("/add")
    @ApiOperation(value = "新增",notes="创建薪资模板:{\n" +
            "  \"name\": \"\"," +"模板名称"+
            "  \"describe\": \"\"," +"描述备注"+
            "  \"employeeId\": 0," +"员工id，模板的员工id为0"+
            "  \"salary\": 0," +"薪资数目"+
            "  \"salaryLevel\": 0,薪资等级：1，2，3，4，5，6，暂时没用"+
            "}")
    @UserToken.HR
    @ApiImplicitParams({
            @ApiImplicitParam(name = "token", value = "用户token", required = true, dataType = "String", paramType = "header"),
    })
    public ResultResponse add(@RequestBody SalaryLevel salaryLevel){

        if (salaryLevel.getSalary()==null||salaryLevel.getDescribe()==null){
            return ResultResponse.error("400","请输入必要的参数");
        }

        SalaryLevel r=salaryLevelService.insert(salaryLevel);


        return ResultResponse.resultSuccess(r);
    }
    @DeleteMapping("/delete")
    @ApiOperation(value = "删除",notes=" ")
    @UserToken.HR
    @ApiImplicitParams({
            @ApiImplicitParam(name = "token", value = "用户token", required = true, dataType = "String", paramType = "header"),
    })
    public ResultResponse delete(Integer salaryId){

        if (salaryLevelService.queryById(salaryId)==null){

            return ResultResponse.error("404","没有找到相关记录salaryId="+salaryId);
        }

        if (salaryLevelService.deleteById(salaryId)){
            return ResultResponse.resultSuccess("删除成功");
        }

        return ResultResponse.error("500","删除失败，请联系管理员");
    }
    @PostMapping("/edit")
    @ApiOperation(value = "编辑",notes=" ")
    @UserToken.HR
    @ApiImplicitParams({
            @ApiImplicitParam(name = "token", value = "用户token", required = true, dataType = "String", paramType = "header"),
    })
    public ResultResponse edit(@RequestBody SalaryLevel salaryLevel){
        if (salaryLevel.getId()==null){
            return ResultResponse.error("400","请输入必要的参数");
        }
        salaryLevelService.update(salaryLevel);

        return ResultResponse.resultSuccess("更新成功");
    }
    @PostMapping("/getInfo")
    @ApiOperation(value = "单个查询",notes="传薪资id或者用户id之一")
    @UserToken.HR
    @ApiImplicitParams({
            @ApiImplicitParam(name = "token", value = "用户token", required = true, dataType = "String", paramType = "header"),
    })
    public ResultResponse getInfo(@RequestBody SalaryLevel salaryLevel){
        if (salaryLevel.getId()!=null){
            return ResultResponse.resultSuccess(salaryLevelService.queryById(salaryLevel.getId()));
        }
        else if (salaryLevel.getEmployeeId()!=null&&salaryLevel.getEmployeeId()!=0){
            return ResultResponse.resultSuccess(salaryLevelService.queryByEmId(salaryLevel.getEmployeeId()));
        }

        return ResultResponse.error("400","传入必要的参数");
    }
    @PostMapping("/list")
    @ApiOperation(value = "获取基础薪资模板列表",notes="employeeId=0 ")
    @UserToken.HR
    @ApiImplicitParams({
            @ApiImplicitParam(name = "token", value = "用户token", required = true, dataType = "String", paramType = "header"),
    })
    public ResultResponse list(@RequestBody SalaryLevel salaryLevel,Integer limit,Integer offset){
        //校验参数
        if (limit==null||offset==null){
            return ResultResponse.error("400","请传入正确的limit和offset");
        }


        return ResultResponse.resultMap(salaryLevelService.count(salaryLevel),salaryLevelService.getList(salaryLevel,limit,offset));
    }
    @PostMapping("/bind")
    @ApiOperation(value = "绑定薪资水平",notes="传入薪资模板id，用户id")
    @UserToken.HR
    @ApiImplicitParams({
            @ApiImplicitParam(name = "token", value = "用户token", required = true, dataType = "String", paramType = "header"),
    })
    @Transactional
    public ResultResponse bind(Integer salaryId,Integer employeeId){
        SalaryLevel org=salaryLevelService.queryByEmId(employeeId);

        if (org==null){
            SalaryLevel salaryLevel=salaryLevelService.queryById(salaryId);
            salaryLevel.setId(null);
            salaryLevel.setEmployeeId(employeeId);
            SalaryLevel r=salaryLevelService.insert(salaryLevel);
        }else {
            SalaryLevel salaryLevel=salaryLevelService.queryById(salaryId);
            salaryLevel.setId(org.getId());
            salaryLevel.setEmployeeId(employeeId);
            SalaryLevel r=salaryLevelService.update(salaryLevel);
        }
        SalaryLevel  r=salaryLevelService.queryByEmId(employeeId);

        Employee employee=new Employee();
        employee.setEmployeeId(employeeId);
        employee.setSarlaryLevel(r.getId());

        employeeService.update(employee);
        EmployeeSalary salary=salaryService.queryByMonth(Utils.getMonthId(),employeeId);
        if (salary!=null){
            salary.setTotalPay(salary.getTotalPay()-salary.getBaseSalary());
            salary.setBaseSalary(r.getSalary());
            salary.setTotalPay(salary.getTotalPay()+salary.getBaseSalary());
            salaryService.update(salary);

        }


        return ResultResponse.resultSuccess(r);
    }



}

