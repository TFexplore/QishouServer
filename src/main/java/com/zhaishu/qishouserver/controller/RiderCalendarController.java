package com.zhaishu.qishouserver.controller;

import com.google.gson.Gson;
import com.zhaishu.qishouserver.Security.UserToken;
import com.zhaishu.qishouserver.Vo.DateVo;
import com.zhaishu.qishouserver.Vo.RiderVo;
import com.zhaishu.qishouserver.common.ResultResponse;
import com.zhaishu.qishouserver.entity.*;

import com.zhaishu.qishouserver.service.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 骑手日历表(RiderCalendar)表控制层
 *
 * @author makejava
 * @since 2022-04-18 19:22:41
 */
@RestController
@RequestMapping("riderCalendar")
@Api(tags = "A骑手日历表", description = "")
public class RiderCalendarController {
    /**
     * 服务对象
     */
    @Resource
    private RiderCalendarService riderCalendarService;
    @Resource
    private WorkTimeService workTimeService;
    @Resource
    private RiderScheduleService riderScheduleService;

    @Resource
    private ScheduleTemplateService templateService;
    @Resource
    private CalendarTemplateService calendarTemplateService;

    @PostMapping("/editDateType")
    @ApiOperation(value = "修改日期类型",notes="1正常工作日，2周末、3寒暑假、4节日、5其他特殊日")
    @UserToken.Admin
    @ApiImplicitParams({
            @ApiImplicitParam(name = "token", value = "用户token", required = true, dataType = "String", paramType = "header"),
    })
    public ResultResponse edit(@RequestBody RiderCalendar riderCalendar) {
        if (riderCalendar.getDateId()==null||riderCalendar.getDateType()==null){
            return ResultResponse.error("400","请传入正确的日期编号：20220202 以及日期类型");
        }
        this.riderCalendarService.update(riderCalendar);

        return ResultResponse.resultSuccess("success");
    }

    @PostMapping("/getCalendar")
    @ApiOperation(value = "查询日历表" ,notes ="1正常工作日，2周末、3寒暑假、4节日、5其他特殊日,当传入一个日期id时，将查询该日期及其之后的日期：20220505")
    @UserToken.Admin
    @ApiImplicitParams({
            @ApiImplicitParam(name = "token", value = "用户token", required = true, dataType = "String", paramType = "header"),
    })
    public ResultResponse getCalendar(@RequestBody RiderCalendar riderCalendar, Integer limit,Integer offset) {
        //校验参数
        if (limit==null||offset==null){
            return ResultResponse.error("400","请传入正确的limit和offset");
        }

        List<RiderCalendar> calendarList=this.riderCalendarService.queryByPage(riderCalendar, limit,offset);
        return ResultResponse.resultSuccess(calendarList);
    }
    @PostMapping("/getWorkTimes")
    @ApiOperation(value = "查询一周的时间段" ,notes ="当传入一个日期id时，将查询该日期及其之后的日期：20220505，limit 7，offset 0")
    @UserToken.Admin
    @ApiImplicitParams({
            @ApiImplicitParam(name = "token", value = "用户token", required = true, dataType = "String", paramType = "header"),
    })
    public ResultResponse getWorkTimes(@RequestBody RiderCalendar riderCalendar, Integer limit,Integer offset) {
        //校验参数
        if (limit==null||offset==null){
            return ResultResponse.error("400","请传入正确的limit和offset");
        }
        List<DateVo> list=this.riderCalendarService.getCalendars(riderCalendar, limit,offset);
        return ResultResponse.resultSuccess(list);
    }
    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    @ApiOperation("通过id查询:dateId 20220202，返回RiderCalendar类型")
    @UserToken.Admin
    @ApiImplicitParams({
            @ApiImplicitParam(name = "token", value = "用户token", required = true, dataType = "String", paramType = "header"),
    })
    public ResultResponse queryById(@PathVariable("id") Integer id) {

        return ResultResponse.resultSuccess(this.riderCalendarService.queryById(id));
    }
    @PostMapping("/addWorkTime")
    @ApiOperation(value = "新增时间段",notes = "增加工作时间段，日期类型位13位时间戳,出入参数：dateId:20220202,startTime:,endTime: 时间戳类型，返回workTime")
    @UserToken.Admin
    @ApiImplicitParams({
            @ApiImplicitParam(name = "token", value = "用户token", required = true, dataType = "String", paramType = "header"),
    })
    @Transactional
    public ResultResponse addWorkTime(Integer tempId,@RequestBody  WorkTime workTime){
        if (workTime.getDateId()==null){
            return ResultResponse.error("400","请传入正确的日期编号：20220202");
        }
        if (workTime.getStartTime()==null||workTime.getEndTime()==null){
            return ResultResponse.error("400","请传入正确时间：时间戳类型");
        }
        if (workTime.getStartTime()==0||workTime.getEndTime()==0){
            return ResultResponse.error("400","请传入正确时间：时间戳类型");
        }
        if (this.workTimeService.queryByMap(workTime).size()>0){
            return ResultResponse.error("400","该时间段已存在");
        }

        RiderSchedule schedule=new RiderSchedule();
        schedule.setWorktimeId(this.workTimeService.insert(workTime).getWorktimeId());
        List<RiderVo> list=templateService.getRiders(tempId);
        for (RiderVo r:list){
            schedule.setEmployeeId(r.getEmployeeId());
            riderScheduleService.insert(schedule);
        }
        return ResultResponse.resultSuccess("操作成功");
    }
    @PostMapping("/NewModle")
    @ApiOperation(value = "新建模板",notes = "返回模板第一天dateId")
    @UserToken.Admin
    @ApiImplicitParams({
            @ApiImplicitParam(name = "token", value = "用户token", required = true, dataType = "String", paramType = "header"),
    })
    public ResultResponse addModle(@RequestBody CalendarTemplate template){
        if (template.getTemplateName()==null){
            return ResultResponse.error("400","name not null!");

        }
        int n=this.riderCalendarService.countTemplate();
        RiderCalendar riderCalendar;
        for (int i = 1; i <= 7; i++) {
            riderCalendar=new RiderCalendar();
            riderCalendar.setDateId(20000100+i+n);
            riderCalendar.setDateType(1);
            riderCalendarService.insert(riderCalendar);
        }
        template.setDateId(20000100+n+1);
        template.setIsUsing(0);
        calendarTemplateService.insert(template);
        Map<String,Object> map=new HashMap<>();
        map.put("dateId",20000100+n+1);

        return ResultResponse.resultSuccess(map);
    }
    @GetMapping("/getTemplates")
    @ApiOperation(value = "获取模板列表",notes = "模板信息中包含日期id，通过日期id查询模板")
    @UserToken.Admin
    @ApiImplicitParams({
            @ApiImplicitParam(name = "token", value = "用户token", required = true, dataType = "String", paramType = "header"),
    })
    public ResultResponse getTemplates(Integer limit,Integer offset){
        //参数校验
        if (limit==null||offset==null){
            return ResultResponse.error("400","缺少参数:limit ,offset");
        }

        CalendarTemplate template=new CalendarTemplate();

        return ResultResponse.resultMap(calendarTemplateService.count(template),calendarTemplateService.queryByPage(template,offset,limit));
    }


}

