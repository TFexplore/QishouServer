package com.zhaishu.qishouserver.entity;

import java.util.Date;
import java.io.Serializable;

/**
 * 工作时段表(WorkTime)实体类
 *
 * @author makejava
 * @since 2022-04-18 19:22:41
 */
public class WorkTime implements Serializable {
    private static final long serialVersionUID = -96950068025550547L;
    /**
     * 自增id
     */
    private Integer id;
    /**
     * 工作时段编号
     */
    private Integer worktimeId;
    
    private Integer dateId;
    /**
     * 时段开始时间
     */
    private long startTime;
    /**
     * 时段结束时间
     */
    private long endTime;
    
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

    public Integer getWorktimeId() {
        return worktimeId;
    }

    public void setWorktimeId(Integer worktimeId) {
        this.worktimeId = worktimeId;
    }

    public Integer getDateId() {
        return dateId;
    }

    public void setDateId(Integer dateId) {
        this.dateId = dateId;
    }

    public long getStartTime() {
        return startTime;
    }

    public void setStartTime(long startTime) {
        this.startTime = startTime;
    }

    public long getEndTime() {
        return endTime;
    }

    public void setEndTime(long endTime) {
        this.endTime = endTime;
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

