package com.zhaishu.qishouserver.Vo;

import com.zhaishu.qishouserver.entity.RiderSchedule;
import io.swagger.annotations.ApiModelProperty;

public class ScheduleVo extends RiderSchedule {
    private String name;

    @ApiModelProperty(name = "楼栋描述")
    private String location_note;

    public ScheduleVo() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation_note() {
        return location_note;
    }

    public void setLocation_note(String location_note) {
        this.location_note = location_note;
    }
}
