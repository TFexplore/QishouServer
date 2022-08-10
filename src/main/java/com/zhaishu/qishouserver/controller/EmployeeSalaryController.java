package com.zhaishu.qishouserver.controller;

import com.zhaishu.qishouserver.Security.UserToken;
import com.zhaishu.qishouserver.Vo.RiderSalaryVo;
import com.zhaishu.qishouserver.common.ResultResponse;
import com.zhaishu.qishouserver.common.Utils;
import com.zhaishu.qishouserver.entity.*;
import com.zhaishu.qishouserver.service.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * 员工薪资表(EmployeeSalary)表控制层
 *
 * @author makejava
 * @since 2022-07-15 16:21:00
 */
@RestController
@RequestMapping("employeeSalary")
@Api(tags = "AAA月薪资记录表", description = "")
public class EmployeeSalaryController {
    /**
     * 服务对象
     */
    @Resource
    private EmployeeSalaryService employeeSalaryService;
    @Resource
    private EmployeeWalletService walletService;
    @Resource
    private EmployeeWalletBillService billService;
    @Resource
    private MessageService messageService;

    /**
     * 分页查询
     *
     * @param
     * @param      
     * @return 查询结果
     */
    @PostMapping("/queryByPage")
    @ApiOperation(value = "分页查询管理" ,notes ="传入月份Id:202207，骑手信息作为筛选条件条件：姓名，楼栋，骑手类型")
    @UserToken.HR
    @ApiImplicitParams({
            @ApiImplicitParam(name = "token", value = "用户token", required = true, dataType = "String", paramType = "header"),
    })
    public ResultResponse queryByPage(@RequestBody RiderSalaryVo salaryVo, Integer offset, Integer limit) {
        //校验参数
        if (limit==null||offset==null){
            return ResultResponse.error("400","请传入正确的limit和offset");
        }
        if (salaryVo.getMonthId()==null){
            return ResultResponse.error("400","请传入MonthId");
        }


        return ResultResponse.resultMap(this.employeeSalaryService.countList(salaryVo),this.employeeSalaryService.getRiderSalaryList(salaryVo, limit,offset));
    }




    @PostMapping("/commit")
    @ApiOperation(value = "发放工资" ,notes ="传入用户工号，月份Id，将实发金额改为将要发放的金额。")
    @UserToken.HR
    @ApiImplicitParams({
            @ApiImplicitParam(name = "token", value = "用户token", required = true, dataType = "String", paramType = "header"),
    })
    @Transactional
    public ResultResponse commit(@RequestBody List<EmployeeSalary> employeeSalarys) {
        List<Integer> messages=new ArrayList<>();
        for (EmployeeSalary employeeSalary:employeeSalarys){
            if (employeeSalary.getEmployeeId()==null||employeeSalary.getMonthId()==null){

                return ResultResponse.error("400","请传入MonthId和工号");
            }
            if (employeeSalary.getRealPay()==null){
                ResultResponse.error("400","请传入实发金额："+employeeSalary.getEmployeeId());
            }
            EmployeeSalary org=employeeSalaryService.queryByMonth(employeeSalary.getMonthId(),employeeSalary.getEmployeeId());
            if ((org.getRealPay()+employeeSalary.getRealPay())>org.getTotalPay()){
                return ResultResponse.error("403","发放金额超过总工资："+employeeSalary.getEmployeeId());

            }
            //生成账单记录
            EmployeeWalletBill bill=new EmployeeWalletBill();
            bill.setEmployeeId(employeeSalary.getEmployeeId());
            bill.setWalletBillName("工资发放");
            bill.setPayType(2);
            bill.setPayStatus(2);
            bill.setTotalMoney(employeeSalary.getRealPay());
            bill.setWalletBillId(Utils.getStringNum(18));
            billService.insert(bill);
            //更新钱包金额
            EmployeeWallet wallet=walletService.queryById(employeeSalary.getEmployeeId());
            wallet.setBalance(wallet.getBalance()+employeeSalary.getRealPay());
            walletService.update(wallet);
            //工资发放消息通知
            Message message=new Message();
            message.setMessageId(Utils.getShortId(6));
            message.setTitle("工资发放");
            message.setMessageType(1);
            message.setContent("工资已发放，请注意钱包变化");
            message.setEmployeeId(employeeSalary.getEmployeeId());
            message.setPushTime(System.currentTimeMillis());
            message.setStatus(0);
            messageService.insert(message);
            messages.add(message.getMessageId());

            employeeSalary.setRealPay(org.getRealPay()+employeeSalary.getRealPay());

            this.employeeSalaryService.update(employeeSalary);
        }
        for (Integer message : messages) {
            messageService.pushMessage(message);
        }

        return ResultResponse.resultSuccess("操作成功");
    }
    @PostMapping("/commitALL")
    @ApiOperation(value = "发放全部月工资" ,notes ="传入月份Id")
    @UserToken.HR
    @ApiImplicitParams({
            @ApiImplicitParam(name = "token", value = "用户token", required = true, dataType = "String", paramType = "header"),
    })
    @Transactional
    public ResultResponse commit(Integer monthId) {




        return ResultResponse.resultSuccess("");
    }


}

