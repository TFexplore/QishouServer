package com.zhaishu.qishouserver.entity;

import java.io.Serializable;

/**
 * 楼栋表(TApartment)实体类
 *
 * @author makejava
 * @since 2022-05-06 20:41:37
 */
public class TApartment implements Serializable {
    private static final long serialVersionUID = -52751177904907841L;
    /**
     * 楼栋表id，自增
     */
    private Long id;
    /**
     * 关联仓库id，可为空，暂时未关联仓库
     */
    private Long storageId;
    /**
     * 楼栋名
     */
    private String tname;
    /**
     * 详情
     */
    private String info;
    /**
     * 运营状态，关联字典表
     */
    private Long status;
    /**
     * 楼下自提：50,禁用；51,启用
     */
    private Long toDownstairs;
    /**
     * 楼栋类型：特殊楼栋、测试楼栋、业务楼栋
     */
    private Long apartType;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getStorageId() {
        return storageId;
    }

    public void setStorageId(Long storageId) {
        this.storageId = storageId;
    }

    public String getTname() {
        return tname;
    }

    public void setTname(String tname) {
        this.tname = tname;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public Long getStatus() {
        return status;
    }

    public void setStatus(Long status) {
        this.status = status;
    }

    public Long getToDownstairs() {
        return toDownstairs;
    }

    public void setToDownstairs(Long toDownstairs) {
        this.toDownstairs = toDownstairs;
    }

    public Long getApartType() {
        return apartType;
    }

    public void setApartType(Long apartType) {
        this.apartType = apartType;
    }

}

