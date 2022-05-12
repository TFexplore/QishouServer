package com.zhaishu.qishouserver.controller;

import com.zhaishu.qishouserver.entity.InvitateRider;
import com.zhaishu.qishouserver.service.InvitateRiderService;
import io.swagger.annotations.Api;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * 邀请骑手记录(InvitateRider)表控制层
 *
 * @author makejava
 * @since 2022-04-18 19:22:41
 */
@RestController
@RequestMapping("invitateRider")
@Api(tags = "邀请表", description = "")
public class InvitateRiderController {
    /**
     * 服务对象
     */
    @Resource
    private InvitateRiderService invitateRiderService;

    /**
     * 分页查询
     *
     * @param invitateRider 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @GetMapping
    public ResponseEntity<Page<InvitateRider>> queryByPage(InvitateRider invitateRider, PageRequest pageRequest) {
        return ResponseEntity.ok(this.invitateRiderService.queryByPage(invitateRider, pageRequest));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public ResponseEntity<InvitateRider> queryById(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(this.invitateRiderService.queryById(id));
    }

    /**
     * 新增数据
     *
     * @param invitateRider 实体
     * @return 新增结果
     */
    @PostMapping
    public ResponseEntity<InvitateRider> add(InvitateRider invitateRider) {
        return ResponseEntity.ok(this.invitateRiderService.insert(invitateRider));
    }

    /**
     * 编辑数据
     *
     * @param invitateRider 实体
     * @return 编辑结果
     */
    @PutMapping
    public ResponseEntity<InvitateRider> edit(InvitateRider invitateRider) {
        return ResponseEntity.ok(this.invitateRiderService.update(invitateRider));
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @DeleteMapping
    public ResponseEntity<Boolean> deleteById(Integer id) {
        return ResponseEntity.ok(this.invitateRiderService.deleteById(id));
    }

}

