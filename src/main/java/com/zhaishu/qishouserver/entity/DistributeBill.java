package com.zhaishu.qishouserver.entity;

import java.util.Date;
import java.io.Serializable;

/**
 * 骑手配送账单表(DistributeBill)实体类
 *
 * @author makejava
 * @since 2022-04-18 19:21:34
 */
public class DistributeBill implements Serializable {
    private static final long serialVersionUID = -39866252063484306L;
    /**
     * 自增id
     */
    private Integer id;
    /**
     * 配送账单编号
     */
    private Integer distributeBillId;
    /**
     * 订单ID
     */
    private Integer goodsOrderId;
    /**
     * 账单金额
     */
    private Double billAmount;
    /**
     * 账单生成时间
     */
    private Long billTime;
    
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

    public Integer getDistributeBillId() {
        return distributeBillId;
    }

    public void setDistributeBillId(Integer distributeBillId) {
        this.distributeBillId = distributeBillId;
    }

    public Integer getGoodsOrderId() {
        return goodsOrderId;
    }

    public void setGoodsOrderId(Integer goodsOrderId) {
        this.goodsOrderId = goodsOrderId;
    }

    public Double getBillAmount() {
        return billAmount;
    }

    public void setBillAmount(Double billAmount) {
        this.billAmount = billAmount;
    }

    public Long getBillTime() {
        return billTime;
    }

    public void setBillTime(Long billTime) {
        this.billTime = billTime;
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

