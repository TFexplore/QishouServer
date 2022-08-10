package com.zhaishu.qishouserver.entity;

import java.util.Date;
import java.io.Serializable;
import io.swagger.annotations.ApiModelProperty;

/**
 * (ApplyWithdraw)实体类
 *
 * @author makejava
 * @since 2022-08-06 11:21:06
 */
public class ApplyWithdraw implements Serializable {
    private static final long serialVersionUID = 746918473673980561L;
        
    @ApiModelProperty(value = "自增id")
         private String id;
    private String applyId;
        private Integer employeeId;
        
    @ApiModelProperty(value = "微信ID,该项根据微信绑定需要变更")
         private String weixinId;
        
    @ApiModelProperty(value = "提现金额")
         private Double withdrawNum;
        
    @ApiModelProperty(value = "提现时间")
         private Long withdrawTime;
        
    @ApiModelProperty(value = "提现状态：-1待审批，0不通过，1审批通过，3自动通过，4提现失败，5提现到账")
         private Integer withdrawFlag;
        private Integer isDelete;
        private Date createTime;
        private Integer createBy;
        private Date updateTime;
        private Integer updateBy;
        
    @ApiModelProperty(value = "审批人id")
         private Integer checkBy;
        
    @ApiModelProperty(value = "微信提现成功回执代码")
         private String returnCode;

    public String getApplyId() {
        return applyId;
    }

    public void setApplyId(String applyId) {
        this.applyId = applyId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
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

    public Long getWithdrawTime() {
        return withdrawTime;
    }

    public void setWithdrawTime(Long withdrawTime) {
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

    public Integer getCheckBy() {
        return checkBy;
    }

    public void setCheckBy(Integer checkBy) {
        this.checkBy = checkBy;
    }

    public String getReturnCode() {
        return returnCode;
    }

    public void setReturnCode(String returnCode) {
        this.returnCode = returnCode;
    }

}

