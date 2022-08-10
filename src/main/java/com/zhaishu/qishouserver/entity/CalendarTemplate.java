package com.zhaishu.qishouserver.entity;

import io.swagger.annotations.ApiModelProperty;

import java.util.Date;
import java.io.Serializable;

/**
 * (CalendarTemplate)实体类
 *
 * @author makejava
 * @since 2022-07-28 22:35:54
 */
public class CalendarTemplate implements Serializable {
    private static final long serialVersionUID = 406658937946887435L;
        private Integer id;
        
    @ApiModelProperty(value = "模板的开始日期编号")
         private Integer dateId;
        
    @ApiModelProperty(value = "模板名称")
         private String templateName;
        
    @ApiModelProperty(value = "是否启用状态")
         private Integer isUsing;
        private Integer idDelete;
        private Date createTime;


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

    public String getTemplateName() {
        return templateName;
    }

    public void setTemplateName(String templateName) {
        this.templateName = templateName;
    }

    public Integer getIsUsing() {
        return isUsing;
    }

    public void setIsUsing(Integer isUsing) {
        this.isUsing = isUsing;
    }

    public Integer getIdDelete() {
        return idDelete;
    }

    public void setIdDelete(Integer idDelete) {
        this.idDelete = idDelete;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

}

