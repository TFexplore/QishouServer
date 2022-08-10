package com.zhaishu.qishouserver.entity;

import io.swagger.annotations.ApiModelProperty;

import java.util.Date;
import java.io.Serializable;

/**
 * (SalaryCondition)实体类
 *
 * @author makejava
 * @since 2022-07-15 15:28:38
 */
public class SalaryCondition implements Serializable {
    private static final long serialVersionUID = 777128936760062225L;
        
    @ApiModelProperty(value = "自增id")
         private Integer id;
        
    @ApiModelProperty(value = "模板名称")
         private String name;
        
    @ApiModelProperty(value = "触发背景类型:1.订单量，2订单超时，3.订单好评量，4，订单差评")
         private Integer triggerBkType;
        
    @ApiModelProperty(value = "触发背景")
         private Integer triggerBkNum;
        
    @ApiModelProperty(value = "背景触发条件：1：大于，2小于，3+，4-，5=")
         private Integer triggerBkCondition;
        
    @ApiModelProperty(value = "触发类型:1.订单量，2订单超时，3.订单好评量，4，订单差评")
         private Integer triggerType;
        
    @ApiModelProperty(value = "触发数量")
         private Integer triggerNum;
        
    @ApiModelProperty(value = "触发条件：1：>，2<，3+，4-，5=\"")
         private Integer triggerCondition;
        
    @ApiModelProperty(value = "结果类型：1.加，2.罚")
         private Integer resultsType;
        
    @ApiModelProperty(value = "结果数量")
         private Double resultsNum;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getTriggerBkType() {
        return triggerBkType;
    }

    public void setTriggerBkType(Integer triggerBkType) {
        this.triggerBkType = triggerBkType;
    }

    public Integer getTriggerBkNum() {
        return triggerBkNum;
    }

    public void setTriggerBkNum(Integer triggerBkNum) {
        this.triggerBkNum = triggerBkNum;
    }

    public Integer getTriggerBkCondition() {
        return triggerBkCondition;
    }

    public void setTriggerBkCondition(Integer triggerBkCondition) {
        this.triggerBkCondition = triggerBkCondition;
    }

    public Integer getTriggerType() {
        return triggerType;
    }

    public void setTriggerType(Integer triggerType) {
        this.triggerType = triggerType;
    }

    public Integer getTriggerNum() {
        return triggerNum;
    }

    public void setTriggerNum(Integer triggerNum) {
        this.triggerNum = triggerNum;
    }

    public Integer getTriggerCondition() {
        return triggerCondition;
    }

    public void setTriggerCondition(Integer triggerCondition) {
        this.triggerCondition = triggerCondition;
    }

    public Integer getResultsType() {
        return resultsType;
    }

    public void setResultsType(Integer resultsType) {
        this.resultsType = resultsType;
    }

    public Double getResultsNum() {
        return resultsNum;
    }

    public void setResultsNum(Double resultsNum) {
        this.resultsNum = resultsNum;
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

