package com.zhaishu.qishouserver;

import com.google.gson.Gson;
import com.zhaishu.qishouserver.Security.HashPasswordEncoder;
import com.zhaishu.qishouserver.Vo.*;
import com.zhaishu.qishouserver.common.RedisUtil;
import com.zhaishu.qishouserver.common.Utils;
import com.zhaishu.qishouserver.dao.*;
import com.zhaishu.qishouserver.entity.*;
import com.zhaishu.qishouserver.http.OkHttpCli;
import com.zhaishu.qishouserver.service.*;

import org.apache.commons.lang3.RandomUtils;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import sun.net.www.http.HttpClient;


import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.*;


@MapperScan("com.zhaishu.qishouserver.dao")
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class QishouServerApplicationTests {

    @Autowired
    EmployeeService riderService;

    @Resource
    RiderDao riderDao;
    @Resource
    EmployeeDao employeeDao;
    @Resource
    EmployeeWalletDao employeeWalletDao;
    @Resource
    InApplicationDao inApplicationDao;
    @Resource
    SeparationApplicationDao separationApplicationDao;
    @Resource
    HashPasswordEncoder encoder;
    @Resource
    WorkTimeDao workTimeDao;
    @Resource
    RiderScheduleDao riderScheduleDao;
    @Resource
    ScheduleTemplateService templateService;
    @Resource
    ScheduleTemplateDao templateDao;
    @Resource
    DistributeOrderService distributeOrderService;
    @Resource
    EmployeeSalaryDayrecordService dayrecordService;
    @Resource
    SalaryLevelService salaryLevelService;
    @Resource
    NoticeDao noticeDao;
    @Resource
    EmployeeSalaryDao salaryDao;
    @Resource
    RedisUtil redisUtil;
    @Resource
    ApplyWithdrawDao applyWithdrawDao;
    @Test
    void test() {
        Gson gson=new Gson();
        System.out.println(applyWithdrawDao.getAmountByDate(5,1659283200000L,System.currentTimeMillis()));

    }
    @Resource
    WorkTimeService workTimeService;
    @Resource
    RiderScheduleService service;
    @Resource
    DistributeOrderDao distributeOrderDao;
    @Test
    void contextLoads() {
        DateUtils.ordinaryRandom();
        DateUtils.averageRandom();

    }


    @Test

    void addRecord(){
       for (int i=23;i<33;i++){
           employeeDao.insert(DateUtils.getEmployee(i));
           riderDao.insert(DateUtils.getRider(i));
           inApplicationDao.insert(DateUtils.getInApplication(i));
           separationApplicationDao.insert(DateUtils.getSepration(i));
           employeeWalletDao.insert(DateUtils.getEmployeeWallet(i));
       }
    }
    @Test
    void add(){
        Employee employee=new Employee();
        employee.setPassword(encoder.encode("123456"));
        employee.setName("admin");
        employee.setEmployeeType(1);
        employee.setEmployeeId(1);
        employee.setSex(0);
        employee.setPhoneNum("admin");
        employee.setIsDelete(0);
        this.employeeDao.insert(employee);
    }
    @Resource
    RiderCalendarDao riderCalendarDao;
    @Test
    void addRiderCalendar(){
        RiderCalendar riderCalendar;
        for (int i = 5; i < 365*10+5; i++) {
            riderCalendar=new RiderCalendar();
            riderCalendar.setDateId(Utils.getDateByInteger(i));
            riderCalendar.setDateType(1);
            riderCalendarDao.insert(riderCalendar);
        }
        System.out.println("over!");

    }
    @Autowired
    private OkHttpCli okHttpCli;
    @Test
    void HTTP(){
        String url = "https://www.zmice.top/wallet/getBalance/manager";
        Map<String,String> map=new HashMap<>();
        map.put("aapplyId", String.valueOf(67925966));
        map.put("applykeyVode", String.valueOf(67925966));
        map.put("employeeId", String.valueOf(67925966));
        map.put("weixinId", String.valueOf(67925966));
        System.out.println(okHttpCli.doPost(url,map));


    }

    //薪资管理



}
