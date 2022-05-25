package com.zhaishu.qishouserver.entity;

import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;
import java.util.Date;
import java.io.Serializable;

/**
 * 骑手排班表(RiderSchedule)实体类
 *
 * @author makejava
 * @since 2022-04-18 19:22:41
 */
public class RiderSchedule implements Serializable {
    private static final long serialVersionUID = -78650387610726134L;
    /**
     * 自增id
     */
    private Integer id;
    /**
     * 排班编号
     */
    @ApiModelProperty("排班编号")
    private Integer scheduleId;
    /**
     * 工作时段编号
     */
    @ApiModelProperty("工作时段编号，与时段表对应，通过时段表id分组查询")
    @NotNull(message = "工作时段编号不能为空")
    private Integer worktimeId;

    @NotNull(message = "骑手编号不能为空")
    private Integer employeeId;
    /**
     * 骑手实际上班开始时间
     */
    @ApiModelProperty("骑手实际上班开始时间")
    private Long workStartTime;
    /**
     * 骑手实际上班结束时间
     */
    @ApiModelProperty("骑手实际上班结束时间")
    private Long workEndTime;
    
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

    public Integer getScheduleId() {
        return scheduleId;
    }

    public void setScheduleId(Integer scheduleId) {
        this.scheduleId = scheduleId;
    }

    public Integer getWorktimeId() {
        return worktimeId;
    }

    public void setWorktimeId(Integer worktimeId) {
        this.worktimeId = worktimeId;
    }

    public Integer getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Integer employeeId) {
        this.employeeId = employeeId;
    }

    public Long getWorkStartTime() {
        return workStartTime;
    }

    public void setWorkStartTime(Long workStartTime) {
        this.workStartTime = workStartTime;
    }

    public Long getWorkEndTime() {
        return workEndTime;
    }

    public void setWorkEndTime(Long workEndTime) {
        this.workEndTime = workEndTime;
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

