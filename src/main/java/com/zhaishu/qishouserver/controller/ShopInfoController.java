package com.zhaishu.qishouserver.controller;

import com.zhaishu.qishouserver.common.ResultResponse;
import com.zhaishu.qishouserver.entity.ConfigBRider;
import com.zhaishu.qishouserver.entity.ShopInfo;
import com.zhaishu.qishouserver.service.ConfigBRiderService;
import com.zhaishu.qishouserver.service.ShopInfoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 商铺信息表(ShopInfo)表控制层
 *
 * @author makejava
 * @since 2022-05-26 11:13:09
 */
@RestController
@RequestMapping("shopInfo")
@Api(tags = "AA获取商户列表")
public class ShopInfoController {
    /**
     * 服务对象
     */
    @Resource
    private ShopInfoService shopInfoService;
    @Resource
    private ConfigBRiderService configBRiderService;

    @PostMapping("getShopList")
    @ApiOperation(value = "获取商户列表", notes = "必要参数商户id:100101,模板")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "token", value = "Token", required = true, dataTypeClass = String.class, paramType = "header")
    })
    public ResultResponse getShopList(@RequestBody ShopInfo info, Integer limit,Integer offset){
       List<ShopInfo> list=this.shopInfoService.queryAllByLimit(info, limit, offset);
        Map<String,Object> map=new HashMap<>();
        map.put("total",this.shopInfoService.count(info));
        map.put("list",list);

        return ResultResponse.resultSuccess(map);
    }


    @PostMapping("updateShop")
    @ApiOperation(value = "更新商户信息", notes = "必要参数商户id")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "token", value = "Token", required = true, dataTypeClass = String.class, paramType = "header")
    })
    public ResultResponse updateShop(@RequestBody ShopInfo info){
        if (info.getShopId()==null){
            return  ResultResponse.error("400","缺少必要参数商户id");
        }

        this.shopInfoService.update(info);

        return ResultResponse.resultSuccess("");
    }

    @PostMapping("addShop")
    @ApiOperation(value = "添加商户", notes = "传入商户必要信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "token", value = "Token", required = true, dataTypeClass = String.class, paramType = "header")
    })
    @Transactional
    public ResultResponse addShop(@RequestBody ShopInfo info){
        if (info.getShopId()==null||info.getShopName()==null){
            return ResultResponse.error("400","参数错误，必须传入商户id（6）和商户名（20)");
        }
        if (shopInfoService.queryById(info.getShopId())!=null){
            return ResultResponse.error("500","商户id重复，请重新传入商户id");
        }
        List<ConfigBRider> configBRiders=configBRiderService.queryById(100101);
        if (configBRiders.size()<=0){
            return ResultResponse.error("404","配置缺失，请联系管理员");
        }
        for (ConfigBRider config:
                configBRiders) {
            config.setShopId(info.getShopId());
            config.setId(null);
            config.setValue(0.0);
            configBRiderService.insert(config);
        }

       return ResultResponse.resultSuccess(shopInfoService.insert(info));
    }


}

