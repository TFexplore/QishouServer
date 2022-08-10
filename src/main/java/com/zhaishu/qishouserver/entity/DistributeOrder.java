package com.zhaishu.qishouserver.entity;

import io.swagger.annotations.ApiModelProperty;

import java.util.Date;
import java.io.Serializable;

/**
 * 骑手配送信息表(DistributeOrder)实体类
 *
 * @author makejava
 * @since 2022-07-20 19:11:37
 */
public class DistributeOrder implements Serializable {
    private static final long serialVersionUID = 433448129749110217L;
        
    @ApiModelProperty(value = "自增id")
         private Integer id;
        
    @ApiModelProperty(value = "骑手配送订单ID")
         private Integer distributeId;
        
    @ApiModelProperty(value = "商品订单ID")
         private Integer orderId;
        
    @ApiModelProperty(value = "骑手ID")
         private Integer employeeId;
        
    @ApiModelProperty(value = "订单评价等级:1好评，2差评")
         private Integer commentLevel;
        
    @ApiModelProperty(value = "订单评价内容")
         private String commentContent;
        
    @ApiModelProperty(value = "接单时间")
         private Long getOrderTime;
        
    @ApiModelProperty(value = "取货时间")
         private Long takeOrderTime;
        
    @ApiModelProperty(value = "配送完成时间")
         private Long distributeFinishTime;
        
    @ApiModelProperty(value = "订单完成时间")
         private Long orderFinishTime;
        private Date createTime;
        private Integer createBy;
        private Date updateTime;
        private Integer updateBy;
        private Integer isDelete;
        
    @ApiModelProperty(value = "订单状态：1准时送达，2超时配送")
         private Integer status;

    @ApiModelProperty(value = "是否入账")
    private Integer isCount;


    public Integer getIsCount() {
        return isCount;
    }

    public void setIsCount(Integer isCount) {
        this.isCount = isCount;
    }

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

    public Long getGetOrderTime() {
        return getOrderTime;
    }

    public void setGetOrderTime(Long getOrderTime) {
        this.getOrderTime = getOrderTime;
    }

    public Long getTakeOrderTime() {
        return takeOrderTime;
    }

    public void setTakeOrderTime(Long takeOrderTime) {
        this.takeOrderTime = takeOrderTime;
    }

    public Long getDistributeFinishTime() {
        return distributeFinishTime;
    }

    public void setDistributeFinishTime(Long distributeFinishTime) {
        this.distributeFinishTime = distributeFinishTime;
    }

    public Long getOrderFinishTime() {
        return orderFinishTime;
    }

    public void setOrderFinishTime(Long orderFinishTime) {
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

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

}

