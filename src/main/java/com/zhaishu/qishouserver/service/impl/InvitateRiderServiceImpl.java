package com.zhaishu.qishouserver.service.impl;

import com.zhaishu.qishouserver.entity.InvitateRider;
import com.zhaishu.qishouserver.dao.InvitateRiderDao;
import com.zhaishu.qishouserver.service.InvitateRiderService;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import javax.annotation.Resource;

/**
 * 邀请骑手记录(InvitateRider)表服务实现类
 *
 * @author makejava
 * @since 2022-04-18 19:22:41
 */
@Service("invitateRiderService")
public class InvitateRiderServiceImpl implements InvitateRiderService {
    @Resource
    private InvitateRiderDao invitateRiderDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public InvitateRider queryById(Integer id) {
        return this.invitateRiderDao.queryById(id);
    }

    /**
     * 分页查询
     *
     * @param invitateRider 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @Override
    public Page<InvitateRider> queryByPage(InvitateRider invitateRider, PageRequest pageRequest) {
        long total = this.invitateRiderDao.count(invitateRider);
        return new PageImpl<>(this.invitateRiderDao.queryAllByLimit(invitateRider, pageRequest), pageRequest, total);
    }

    /**
     * 新增数据
     *
     * @param invitateRider 实例对象
     * @return 实例对象
     */
    @Override
    public InvitateRider insert(InvitateRider invitateRider) {
        this.invitateRiderDao.insert(invitateRider);
        return invitateRider;
    }

    /**
     * 修改数据
     *
     * @param invitateRider 实例对象
     * @return 实例对象
     */
    @Override
    public InvitateRider update(InvitateRider invitateRider) {
        this.invitateRiderDao.update(invitateRider);
        return this.queryById(invitateRider.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.invitateRiderDao.deleteById(id) > 0;
    }
}
