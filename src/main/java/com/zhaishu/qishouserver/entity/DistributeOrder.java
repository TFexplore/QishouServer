package com.zhaishu.qishouserver.entity;

import java.util.Date;
import java.io.Serializable;

/**
 * 骑手配送信息表(DistributeOrder)实体类
 *
 * @author makejava
 * @since 2022-04-18 19:22:40
 */
public class DistributeOrder implements Serializable {
    private static final long serialVersionUID = 367967492392959767L;
    /**
     * 自增id
     */
    private Integer id;
    /**
     * 骑手配送订单ID
     */
    private Integer distributeId;
    /**
     * 商品订单ID
     */
    private Integer orderId;
    /**
     * 骑手ID
     */
    private Integer employeeId;
    /**
     * 订单评价等级
     */
    private Integer commentLevel;
    /**
     * 订单评价内容
     */
    private String commentContent;
    /**
     * 接单时间
     */
    private Date getOrderTime;
    /**
     * 取货时间
     */
    private Date takeOrderTime;
    /**
     * 配送完成时间
     */
    private String distributeFinishTime;
    /**
     * 订单完成时间
     */
    private Date orderFinishTime;
    
    private Date createTime;
    
    private Integer createBy;
    
    private Date updateTime;
    
    private Integer updateBy;
    
    private Integer isDelete;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getDistributeId() {
        return distributeId;
    }

    public void setDistributeId(Integer distributeId) {
        this.distributeId = distributeId;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public Integer getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Integer employeeId) {
        this.employeeId = employeeId;
    }

    public Integer getCommentLevel() {
        return commentLevel;
    }

    public void setCommentLevel(Integer commentLevel) {
        this.commentLevel = commentLevel;
    }

    public String getCommentContent() {
        return commentContent;
    }

    public void setCommentContent(String commentContent) {
        this.commentContent = commentContent;
    }

    public Date getGetOrderTime() {
        return getOrderTime;
    }

    public void setGetOrderTime(Date getOrderTime) {
        this.getOrderTime = getOrderTime;
    }

    public Date getTakeOrderTime() {
        return takeOrderTime;
    }

    public void setTakeOrderTime(Date takeOrderTime) {
        this.takeOrderTime = takeOrderTime;
    }

    public String getDistributeFinishTime() {
        return distributeFinishTime;
    }

    public void setDistributeFinishTime(String distributeFinishTime) {
        this.distributeFinishTime = distributeFinishTime;
    }

    public Date getOrderFinishTime() {
        return orderFinishTime;
    }

    public void setOrderFinishTime(Date orderFinishTime) {
        this.orderFinishTime = orderFinishTime;
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

    public Integer getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
    }

}

