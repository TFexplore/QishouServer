package com.zhaishu.qishouserver.controller;

import com.zhaishu.qishouserver.Security.UserToken;
import com.zhaishu.qishouserver.Vo.DateVo;
import com.zhaishu.qishouserver.common.ResultResponse;
import com.zhaishu.qishouserver.entity.RiderCalendar;
import com.zhaishu.qishouserver.entity.WorkTime;
import com.zhaishu.qishouserver.service.RiderCalendarService;
import com.zhaishu.qishouserver.service.WorkTimeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * 骑手日历表(RiderCalendar)表控制层
 *
 * @author makejava
 * @since 2022-04-18 19:22:41
 */
@RestController
@RequestMapping("riderCalendar")
@Api(tags = "骑手日历表", description = "")
public class RiderCalendarController {
    /**
     * 服务对象
     */
    @Resource
    private RiderCalendarService riderCalendarService;
    @Resource
    private WorkTimeService workTimeService;



    @PostMapping("/editDateType")
    @ApiOperation(value = "修改日期类型",notes="1正常工作日，2周末、3寒暑假、4节日、5其他特殊日")
    @UserToken.SuperAdmin
    @ApiImplicitParams({
            @ApiImplicitParam(name = "token", value = "用户token", required = true, dataType = "String", paramType = "header"),
    })
    public ResultResponse edit(@RequestBody RiderCalendar riderCalendar) {
        if (riderCalendar.getDateId()==null){
            return ResultResponse.error("400","请传入正确的日期编号：20220202");
        }
        this.riderCalendarService.update(riderCalendar);

        return ResultResponse.resultSuccess("success");
    }



    @GetMapping("/getCalendar")
    @ApiOperation(value = "查询日历表" ,notes ="1正常工作日，2周末、3寒暑假、4节日、5其他特殊日,当传入一个日期id时，将查询该日期及其之后的日期：20220505")
    @UserToken.SuperAdmin
    @ApiImplicitParams({
            @ApiImplicitParam(name = "token", value = "用户token", required = true, dataType = "String", paramType = "header"),
    })
    public ResultResponse queryByPage(RiderCalendar riderCalendar, Integer limit,Integer offset) {
        List<RiderCalendar> calendarList=this.riderCalendarService.queryByPage(riderCalendar, limit,offset);
        return ResultResponse.resultSuccess(calendarList);
    }
    @GetMapping("/getWorkTimes")
    @ApiOperation(value = "查询一周的时间段" ,notes ="当传入一个日期id时，将查询该日期及其之后的日期：20220505，limit 7，offset 0")
    @UserToken.SuperAdmin
    @ApiImplicitParams({
            @ApiImplicitParam(name = "token", value = "用户token", required = true, dataType = "String", paramType = "header"),
    })
    public ResultResponse getWorkTimes(RiderCalendar riderCalendar, Integer limit,Integer offset) {
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
    @ApiOperation("通过id查询")
    @UserToken.Admin
    @ApiImplicitParams({
            @ApiImplicitParam(name = "token", value = "用户token", required = true, dataType = "String", paramType = "header"),
    })
    public ResultResponse queryById(@PathVariable("id") Integer id) {

        return ResultResponse.resultSuccess(this.riderCalendarService.queryById(id));
    }
    @PostMapping("/addWorkTime")
    @ApiOperation("增加工作时间段，日期类型位13位时间戳")
    @UserToken.Admin
    @ApiImplicitParams({
            @ApiImplicitParam(name = "token", value = "用户token", required = true, dataType = "String", paramType = "header"),
    })
    public ResultResponse addWorkTime(WorkTime workTime){
        if (this.workTimeService.queryByMap(workTime)!=null){
            return ResultResponse.error("400","该时间段已存在");
        }
        if (this.workTimeService.insert(workTime)!=0){
            return ResultResponse.resultSuccess("添加成功");
        }
        return ResultResponse.error("500","添加失败，请联系管理员");
    }



}

