package com.zhaishu.qishouserver.controller;

import com.zhaishu.qishouserver.Security.UserToken;
import com.zhaishu.qishouserver.common.ResultResponse;
import com.zhaishu.qishouserver.entity.CalendarTemplate;
import com.zhaishu.qishouserver.service.CalendarTemplateService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (CalendarTemplate)表控制层
 *
 * @author makejava
 * @since 2022-07-28 22:35:54
 */
@RestController
@RequestMapping("calendarTemplate")
@Api(tags = "AAA时间安排模板", description = "表")
public class CalendarTemplateController {
    /**
     * 服务对象
     */
    @Resource
    private CalendarTemplateService calendarTemplateService;

    /**
     * 分页查询
     *
     * @param calendarTemplate 筛选条件
     * @param      
     * @return 查询结果
     */
    @PostMapping("/queryByPage")
        @ApiOperation(value = "批量筛选查询", notes = "传入筛选字段等必要信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "token", value = "Token", required = true, dataTypeClass = String.class, paramType = "header")
    })
    @UserToken.Admin
    public ResultResponse queryByPage(@RequestBody CalendarTemplate calendarTemplate, Integer offset, Integer limit) {
        if(offset==null||limit==null){
        return ResultResponse.error("400","offset and limit not null");
        }
        
        return ResultResponse.resultMap(this.calendarTemplateService.count(calendarTemplate),this.calendarTemplateService.queryByPage(calendarTemplate, offset,limit));
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
        CalendarTemplate q=this.calendarTemplateService.queryById(id);
        if(q==null){
         return ResultResponse.error("404","not found the record");
        }
    
    
        return ResultResponse.resultSuccess(q);
    }

    /**
     * 新增数据
     *
     * @param calendarTemplate 实体
     * @return 新增结果
     */
    @PostMapping("/add")
        @ApiOperation(value = "新增", notes = "传入必要信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "token", value = "Token", required = true, dataTypeClass = String.class, paramType = "header")
    })
    @UserToken.Admin
    public ResultResponse add(@RequestBody CalendarTemplate calendarTemplate) {
        return ResultResponse.resultSuccess(this.calendarTemplateService.insert(calendarTemplate));
    }

    /**
     * 编辑数据
     *
     * @param calendarTemplate 实体
     * @return 编辑结果
     */
    @PostMapping("/edit")
        @ApiOperation(value = "修改编辑", notes = "传入唯一字段和需要修改的字段")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "token", value = "Token", required = true, dataTypeClass = String.class, paramType = "header")
    })
    @UserToken.Admin
    public ResultResponse edit(@RequestBody CalendarTemplate calendarTemplate) {
        if(calendarTemplate.getId()==null){
        return ResultResponse.error("400","please input the key");
        }
        
        return ResultResponse.resultSuccess(this.calendarTemplateService.update(calendarTemplate));
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @DeleteMapping
    public ResultResponse deleteById(Integer id) {
        if(!this.calendarTemplateService.deleteById(id)){
        
        return  ResultResponse.error("500","删除失败，请联系管理员");
        
        }
    
        return ResultResponse.resultSuccess("操作成功");
    }

}
