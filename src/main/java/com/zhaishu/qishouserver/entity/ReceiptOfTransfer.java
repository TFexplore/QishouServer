package com.zhaishu.qishouserver.entity;

import java.util.Date;
import java.io.Serializable;

/**
 * 转账回执单(ReceiptOfTransfer)实体类
 *
 * @author makejava
 * @since 2022-04-18 19:22:41
 */
public class ReceiptOfTransfer implements Serializable {
    private static final long serialVersionUID = -12534006531017600L;
    /**
     * 自增id
     */
    private Integer id;
    /**
     * 回执单ID
     */
    private Integer receiptId;
    /**
     * 支付工资账单ID
     */
    private Integer salaryBillId;
    /**
     * 财务打款人ID
     */
    private Integer financeId;
    /**
     * 扣款账户
     */
    private Integer deliningBalanceAccount;
    /**
     * 收款账户
     */
    private Integer accountCredited;
    /**
     * 转账状态
     */
    private Integer transferState;
    
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

    public Integer getReceiptId() {
        return receiptId;
    }

    public void setReceiptId(Integer receiptId) {
        this.receiptId = receiptId;
    }

    public Integer getSalaryBillId() {
        return salaryBillId;
    }

    public void setSalaryBillId(Integer salaryBillId) {
        this.salaryBillId = salaryBillId;
    }

    public Integer getFinanceId() {
        return financeId;
    }

    public void setFinanceId(Integer financeId) {
        this.financeId = financeId;
    }

    public Integer getDeliningBalanceAccount() {
        return deliningBalanceAccount;
    }

    public void setDeliningBalanceAccount(Integer deliningBalanceAccount) {
        this.deliningBalanceAccount = deliningBalanceAccount;
    }

    public Integer getAccountCredited() {
        return accountCredited;
    }

    public void setAccountCredited(Integer accountCredited) {
        this.accountCredited = accountCredited;
    }

    public Integer getTransferState() {
        return transferState;
    }

    public void setTransferState(Integer transferState) {
        this.transferState = transferState;
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

