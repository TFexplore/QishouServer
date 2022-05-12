package com.zhaishu.qishouserver.entity;

import io.swagger.annotations.ApiModelProperty;

import java.util.Date;
import java.io.Serializable;

/**
 * (EmployeeWallet)实体类
 *
 * @author makejava
 * @since 2022-04-18 19:22:40
 */
public class EmployeeWallet implements Serializable {
    private static final long serialVersionUID = -90742809280341132L;
    /**
     * 自增id
     */
    private Integer id;

    @ApiModelProperty(value = "工号")
    private Integer employeeId;
    /**
     * 余额
     */
    @ApiModelProperty(value = "余额")
    private Double balance;
    /**
     * 单独的6位支付密码
     */
    @ApiModelProperty(value = "单独的6位支付密码")
    private String password;
    /**
     * 微信ID
     */
    @ApiModelProperty(value = "微信ID")
    private String weixinId;
    /**
     * 支付宝ID
     */
    @ApiModelProperty(value = "支付宝ID")
    private String alipay;
    
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

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

