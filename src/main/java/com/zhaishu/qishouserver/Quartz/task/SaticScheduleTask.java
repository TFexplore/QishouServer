package com.zhaishu.qishouserver.Quartz.task;

import com.google.gson.Gson;
import com.zhaishu.qishouserver.common.Utils;
import com.zhaishu.qishouserver.dao.DistributeOrderDao;
import com.zhaishu.qishouserver.dao.EmployeeSalaryDao;
import com.zhaishu.qishouserver.dao.EmployeeSalaryRecordDao;
import com.zhaishu.qishouserver.entity.*;
import com.zhaishu.qishouserver.service.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Configuration      //1.主要用于标记配置类，兼备Component的效果。
@EnableScheduling   // 2.开启定时任务
@Slf4j
public class SaticScheduleTask {
    //3.添加定时任务
    //@Scheduled(cron = "0/5 * * * * ?")
    //或直接指定时间间隔，例如：5秒
    @Resource
    DistributeOrderService distributeService;
    @Resource
    EmployeeSalaryRecordService recordService;
    @Resource
    EmployeeSalaryService salaryService;
    @Resource
    EmployeeSalaryDayrecordService dayRecordService;
    @Resource
    ConfigBRiderService configBRiderService;
    @Resource
    SalaryConditionService conditionService;
    @Resource
    EmployeeSalaryRecordDao recordDao;
    @Resource
    SalaryLevelService salaryLevelService;

    List<SalaryCondition> conditions;
    Double orderPrice;
    Gson gson=new Gson();

    @Scheduled(fixedRate=60*1000)
    @Transactional
    void configureTasks() {
        log.info("---------------执行静态定时任务入账统计---------------- ");
        conditions=conditionService.queryByPage(new SalaryCondition(),999,0);
        getRecord();
        log.info("---------------执行定时任务入账统计结束---------------- ");
    }
    @Scheduled(fixedDelay =24*60*60*1000)
    @Transactional
    void dayTasks(){
        log.info("------------------执行每日结算任务------------------- ");
        EmployeeSalaryDayrecord vo=new EmployeeSalaryDayrecord();
        vo.setDateId(Utils.getDateId());
        List<EmployeeSalaryDayrecord> dayRecords=dayRecordService.queryByPage(vo,0,Integer.MAX_VALUE);
        for (EmployeeSalaryDayrecord dayRecord:dayRecords){
            EmployeeSalary salary=salaryService.queryByMonth(Utils.getMonthId(),dayRecord.getEmployeeId());
            if (salary==null){
                salary=new EmployeeSalary();
                salary.setMonthId(Utils.getMonthId());
                salary.setEmployeeId(dayRecord.getEmployeeId());
                SalaryLevel level=salaryLevelService.queryByEmId(dayRecord.getEmployeeId());
                if (level==null){
                    level=new SalaryLevel();
                    level.setEmployeeId(dayRecord.getEmployeeId());
                    level.setSalary(2000.00);
                    salaryLevelService.insert(level);
                }
                salary.setBaseSalary(level.getSalary());
                salaryService.insert(salary);
                salary=salaryService.queryByMonth(Utils.getMonthId(),dayRecord.getEmployeeId());
            }
            salary.setOrderSalary(salary.getOrderSalary()+dayRecord.getOrderCompletePrice());
            salary.setInviteRiderBonus(salary.getInviteRiderBonus()+dayRecord.getInviteUserPrice());
            salary.setPositiveCommentBonus(salary.getPositiveCommentBonus()+dayRecord.getPositiveCommentBonus());
            salary.setNegativeCommentForfeit(salary.getNegativeCommentForfeit()+dayRecord.getNegativeCommentForfeit());
            salary.setOtherBonus(salary.getOtherBonus()+dayRecord.getOtherBonus());
            salary.setOtherForfeit(salary.getOtherForfeit()+dayRecord.getOtherForfeit());
            Double total=salary.getBaseSalary()
                    +salary.getOrderSalary()
                    +salary.getOtherBonus()
                    +salary.getPositiveCommentBonus()
                    +salary.getInviteRiderBonus()
                    -salary.getOtherForfeit()
                    -salary.getNegativeCommentForfeit()
                    -salary.getRefuseOrderForfeit()
                    -salary.getOverTimeForfeit();
            salary.setTotalPay(total);
          salaryService.update(salary);
        }

        log.info("------------------执行结算任务完成------------------- ");
    }

     void getRecord(){
        ConfigBRider configVo=new ConfigBRider();
        configVo.setCode(1002);
        configVo.setShopId(100101);
        ConfigBRider finishType=configBRiderService.queryByLimit(configVo).get(0);//订单结算要求：1骑手送达，2买家确认，3同时
        configVo.setCode(1007);
        ConfigBRider limitTime=configBRiderService.queryByLimit(configVo).get(0);//配送超时时间
        configVo.setCode(1008);
        orderPrice=configBRiderService.queryByLimit(configVo).get(0).getValue();//订单价
        DistributeOrder vo=new DistributeOrder();
        vo.setIsCount(0);
        if (finishType.getValue().intValue()==1){//骑手送达完成
            vo.setDistributeFinishTime(1111L);

        }else {//订单完成
            vo.setOrderFinishTime(1111L);
            vo.setDistributeFinishTime(1111L);
        }
        List<DistributeOrder> list=distributeService.queryAllByMap(vo);//配送订单列表

        if (list.size()!=0){
            for (DistributeOrder order: list){


                if (order.getDistributeFinishTime()- order.getGetOrderTime()>limitTime.getValue().longValue()){
                    order.setStatus(2);//超时配送

                }else{
                    order.setStatus(1);//准时送达

                }
            update(order);

            order.setIsCount(1);//标识已入帐
            distributeService.update(order);
            }
        }

    }
     SalaryCondition getResult(Integer type,Integer num){
        SalaryCondition condition=null;
        for (SalaryCondition cn:conditions){
            if (cn.getTriggerType()!=type){
                continue;
            }
            if (cn.getTriggerBkNum()>num){

                continue;
            }
            if (condition==null){

                condition=cn;
                continue;
            }
            if (condition.getTriggerBkNum()<cn.getTriggerBkNum()){
                condition=cn;
            }

        }
        if (condition!=null){
            log.info("####满足条件:"+gson.toJson(condition));
            return condition;
        }

      return new SalaryCondition();
    }
    //生成record，更新dayrecord
     void update(DistributeOrder order){
        log.info("####order入账:"+gson.toJson(order));
        List<EmployeeSalaryRecord> records=new ArrayList<>();
        EmployeeSalaryDayrecord dayrecord= dayRecordService.queryById(Utils.getDateId(), order.getEmployeeId());

        if (dayrecord==null){
            dayrecord=new EmployeeSalaryDayrecord();
            dayrecord.setDateId(Utils.getDateId());
            dayrecord.setEmployeeId(order.getEmployeeId());
            dayRecordService.insert(dayrecord);
            dayrecord=dayRecordService.queryById(Utils.getDateId(), order.getEmployeeId());
        }
        SalaryCondition condition=getResult(1,dayrecord.getOrderCompleteNum());
        if (condition.getName()!=null){
            EmployeeSalaryRecord record=new EmployeeSalaryRecord();
            record.setEmployeeId(order.getEmployeeId());
            record.setDesc("订单达成奖金: "+condition.getName());
            record.setNum(condition.getResultsNum());
            record.setMonthId(Utils.getMonthId());
            record.setRecordTime(System.currentTimeMillis());
            record.setType(1);//奖金
            records.add(record);
            dayrecord.setOrderCompletePrice(dayrecord.getOrderCompletePrice()+condition.getResultsNum());
        }
        dayrecord.setOrderCompleteNum(dayrecord.getOrderCompleteNum()+1);
        dayrecord.setOrderCompletePrice(dayrecord.getOrderCompletePrice()+orderPrice);

        if (order.getStatus()==2){
            condition=getResult(2,dayrecord.getOvertimeNum());
            if (condition.getName()!=null){
                EmployeeSalaryRecord record=new EmployeeSalaryRecord();
                record.setEmployeeId(order.getEmployeeId());
                record.setDesc("超时订单罚金: "+condition.getName());
                record.setNum(condition.getResultsNum());
                record.setMonthId(Utils.getMonthId());
                record.setRecordTime(System.currentTimeMillis());
                record.setType(2);//罚金
                records.add(record);
                dayrecord.setOvertimePrice(dayrecord.getOvertimePrice()+condition.getResultsNum());
            }
            dayrecord.setOvertimeNum(dayrecord.getOvertimeNum()+1);
        }
        if (order.getCommentLevel()!=null){
            if (order.getCommentLevel()==1){
                condition=getResult(3,dayrecord.getOvertimeNum());
                if (condition.getName()!=null){
                    EmployeeSalaryRecord record=new EmployeeSalaryRecord();
                    record.setEmployeeId(order.getEmployeeId());
                    record.setDesc("好评奖金: "+condition.getName());
                    record.setNum(condition.getResultsNum());
                    record.setMonthId(Utils.getMonthId());
                    record.setRecordTime(System.currentTimeMillis());
                    record.setType(1);//奖金
                    records.add(record);
                    dayrecord.setPositiveCommentBonus(dayrecord.getPositiveCommentBonus()+condition.getResultsNum());
                }
                dayrecord.setPositiveCommentNum(dayrecord.getPositiveCommentNum()+1);
            }
            if (order.getCommentLevel()==2){
                condition=getResult(4,dayrecord.getOvertimeNum());
                if (condition.getName()!=null){
                    EmployeeSalaryRecord record=new EmployeeSalaryRecord();
                    record.setEmployeeId(order.getEmployeeId());
                    record.setDesc("差评订单罚金: "+condition.getName());
                    record.setNum(condition.getResultsNum());
                    record.setMonthId(Utils.getMonthId());
                    record.setRecordTime(System.currentTimeMillis());
                    record.setType(2);//罚金
                    records.add(record);
                    dayrecord.setNegativeCommentForfeit(dayrecord.getNegativeCommentForfeit()+condition.getResultsNum());
                }
                dayrecord.setNegativeCommentNum(dayrecord.getNegativeCommentNum()+1);
            }
        }

        EmployeeSalaryRecord record=new EmployeeSalaryRecord();//配送记录
        record.setEmployeeId(order.getEmployeeId());
        record.setRecordTime(System.currentTimeMillis());
        record.setMonthId(Utils.getMonthId());
        record.setDesc("订单基础工资");
        record.setNum(orderPrice);
        record.setType(1);
        records.add(record);
        recordDao.insertBatch(records);//批量插入记录
        dayRecordService.update(dayrecord);//更新统计记录
    }

}