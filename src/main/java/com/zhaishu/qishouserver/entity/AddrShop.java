package com.zhaishu.qishouserver.entity;

import java.util.Date;
import java.io.Serializable;
import io.swagger.annotations.ApiModelProperty;

/**
 * (AddrShop)实体类
 *
 * @author makejava
 * @since 2022-08-10 09:37:52
 */
public class AddrShop implements Serializable {
    private static final long serialVersionUID = -74394766824326709L;
        private Integer id;
        private Integer addrNum;
        private String name;
        private Integer isDelet;
        private Date createTime;
        private Date updateTime;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getAddrNum() {
        return addrNum;
    }

    public void setAddrNum(Integer addrNum) {
        this.addrNum = addrNum;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getIsDelet() {
        return isDelet;
    }

    public void setIsDelet(Integer isDelet) {
        this.isDelet = isDelet;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

}

