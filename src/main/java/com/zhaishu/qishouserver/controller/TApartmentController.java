package com.zhaishu.qishouserver.controller;

import com.zhaishu.qishouserver.Security.UserToken;
import com.zhaishu.qishouserver.common.ResultResponse;
import com.zhaishu.qishouserver.entity.TApartment;
import com.zhaishu.qishouserver.service.TApartmentService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * 楼栋表(TApartment)表控制层
 *
 * @author makejava
 * @since 2022-05-06 20:41:37
 */
@RestController
@RequestMapping("tApartment")
@Api(tags = "B楼栋信息表", description = "modle ：TApartment")
public class TApartmentController {
    /**
     * 服务对象
     */
    @Resource
    private TApartmentService tApartmentService;


    @GetMapping("/getLocatinMap")
    @ApiOperation(value = "获取楼栋信息映射表", notes = "mode：inApplication,传入骑手id，审核人id，时间等必要信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "token", value = "Token", required = true, dataTypeClass = String.class, paramType = "header")
    })
    @UserToken.Admin
    public ResultResponse getLocatinMap(){
        List<TApartment> list=tApartmentService.getAll();

        return ResultResponse.resultSuccess(list);
    }
    /**
     * 分页查询
     *
     * @param tApartment 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @GetMapping
    public ResponseEntity<Page<TApartment>> queryByPage(TApartment tApartment, PageRequest pageRequest) {
        return ResponseEntity.ok(this.tApartmentService.queryByPage(tApartment, pageRequest));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public ResponseEntity<TApartment> queryById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(this.tApartmentService.queryById(id));
    }

    /**
     * 新增数据
     *
     * @param tApartment 实体
     * @return 新增结果
     */
    @PostMapping
    public ResponseEntity<TApartment> add(TApartment tApartment) {
        return ResponseEntity.ok(this.tApartmentService.insert(tApartment));
    }

    /**
     * 编辑数据
     *
     * @param tApartment 实体
     * @return 编辑结果
     */
    @PutMapping
    public ResponseEntity<TApartment> edit(TApartment tApartment) {
        return ResponseEntity.ok(this.tApartmentService.update(tApartment));
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @DeleteMapping
    public ResponseEntity<Boolean> deleteById(Long id) {
        return ResponseEntity.ok(this.tApartmentService.deleteById(id));
    }

}

