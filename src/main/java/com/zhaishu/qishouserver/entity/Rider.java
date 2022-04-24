package com.zhaishu.qishouserver.entity;

import java.util.Date;
import java.io.Serializable;

/**
 * 骑手信息表(Rider)实体类
 *
 * @author makejava
 * @since 2022-04-18 19:22:41
 */
public class Rider{

    /**
     * 自增id
     */
    private Integer id;
    /**
     * 骑手继承员工，使用员工ID
     */
    private Integer employeeId;
    /**
     * 骑手类型，未审核成功为0
     */
    private Integer riderType;
    /**
     * 学校位置编号
     */
    private Integer locationId;
    /**
     * 申请注册时间
     */
    private Date registTime;
    /**
     * 审核注册时间
     */
    private Date checkTime;
    /**
     * 审核人ID
     */
    private String hr;
    /**
     * 骑手邀请码
     */
    private Integer invitationCode;
    
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

    public Integer getRiderType() {
        return riderType;
    }

    public void setRiderType(Integer riderType) {
        this.riderType = riderType;
    }

    public Integer getLocationId() {
        return locationId;
    }

    public void setLocationId(Integer locationId) {
        this.locationId = locationId;
    }

    public Date getRegistTime() {
        return registTime;
    }

    public void setRegistTime(Date registTime) {
        this.registTime = registTime;
    }

    public Date getCheckTime() {
        return checkTime;
    }

    public void setCheckTime(Date checkTime) {
        this.checkTime = checkTime;
    }

    public String getHr() {
        return hr;
    }

    public void setHr(String hr) {
        this.hr = hr;
    }

    public Integer getInvitationCode() {
        return invitationCode;
    }

    public void setInvitationCode(Integer invitationCode) {
        this.invitationCode = invitationCode;
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

