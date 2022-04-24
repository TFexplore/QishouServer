package com.zhaishu.qishouserver.service.impl;

import com.zhaishu.qishouserver.entity.DistributeOrder;
import com.zhaishu.qishouserver.dao.DistributeOrderDao;
import com.zhaishu.qishouserver.service.DistributeOrderService;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import javax.annotation.Resource;

/**
 * 骑手配送信息表(DistributeOrder)表服务实现类
 *
 * @author makejava
 * @since 2022-04-18 19:22:40
 */
@Service("distributeOrderService")
public class DistributeOrderServiceImpl implements DistributeOrderService {
    @Resource
    private DistributeOrderDao distributeOrderDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public DistributeOrder queryById(Integer id) {
        return this.distributeOrderDao.queryById(id);
    }

    /**
     * 分页查询
     *
     * @param distributeOrder 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @Override
    public Page<DistributeOrder> queryByPage(DistributeOrder distributeOrder, PageRequest pageRequest) {
        long total = this.distributeOrderDao.count(distributeOrder);
        return new PageImpl<>(this.distributeOrderDao.queryAllByLimit(distributeOrder, pageRequest), pageRequest, total);
    }

    /**
     * 新增数据
     *
     * @param distributeOrder 实例对象
     * @return 实例对象
     */
    @Override
    public DistributeOrder insert(DistributeOrder distributeOrder) {
        this.distributeOrderDao.insert(distributeOrder);
        return distributeOrder;
    }

    /**
     * 修改数据
     *
     * @param distributeOrder 实例对象
     * @return 实例对象
     */
    @Override
    public DistributeOrder update(DistributeOrder distributeOrder) {
        this.distributeOrderDao.update(distributeOrder);
        return this.queryById(distributeOrder.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.distributeOrderDao.deleteById(id) > 0;
    }
}
