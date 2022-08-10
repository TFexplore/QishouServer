package com.zhaishu.qishouserver.Vo;

import com.zhaishu.qishouserver.entity.EmployeeSalary;
import io.swagger.annotations.ApiModelProperty;

public class RiderSalaryVo{
    private Integer employeeId;
    private String name;
    private Integer sex;
    private String phoneNum;
    private Integer riderType;
    @ApiModelProperty(value = "微信ID")
    private String weixinId;

    @ApiModelProperty(value = "支付宝ID")
    private String alipay;


    @ApiModelProperty("楼栋描述")
    private String location_note;
    //楼栋
    private Integer apartmentId;
    @ApiModelProperty("奖金总计")
    private Double totalBonus;
    @ApiModelProperty("罚金总计")
    private Double totalForfeit;
    @ApiModelProperty("薪资等级名称")
    private String salaryLevel;
    @ApiModelProperty("基础薪资,新增等级")
    private Double baseSalary;
    @ApiModelProperty("订单薪资")
    private Double orderSalary;
    @ApiModelProperty("薪资总计，应发金额")
    private Integer totalSalary;

    @ApiModelProperty(value = "实发金额")
    private Double realPay;
    @ApiModelProperty("月份ID")
    private Integer monthId;


    public RiderSalaryVo() {


    }

    public String getWeixinId() {
        return weixinId;
    }

    public void setWeixinId(String weixinId) {
        this.weixinId = weixinId;
    }

    public String getAlipay() {
        return alipay;
    }

    public void setAlipay(String alipay) {
        this.alipay = alipay;
    }

    public Double getOrderSalary() {
        return orderSalary;
    }

    public void setOrderSalary(Double orderSalary) {
        this.orderSalary = orderSalary;
    }

    public Double getRealPay() {
        return realPay;
    }

    public void setRealPay(Double realPay) {
        this.realPay = realPay;
    }

    public Integer getApartmentId() {
        return apartmentId;
    }

    public void setApartmentId(Integer apartmentId) {
        this.apartmentId = apartmentId;
    }

    public Double getTotalBonus() {
        return totalBonus;
    }

    public void setTotalBonus(Double totalBonus) {
        this.totalBonus = totalBonus;
    }

    public Double getTotalForfeit() {
        return totalForfeit;
    }

    public void setTotalForfeit(Double totalForfeit) {
        this.totalForfeit = totalForfeit;
    }

    public String getSalaryLevel() {
        return salaryLevel;
    }

    public void setSalaryLevel(String salaryLevel) {
        this.salaryLevel = salaryLevel;
    }

    public Double getBaseSalary() {
        return baseSalary;
    }

    public void setBaseSalary(Double baseSalary) {
        this.baseSalary = baseSalary;
    }

    public Integer getTotalSalary() {
        return totalSalary;
    }

    public void setTotalSalary(Integer totalSalary) {
        this.totalSalary = totalSalary;
    }

    public Integer getRiderType() {
        return riderType;
    }

    public void setRiderType(Integer riderType) {
        this.riderType = riderType;
    }

    public Integer getMonthId() {
        return monthId;
    }

    public void setMonthId(Integer monthId) {
        this.monthId = monthId;
    }

    public Integer getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Integer employeeId) {
        this.employeeId = employeeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public String getLocation_note() {
        return location_note;
    }

    public void setLocation_note(String location_note) {
        this.location_note = location_note;
    }

}
