package com.zhaishu.qishouserver.controller;

import com.google.gson.Gson;
import com.zhaishu.qishouserver.Security.UserToken;
import com.zhaishu.qishouserver.common.ResultResponse;
import com.zhaishu.qishouserver.entity.Rider;
import com.zhaishu.qishouserver.service.EmployeeService;
import com.zhaishu.qishouserver.service.RiderService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.net.Socket;

/**
 * 骑手信息表(Rider)表控制层
 *
 * @author makejava
 * @since 2022-04-18 19:22:41
 */
@RestController
@RequestMapping("rider")
public class RiderController {
    /**
     * 服务对象
     */
    @Resource
    private RiderService riderService;
    @Resource
    private EmployeeService employeeService;


    //注册骑手
    @PostMapping("/register")
    //@UserToken.UserLoginToken
    @ApiOperation(value = "查询房间")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "Tel", value = "手机号", required = true, dataTypeClass = String.class, paramType = "query"),
            //@ApiImplicitParam(name = "token", value = "Token", required = true, dataTypeClass = String.class, paramType = "header")
    })
    public ResultResponse register(String tel,@RequestBody @Valid Rider rider){


        Gson gson= new Gson();

        System.out.println(gson.toJson(rider));



        //更改员工类型
        employeeService.updateTypeByTel(1,tel);

        return ResultResponse.resultSuccess("sucess");
    }







    /**
     * 分页查询
     *
     * @param rider 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @GetMapping
    public ResponseEntity<Page<Rider>> queryByPage(Rider rider, PageRequest pageRequest) {
        return ResponseEntity.ok(this.riderService.queryByPage(rider, pageRequest));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public ResponseEntity<Rider> queryById(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(this.riderService.queryById(id));
    }

    /**
     * 新增数据
     *
     * @param rider 实体
     * @return 新增结果
     */
    @PostMapping
    public ResponseEntity<Rider> add(Rider rider) {
        return ResponseEntity.ok(this.riderService.insert(rider));
    }

    /**
     * 编辑数据
     *
     * @param rider 实体
     * @return 编辑结果
     */
    @PutMapping
    public ResponseEntity<Rider> edit(Rider rider) {
        return ResponseEntity.ok(this.riderService.update(rider));
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @DeleteMapping
    public ResponseEntity<Boolean> deleteById(Integer id) {
        return ResponseEntity.ok(this.riderService.deleteById(id));
    }

}

