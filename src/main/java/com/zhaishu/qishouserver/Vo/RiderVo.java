package com.zhaishu.qishouserver.Vo;

import com.zhaishu.qishouserver.entity.Rider;
import io.swagger.annotations.ApiModelProperty;

public class RiderVo extends Rider {
    private String name;
    private Integer sex;
    private String phoneNum;
    @ApiModelProperty("pwd")
    private String password;
    @ApiModelProperty("薪资等价")
    private String salaryLevel;
    @ApiModelProperty("薪资等级id")
    private Integer salaryLevelId;
    @ApiModelProperty("头像")
    private String avatar;
    @ApiModelProperty("身份证头像照")
    private String frontIdCard;
    @ApiModelProperty("身份证国徽照")
    private String behindIdCard;
    @ApiModelProperty("手持身份证照")
    private String holdingIdCard;
    @ApiModelProperty(value = "身份证号码")
    private String idCard;
    @ApiModelProperty("楼栋描述")
    private String location_note;
    @ApiModelProperty("审核状态")
    private Integer checkState;
    @ApiModelProperty("审核描述")
    private String checkContent;

    public RiderVo() {
    }

    public Integer getSalaryLevelId() {
        return salaryLevelId;
    }

    public void setSalaryLevelId(Integer salaryLevelId) {
        this.salaryLevelId = salaryLevelId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public String getSalaryLevel() {
        return salaryLevel;
    }

    public void setSalaryLevel(String salaryLevel) {
        this.salaryLevel = salaryLevel;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getFrontIdCard() {
        return frontIdCard;
    }

    public void setFrontIdCard(String frontIdCard) {
        this.frontIdCard = frontIdCard;
    }

    public String getBehindIdCard() {
        return behindIdCard;
    }

    public void setBehindIdCard(String behindIdCard) {
        this.behindIdCard = behindIdCard;
    }

    public String getHoldingIdCard() {
        return holdingIdCard;
    }

    public void setHoldingIdCard(String holdingIdCard) {
        this.holdingIdCard = holdingIdCard;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getLocation_note() {
        return location_note;
    }

    public void setLocation_note(String location_note) {
        this.location_note = location_note;
    }

    public Integer getCheckState() {
        return checkState;
    }

    public void setCheckState(Integer checkState) {
        this.checkState = checkState;
    }

    public String getCheckContent() {
        return checkContent;
    }

    public void setCheckContent(String checkContent) {
        this.checkContent = checkContent;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
