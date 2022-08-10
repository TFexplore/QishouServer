package com.zhaishu.qishouserver.controller;
import com.zhaishu.qishouserver.Security.UserToken;
import com.zhaishu.qishouserver.common.ResultResponse;
import com.zhaishu.qishouserver.entity.ConfigBRider;
import com.zhaishu.qishouserver.service.ConfigBRiderService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * 配置信息表，字典表(ConfigBRider)表控制层
 *
 * @author makejava
 * @since 2022-05-26 09:25:28
 */
@RestController
@RequestMapping("configBRider")
@Api(tags = "AA商户接单配置信息表")
public class ConfigBRiderController{
    /**
     * 服务对象
     */
    @Resource
    private ConfigBRiderService configBRiderService;

    @GetMapping("/GetConfigById")
    @ApiOperation(value = "获取配置表", notes = "传入商户id，没有绑定商户id的需要先绑定商户,100101模板")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "token", value = "Token", required = true, dataTypeClass = String.class, paramType = "header")
    })
    @UserToken.Sales
    public ResultResponse GetConfigById(Integer shopId){
        List<ConfigBRider> config=this.configBRiderService.queryById(shopId);
        if (config==null){
            return  ResultResponse.error("404","不存在的商户id");
        }

        return  ResultResponse.resultSuccess(config);
    }
    @PostMapping("/EditConfigById")
    @ApiOperation(value = "编辑配置", notes = "必要参数商户id")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "token", value = "Token", required = true, dataTypeClass = String.class, paramType = "header")
    })
    @UserToken.Sales
    public ResultResponse EditConfigById(@RequestBody ConfigBRider config){
        if (config.getShopId()==null){
            return ResultResponse.error("400","缺少参数：shopId");
        }
        if (config.getCode()==null||config.getValue()==null){
            return ResultResponse.error("400","缺少必要参数：code ，value");
        }

        return  ResultResponse.resultSuccess( this.configBRiderService.update(config));
    }
    @PostMapping("/getByLimit")
    @ApiOperation(value = "获取单条配置", notes = "必要参数商户id和字段code：100101，1008获取订单单价")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "token", value = "Token", required = true, dataTypeClass = String.class, paramType = "header")
    })
    @UserToken.Sales
    public ResultResponse getByLimit(@RequestBody ConfigBRider config){
        if (config.getShopId()==null){
            return ResultResponse.error("400","缺少参数：shopId");
        }
        if (config.getCode()==null){
            return ResultResponse.error("400","缺少必要参数：code ，value");
        }

        return  ResultResponse.resultSuccess( this.configBRiderService.queryByLimit(config).get(0));
    }


}
