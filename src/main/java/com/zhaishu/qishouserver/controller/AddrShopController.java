package com.zhaishu.qishouserver.controller;

import com.zhaishu.qishouserver.Security.UserToken;
import com.zhaishu.qishouserver.common.Utils;
import com.zhaishu.qishouserver.entity.AddrShop;
import com.zhaishu.qishouserver.service.AddrShopService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import com.zhaishu.qishouserver.common.ResultResponse;

/**
 * (AddrShop)表控制层
 *
 * @author makejava
 * @since 2022-08-10 09:37:52
 */
@RestController
@RequestMapping("addrShop")
@Api(tags = "AAAAA自提点管理", description = "表")
public class AddrShopController {
    /**
     * 服务对象
     */
    @Resource
    private AddrShopService addrShopService;


    @PostMapping("/queryByPage")
        @ApiOperation(value = "批量筛选查询", notes = "传入筛选字段等必要信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "token", value = "Token", required = true, dataTypeClass = String.class, paramType = "header")
    })
    @UserToken.Admin
    public ResultResponse queryByPage(@RequestBody AddrShop addrShop,Integer offset,Integer limit) {
        if(offset==null||limit==null){
        return ResultResponse.error("400","offset and limit not null");
        }

        
        return ResultResponse.resultMap(this.addrShopService.count(addrShop),this.addrShopService.queryByPage(addrShop, offset,limit));
    }


    @GetMapping("/queryById")
        @ApiOperation(value = "查询单条", notes = "传入id")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "token", value = "Token", required = true, dataTypeClass = String.class, paramType = "header")
    })
    @UserToken.Admin
    public ResultResponse queryById(Integer id) {
        AddrShop q=this.addrShopService.queryById(id);
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
    public ResultResponse add(@RequestBody AddrShop addrShop) {
        if (addrShop.getName() == null) {
            return ResultResponse.error("400","name is null");

        }
        addrShop.setIsDelet(0);
        addrShop.setAddrNum(Utils.getShortId(6));

        return ResultResponse.resultSuccess(this.addrShopService.insert(addrShop));
    }


    @PostMapping("/edit")
    @ApiOperation(value = "修改编辑", notes = "传入唯一字段编号num和需要修改的字段")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "token", value = "Token", required = true, dataTypeClass = String.class, paramType = "header")
    })
    @UserToken.Admin
    public ResultResponse edit(@RequestBody AddrShop addrShop) {
        if(addrShop.getAddrNum()==null){
        return ResultResponse.error("400","please input the key");
        }
        
        return ResultResponse.resultSuccess(this.addrShopService.update(addrShop));
    }


    @DeleteMapping
    @ApiOperation(value = "删除", notes = "传入编号num")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "token", value = "Token", required = true, dataTypeClass = String.class, paramType = "header")
    })
    @UserToken.Admin
    public ResultResponse deleteById(Integer id) {
        if(!this.addrShopService.deleteById(id)){
        
        return  ResultResponse.error("500","删除失败，请联系管理员");
        
        }
    
        return ResultResponse.resultSuccess("操作成功");
    }

}

