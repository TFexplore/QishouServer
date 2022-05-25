package com.zhaishu.qishouserver.entity;

import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.Size;
import java.io.Serializable;

/**
 * (ScheduleTemplate)实体类
 *
 * @author makejava
 * @since 2022-05-13 21:24:40
 */
public class ScheduleTemplate implements Serializable {
    private static final long serialVersionUID = -17314653256693558L;

    @ApiModelProperty(value = "对应排班表的WorkTimeID")
    private Integer id;

    @ApiModelProperty("备注描述")
    @Size(max = 255)
    private String discribe;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDiscribe() {
        return discribe;
    }

    public void setDiscribe(String discribe) {
        this.discribe = discribe;
    }

}

