package com.zhaishu.qishouserver.entity;

import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.io.Serializable;

/**
 * (Notice)实体类
 *
 * @author makejava
 * @since 2022-08-02 14:40:54
 */
public class Notice implements Serializable {
    private static final long serialVersionUID = -41553581955535773L;
        private Integer id;
        private Integer noticeId;
    @ApiModelProperty(value = "发布人id")
    @NotNull(message = "发布人id不为空")
    private String employeeId;

    @ApiModelProperty(value = "标题")
    @NotBlank(message = "标题不为空")
    private String noticeTitle;

    @ApiModelProperty(value = "内容")
    @NotBlank(message = "内容不为空")
    private String noticeContent;
        
    @ApiModelProperty(value = "图片储存路径")
    @NotBlank(message = "图片不为空")
    private String noticeImg;
        
    @ApiModelProperty(value = "类型：1： 2：")
    @NotNull(message = "类型不为空")
    private Integer noticeType;
        
    @ApiModelProperty(value = "公告开始时间")
    @NotNull(message = "公告开始时间不为空")
    private Long startTime;
        
    @ApiModelProperty(value = "公告结束时间")
    @NotNull(message = "公告结束时间不为空")
    private Long endTime;
    private Date createTime;
    private Integer isDelete;
    private Date updateTime;

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getNoticeId() {
        return noticeId;
    }

    public void setNoticeId(Integer noticeId) {
        this.noticeId = noticeId;
    }

    public String getNoticeTitle() {
        return noticeTitle;
    }

    public void setNoticeTitle(String noticeTitle) {
        this.noticeTitle = noticeTitle;
    }

    public String getNoticeContent() {
        return noticeContent;
    }

    public void setNoticeContent(String noticeContent) {
        this.noticeContent = noticeContent;
    }

    public String getNoticeImg() {
        return noticeImg;
    }

    public void setNoticeImg(String noticeImg) {
        this.noticeImg = noticeImg;
    }

    public Integer getNoticeType() {
        return noticeType;
    }

    public void setNoticeType(Integer noticeType) {
        this.noticeType = noticeType;
    }

    public Long getStartTime() {
        return startTime;
    }

    public void setStartTime(Long startTime) {
        this.startTime = startTime;
    }

    public Long getEndTime() {
        return endTime;
    }

    public void setEndTime(Long endTime) {
        this.endTime = endTime;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
    }

}

