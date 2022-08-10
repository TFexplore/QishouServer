package com.zhaishu.qishouserver.entity;

import io.swagger.annotations.ApiModelProperty;

import java.util.Date;
import java.io.Serializable;

/**
 * (EmployeeWalletBill)实体类
 *
 * @author makejava
 * @since 2022-08-03 18:11:34
 */
public class EmployeeWalletBill implements Serializable {
    private static final long serialVersionUID = 476526960042926046L;
        private Long id;
        
    @ApiModelProperty(value = "账目编号")
         private String walletBillId;
        
    @ApiModelProperty(value = "账单名称")
         private String walletBillName;
        
    @ApiModelProperty(value = "账单内容")
         private String walletBillDetail;
        private Integer employeeId;
        
    @ApiModelProperty(value = "总额度")
         private Double totalMoney;
        
    @ApiModelProperty(value = "账单属性(1支出，2收入)")
         private Integer payStatus;
        
    @ApiModelProperty(value = "账单类型(1提现,2工资,3奖金,4罚金)")
         private Integer payType;
        private Date createTime;
        private Integer createBy;
        private Date updateTime;
        private Integer updateBy;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getWalletBillId() {
        return walletBillId;
    }

    public void setWalletBillId(String walletBillId) {
        this.walletBillId = walletBillId;
    }

    public String getWalletBillName() {
        return walletBillName;
    }

    public void setWalletBillName(String walletBillName) {
        this.walletBillName = walletBillName;
    }

    public String getWalletBillDetail() {
        return walletBillDetail;
    }

    public void setWalletBillDetail(String walletBillDetail) {
        this.walletBillDetail = walletBillDetail;
    }

    public Integer getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Integer employeeId) {
        this.employeeId = employeeId;
    }

    public Double getTotalMoney() {
        return totalMoney;
    }

    public void setTotalMoney(Double totalMoney) {
        this.totalMoney = totalMoney;
    }

    public Integer getPayStatus() {
        return payStatus;
    }

    public void setPayStatus(Integer payStatus) {
        this.payStatus = payStatus;
    }

    public Integer getPayType() {
        return payType;
    }

    public void setPayType(Integer payType) {
        this.payType = payType;
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

