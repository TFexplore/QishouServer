package com.zhaishu.qishouserver.controller;

import com.zhaishu.qishouserver.Security.UserToken;
import com.zhaishu.qishouserver.common.ResultResponse;
import com.zhaishu.qishouserver.common.Utils;
import com.zhaishu.qishouserver.entity.Notice;
import com.zhaishu.qishouserver.service.NoticeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (Notice)表控制层
 *
 * @author makejava
 * @since 2022-08-02 14:40:54
 */
@RestController
@RequestMapping("notice")
@Api(tags = "AAAA公告管理", description = "表")
public class NoticeController {
    /**
     * 服务对象
     */
    @Resource
    private NoticeService noticeService;

    /**
     * 分页查询
     *
     * @param notice 筛选条件
     * @param      
     * @return 查询结果
     */
    @PostMapping("/queryByPage")
        @ApiOperation(value = "批量筛选查询", notes = "传入筛选字段等必要信息,获取当前显示的公告时传入startTime值为当前时间")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "token", value = "Token", required = true, dataTypeClass = String.class, paramType = "header")
    })
    @UserToken.PassToken
    public ResultResponse queryByPage(@RequestBody Notice notice, Integer offset, Integer limit) {
        if(offset==null||limit==null){

        return ResultResponse.error("400","offset and limit not null");

        }

        
        return ResultResponse.resultMap(this.noticeService.count(notice),this.noticeService.queryByPage(notice, offset,limit));
    }
    @GetMapping("/employeeList")
    @ApiOperation(value = "获取发布人列表", notes = "")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "token", value = "Token", required = true, dataTypeClass = String.class, paramType = "header")
    })
    @UserToken.Admin
    public ResultResponse getEmployeeList(){

        return ResultResponse.resultSuccess(noticeService.getEmployeeList());
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("/queryById")
        @ApiOperation(value = "查询单条", notes = "传入id")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "token", value = "Token", required = true, dataTypeClass = String.class, paramType = "header")
    })
    @UserToken.Admin
    public ResultResponse queryById(Integer id) {
        Notice q=this.noticeService.queryById(id);
        if(q==null){
         return ResultResponse.error("404","not found the record");
        }
    
    
        return ResultResponse.resultSuccess(q);
    }

    /**
     * 新增数据
     *
     * @param notice 实体
     * @return 新增结果
     */
    @PostMapping("/add")
        @ApiOperation(value = "新增", notes = "传入必要信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "token", value = "Token", required = true, dataTypeClass = String.class, paramType = "header")
    })
    @UserToken.Admin
    public ResultResponse add(@RequestBody @Validated Notice notice) {

        notice.setNoticeId(Utils.getShortId(6));
        notice.setIsDelete(0);
        return ResultResponse.resultSuccess(this.noticeService.insert(notice));
    }

    /**
     * 编辑数据
     *
     * @param notice 实体
     * @return 编辑结果
     */
    @PostMapping("/edit")
        @ApiOperation(value = "修改编辑", notes = "传入唯一字段和需要修改的字段")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "token", value = "Token", required = true, dataTypeClass = String.class, paramType = "header")
    })
    @UserToken.Admin
    public ResultResponse edit(@RequestBody Notice notice) {
        if(notice.getNoticeId()==null){
        return ResultResponse.error("400","please input the key");
        }
        
        return ResultResponse.resultSuccess(this.noticeService.update(notice));
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @DeleteMapping
    public ResultResponse deleteById(Integer id) {
        if(!this.noticeService.deleteById(id)){
        
        return  ResultResponse.error("500","删除失败，请联系管理员");
        
        }
    
        return ResultResponse.resultSuccess("操作成功");
    }

}

