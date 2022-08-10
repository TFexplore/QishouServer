package com.zhaishu.qishouserver.entity;

import java.io.Serializable;

/**
 * 配置信息表，字典表(ConfigBRider)实体类
 *
 * @author makejava
 * @since 2022-05-26 09:58:54
 */
public class ConfigBRider implements Serializable {
    private static final long serialVersionUID = -74193625687616429L;
    /**
     * 递增ID
     */
    private Integer id;
    
    private Integer shopId;
    /**
     * 代码
     */
    private Integer code;
    /**
     * 描述
     */
    private String note;
    
    private Double value;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getShopId() {
        return shopId;
    }

    public void setShopId(Integer shopId) {
        this.shopId = shopId;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

}

