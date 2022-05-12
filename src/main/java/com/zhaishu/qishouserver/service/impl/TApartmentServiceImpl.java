package com.zhaishu.qishouserver.service.impl;

import com.zhaishu.qishouserver.entity.TApartment;
import com.zhaishu.qishouserver.dao.TApartmentDao;
import com.zhaishu.qishouserver.service.TApartmentService;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import javax.annotation.Resource;
import java.util.List;

/**
 * 楼栋表(TApartment)表服务实现类
 *
 * @author makejava
 * @since 2022-05-06 20:41:37
 */
@Service("tApartmentService")
public class TApartmentServiceImpl implements TApartmentService {
    @Resource
    private TApartmentDao tApartmentDao;


    @Override
    public List<TApartment> getAll(){

        return this.tApartmentDao.getAll();
    }
    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public TApartment queryById(Long id) {
        return this.tApartmentDao.queryById(id);
    }

    /**
     * 分页查询
     *
     * @param tApartment 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @Override
    public Page<TApartment> queryByPage(TApartment tApartment, PageRequest pageRequest) {
        long total = this.tApartmentDao.count(tApartment);
        return new PageImpl<>(this.tApartmentDao.queryAllByLimit(tApartment, pageRequest), pageRequest, total);
    }

    /**
     * 新增数据
     *
     * @param tApartment 实例对象
     * @return 实例对象
     */
    @Override
    public TApartment insert(TApartment tApartment) {
        this.tApartmentDao.insert(tApartment);
        return tApartment;
    }

    /**
     * 修改数据
     *
     * @param tApartment 实例对象
     * @return 实例对象
     */
    @Override
    public TApartment update(TApartment tApartment) {
        this.tApartmentDao.update(tApartment);
        return this.queryById(tApartment.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Long id) {
        return this.tApartmentDao.deleteById(id) > 0;
    }
}
