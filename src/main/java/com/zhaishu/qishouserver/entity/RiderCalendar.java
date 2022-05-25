package com.zhaishu.qishouserver.entity;

import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;

import java.util.Date;
import java.io.Serializable;

/**
 * 骑手日历表(RiderCalendar)实体类
 *
 * @author makejava
 * @since 2022-04-18 19:22:41
 */
public class RiderCalendar implements Serializable {
    private static final long serialVersionUID = -30460672851556128L;
    /**
     * 自增id
     */
    private Integer id;
    /**
     * 日期编号
     */
    @ApiModelProperty(value = "日期编号,格式：yyyyMMdd,如：20200101,小于20000101开始的日期是模板日期")
    private Integer dateId;
    /**
     * 日期类型
     */
    @ApiModelProperty(value = "日期类型，1正常工作日，2周末、3寒暑假、4节日、5其他特殊日")
    private Integer dateType;
    
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

    public Integer getDateId() {
        return dateId;
    }

    public void setDateId(Integer dateId) {
        this.dateId = dateId;
    }

    public Integer getDateType() {
        return dateType;
    }

    public void setDateType(Integer dateType) {
        this.dateType = dateType;
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

