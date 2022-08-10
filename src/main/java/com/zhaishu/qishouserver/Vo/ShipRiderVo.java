package com.zhaishu.qishouserver.Vo;

import io.swagger.annotations.ApiModelProperty;

public class ShipRiderVo {
    Integer riderId;
    String name;
    private String phoneNum;
    @ApiModelProperty(name = "楼栋描述")
    private String location_note;

    public Integer getRiderId() {
        return riderId;
    }

    public void setRiderId(Integer riderId) {
        this.riderId = riderId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public String getLocation_note() {
        return location_note;
    }

    public void setLocation_note(String location_note) {
        this.location_note = location_note;
    }
}
