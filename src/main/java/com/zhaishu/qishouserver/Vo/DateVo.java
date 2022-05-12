package com.zhaishu.qishouserver.Vo;

import com.zhaishu.qishouserver.entity.RiderCalendar;
import com.zhaishu.qishouserver.entity.WorkTime;

import java.util.List;

public class DateVo extends RiderCalendar {
    //某一天的全部工作时间段
    public List<WorkTime> workTimes;
}
