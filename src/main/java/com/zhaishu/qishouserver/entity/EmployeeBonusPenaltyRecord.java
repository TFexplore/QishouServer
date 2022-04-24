package com.zhaishu.qishouserver.entity;

import java.util.Date;
import java.io.Serializable;

/**
 * 奖罚记录表(EmployeeBonusPenaltyRecord)实体类
 *
 * @author makejava
 * @since 2022-04-18 19:22:40
 */
public class EmployeeBonusPenaltyRecord implements Serializable {
    private static final long serialVersionUID = -70370808601861409L;
    
    private Integer id;
    
    private Integer employeeId;
    /**
     * 记录结算开始时间
     */
    private Date startTime;
    /**
     * 记录结算结束时间
     */
    private Date endTime;
    /**
     * 订单提成数量
     */
    private Integer orderCommissionNum;
    /**
     * 订单提成单价
     */
    private Double orderCommissionPrice;
    /**
     * 工作时间提成数量
     */
    private Integer worktimeCommissionNum;
    /**
     * 工作时间提成单价
     */
    private Double worktimeCommisionPrice;
    /**
     * 节假日工作提成数量
     */
    private Integer festivalCommissionNum;
    /**
     * 节假日工作提成单价
     */
    private Double festivalCommissionPrice;
    /**
     * 特殊工作日提成数量
     */
    private Integer specialWorktimeCommisionNum;
    /**
     * 特殊工作日提成单价
     */
    private Double specialWorktimeCommissionPrice;
    /**
     * 邀请新用户数量
     */
    private Integer inviteUserNum;
    /**
     * 邀请新用户单价
     */
    private Double inviteUserPrice;
    /**
     * 好评奖金
     */
    private Double positiveCommentBonus;
    /**
     * 差评罚金
     */
    private Double negativeCommentForfeit;
    /**
     * 超时配送次数
     */
    private Integer overtimeNum;
    /**
     * 超时配送罚款单价
     */
    private Double overtimePrice;
    /**
     * 其他奖金
     */
    private Double otherBonus;
    /**
     * 其他罚金
     */
    private Double otherForfeit;
    
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

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public Integer getOrderCommissionNum() {
        return orderCommissionNum;
    }

    public void setOrderCommissionNum(Integer orderCommissionNum) {
        this.orderCommissionNum = orderCommissionNum;
    }

    public Double getOrderCommissionPrice() {
        return orderCommissionPrice;
    }

    public void setOrderCommissionPrice(Double orderCommissionPrice) {
        this.orderCommissionPrice = orderCommissionPrice;
    }

    public Integer getWorktimeCommissionNum() {
        return worktimeCommissionNum;
    }

    public void setWorktimeCommissionNum(Integer worktimeCommissionNum) {
        this.worktimeCommissionNum = worktimeCommissionNum;
    }

    public Double getWorktimeCommisionPrice() {
        return worktimeCommisionPrice;
    }

    public void setWorktimeCommisionPrice(Double worktimeCommisionPrice) {
        this.worktimeCommisionPrice = worktimeCommisionPrice;
    }

    public Integer getFestivalCommissionNum() {
        return festivalCommissionNum;
    }

    public void setFestivalCommissionNum(Integer festivalCommissionNum) {
        this.festivalCommissionNum = festivalCommissionNum;
    }

    public Double getFestivalCommissionPrice() {
        return festivalCommissionPrice;
    }

    public void setFestivalCommissionPrice(Double festivalCommissionPrice) {
        this.festivalCommissionPrice = festivalCommissionPrice;
    }

    public Integer getSpecialWorktimeCommisionNum() {
        return specialWorktimeCommisionNum;
    }

    public void setSpecialWorktimeCommisionNum(Integer specialWorktimeCommisionNum) {
        this.specialWorktimeCommisionNum = specialWorktimeCommisionNum;
    }

    public Double getSpecialWorktimeCommissionPrice() {
        return specialWorktimeCommissionPrice;
    }

    public void setSpecialWorktimeCommissionPrice(Double specialWorktimeCommissionPrice) {
        this.specialWorktimeCommissionPrice = specialWorktimeCommissionPrice;
    }

    public Integer getInviteUserNum() {
        return inviteUserNum;
    }

    public void setInviteUserNum(Integer inviteUserNum) {
        this.inviteUserNum = inviteUserNum;
    }

    public Double getInviteUserPrice() {
        return inviteUserPrice;
    }

    public void setInviteUserPrice(Double inviteUserPrice) {
        this.inviteUserPrice = inviteUserPrice;
    }

    public Double getPositiveCommentBonus() {
        return positiveCommentBonus;
    }

    public void setPositiveCommentBonus(Double positiveCommentBonus) {
        this.positiveCommentBonus = positiveCommentBonus;
    }

    public Double getNegativeCommentForfeit() {
        return negativeCommentForfeit;
    }

    public void setNegativeCommentForfeit(Double negativeCommentForfeit) {
        this.negativeCommentForfeit = negativeCommentForfeit;
    }

    public Integer getOvertimeNum() {
        return overtimeNum;
    }

    public void setOvertimeNum(Integer overtimeNum) {
        this.overtimeNum = overtimeNum;
    }

    public Double getOvertimePrice() {
        return overtimePrice;
    }

    public void setOvertimePrice(Double overtimePrice) {
        this.overtimePrice = overtimePrice;
    }

    public Double getOtherBonus() {
        return otherBonus;
    }

    public void setOtherBonus(Double otherBonus) {
        this.otherBonus = otherBonus;
    }

    public Double getOtherForfeit() {
        return otherForfeit;
    }

    public void setOtherForfeit(Double otherForfeit) {
        this.otherForfeit = otherForfeit;
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

