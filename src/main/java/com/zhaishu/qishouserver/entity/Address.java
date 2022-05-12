package com.zhaishu.qishouserver.entity;

import java.io.Serializable;

/**
 * (Address)实体类
 *
 * @author makejava
 * @since 2022-04-28 21:42:19
 */
public class Address implements Serializable {
    private static final long serialVersionUID = -41269809570202733L;
    
    private Integer id;
    /**
     * employee id
     */
    private Integer employeeId;
    /**
     * 省份
     */
    private String provinces;
    /**
     * 城市
     */
    private String city;
    /**
     * 区县
     */
    private String district;
    /**
     * 街道
     */
    private String street;
    /**
     * 详细地址描述
     */
    private String description;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Integer employeeId) {
        this.employeeId = employeeId;
    }

    public String getProvinces() {
        return provinces;
    }

    public void setProvinces(String provinces) {
        this.provinces = provinces;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}

