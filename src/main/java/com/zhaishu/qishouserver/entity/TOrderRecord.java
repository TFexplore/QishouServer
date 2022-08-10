package com.zhaishu.qishouserver.entity;

import java.io.Serializable;

/**
 * (TOrderRecord)实体类
 *
 * @author makejava
 * @since 2022-07-18 11:54:53
 */
public class TOrderRecord implements Serializable {
    private static final long serialVersionUID = 330084817947330935L;
        private Long id;
        private String orderCode;
        private Long status;
        private Long createTime;
        private String detail;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOrderCode() {
        return orderCode;
    }

    public void setOrderCode(String orderCode) {
        this.orderCode = orderCode;
    }

    public Long getStatus() {
        return status;
    }

    public void setStatus(Long status) {
        this.status = status;
    }

    public Long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Long createTime) {
        this.createTime = createTime;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

}

