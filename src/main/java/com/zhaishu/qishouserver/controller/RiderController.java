package com.zhaishu.qishouserver.controller;


import com.zhaishu.qishouserver.Security.UserToken;
import com.zhaishu.qishouserver.Vo.RiderVo;
import com.zhaishu.qishouserver.common.ResultResponse;
import com.zhaishu.qishouserver.common.TokenUtils;
import com.zhaishu.qishouserver.common.Utils;
import com.zhaishu.qishouserver.entity.Employee;
import com.zhaishu.qishouserver.entity.InApplication;
import com.zhaishu.qishouserver.entity.Rider;
import com.zhaishu.qishouserver.entity.SeparationApplication;
import com.zhaishu.qishouserver.service.EmployeeService;
import com.zhaishu.qishouserver.service.InApplicationService;
import com.zhaishu.qishouserver.service.RiderService;
import com.zhaishu.qishouserver.service.SeparationApplicationService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.models.auth.In;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.net.Socket;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 骑手信息表(Rider)表控制层
 *
 * @author makejava
 * @since 2022-04-18 19:22:41
 */
@RestController
@RequestMapping("rider")
@Api(tags = "RiderController", description = "骑手信息表")
public class RiderController {
    /**
     * 服务对象
     */
    @Resource
    private RiderService riderService;
    @Resource
    private EmployeeService employeeService;
    @Resource
    private InApplicationService inApplicationService;
    @Resource
    private SeparationApplicationService separationService;


    @PostMapping("/riderIn")
    @ApiOperation(value = "入职申请处理", notes = "mode：inApplication,传入骑手id，审核人id:CreatBy，审核状态等必要信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "token", value = "Token", required = true, dataTypeClass = String.class, paramType = "header")
    })
    @UserToken.Admin
    @Transactional
    public ResultResponse RiderIn(@RequestHeader String token,Integer type,@RequestBody InApplication in){
       if (in.getEmployeeId()==null){
           return  ResultResponse.error("400","InApplication：缺少必要参数工号");
       }
        RiderVo rider=new RiderVo();
        rider.setEmployeeId(in.getEmployeeId());
        if (in.getCheckState()==1){//审核通过
            rider.setRiderType(type);
            rider.setCheckTime(new Date());
        }
            rider.setHr(""+TokenUtils.getIntegerValus("userId",token));
            riderService.update(rider);
            inApplicationService.update(in);

        return ResultResponse.resultSuccess("操作成功");
    }
    @PostMapping("/riderSe")
    @ApiOperation(value = "处理主动离职骑手申请", notes = "mode：SeparationApplication,处理离职申请表,传入需要更新的参数列表")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "token", value = "Token", required = true, dataTypeClass = String.class, paramType = "header")
    })
    @Transactional
    public ResultResponse RiderSe(@RequestBody SeparationApplication se){
        if (se.getEmployeeId()==null){
            return  ResultResponse.error("400","SeparationApplication：缺少必要参数工号");
        }
        if (se.getCheckState()==null) {
            return ResultResponse.error("400", "SeparationApplication：缺少必要参数审核状态");
        }

        if (se.getCheckState()==1){//同意离职 1.修改is_delete
            RiderVo rider=new RiderVo();
            rider.setIsDelete(1);
            rider.setEmployeeId(se.getEmployeeId());
            riderService.update(rider);
        }

        separationService.update(se);

        return ResultResponse.resultSuccess("操作成功");
    }
    @PostMapping("/riderOut")
    @ApiOperation(value = "解雇骑手", notes = "直接修改isDelete，添加离职申请表")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "token", value = "Token", required = true, dataTypeClass = String.class, paramType = "header")
    })
    @Transactional
    public ResultResponse RiderOut(@RequestBody SeparationApplication se){
            if (se.getEmployeeId()==null){
                return  ResultResponse.error("400","SeparationApplication：缺少必要参数工号");
            }
        if (separationService.queryById(se.getEmployeeId())!=null){
            RiderVo rider=new RiderVo();
            rider.setIsDelete(1);
            rider.setEmployeeId(se.getEmployeeId());
            riderService.update(rider);
            separationService.update(se);
            return ResultResponse.resultSuccess("骑手解雇成功");
        }
            RiderVo rider=new RiderVo();
            rider.setIsDelete(2);
            rider.setEmployeeId(se.getEmployeeId());
            riderService.update(rider);
            separationService.insert(se);

        return ResultResponse.resultSuccess("骑手解雇成功");
    }

    @PostMapping("/getAllRiders")
    @ApiOperation(value = "获取所有骑手", notes = "不包含未入职的骑手，mode：RiderVo 通过map进行筛选，map为空则获取所有骑手{\n"+
            "  \"employeeId\": 0, 工号\n" +
            "  \"invitationCode\": 0,  邀请码\n" +
            "  \"isDelete\": 0, 是否在职0为在职\n" +
            "  \"locationId\": 0, 楼栋\n" +
            "  \"name\": \"string\", 通过姓名查找\n" +
            "  \"phoneNum\": \"string\",通过电话查找\n" +
            "  \"riderType\": 0, 骑手类型\n" +
            "  \"sex\": 0, 性别\n" +
            "}")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "token", value = "Token", required = true, dataTypeClass = String.class, paramType = "header")
    })
    public ResultResponse getAllRiders(@RequestBody RiderVo riderVo,int offset,int limit){
        List<RiderVo> riderVoList = this.riderService.getAllRiders(offset,limit,riderVo);
        Map<String,Object> map = new HashMap<>();
        map.put("riderVoList",riderVoList);
        map.put("total",this.riderService.countAllRiders(riderVo));

        return ResultResponse.resultSuccess(map);
    }
    @PostMapping("/getAllRidersIn")
    @ApiOperation(value = "获取申请入职骑手", notes = "mode：RiderVo 筛选方法同上"+
            "  \"registTime\": \"2022-05-04T15:39:57.\",  筛选开始时间，获取的数据中此字段代表注册时间\n"+
            "  \"checkTime\": \"2022-05-04T15:39:57.817Z\", 筛选结束时间，获取的数据中此字段代表审核时间\n")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "token", value = "Token", required = true, dataTypeClass = String.class, paramType = "header")
    })
    public ResultResponse getAllRidersIn(@RequestBody RiderVo riderVo,int offset,int limit){
        List<RiderVo> riderVoList = this.riderService.getAllRidersIn(offset,limit,riderVo);
        Map<String,Object> map = new HashMap<>();
        map.put("riderVoList",riderVoList);
        map.put("total",this.riderService.countAllRidersIn(riderVo));

        return ResultResponse.resultSuccess(map);
    }
    @PostMapping("/getAllRidersSe")
    @ApiOperation(value = "获取所有离职申请骑手", notes = "使用mode：RiderVo 筛选方法同上，" +"审核状态：-1未审核，0未通过，1已通过 "+
                    "  \"registTime\": \"2022-05-04T15:39:57.\",  筛选开始时间，获取的数据中此字段代表注册时间\n"+
                    "  \"checkTime\": \"2022-05-04T15:39:57.817Z\", 筛选结束时间，获取的数据中此字段代表审核时间\n" )
    @ApiImplicitParams({
            @ApiImplicitParam(name = "token", value = "Token", required = true, dataTypeClass = String.class, paramType = "header")
    })
    public ResultResponse getAllRidersSe(@RequestBody RiderVo riderVo,int offset,int limit){
        List<RiderVo> riderVoList = this.riderService.getAllRidersSe(offset,limit,riderVo);
        Map<String,Object> map = new HashMap<>();
        map.put("riderVoList",riderVoList);
        map.put("total",this.riderService.countAllRidersSe(riderVo));

        return ResultResponse.resultSuccess(map);
    }
    @PostMapping("/editRider")
    @ApiOperation(value = "编辑骑手信息", notes = "使用mode：Rider ,解雇骑手传入id和isdelete字段 工号必须传入，其他字段传需要修改的")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "token", value = "Token", required = true, dataTypeClass = String.class, paramType = "header")
    })
    public ResultResponse edit(@RequestBody RiderVo rider) {
        //参数校验
        if (rider.getEmployeeId() == null) {
            return ResultResponse.error("400","缺少工号");
        }

        //更新骑手信息
        this.riderService.update(rider);

        return ResultResponse.resultSuccess("sucess");
    }

    @GetMapping("/getRiderById")
    @ApiOperation(value = "查询", notes = "")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "token", value = "Token", required = true, dataTypeClass = String.class, paramType = "header")
    })
    public ResultResponse getRiderById(String id) {
        //判断是否存在
        RiderVo rider = this.riderService.getRiderById(Integer.valueOf(id));
        if (rider== null) {
            return ResultResponse.error("400","骑手不存在");
        }
        return ResultResponse.resultSuccess(rider);
    }


}

