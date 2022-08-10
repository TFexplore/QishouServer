package com.zhaishu.qishouserver.controller;

import com.zhaishu.qishouserver.Security.UserToken;
import com.zhaishu.qishouserver.Vo.ApplyDrawVo;
import com.zhaishu.qishouserver.common.RedisUtil;
import com.zhaishu.qishouserver.common.TokenUtils;
import com.zhaishu.qishouserver.common.Utils;
import com.zhaishu.qishouserver.entity.ApplyWithdraw;
import com.zhaishu.qishouserver.http.OkHttpCli;
import com.zhaishu.qishouserver.service.ApplyWithdrawService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import com.zhaishu.qishouserver.common.ResultResponse;

import java.util.HashMap;
import java.util.Map;

/**
 * (ApplyWithdraw)表控制层
 *
 * @author makejava
 * @since 2022-08-06 11:21:05
 */
@RestController
@RequestMapping("applyWithdraw")
@Api(tags = "AAAA提现申请管理", description = "表")
public class ApplyWithdrawController {
    /**
     * 服务对象
     */
    @Resource
    private ApplyWithdrawService applyWithdrawService;
    @Resource
    HttpServletRequest httpServletRequest;
    @Resource
    OkHttpCli httpCli;
    @Resource
    RedisUtil redisUtil;

    @PostMapping("/queryByPage")
        @ApiOperation(value = "批量筛选查询", notes = "传入筛选字段等必要信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "token", value = "Token", required = true, dataTypeClass = String.class, paramType = "header")
    })
    @UserToken.Admin
    public ResultResponse queryByPage(@RequestBody ApplyDrawVo applyWithdraw, Integer offset, Integer limit) {
        if(offset==null||limit==null){
         return ResultResponse.error("400","offset and limit not null");
        }

        
        return ResultResponse.resultMap(this.applyWithdrawService.count(applyWithdraw),this.applyWithdrawService.queryByPage(applyWithdraw, offset,limit));
    }
    @PostMapping("/commit")
    @ApiOperation(value = "审批", notes = "传入applyId,type：1通过，0不通过")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "token", value = "Token", required = true, dataTypeClass = String.class, paramType = "header")
    })
    @UserToken.Admin
    @Transactional(isolation = Isolation.SERIALIZABLE)
    public ResultResponse commit(String applyId, Integer type) {
        if(applyId==null||type==null){
            return ResultResponse.error("400","applyId and type not null");
        }
        ApplyWithdraw withdraw=applyWithdrawService.queryById(applyId);
        if (withdraw==null){
            return ResultResponse.error("403","申请状态发生变化，审批失败,请刷新页面");

        }

        withdraw.setApplyId(applyId);
        String token=httpServletRequest.getHeader("token");
        withdraw.setCheckBy(TokenUtils.getIntegerValus("userId",token));
        withdraw.setWithdrawFlag(type);
        applyWithdrawService.update(withdraw);

        if (type==1){//提现接口
            String url = "https://www.zmice.top/wallet/getBalance/manager";
            Map<String,String> map=new HashMap<>();
            map.put("aapplyId", applyId);
            String value=Utils.getStringNum(18);
            redisUtil.saveKeyValue("applyKey", value);
            map.put("applykeyVode",value);
            map.put("employeeId", String.valueOf(withdraw.getEmployeeId()));
            map.put("weixinId", withdraw.getWeixinId());
            httpCli.doEnPost(url,map);
        }

        return ResultResponse.resultSuccess("success");
    }
    @GetMapping("/sum")
    @ApiOperation(value = "统计", notes = "传入开始结束时间，以及flag：5已到账金额")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "token", value = "Token", required = true, dataTypeClass = String.class, paramType = "header")
    })
    @UserToken.Admin
    public ResultResponse sum(Integer flag,Long startTime,Long endTime) {
        if(flag==null||(startTime==null||endTime==null)){
            return ResultResponse.error("400","please input the key");
        }

        return ResultResponse.resultSuccess(this.applyWithdrawService.getAmountByDate(flag, startTime, endTime));
    }



    @GetMapping("/queryById")
        @ApiOperation(value = "查询单条", notes = "传入id")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "token", value = "Token", required = true, dataTypeClass = String.class, paramType = "header")
    })
    @UserToken.Admin
    public ResultResponse queryById(String id) {
        ApplyWithdraw q=this.applyWithdrawService.queryById(id);
        if(q==null){
         return ResultResponse.error("404","not found the record");
        }
    
    
        return ResultResponse.resultSuccess(q);
    }


    @PostMapping("/add")
        @ApiOperation(value = "新增", notes = "传入必要信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "token", value = "Token", required = true, dataTypeClass = String.class, paramType = "header")
    })
    @UserToken.Admin
    public ResultResponse add(@RequestBody ApplyWithdraw applyWithdraw) {
        return ResultResponse.resultSuccess(this.applyWithdrawService.insert(applyWithdraw));
    }


    @PostMapping("/edit")
        @ApiOperation(value = "修改编辑", notes = "传入唯一字段和需要修改的字段")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "token", value = "Token", required = true, dataTypeClass = String.class, paramType = "header")
    })
    @UserToken.Admin
    public ResultResponse edit(@RequestBody ApplyWithdraw applyWithdraw) {
        if(applyWithdraw.getId()==null){
        return ResultResponse.error("400","please input the key");
        }
        
        return ResultResponse.resultSuccess(this.applyWithdrawService.update(applyWithdraw));
    }


    @DeleteMapping
    public ResultResponse deleteById(Integer id) {
        if(!this.applyWithdrawService.deleteById(id)){
        
        return  ResultResponse.error("500","删除失败，请联系管理员");
        
        }
    
        return ResultResponse.resultSuccess("操作成功");
    }

}

