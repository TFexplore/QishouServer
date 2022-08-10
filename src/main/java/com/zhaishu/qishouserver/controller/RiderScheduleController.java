package com.zhaishu.qishouserver.controller;

import com.zhaishu.qishouserver.Security.UserToken;
import com.zhaishu.qishouserver.Vo.*;
import com.zhaishu.qishouserver.common.ResultResponse;
import com.zhaishu.qishouserver.common.RuntimeExceptions;
import com.zhaishu.qishouserver.common.Utils;
import com.zhaishu.qishouserver.dao.RiderDao;
import com.zhaishu.qishouserver.entity.RiderSchedule;
import com.zhaishu.qishouserver.entity.ScheduleTemplate;
import com.zhaishu.qishouserver.entity.WorkTime;
import com.zhaishu.qishouserver.service.*;
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
    @Resource
    private DistributeOrderService orderService;

    @Resource
    private RiderService riderService;


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
    @PostMapping("/forcedWork")
    @ApiOperation(value = "强制上下班",notes="传入工号和上下班状态修改")
    @UserToken.Admin
    @ApiImplicitParams({
            @ApiImplicitParam(name = "token", value = "用户token", required = true, dataType = "String", paramType = "header"),
    })
    @Transactional
    public ResultResponse forcedWork(@RequestBody RiderVo rider){
        //校验参数
        int r=0;
        if (rider.getEmployeeId()==null||rider.getIsOnline()==null){
            return ResultResponse.error("400","请传入正确的工号和状态码");
        }
        if (rider.getIsOnline()==9){//强制下班处理
            OrderVo orderVo=new OrderVo();
            ShipRiderVo shipRiderVo=new ShipRiderVo();
            shipRiderVo.setRiderId(rider.getEmployeeId());
            orderVo.setRider(shipRiderVo);
            r=orderService.countOrdersOnDeal(orderVo);
            if (r!=0){
                return ResultResponse.error("403","有未完成的订单需要处理："+r);
            }
            //更新出勤记录
            RiderSchedule schedule=new RiderSchedule();
            schedule.setEmployeeId(rider.getEmployeeId());
            schedule.setWorktimeId(Utils.getDateId());
            schedule.setWorkStartTime(System.currentTimeMillis());
            RiderSchedule sc=riderScheduleService.getScheduleById(schedule);
            if (sc!=null){
                sc.setWorkEndTime(System.currentTimeMillis());
                riderScheduleService.update(sc);
            }
        }else {//强制上班处理




        }
        riderService.update(rider);


        return ResultResponse.resultSuccess("success");
    }

    @PostMapping("/workRecords")
    @ApiOperation(value = "获取骑手工作出勤记录",notes="传入开始，结束时间，毫秒级，Module:WorkRecordVo")
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


    @GetMapping("/getRiderVo")
    @ApiOperation(value = "通过workTimeId获取骑手列表",notes="传入worktimeId，相同时间段内的骑手")
    @UserToken.Admin
    @ApiImplicitParams({
            @ApiImplicitParam(name = "token", value = "用户token", required = true, dataType = "String", paramType = "header"),
    })
    public ResultResponse getRiderVo(Integer workTimeId){
        List<RiderVo> list=this.templateService.getRiders(workTimeId);
        return ResultResponse.resultSuccess(list);
    }

    //-------------------------------分组模板
    @PostMapping("/addWithList")
    @ApiOperation(value = "通过分组添加员工",notes="传入员工工号list（通过获取分组列表获得），备注:选择人员分组模板 获取分组员工列表 添加员工")
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
    @ApiOperation(value = "新增分组",notes="传入员工工号list，备注。人员分组模板，一个workId为一组，查询分组人员时传入workId 第一组")
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

        if (this.riderScheduleService.queryById(template.getId()).size()!=0){
           throw  new RuntimeExceptions("500","分组id冲突，请联系管理员");
        }
        for (Integer id: employeeIds) {
            schedule.setEmployeeId(id);
            riderScheduleService.insert(schedule);
        }
        return ResultResponse.resultSuccess(template);
    }
    @GetMapping("/getScheduleTemplates")
    @ApiOperation(value = "获取分组列表",notes="列表包含分组信息和分组内骑手列表，分组id就是worktimeId，添加骑手到分组与添加骑手到工作时间段操作一致")
    @UserToken.Admin
    @ApiImplicitParams({
            @ApiImplicitParam(name = "token", value = "用户token", required = true, dataType = "String", paramType = "header"),
    })
    public ResultResponse getScheduleTemplates(Integer limit,Integer offset){
        //参数校验
        if (limit==null||offset==null){
            return ResultResponse.error("400","缺少参数:limit ,offset");
        }

        List<TemplateVo> list=this.templateService.getTempletes(limit,offset);
        return ResultResponse.resultMap(templateService.count(),list);
    }

    //-------------------------------删除
    @PostMapping("/deleteTemplate")
    @ApiOperation(value = "删除分组模板",notes="传入worktimeId,同时删除该时段已安排的排班")
    @UserToken.Admin
    @ApiImplicitParams({
            @ApiImplicitParam(name = "token", value = "用户token", required = true, dataType = "String", paramType = "header"),
    })
    public ResultResponse deleteTemplate(Integer id){

        if (templateService.queryById(id)!=null){
            if (!templateService.deleteById(id)){
                return ResultResponse.error("500","删除template失败，请联系管理员");
            }
        }else return ResultResponse.error("404","no template id="+id);

        if (workTimeService.queryById(id)!=null){
            if (!workTimeService.deleteById(id)){
                 return ResultResponse.error("500","删除worktime记录失败，请联系管理员");
            }

        }else { return ResultResponse.error("404","未找到worktimeid= "+id);}


        if (this.riderScheduleService.queryById(id).size()!=0){
            if (!riderScheduleService.deleteById(id)){
                return ResultResponse.error("500","删除排班记录失败，请联系管理员");
            }
        }

        return ResultResponse.resultSuccess("删除成功");
    }
    @PostMapping("/deleteWorkTime")
    @ApiOperation(value = "删除时间段",notes="传入worktimeId,同时删除该时段已安排的排班")
    @UserToken.Admin
    @ApiImplicitParams({
            @ApiImplicitParam(name = "token", value = "用户token", required = true, dataType = "String", paramType = "header"),
    })
    @Transactional
    public ResultResponse deleteWorkTime(Integer workTimeId){

        if (workTimeService.queryById(workTimeId)==null){
            return ResultResponse.error("404","未找到worktimeid= "+workTimeId);
        }
        workTimeService.deleteById(workTimeId);
        if (this.riderScheduleService.queryById(workTimeId).size()!=0){
            if (!riderScheduleService.deleteById(workTimeId)){
                return ResultResponse.error("500","删除排班记录失败，请联系管理员");
            }
        }

        return ResultResponse.resultSuccess("删除成功");
    }
    @PostMapping("/deleteRider")
    @ApiOperation(value = "删除排班内的骑手",notes="传入worktimeId,同时删除该时段已安排的排班")
    @UserToken.Admin
    @ApiImplicitParams({
            @ApiImplicitParam(name = "token", value = "用户token", required = true, dataType = "String", paramType = "header"),
    })
    public ResultResponse deleteRider(Integer workTimeId,@RequestBody List<Integer> employeeIds){
        for (Integer id: employeeIds) {
            if (riderScheduleService.deleteRider(workTimeId, id)==0){
                throw new RuntimeExceptions("500","删除失败，请联系管理员");
            }
        }

        return ResultResponse.resultSuccess("删除成功");
    }
    @PostMapping("/editTemplate")
    @ApiOperation(value = "修改分组备注",notes="传入worktimeId,备注")
    @UserToken.Admin
    @ApiImplicitParams({
            @ApiImplicitParam(name = "token", value = "用户token", required = true, dataType = "String", paramType = "header"),
    })
    public ResultResponse editTemplate(@RequestBody ScheduleTemplate template){
        if (template.getId()==null||template.getDiscribe()==null){
            return ResultResponse.error("400","参数错误");
        }
        templateService.update(template);

        return ResultResponse.resultSuccess("修改成功");
    }

}

