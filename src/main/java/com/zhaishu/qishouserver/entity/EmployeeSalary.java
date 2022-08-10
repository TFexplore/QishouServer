package com.zhaishu.qishouserver.entity;

import io.swagger.annotations.ApiModelProperty;

import java.util.Date;
import java.io.Serializable;

/**
 * 员工薪资表(EmployeeSalary)实体类
 *
 * @author makejava
 * @since 2022-07-15 16:21:01
 */
public class EmployeeSalary implements Serializable {
    private static final long serialVersionUID = -43764503208402501L;
        
    @ApiModelProperty(value = "自增id")
         private Integer id;
        
    @ApiModelProperty(value = "员工薪酬信息ID")
         private Integer employeeSalaryId;
        private Integer employeeId;
        
    @ApiModelProperty(value = "基本工资")
         private Double baseSalary;
        
    @ApiModelProperty(value = "订单工资")
         private Double orderSalary;
        
    @ApiModelProperty(value = "订单提成工资")
         private Double orderRoyalty;
        
    @ApiModelProperty(value = "出勤奖金")
         private Double attendBonus;
        
    @ApiModelProperty(value = "邀请骑手奖金")
         private Double inviteRiderBonus;
        
    @ApiModelProperty(value = "好评奖金")
         private Double positiveCommentBonus;
        
    @ApiModelProperty(value = "其他奖金")
         private Double otherBonus;
        
    @ApiModelProperty(value = "差评罚金")
         private Double negativeCommentForfeit;
        
    @ApiModelProperty(value = "超时配送罚金")
         private Double overTimeForfeit;
        
    @ApiModelProperty(value = "拒绝订单罚金")
         private Double refuseOrderForfeit;
        
    @ApiModelProperty(value = "其他罚金")
         private Double otherForfeit;
        private Integer isDelete;
        private Date createTime;
        private Integer createBy;
        private Date updateTime;
        private Integer updateBy;
        
    @ApiModelProperty(value = "应发金额")
         private Double totalPay;
        
    @ApiModelProperty(value = "实发金额")
         private Double realPay;
        
    @ApiModelProperty(value = "月份id")
         private Integer monthId;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getEmployeeSalaryId() {
        return employeeSalaryId;
    }

    public void setEmployeeSalaryId(Integer employeeSalaryId) {
        this.employeeSalaryId = employeeSalaryId;
    }

    public Integer getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Integer employeeId) {
        this.employeeId = employeeId;
    }

    public Double getBaseSalary() {
        return baseSalary;
    }

    public void setBaseSalary(Double baseSalary) {
        this.baseSalary = baseSalary;
    }

    public Double getOrderSalary() {
        return orderSalary;
    }

    public void setOrderSalary(Double orderSalary) {
        this.orderSalary = orderSalary;
    }

    public Double getOrderRoyalty() {
        return orderRoyalty;
    }

    public void setOrderRoyalty(Double orderRoyalty) {
        this.orderRoyalty = orderRoyalty;
    }

    public Double getAttendBonus() {
        return attendBonus;
    }

    public void setAttendBonus(Double attendBonus) {
        this.attendBonus = attendBonus;
    }

    public Double getInviteRiderBonus() {
        return inviteRiderBonus;
    }

    public void setInviteRiderBonus(Double inviteRiderBonus) {
        this.inviteRiderBonus = inviteRiderBonus;
    }

    public Double getPositiveCommentBonus() {
        return positiveCommentBonus;
    }

    public void setPositiveCommentBonus(Double positiveCommentBonus) {
        this.positiveCommentBonus = positiveCommentBonus;
    }

    public Double getOtherBonus() {
        return otherBonus;
    }

    public void setOtherBonus(Double otherBonus) {
        this.otherBonus = otherBonus;
    }

    public Double getNegativeCommentForfeit() {
        return negativeCommentForfeit;
    }

    public void setNegativeCommentForfeit(Double negativeCommentForfeit) {
        this.negativeCommentForfeit = negativeCommentForfeit;
    }

    public Double getOverTimeForfeit() {
        return overTimeForfeit;
    }

    public void setOverTimeForfeit(Double overTimeForfeit) {
        this.overTimeForfeit = overTimeForfeit;
    }

    public Double getRefuseOrderForfeit() {
        return refuseOrderForfeit;
    }

    public void setRefuseOrderForfeit(Double refuseOrderForfeit) {
        this.refuseOrderForfeit = refuseOrderForfeit;
    }

    public Double getOtherForfeit() {
        return otherForfeit;
    }

    public void setOtherForfeit(Double otherForfeit) {
        this.otherForfeit = otherForfeit;
    }

    public Integer getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getCreateBy() {
        return createBy;
    }

    public void setCreateBy(Integer createBy) {
        this.createBy = createBy;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Integer getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(Integer updateBy) {
        this.updateBy = updateBy;
    }

    public Double getTotalPay() {
        return totalPay;
    }

    public void setTotalPay(Double totalPay) {
        this.totalPay = totalPay;
    }

    public Double getRealPay() {
        return realPay;
    }

    public void setRealPay(Double realPay) {
        this.realPay = realPay;
    }

    public Integer getMonthId() {
        return monthId;
    }

    public void setMonthId(Integer monthId) {
        this.monthId = monthId;
    }

}

