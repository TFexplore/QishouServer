package com.zhaishu.qishouserver.service;

import com.zhaishu.qishouserver.entity.InvitateRider;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

/**
 * 邀请骑手记录(InvitateRider)表服务接口
 *
 * @author makejava
 * @since 2022-04-18 19:22:41
 */
public interface InvitateRiderService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    InvitateRider queryById(Integer id);

    /**
     * 分页查询
     *
     * @param invitateRider 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    Page<InvitateRider> queryByPage(InvitateRider invitateRider, PageRequest pageRequest);

    /**
     * 新增数据
     *
     * @param invitateRider 实例对象
     * @return 实例对象
     */
    InvitateRider insert(InvitateRider invitateRider);

    /**
     * 修改数据
     *
     * @param invitateRider 实例对象
     * @return 实例对象
     */
    InvitateRider update(InvitateRider invitateRider);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Integer id);

}
