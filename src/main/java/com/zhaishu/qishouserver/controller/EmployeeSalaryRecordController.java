package com.zhaishu.qishouserver.controller;

import com.zhaishu.qishouserver.Security.UserToken;
import com.zhaishu.qishouserver.common.ResultResponse;
import com.zhaishu.qishouserver.common.Utils;
import com.zhaishu.qishouserver.entity.EmployeeSalary;
import com.zhaishu.qishouserver.entity.EmployeeSalaryRecord;
import com.zhaishu.qishouserver.entity.SalaryLevel;
import com.zhaishu.qishouserver.service.EmployeeSalaryRecordService;
import com.zhaishu.qishouserver.service.EmployeeSalaryService;
import com.zhaishu.qishouserver.service.SalaryLevelService;
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
 * (EmployeeSalaryRecord)表控制层
 *
 * @author makejava
 * @since 2022-07-14 12:37:16
 */
@RestController
@RequestMapping("employeeSalaryRecord")
@Api(tags = "AAA金额变化事件记录表", description = "")
public class EmployeeSalaryRecordController {
    /**
     * 服务对象
     */
    @Resource
    private EmployeeSalaryRecordService employeeSalaryRecordService;
    @Resource
    private EmployeeSalaryService salaryService;
    @Resource
    private SalaryLevelService salaryLevelService;
    /**
     * 分页查询
     *
     * @param employeeSalaryRecord 筛选条件
     * @param
     * @return 查询结果
     */
    @PostMapping("/queryByPage")
    @ApiOperation(value = "详细记录列表" ,notes ="传入用户工号，月份Id")
    @UserToken.Admin
    @ApiImplicitParams({
            @ApiImplicitParam(name = "token", value = "用户token", required = true, dataType = "String", paramType = "header"),
    })
    public ResultResponse queryByPage(@RequestBody EmployeeSalaryRecord employeeSalaryRecord, Integer offset, Integer limit) {
        //校验参数
        if (limit==null||offset==null){
            return ResultResponse.error("400","请传入正确的limit和offset");
        }
        if (employeeSalaryRecord.getEmployeeId()==null){
            return ResultResponse.error("400","请传入employeeId()");
        }
        if (employeeSalaryRecord.getMonthId()==null){
            return ResultResponse.error("400","请传入MonthId");
        }




        return ResultResponse.resultMap(employeeSalaryRecordService.count(employeeSalaryRecord),this.employeeSalaryRecordService.queryByPage(employeeSalaryRecord, offset,limit));

    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("/queryById")
    @ApiOperation(value = "通过Id查询单条记录" ,notes ="")
    @UserToken.Admin
    @ApiImplicitParams({
            @ApiImplicitParam(name = "token", value = "用户token", required = true, dataType = "String", paramType = "header"),
    })
    public ResultResponse queryById(Integer id) {
        EmployeeSalaryRecord salaryRecord=this.employeeSalaryRecordService.queryById(id);
        if (salaryRecord==null){
            return ResultResponse.error("404","未找到相关记录");
        }

        return ResultResponse.resultSuccess(salaryRecord);
    }

    /**
     * 新增数据
     *
     * @param employeeSalaryRecord 实体
     * @return 新增结果
     */
    @PostMapping("/add")
    @ApiOperation(value = "新增" ,notes ="必要信息:除id外全部字段")
    @UserToken.Admin
    @ApiImplicitParams({
            @ApiImplicitParam(name = "token", value = "用户token", required = true, dataType = "String", paramType = "header"),
    })
    public ResultResponse add(@RequestBody EmployeeSalaryRecord employeeSalaryRecord) {
        if(employeeSalaryRecord.getEmployeeId()==null){
            return ResultResponse.error("400","请传入员工工号");
        }
        if (employeeSalaryRecord.getNum()==null){
            return ResultResponse.error("400","请传入变动金额");
        }
        if (employeeSalaryRecord.getType()==null){
            return ResultResponse.error("400","请传入记录类型:1奖金2罚金");
        }
        if (employeeSalaryRecord.getMonthId()==null){
            employeeSalaryRecord.setMonthId(Utils.getMonthId());
        }
        employeeSalaryRecord.setStatus(1);
        EmployeeSalary salary=salaryService.queryByMonth(Utils.getMonthId(),employeeSalaryRecord.getEmployeeId());
        if (salary==null) {
            salary = new EmployeeSalary();
            salary.setMonthId(Utils.getMonthId());
            salary.setEmployeeId(employeeSalaryRecord.getEmployeeId());
            SalaryLevel level = salaryLevelService.queryByEmId(employeeSalaryRecord.getEmployeeId());
            if (level == null) {
                level = new SalaryLevel();
                level.setEmployeeId(employeeSalaryRecord.getEmployeeId());
                level.setName("p0");
                level.setSalary(2000.00);
                salaryLevelService.insert(level);
            }
            salary.setBaseSalary(level.getSalary());
            salaryService.insert(salary);
            salary=salaryService.queryByMonth(Utils.getMonthId(),employeeSalaryRecord.getEmployeeId());
            salary.setTotalPay(level.getSalary());
        }

        if (employeeSalaryRecord.getType()==1&&employeeSalaryRecord.getStatus()==1){
            salary.setOtherBonus(salary.getOtherBonus()+employeeSalaryRecord.getNum());
            salary.setTotalPay(salary.getTotalPay()+ employeeSalaryRecord.getNum());
        }else if (employeeSalaryRecord.getType()==2&&employeeSalaryRecord.getStatus()==1){
            salary.setOtherForfeit(salary.getOtherForfeit()+ employeeSalaryRecord.getNum());
            salary.setTotalPay(salary.getTotalPay()-employeeSalaryRecord.getNum());
        }

        salaryService.update(salary);

        return ResultResponse.resultSuccess(this.employeeSalaryRecordService.insert(employeeSalaryRecord));
    }

    /**
     * 编辑数据
     *
     * @param employeeSalaryRecord 实体
     * @return 编辑结果
     */
    @PostMapping("/edit")
    @ApiOperation(value = "编辑修改" ,notes ="必要信息id,以及其他需要修改的字段")
    @UserToken.Admin
    @ApiImplicitParams({
            @ApiImplicitParam(name = "token", value = "用户token", required = true, dataType = "String", paramType = "header"),
    })
    public ResultResponse edit(@RequestBody EmployeeSalaryRecord employeeSalaryRecord) {


        if (employeeSalaryRecord.getId()==null){
            return ResultResponse.error("400","请传入要修改记录的id");
        }
        EmployeeSalaryRecord record=employeeSalaryRecordService.queryById(employeeSalaryRecord.getId());
        EmployeeSalary salary=salaryService.queryByMonth(Utils.getMonthId(),record.getEmployeeId());
        if (employeeSalaryRecord.getNum()!=null){
            if (record.getType()==1){//奖金，在罚金处加
                salary.setOtherBonus(salary.getOtherBonus()+(employeeSalaryRecord.getNum()-record.getNum()));
            }else if (record.getType()==2){//罚金，在奖金处加
                salary.setOtherForfeit(salary.getOtherForfeit()+ (employeeSalaryRecord.getNum()-record.getNum()));
            }

        }
        if (employeeSalaryRecord.getStatus()!=null){
            if (record.getType()==1){//删除奖金，在罚金处加
                salary.setOtherForfeit(salary.getOtherForfeit()+ record.getNum());
            }else if (record.getType()==2){//删除罚金，在奖金处加
                salary.setOtherBonus(salary.getOtherBonus()+record.getNum());
            }
        }
        if (employeeSalaryRecord.getType()!=null){
            if (record.getType()==1){//奖金变罚金，在罚金处加双倍
                salary.setOtherForfeit(salary.getOtherForfeit()+ record.getNum()*2);
            }else if (record.getType()==2){//罚金变赏金，在奖金处加双倍
                salary.setOtherBonus(salary.getOtherBonus()+record.getNum()*2);
            }

        }
        salaryService.update(salary);



        return ResultResponse.resultSuccess(this.employeeSalaryRecordService.update(employeeSalaryRecord));
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @DeleteMapping
    @ApiOperation(value = "删除" ,notes ="传入记录的id")
    @UserToken.Admin
    @ApiImplicitParams({
            @ApiImplicitParam(name = "token", value = "用户token", required = true, dataType = "String", paramType = "header"),
    })
    public ResultResponse deleteById(Integer id) {

        EmployeeSalaryRecord record= employeeSalaryRecordService.queryById(id);
        if (record==null){

            return  ResultResponse.error("404","没有相关记录");
        }


        EmployeeSalary salary=salaryService.queryByMonth(Utils.getMonthId(),record.getEmployeeId());


        if (record.getType()==1){//删除奖金，在罚金处加
           salary.setOtherForfeit(salary.getOtherForfeit()+ record.getNum());
        }else if (record.getType()==2){//删除罚金，在奖金处加
            salary.setOtherBonus(salary.getOtherBonus()+record.getNum());
        }
        salaryService.update(salary);

        if(!this.employeeSalaryRecordService.deleteById(id)){

            return  ResultResponse.error("500","删除失败，请联系管理员");

        }
        return ResultResponse.resultSuccess("操作成功");
    }

}

