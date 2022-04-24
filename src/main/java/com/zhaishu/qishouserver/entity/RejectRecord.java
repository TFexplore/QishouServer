package com.zhaishu.qishouserver.entity;

import java.util.Date;
import java.io.Serializable;

/**
 * 拒接与超时记录表(RejectRecord)实体类
 *
 * @author makejava
 * @since 2022-04-19 11:08:13
 */
public class RejectRecord implements Serializable {
    private static final long serialVersionUID = -39811431097950496L;
    /**
     * 商品订单编号
     */
    private Integer goodsOrderId;
    /**
     * 工号
     */
    private Integer employeeId;
    /**
     * 记录类型:1-拒绝,2-超时
     */
    private Integer recordType;
    /**
     * 反馈信息
     */
    private String feedback;
    /**
     * 记录时间
     */
    private Date recordTime;
    /**
     * 是否记录罚款:1-是,0-否
     */
    private Integer isPenalty;
    /**
     * 审核人
     */
    private Integer checkBy;
    /**
     * 审核时间
     */
    private Date checkTime;
    
    private Date createTime;
    
    private Integer createBy;
    
    private Date updateTime;
    
    private Integer updateBy;


    public Integer getGoodsOrderId() {
        return goodsOrderId;
    }

    public void setGoodsOrderId(Integer goodsOrderId) {
        this.goodsOrderId = goodsOrderId;
    }

    public Integer getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Integer employeeId) {
        this.employeeId = employeeId;
    }

    public Integer getRecordType() {
        return recordType;
    }

    public void setRecordType(Integer recordType) {
        this.recordType = recordType;
    }

    public String getFeedback() {
        return feedback;
    }

    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }

    public Date getRecordTime() {
        return recordTime;
    }

    public void setRecordTime(Date recordTime) {
        this.recordTime = recordTime;
    }

    public Integer getIsPenalty() {
        return isPenalty;
    }

    public void setIsPenalty(Integer isPenalty) {
        this.isPenalty = isPenalty;
    }

    public Integer getCheckBy() {
        return checkBy;
    }

    public void setCheckBy(Integer checkBy) {
        this.checkBy = checkBy;
    }

    public Date getCheckTime() {
        return checkTime;
    }

    public void setCheckTime(Date checkTime) {
        this.checkTime = checkTime;
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

