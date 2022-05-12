package com.zhaishu.qishouserver;

import com.zhaishu.qishouserver.entity.*;
import org.apache.commons.lang3.RandomUtils;

public class DateUtils {






    public static Employee getEmployee(Integer id){
        //随机填充属性并返回Employee对象
        Employee employee = new Employee();
        employee.setEmployeeId(id);
        //随机生成长度为5的字符串  并设置到employee对象中
        StringBuilder name= new StringBuilder();
        for(int i=0;i<5;i++){
            name.append((char) (RandomUtils.nextInt(0, 26) + 'a'));
        }
        employee.setName(name.toString());
        if (id % 2 == 0) {
            employee.setEmployeeType(6);
            employee.setSex(0);
        }else {
            employee.setEmployeeType(7);
            employee.setSex(1);
        }
        //随机身份证号
        StringBuilder idCard = new StringBuilder();
        for (int i = 0; i < 17; i++) {
            idCard.append((int) (RandomUtils.nextInt(0,9)));
        }
        employee.setIdCard(idCard.toString());
        //随机生成长度为11的字符串  并设置到employee对象中
        StringBuilder phone = new StringBuilder();
        for (int i = 0; i < 11; i++) {
            phone.append((int) (RandomUtils.nextInt(0,9)));
        }
        employee.setPhoneNum(phone.toString());
        employee.setIsDelete(0);
        employee.setPassword("49ba59abbe56e057");
        return employee;
    }
    public static InApplication getInApplication(Integer id){
        //随机填充属性并返回InApplication对象
        InApplication inApplication = new InApplication();
        inApplication.setEmployeeId(id);
        if (id % 2 == 0) {
            inApplication.setApplyRiderType(6);
        }else {
            inApplication.setApplyRiderType(7);
        }
        //生成随机时间date类型
        inApplication.setApplyTime(new java.sql.Date(System.currentTimeMillis()+RandomUtils.nextInt(0,1000*60*60*24*7)));
        inApplication.setCheckState(-1);
        return inApplication;

    }
    public static Rider getRider(Integer id){
        Rider rider=new Rider();
        rider.setEmployeeId(id);
        if (id % 2 == 0) {
            rider.setRiderType(6);
        }else {
            rider.setRiderType(7);
        }
        //生成随机时间date类型
        rider.setRegistTime(new java.sql.Date(System.currentTimeMillis()+RandomUtils.nextInt(0,1000*60*60*24*7)));
        rider.setIsDelete(0);
        rider.setLocationId(RandomUtils.nextInt(1,40));
        rider.setInvitationCode(RandomUtils.nextInt(100000,999999));

        return rider;
    }
    public static SeparationApplication getSepration(Integer id){
        SeparationApplication se=new SeparationApplication();
        se.setEmployeeId(id);
        se.setApplyTime(new java.sql.Date(System.currentTimeMillis()+RandomUtils.nextInt(0,1000*60*60*24*7)));
        se.setCheckState(-1);
        return se;
    }
    public  static EmployeeWallet getEmployeeWallet(Integer id){
        EmployeeWallet ew=new EmployeeWallet();
        ew.setEmployeeId(id);
        //随机生成微信id
        StringBuilder wechatId=new StringBuilder();
        for(int i=0;i<20;i++){
            wechatId.append((char) (RandomUtils.nextInt(0, 26) + 'a'));
        }
        ew.setBalance(0.0);
        ew.setWeixinId(wechatId.toString());
        ew.setAlipay(wechatId.toString());
        return ew;
    }




    }









