package com.zhaishu.qishouserver.entity;

import java.util.Date;
import java.io.Serializable;

/**
 * (ApplyWithdraw)实体类
 *
 * @author makejava
 * @since 2022-04-18 19:15:58
 */
public class ApplyWithdraw implements Serializable {
    private static final long serialVersionUID = -54093483149209717L;
    /**
     * 自增id
     */
    private Integer id;
    
    private Integer employeeId;
    /**
     * 微信ID,该项根据微信绑定需要变更
     */
    private String weixinId;
    /**
     * 提现金额
     */
    private Double withdrawNum;
    /**
     * 提现时间
     */
    private Date withdrawTime;
    /**
     * 是否提现完成
     */
    private Integer withdrawFlag;
    
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

    public Integer getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Integer employeeId) {
        this.employeeId = employeeId;
    }

    public String getWeixinId() {
        return weixinId;
    }

    public void setWeixinId(String weixinId) {
        this.weixinId = weixinId;
    }

    public Double getWithdrawNum() {
        return withdrawNum;
    }

    public void setWithdrawNum(Double withdrawNum) {
        this.withdrawNum = withdrawNum;
    }

    public Date getWithdrawTime() {
        return withdrawTime;
    }

    public void setWithdrawTime(Date withdrawTime) {
        this.withdrawTime = withdrawTime;
    }

    public Integer getWithdrawFlag() {
        return withdrawFlag;
    }

    public void setWithdrawFlag(Integer withdrawFlag) {
        this.withdrawFlag = withdrawFlag;
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

