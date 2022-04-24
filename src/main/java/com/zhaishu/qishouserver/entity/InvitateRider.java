package com.zhaishu.qishouserver.entity;

import java.util.Date;
import java.io.Serializable;

/**
 * 邀请骑手记录(InvitateRider)实体类
 *
 * @author makejava
 * @since 2022-04-18 19:22:41
 */
public class InvitateRider implements Serializable {
    private static final long serialVersionUID = 339011215981295466L;
    /**
     * 自增id
     */
    private Integer id;
    /**
     * 邀请人
     */
    private Integer invitateId;
    /**
     * 被邀请人
     */
    private Integer invitatedId;
    /**
     * 是否成功邀请
     */
    private Integer isSuccess;
    /**
     * 发起邀请时间
     */
    private Date invitateTime;
    /**
     * 邀请成功时间
     */
    private Date invitateSuccessTime;
    /**
     * 审核状态
     */
    private Integer checkState;
    /**
     * 审核人
     */
    private Integer checkPeople;
    
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

    public Integer getInvitateId() {
        return invitateId;
    }

    public void setInvitateId(Integer invitateId) {
        this.invitateId = invitateId;
    }

    public Integer getInvitatedId() {
        return invitatedId;
    }

    public void setInvitatedId(Integer invitatedId) {
        this.invitatedId = invitatedId;
    }

    public Integer getIsSuccess() {
        return isSuccess;
    }

    public void setIsSuccess(Integer isSuccess) {
        this.isSuccess = isSuccess;
    }

    public Date getInvitateTime() {
        return invitateTime;
    }

    public void setInvitateTime(Date invitateTime) {
        this.invitateTime = invitateTime;
    }

    public Date getInvitateSuccessTime() {
        return invitateSuccessTime;
    }

    public void setInvitateSuccessTime(Date invitateSuccessTime) {
        this.invitateSuccessTime = invitateSuccessTime;
    }

    public Integer getCheckState() {
        return checkState;
    }

    public void setCheckState(Integer checkState) {
        this.checkState = checkState;
    }

    public Integer getCheckPeople() {
        return checkPeople;
    }

    public void setCheckPeople(Integer checkPeople) {
        this.checkPeople = checkPeople;
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

