package com.zhaishu.qishouserver.Vo;

import com.zhaishu.qishouserver.entity.RiderCalendar;
import com.zhaishu.qishouserver.entity.RiderSchedule;
import com.zhaishu.qishouserver.entity.WorkTime;

import java.util.List;
import java.util.Map;


public class WorkTimeVo extends WorkTime {
    //某一天的全部排班安排
    List<ScheduleVo> riderSchedules;
}
