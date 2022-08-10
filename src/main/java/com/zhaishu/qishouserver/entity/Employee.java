package com.zhaishu.qishouserver.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Date;
import java.io.Serializable;

/**
 * 员工信息表(Employee)实体类
 *
 * @author makejava
 * @since 2022-04-18 19:22:40
 */
@Data
public class Employee implements Serializable {
    private static final long serialVersionUID = 500258589641918623L;
    /**
     * 自增id
     */
    @ApiModelProperty(value = "自增id")
    private Integer id;
    /**
     * 员工ID，6位数？
     */
    @ApiModelProperty(value = "员工ID，6位数？")
    private Integer employeeId;
    @ApiModelProperty(value = "商铺id，6位数？")
    private Integer shopId;
    /**
     * 员工姓名
     */
    @ApiModelProperty(value = "员工姓名")
    @Size(min = 1, max = 5, message = "员工姓名长度在1-5之间")
    private String name;
    /**
     * 身份证号码
     */
    @Size( max = 18, message = "长度在1-18之间")
    @ApiModelProperty(value = "身份证号码")
    private String idCard;

    @Size( max = 11, message = "长度在1-11之间")
    @ApiModelProperty(value = "手机号")
    private String phoneNum;

    @Size( max = 11, message = "长度在1-20之间")
    @ApiModelProperty(value = "密码")
    private String password;

    @ApiModelProperty(value = "性别")
    private Integer sex;
    /**
     * 头像照片
     */
    @ApiModelProperty("头像")
    private String avatar;
    /**
     * 身份证头像照
     */
    @ApiModelProperty("身份证头像照")
    private String frontIdCard;
    /**
     * 身份证国徽照
     */
    @ApiModelProperty("身份证国徽照")
    private String behindIdCard;
    /**
     * 手持身份证照
     */
    @ApiModelProperty("手持身份证照")
    private String holdingIdCard;
    /**
     * 员工类型
     */
    @ApiModelProperty("员工类型")
    private Integer employeeType;
    //入职状态(0未入职,1在职，2已离职)
    private Integer status;
    /**
     * 员工薪酬等级
     */
    @ApiModelProperty("员工薪酬等级")
    private Integer sarlaryLevel;

    @ApiModelProperty("员工状态 0:正常 1:离职")
    private Integer isDelete;

    @TableField(value = "create_time", fill = FieldFill.INSERT)
    private Date createTime;
    
    private Integer createBy;
    @TableField(value = "update_time", fill = FieldFill.INSERT_UPDATE)
    private Date updateTime;
    
    private Integer updateBy;

    public Integer getShopId() {
        return shopId;
    }

    public void setShopId(Integer shopId) {
        this.shopId = shopId;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
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

    public Integer getEmployeeType() {
        return employeeType;
    }

    public void setEmployeeType(Integer employeeType) {
        this.employeeType = employeeType;
    }

    public Integer getSarlaryLevel() {
        return sarlaryLevel;
    }

    public void setSarlaryLevel(Integer sarlaryLevel) {
        this.sarlaryLevel = sarlaryLevel;
    }

    public Integer getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getCreateBy() {
        return createBy;
    }

    public void setCreateBy(Integer createBy) {
        this.createBy = createBy;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Integer getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(Integer updateBy) {
        this.updateBy = updateBy;
    }

}

