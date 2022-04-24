package com.zhaishu.qishouserver.service.impl;

import com.zhaishu.qishouserver.entity.DistributeBill;
import com.zhaishu.qishouserver.dao.DistributeBillDao;
import com.zhaishu.qishouserver.service.DistributeBillService;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import javax.annotation.Resource;

/**
 * 骑手配送账单表(DistributeBill)表服务实现类
 *
 * @author makejava
 * @since 2022-04-18 19:21:34
 */
@Service("distributeBillService")
public class DistributeBillServiceImpl implements DistributeBillService {
    @Resource
    private DistributeBillDao distributeBillDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public DistributeBill queryById(Integer id) {
        return this.distributeBillDao.queryById(id);
    }

    /**
     * 分页查询
     *
     * @param distributeBill 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @Override
    public Page<DistributeBill> queryByPage(DistributeBill distributeBill, PageRequest pageRequest) {
        long total = this.distributeBillDao.count(distributeBill);
        return new PageImpl<>(this.distributeBillDao.queryAllByLimit(distributeBill, pageRequest), pageRequest, total);
    }

    /**
     * 新增数据
     *
     * @param distributeBill 实例对象
     * @return 实例对象
     */
    @Override
    public DistributeBill insert(DistributeBill distributeBill) {
        this.distributeBillDao.insert(distributeBill);
        return distributeBill;
    }

    /**
     * 修改数据
     *
     * @param distributeBill 实例对象
     * @return 实例对象
     */
    @Override
    public DistributeBill update(DistributeBill distributeBill) {
        this.distributeBillDao.update(distributeBill);
        return this.queryById(distributeBill.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.distributeBillDao.deleteById(id) > 0;
    }
}
