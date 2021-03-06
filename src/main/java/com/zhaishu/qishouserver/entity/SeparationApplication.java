package com.zhaishu.qishouserver.entity;

import io.swagger.annotations.ApiModelProperty;

import java.util.Date;
import java.io.Serializable;

/**
 * 离职申请表(SeparationApplication)实体类
 *
 * @author makejava
 * @since 2022-04-18 19:22:41
 */
public class SeparationApplication implements Serializable {
    private static final long serialVersionUID = -71728662684162174L;
    /**
     * 递增ID
     */
    private Integer id;
    /**
     * 工号
     */
    @ApiModelProperty(value = "工号")
    private Integer employeeId;
    /**
     * 申请时间
     */
    @ApiModelProperty(value = "申请时间")
    private Date applyTime;
    /**
     * 审核内容
     */
    @ApiModelProperty(value = "审核内容")
    private String checkContent;
    /**
     * 审核状态
     */
    @ApiModelProperty(value = "审核状态")
    private Integer checkState;
    
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

    public Date getApplyTime() {
        return applyTime;
    }

    public void setApplyTime(Date applyTime) {
        this.applyTime = applyTime;
    }

    public String getCheckContent() {
        return checkContent;
    }

    public void setCheckContent(String checkContent) {
        this.checkContent = checkContent;
    }

    public Integer getCheckState() {
        return checkState;
    }

    public void setCheckState(Integer checkState) {
        this.checkState = checkState;
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

