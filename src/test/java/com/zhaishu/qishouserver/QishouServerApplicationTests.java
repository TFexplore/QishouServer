package com.zhaishu.qishouserver;

import com.github.houbb.data.factory.core.util.DataUtil;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.zhaishu.qishouserver.Security.HashPasswordEncoder;
import com.zhaishu.qishouserver.Vo.*;
import com.zhaishu.qishouserver.common.Utils;
import com.zhaishu.qishouserver.dao.*;
import com.zhaishu.qishouserver.entity.*;
import com.zhaishu.qishouserver.service.EmployeeService;
import com.zhaishu.qishouserver.service.RiderScheduleService;
import com.zhaishu.qishouserver.service.ScheduleTemplateService;
import com.zhaishu.qishouserver.service.WorkTimeService;
import com.zhaishu.qishouserver.service.impl.RiderServiceImpl;
import org.apache.commons.lang3.RandomUtils;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@SpringBootTest
@MapperScan("com.zhaishu.qishouserver.dao")
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
    @Test
    void test() {
        WorkTime workTime=new WorkTime();
        workTime.setWorktimeId(1);
        workTime.setCreateBy(11111);
        workTimeDao.update(workTime);
    }
    @Resource
    WorkTimeService workTimeService;
    @Resource
    RiderScheduleService service;
    @Test
    void contextLoads() {
        WorkRecordVo recordVo=new WorkRecordVo();
        recordVo.setStartTime(1653235200000L);
        recordVo.setEndTime(1653452842000L);
        recordVo.setLocationId(2);
        System.out.println(riderScheduleDao.countWorkRecord(recordVo));
        List<WorkRecordVo> recordVos=riderScheduleDao.getWorkRecord(recordVo,10,0);
        Gson gson=new Gson();
        System.out.println(gson.toJson(recordVos));

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

}
