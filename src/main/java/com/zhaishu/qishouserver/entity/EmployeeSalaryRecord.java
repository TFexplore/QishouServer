package com.zhaishu.qishouserver.entity;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * (EmployeeSalaryRecord)实体类
 *
 * @author makejava
 * @since 2022-07-15 16:08:09
 */
public class EmployeeSalaryRecord implements Serializable {
    private static final long serialVersionUID = 895873782974529842L;
        private Integer id;
        private Integer employeeId;
        
    @ApiModelProperty(value = "记录类型:1奖金2罚金")
         private Integer type;
        
    @ApiModelProperty(value = "事项说明")
         private String desc;
        
    @ApiModelProperty(value = "金额数量")
         private Double num;
        
    @ApiModelProperty(value = "记录时间")
         private Long recordTime;
        
    @ApiModelProperty(value = "订单状态：1计入，0不计入")
         private Integer status;
        
    @ApiModelProperty(value = "月份编号")
         private Integer monthId;


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

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public Double getNum() {
        return num;
    }

    public void setNum(Double num) {
        this.num = num;
    }

    public Long getRecordTime() {
        return recordTime;
    }

    public void setRecordTime(Long recordTime) {
        this.recordTime = recordTime;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getMonthId() {
        return monthId;
    }

    public void setMonthId(Integer monthId) {
        this.monthId = monthId;
    }

}

