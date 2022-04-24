package com.zhaishu.qishouserver.service.impl;

import com.zhaishu.qishouserver.entity.ApplyWithdraw;
import com.zhaishu.qishouserver.dao.ApplyWithdrawDao;
import com.zhaishu.qishouserver.service.ApplyWithdrawService;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import javax.annotation.Resource;

/**
 * (ApplyWithdraw)表服务实现类
 *
 * @author makejava
 * @since 2022-04-18 19:16:00
 */
@Service("applyWithdrawService")
public class ApplyWithdrawServiceImpl implements ApplyWithdrawService {
    @Resource
    private ApplyWithdrawDao applyWithdrawDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public ApplyWithdraw queryById(Integer id) {
        return this.applyWithdrawDao.queryById(id);
    }

    /**
     * 分页查询
     *
     * @param applyWithdraw 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @Override
    public Page<ApplyWithdraw> queryByPage(ApplyWithdraw applyWithdraw, PageRequest pageRequest) {
        long total = this.applyWithdrawDao.count(applyWithdraw);
        return new PageImpl<>(this.applyWithdrawDao.queryAllByLimit(applyWithdraw, pageRequest), pageRequest, total);
    }

    /**
     * 新增数据
     *
     * @param applyWithdraw 实例对象
     * @return 实例对象
     */
    @Override
    public ApplyWithdraw insert(ApplyWithdraw applyWithdraw) {
        this.applyWithdrawDao.insert(applyWithdraw);
        return applyWithdraw;
    }

    /**
     * 修改数据
     *
     * @param applyWithdraw 实例对象
     * @return 实例对象
     */
    @Override
    public ApplyWithdraw update(ApplyWithdraw applyWithdraw) {
        this.applyWithdrawDao.update(applyWithdraw);
        return this.queryById(applyWithdraw.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.applyWithdrawDao.deleteById(id) > 0;
    }
}
