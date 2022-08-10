package com.zhaishu.qishouserver.entity;

import io.swagger.annotations.ApiModelProperty;

import java.util.Date;
import java.io.Serializable;

/**
 * 奖罚记录表(EmployeeSalaryDayrecord)实体类
 *
 * @author makejava
 * @since 2022-07-23 09:56:08
 */
public class EmployeeSalaryDayrecord implements Serializable {
    private static final long serialVersionUID = -75300821590766505L;
        private Integer id;
        
    @ApiModelProperty(value = "日期编号，每天一个编号")
         private Integer dateId;
        private Integer employeeId;
        
    @ApiModelProperty(value = "订单完成数量")
         private Integer orderCompleteNum;
        
    @ApiModelProperty(value = "订单总金额")
         private Double orderCompletePrice;
        
    @ApiModelProperty(value = "邀请新用户数量")
         private Integer inviteUserNum;
        
    @ApiModelProperty(value = "邀新总赏金")
         private Double inviteUserPrice;
        
    @ApiModelProperty(value = "好评总奖金")
         private Double positiveCommentBonus;
        
    @ApiModelProperty(value = "差评总罚金")
         private Double negativeCommentForfeit;
        
    @ApiModelProperty(value = "差评订单数")
         private Integer negativeCommentNum;
        
    @ApiModelProperty(value = "好评订单数")
         private Integer positiveCommentNum;
        
    @ApiModelProperty(value = "超时配送次数")
         private Integer overtimeNum;
        
    @ApiModelProperty(value = "超时配送罚款金额")
         private Double overtimePrice;
        
    @ApiModelProperty(value = "其他奖金")
         private Double otherBonus;
        
    @ApiModelProperty(value = "其他罚金")
         private Double otherForfeit;
        private Integer isDelete;
        private Date createTime;
        private Integer createBy;
        private Date updateTime;
        private Integer updateBy;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getDateId() {
        return dateId;
    }

    public void setDateId(Integer dateId) {
        this.dateId = dateId;
    }

    public Integer getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Integer employeeId) {
        this.employeeId = employeeId;
    }

    public Integer getOrderCompleteNum() {
        return orderCompleteNum;
    }

    public void setOrderCompleteNum(Integer orderCompleteNum) {
        this.orderCompleteNum = orderCompleteNum;
    }

    public Double getOrderCompletePrice() {
        return orderCompletePrice;
    }

    public void setOrderCompletePrice(Double orderCompletePrice) {
        this.orderCompletePrice = orderCompletePrice;
    }

    public Integer getInviteUserNum() {
        return inviteUserNum;
    }

    public void setInviteUserNum(Integer inviteUserNum) {
        this.inviteUserNum = inviteUserNum;
    }

    public Double getInviteUserPrice() {
        return inviteUserPrice;
    }

    public void setInviteUserPrice(Double inviteUserPrice) {
        this.inviteUserPrice = inviteUserPrice;
    }

    public Double getPositiveCommentBonus() {
        return positiveCommentBonus;
    }

    public void setPositiveCommentBonus(Double positiveCommentBonus) {
        this.positiveCommentBonus = positiveCommentBonus;
    }

    public Double getNegativeCommentForfeit() {
        return negativeCommentForfeit;
    }

    public void setNegativeCommentForfeit(Double negativeCommentForfeit) {
        this.negativeCommentForfeit = negativeCommentForfeit;
    }

    public Integer getNegativeCommentNum() {
        return negativeCommentNum;
    }

    public void setNegativeCommentNum(Integer negativeCommentNum) {
        this.negativeCommentNum = negativeCommentNum;
    }

    public Integer getPositiveCommentNum() {
        return positiveCommentNum;
    }

    public void setPositiveCommentNum(Integer positiveCommentNum) {
        this.positiveCommentNum = positiveCommentNum;
    }

    public Integer getOvertimeNum() {
        return overtimeNum;
    }

    public void setOvertimeNum(Integer overtimeNum) {
        this.overtimeNum = overtimeNum;
    }

    public Double getOvertimePrice() {
        return overtimePrice;
    }

    public void setOvertimePrice(Double overtimePrice) {
        this.overtimePrice = overtimePrice;
    }

    public Double getOtherBonus() {
        return otherBonus;
    }

    public void setOtherBonus(Double otherBonus) {
        this.otherBonus = otherBonus;
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

}

