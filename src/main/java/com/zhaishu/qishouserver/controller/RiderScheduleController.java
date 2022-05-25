package com.zhaishu.qishouserver.controller;

import com.zhaishu.qishouserver.Security.UserToken;
import com.zhaishu.qishouserver.Vo.RiderVo;
import com.zhaishu.qishouserver.Vo.ScheduleVo;
import com.zhaishu.qishouserver.Vo.TemplateVo;
import com.zhaishu.qishouserver.Vo.WorkRecordVo;
import com.zhaishu.qishouserver.common.ResultResponse;
import com.zhaishu.qishouserver.entity.RiderSchedule;
import com.zhaishu.qishouserver.entity.ScheduleTemplate;
import com.zhaishu.qishouserver.entity.WorkTime;
import com.zhaishu.qishouserver.service.RiderScheduleService;
import com.zhaishu.qishouserver.service.ScheduleTemplateService;
import com.zhaishu.qishouserver.service.WorkTimeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 骑手排班表(RiderSchedule)表控制层
 *
 * @author makejava
 * @since 2022-04-18 19:22:41
 */
@RestController
@RequestMapping("riderSchedule")
@Api(tags = "A骑手排班表", description = "")
public class RiderScheduleController {
    /**
     * 服务对象
     */
    @Resource
    private RiderScheduleService riderScheduleService;
    @Resource
    private WorkTimeService workTimeService;
    @Resource
    private ScheduleTemplateService templateService;

    @PostMapping("/getRiders")
    @ApiOperation(value = "获取骑手列表",notes="传入可通过姓名，电话，工号进行精确查找")
    @UserToken.Admin
    @ApiImplicitParams({
            @ApiImplicitParam(name = "token", value = "用户token", required = true, dataType = "String", paramType = "header"),
    })
    public ResultResponse getRiders(@RequestBody RiderVo rider, Integer limit, Integer offset){
        //校验参数
        if (limit==null||offset==null){
            return ResultResponse.error("400","请传入正确的limit和offset");
        }
        List<RiderVo> list=this.riderScheduleService.getRiders(rider,limit,offset);
        Map<String,Object> map= new HashMap<>();
        map.put("total",this.riderScheduleService.countRiders(rider));
        map.put("list",list);

        return ResultResponse.resultSuccess(map);
    }

    @PostMapping("/workRecords")
    @ApiOperation(value = "获取工作出勤记录",notes="传入开始，结束时间，毫秒级，Module:WorkRecordVo")
    @UserToken.Admin
    @ApiImplicitParams({
            @ApiImplicitParam(name = "token", value = "用户token", required = true, dataType = "String", paramType = "header"),
    })
    public ResultResponse workRecords(@RequestBody WorkRecordVo recordVo, Integer limit, Integer offset){
        //参数校验
        if (limit==null||offset==null){
            return ResultResponse.error("400","缺少参数:limit ,offset");
        }
        if (recordVo.getStartTime()==null||recordVo.getEndTime()==null){
            return ResultResponse.error("400","缺少参数:start ,end");
        }

        List<WorkRecordVo> list=this.riderScheduleService.getWorkRecord(recordVo, limit, offset);
        Map<String,Object> map=new HashMap<>();
        map.put("total",riderScheduleService.countWorkRecord(recordVo));
        map.put("list",list);

        return ResultResponse.resultSuccess(map);
    }
    @GetMapping("/getSchedules")
    @ApiOperation(value = "获取时段排班列表",notes="传入worktimeId，获得该时段的排班列表")
    @UserToken.Admin
    @ApiImplicitParams({
            @ApiImplicitParam(name = "token", value = "用户token", required = true, dataType = "String", paramType = "header"),
    })
    public ResultResponse getSchedules(Integer workTimeId){
        List<ScheduleVo> list=this.riderScheduleService.getSchedules(workTimeId);
        return ResultResponse.resultSuccess(list);
        }
    @PostMapping("/addSchedule")
    @ApiOperation(value = "新增排班记录",notes="传入worktimeId等必要信息")
    @UserToken.Admin
    @ApiImplicitParams({
            @ApiImplicitParam(name = "token", value = "用户token", required = true, dataType = "String", paramType = "header"),
    })
    public ResultResponse addSchedule(@RequestBody @Validated RiderSchedule schedule){
        WorkTime workTime= workTimeService.queryById(schedule.getWorktimeId());
        if (workTime==null){
            return ResultResponse.error("404","workTime 不存在，添加失败");
        }
        if (this.riderScheduleService.insert(schedule)!=1){
            return ResultResponse.error("500","插入记录失败，请联系管理员");
        }

        return ResultResponse.resultSuccess("操作成功");
    }
    @PostMapping("/addWithList")
    @ApiOperation(value = "通过分组添加",notes="传入员工工号list（通过获取分组列表获得），备注。选择人员分组模板 添加员工")
    @UserToken.Admin
    @ApiImplicitParams({
            @ApiImplicitParam(name = "token", value = "用户token", required = true, dataType = "String", paramType = "header"),
    })
    @Transactional
    public ResultResponse addWithList(@RequestBody List<Integer> employeeIds,Integer workTimeId){

        RiderSchedule schedule=new RiderSchedule();
        schedule.setWorktimeId(workTimeId);
        for (Integer id: employeeIds) {
            schedule.setEmployeeId(id);
            riderScheduleService.insert(schedule);
        }
        List<ScheduleVo> list=this.riderScheduleService.getSchedules(workTimeId);
        return ResultResponse.resultSuccess(list);
    }

    @PostMapping("/addScheduleTemplate")
    @ApiOperation(value = "新增分组",notes="传入员工工号list，备注。人员分组模板，一个workId为一组，查询分组人员时传入workId：2000000000+1 第一组")
    @UserToken.Admin
    @ApiImplicitParams({
            @ApiImplicitParam(name = "token", value = "用户token", required = true, dataType = "String", paramType = "header"),
    })
    @Transactional
    public ResultResponse addScheduleTemplate(@RequestBody List<Integer> employeeIds,String describe){
        ScheduleTemplate template=new ScheduleTemplate();
        template.setDiscribe(describe);
        template=templateService.insert(template);
        RiderSchedule schedule=new RiderSchedule();
        schedule.setWorktimeId(template.getId());
        if (this.riderScheduleService.queryById(template.getId())!=null){
            return ResultResponse.error("500","分组id冲突，请联系管理员");
        }
        for (Integer id: employeeIds) {
          schedule.setEmployeeId(id);
          riderScheduleService.insert(schedule);
        }
        return ResultResponse.resultSuccess(template);
    }
    @GetMapping("/getScheduleTemplates")
    @ApiOperation(value = "获取分组列表",notes="列表包含分组信息和分组内骑手列表")
    @UserToken.Admin
    @ApiImplicitParams({
            @ApiImplicitParam(name = "token", value = "用户token", required = true, dataType = "String", paramType = "header"),
    })
    public ResultResponse getScheduleTemplates(){
        List<TemplateVo> list=this.templateService.getTempletes();
        return ResultResponse.resultSuccess(list);
    }
    @GetMapping("/getRiderVo")
    @ApiOperation(value = "通过workTimeId获取骑手列表",notes="传入worktimeId，相同id的骑手")
    @UserToken.Admin
    @ApiImplicitParams({
            @ApiImplicitParam(name = "token", value = "用户token", required = true, dataType = "String", paramType = "header"),
    })
    public ResultResponse getRiderVo(Integer workTimeId){
        List<RiderVo> list=this.templateService.getRiders(workTimeId);
        return ResultResponse.resultSuccess(list);
    }



}

