package com.zhaishu.qishouserver.entity;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * (VersionCon)实体类
 *
 * @author makejava
 * @since 2022-07-28 22:14:33
 */
public class VersionCon implements Serializable {
    private static final long serialVersionUID = -90925928350996258L;
        private Integer id;
        
    @ApiModelProperty(value = "版本号")
         private String versionName;
        
    @ApiModelProperty(value = "储存路径、下载路径")
         private String path;
        
    @ApiModelProperty(value = "更新时间")
         private Long updateTime;
        
    @ApiModelProperty(value = "是否上线：0否，1是")
         private Integer isOnline;
        private Integer versionId;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getVersionName() {
        return versionName;
    }

    public void setVersionName(String versionName) {
        this.versionName = versionName;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public Long getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Long updateTime) {
        this.updateTime = updateTime;
    }

    public Integer getIsOnline() {
        return isOnline;
    }

    public void setIsOnline(Integer isOnline) {
        this.isOnline = isOnline;
    }

    public Integer getVersionId() {
        return versionId;
    }

    public void setVersionId(Integer versionId) {
        this.versionId = versionId;
    }

}

