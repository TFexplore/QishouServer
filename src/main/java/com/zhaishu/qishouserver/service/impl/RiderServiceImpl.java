package com.zhaishu.qishouserver.service.impl;

import com.zhaishu.qishouserver.entity.Rider;
import com.zhaishu.qishouserver.dao.RiderDao;
import com.zhaishu.qishouserver.service.RiderService;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import javax.annotation.Resource;

/**
 * 骑手信息表(Rider)表服务实现类
 *
 * @author makejava
 * @since 2022-04-18 19:22:41
 */
@Service("riderService")
public class RiderServiceImpl implements RiderService {
    @Resource
    private RiderDao riderDao;

    /**
     * 骑手注册
     *
     * @param rider 骑手信息
     * @return 实例对象
     */
    public Rider register(Rider rider) {


        this.riderDao.insert(rider);
        return rider;
    }


    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public Rider queryById(Integer id) {
        return this.riderDao.queryById(id);
    }

    /**
     * 分页查询
     *
     * @param rider 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @Override
    public Page<Rider> queryByPage(Rider rider, PageRequest pageRequest) {
        long total = this.riderDao.count(rider);
        return new PageImpl<>(this.riderDao.queryAllByLimit(rider, pageRequest), pageRequest, total);
    }

    /**
     * 新增数据
     *
     * @param rider 实例对象
     * @return 实例对象
     */
    @Override
    public Rider insert(Rider rider) {
        this.riderDao.insert(rider);
        return rider;
    }

    /**
     * 修改数据
     *
     * @param rider 实例对象
     * @return 实例对象
     */
    @Override
    public Rider update(Rider rider) {
        this.riderDao.update(rider);
        return this.queryById(rider.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.riderDao.deleteById(id) > 0;
    }
}
