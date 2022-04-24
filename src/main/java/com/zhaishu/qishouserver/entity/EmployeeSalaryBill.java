package com.zhaishu.qishouserver.entity;

import java.util.Date;
import java.io.Serializable;

/**
 * (EmployeeSalaryBill)实体类
 *
 * @author makejava
 * @since 2022-04-18 19:22:40
 */
public class EmployeeSalaryBill implements Serializable {
    private static final long serialVersionUID = 747806456756186102L;
    /**
     * 自增ID,工资账单ID
     */
    private Long id;
    /**
     * 账单编号
     */
    private Integer salaryBillId;
    
    private String salaryBillName;
    
    private Integer employeeId;
    /**
     * 员工薪酬信息ID
     */
    private Integer employeeSalaryId;
    /**
     * 总金额
     */
    private Double totalMoney;
    /**
     * hr审核状态
     */
    private Integer hrCheckState;
    /**
     * 财务审核状态
     */
    private Integer financeCheckState;
    /**
     * 打款状态
     */
    private Integer payState;
    /**
     * 打款人
     */
    private Integer payPeople;
    /**
     * 支付时间
     */
    private Date payTime;
    
    private Integer isDelete;
    
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

    public Integer getSalaryBillId() {
        return salaryBillId;
    }

    public void setSalaryBillId(Integer salaryBillId) {
        this.salaryBillId = salaryBillId;
    }

    public String getSalaryBillName() {
        return salaryBillName;
    }

    public void setSalaryBillName(String salaryBillName) {
        this.salaryBillName = salaryBillName;
    }

    public Integer getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Integer employeeId) {
        this.employeeId = employeeId;
    }

    public Integer getEmployeeSalaryId() {
        return employeeSalaryId;
    }

    public void setEmployeeSalaryId(Integer employeeSalaryId) {
        this.employeeSalaryId = employeeSalaryId;
    }

    public Double getTotalMoney() {
        return totalMoney;
    }

    public void setTotalMoney(Double totalMoney) {
        this.totalMoney = totalMoney;
    }

    public Integer getHrCheckState() {
        return hrCheckState;
    }

    public void setHrCheckState(Integer hrCheckState) {
        this.hrCheckState = hrCheckState;
    }

    public Integer getFinanceCheckState() {
        return financeCheckState;
    }

    public void setFinanceCheckState(Integer financeCheckState) {
        this.financeCheckState = financeCheckState;
    }

    public Integer getPayState() {
        return payState;
    }

    public void setPayState(Integer payState) {
        this.payState = payState;
    }

    public Integer getPayPeople() {
        return payPeople;
    }

    public void setPayPeople(Integer payPeople) {
        this.payPeople = payPeople;
    }

    public Date getPayTime() {
        return payTime;
    }

    public void setPayTime(Date payTime) {
        this.payTime = payTime;
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

