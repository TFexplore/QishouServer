package com.zhaishu.qishouserver.Vo;

import io.swagger.annotations.ApiModelProperty;

public class WorkRecordVo {
    Integer employeeId;
    String name;
    String phoneNum;
    Integer riderType;
    Integer locationId;
    Long startTime;
    Long endTime;

    @ApiModelProperty("楼栋名")
    String tName;
    @ApiModelProperty("完成订单数")
    private Integer orders;
    @ApiModelProperty("工作时长：毫秒级")
    private Long workTime;
    @ApiModelProperty("缺勤次数")
    private Integer unWorkTimes;
    @ApiModelProperty("超时订单数")
    private Integer timesOut;
    @ApiModelProperty("好评订单次数")
    private Integer goodOrders;
    @ApiModelProperty("差评订单次数")
    private Integer badOrders;


    public WorkRecordVo() {

    }

    public Integer getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Integer employeeId) {
        this.employeeId = employeeId;
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

    public Integer getRiderType() {
        return riderType;
    }

    public void setRiderType(Integer riderType) {
        this.riderType = riderType;
    }

    public Integer getLocationId() {
        return locationId;
    }

    public void setLocationId(Integer locationId) {
        this.locationId = locationId;
    }

    public String gettName() {
        return tName;
    }

    public void settName(String tName) {
        this.tName = tName;
    }

    public Integer getOrders() {
        return orders;
    }

    public void setOrders(Integer orders) {
        this.orders = orders;
    }

    public Long getWorkTime() {
        return workTime;
    }

    public void setWorkTime(Long workTime) {
        this.workTime = workTime;
    }

    public Integer getUnWorkTimes() {
        return unWorkTimes;
    }

    public void setUnWorkTimes(Integer unWorkTimes) {
        this.unWorkTimes = unWorkTimes;
    }

    public Integer getTimesOut() {
        return timesOut;
    }

    public void setTimesOut(Integer timesOut) {
        this.timesOut = timesOut;
    }

    public Integer getGoodOrders() {
        return goodOrders;
    }

    public void setGoodOrders(Integer goodOrders) {
        this.goodOrders = goodOrders;
    }

    public Integer getBadOrders() {
        return badOrders;
    }

    public void setBadOrders(Integer badOrders) {
        this.badOrders = badOrders;
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
}
