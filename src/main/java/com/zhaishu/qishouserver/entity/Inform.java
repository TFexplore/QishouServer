package com.zhaishu.qishouserver.entity;

import java.util.Date;
import java.io.Serializable;

/**
 * 通知公告表(Inform)实体类
 *
 * @author makejava
 * @since 2022-04-18 19:22:41
 */
public class Inform implements Serializable {
    private static final long serialVersionUID = 116511029833317992L;
    /**
     * 自增id
     */
    private Integer id;
    
    private Integer informId;
    /**
     * 通知类型
     */
    private Integer informType;
    /**
     * 题目
     */
    private String informTitle;
    /**
     * 内容
     */
    private String informContent;
    /**
     * 时间
     */
    private Date infromTime;
    /**
     * 有效期，单位天
     */
    private Integer periodValidity;
    
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

    public Integer getInformId() {
        return informId;
    }

    public void setInformId(Integer informId) {
        this.informId = informId;
    }

    public Integer getInformType() {
        return informType;
    }

    public void setInformType(Integer informType) {
        this.informType = informType;
    }

    public String getInformTitle() {
        return informTitle;
    }

    public void setInformTitle(String informTitle) {
        this.informTitle = informTitle;
    }

    public String getInformContent() {
        return informContent;
    }

    public void setInformContent(String informContent) {
        this.informContent = informContent;
    }

    public Date getInfromTime() {
        return infromTime;
    }

    public void setInfromTime(Date infromTime) {
        this.infromTime = infromTime;
    }

    public Integer getPeriodValidity() {
        return periodValidity;
    }

    public void setPeriodValidity(Integer periodValidity) {
        this.periodValidity = periodValidity;
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

