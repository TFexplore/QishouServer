package com.zhaishu.qishouserver.controller;

import com.zhaishu.qishouserver.Security.UserToken;
import com.zhaishu.qishouserver.common.ResultResponse;
import com.zhaishu.qishouserver.common.Utils;
import com.zhaishu.qishouserver.entity.VersionCon;
import com.zhaishu.qishouserver.service.VersionConService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (VersionCon)表控制层
 *
 * @author makejava
 * @since 2022-07-28 20:33:55
 */
@RestController
@RequestMapping("versionCon")
@Api(tags = "AAA版本管理", description = "表")
public class VersionConController {
    /**
     * 服务对象
     */
    @Resource
    private VersionConService versionConService;


    /**
     * 通过主键查询单条数据
     *
     * @return 单条数据
     */
    @GetMapping("/getNewVersion")
    @ApiOperation(value = "获取最新版本信息", notes = "200成功，404暂无最新版本信息")
    @UserToken.PassToken
    public ResultResponse getNewVersion() {

        VersionCon q=new VersionCon();
        q.setIsOnline(1);

        try {
            q= this.versionConService.queryByPage(q,0,1).get(0);
        }catch (IndexOutOfBoundsException e){
            return ResultResponse.error("404","not found the record");
        }


        return ResultResponse.resultSuccess(q);
    }
    /**
     * 分页查询
     *
     * @param versionCon 筛选条件
     * @param      
     * @return 查询结果
     */
    @PostMapping("/queryByPage")
    @ApiOperation(value = "批量筛选查询", notes = "传入筛选字段等必要信息")
    @UserToken.SuperAdmin
    @ApiImplicitParams({
            @ApiImplicitParam(name = "token", value = "Token", required = true, dataTypeClass = String.class, paramType = "header")
    })
    public ResultResponse queryByPage(@RequestBody VersionCon versionCon, Integer offset, Integer limit) {
        if(offset==null||limit==null){
        return ResultResponse.error("400","offset and limit not null");
        }
        if(versionCon==null){
        return ResultResponse.error("400","please input the limit key");
        }
        
        return ResultResponse.resultSuccess("");
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("/queryById")
    @ApiOperation(value = "查询单条", notes = "传入id")
    @UserToken.SuperAdmin
    @ApiImplicitParams({
            @ApiImplicitParam(name = "token", value = "Token", required = true, dataTypeClass = String.class, paramType = "header")
    })
    public ResultResponse queryById(Integer id) {
        VersionCon q=this.versionConService.queryById(id);
        if(q==null){
         return ResultResponse.error("404","not found the record");
        }
    
    
        return ResultResponse.resultSuccess(q);
    }

    /**
     * 新增数据
     *
     * @param versionCon 实体
     * @return 新增结果
     */
    @PostMapping("/add")
    @ApiOperation(value = "新增", notes = "传入必要信息")
    @UserToken.SuperAdmin
    public ResultResponse add(@RequestBody VersionCon versionCon) {
        return ResultResponse.resultSuccess(this.versionConService.insert(versionCon));
    }

    /**
     * 编辑数据
     *
     * @return 编辑结果
     */
    @PostMapping("/edit")
    @ApiOperation(value = "修改", notes = "传入唯一字段和需要修改的字段")
    @UserToken.SuperAdmin
    @ApiImplicitParams({
            @ApiImplicitParam(name = "token", value = "Token", required = true, dataTypeClass = String.class, paramType = "header")
    })
    public ResultResponse edit(@RequestBody VersionCon con) {
        if(con==null){
        return ResultResponse.error("400","please input the key");
        }
        if (con.getId()==null){
            return ResultResponse.error("400","please input the key");
        }
        if (queryById(con.getId())==null){
            return ResultResponse.error("404","not found");
        }
        if (con.getIsOnline()!=null&&con.getIsOnline()==1){
            VersionCon versionCon=new VersionCon();
            versionCon.setIsOnline(1);
            try {
                versionCon=versionConService.queryByPage(versionCon,0,1).get(0);
                versionCon.setIsOnline(0);
                versionConService.update(versionCon);
            }catch (IndexOutOfBoundsException e) {

            }finally {

                versionConService.update(con);
            }

        }else  versionConService.update(con);

        return ResultResponse.resultSuccess(versionConService.queryById(con.getId()));
    }
    /**上传地址*/
    @Value("${apk.path}")
    private String apkPath;
    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @PostMapping("/deleteById")
    @ApiOperation(value = "删除", notes = "传入唯一字段和需要修改的字段")
    @UserToken.SuperAdmin
    @ApiImplicitParams({
            @ApiImplicitParam(name = "token", value = "Token", required = true, dataTypeClass = String.class, paramType = "header")
    })
    public ResultResponse deleteById(Integer id) {
        VersionCon con=versionConService.queryById(id);
        if (con==null){
            return ResultResponse.error("404","not found");
        }
        String realPath=apkPath+String.valueOf(con.getVersionId())+"/";

        if (!Utils.deleteDirectory(realPath)){
            return  ResultResponse.error("500","文件删除失败，请联系管理员");

        }
        if(!this.versionConService.deleteById(id)){
        
        return  ResultResponse.error("500","删除失败，请联系管理员");
        
        }




    
        return ResultResponse.resultSuccess("操作成功");
    }

}

