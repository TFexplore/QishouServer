package com.zhaishu.qishouserver.controller;

import com.zhaishu.qishouserver.Security.UserToken;
import com.zhaishu.qishouserver.Vo.RiderVo;
import com.zhaishu.qishouserver.Vo.ScheduleVo;
import com.zhaishu.qishouserver.common.ResultResponse;
import com.zhaishu.qishouserver.entity.RiderSchedule;
import com.zhaishu.qishouserver.entity.WorkTime;
import com.zhaishu.qishouserver.service.RiderScheduleService;
import com.zhaishu.qishouserver.service.WorkTimeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * 骑手排班表(RiderSchedule)表控制层
 *
 * @author makejava
 * @since 2022-04-18 19:22:41
 */
@RestController
@RequestMapping("riderSchedule")
@Api(tags = "骑手排班表", description = "")
public class RiderScheduleController {
    /**
     * 服务对象
     */
    @Resource
    private RiderScheduleService riderScheduleService;
    @Resource
    private WorkTimeService workTimeService;


    @GetMapping("/getRiders")
    @ApiOperation(value = "获取骑手列表",notes="传入可通过姓名，电话，工号进行精确查找")
    @UserToken.Admin
    @ApiImplicitParams({
            @ApiImplicitParam(name = "token", value = "用户token", required = true, dataType = "String", paramType = "header"),
    })
    public ResultResponse getRiders(@RequestBody RiderVo rider, Integer limit, Integer offset){
        List<RiderVo> list=this.riderScheduleService.getRiders(rider,limit,offset);
        return ResultResponse.resultSuccess(list);
    }
    @GetMapping("/getSchedules")
    @ApiOperation(value = "获取时段排班列表",notes="传入worktimeId")
    @UserToken.Admin
    @ApiImplicitParams({
            @ApiImplicitParam(name = "token", value = "用户token", required = true, dataType = "String", paramType = "header"),
    })
    public ResultResponse getSchedules(Integer workTimeId){
        List<ScheduleVo> list=this.riderScheduleService.getSchedules(workTimeId);
        return ResultResponse.resultSuccess(list);
        }
    @GetMapping("/addSchedule")
    @ApiOperation(value = "新增排班记录",notes="传入worktimeId等必要信息")
    @UserToken.Admin
    @ApiImplicitParams({
            @ApiImplicitParam(name = "token", value = "用户token", required = true, dataType = "String", paramType = "header"),
    })
    public ResultResponse addSchedule(@RequestBody RiderSchedule schedule){
        WorkTime workTime= workTimeService.queryById(schedule.getWorktimeId());
        if (workTime==null){
            return ResultResponse.error("404","workTime 不存在，添加失败");
        }
        if (this.riderScheduleService.insert(schedule)!=1){
            return ResultResponse.error("500","插入记录失败，请联系管理员");
        }

        return ResultResponse.resultSuccess("操作成功");
    }

}

