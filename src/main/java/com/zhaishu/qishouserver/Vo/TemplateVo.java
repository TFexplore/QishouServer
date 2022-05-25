package com.zhaishu.qishouserver.Vo;

import com.zhaishu.qishouserver.entity.ScheduleTemplate;

import java.util.List;

public class TemplateVo extends ScheduleTemplate {
    List<RiderVo> riders;

    public TemplateVo() {

    }

    public List<RiderVo> getRiders() {
        return riders;
    }

    public void setRiders(List<RiderVo> riders) {
        this.riders = riders;
    }
}
