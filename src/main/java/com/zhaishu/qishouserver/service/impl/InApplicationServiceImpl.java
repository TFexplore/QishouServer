package com.zhaishu.qishouserver.service.impl;

import com.zhaishu.qishouserver.entity.InApplication;
import com.zhaishu.qishouserver.dao.InApplicationDao;
import com.zhaishu.qishouserver.service.InApplicationService;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import javax.annotation.Resource;

/**
 * 入职申请表(InApplication)表服务实现类
 *
 * @author makejava
 * @since 2022-04-18 19:22:40
 */
@Service("inApplicationService")
public class InApplicationServiceImpl implements InApplicationService {
    @Resource
    private InApplicationDao inApplicationDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public InApplication queryById(Integer id) {
        return this.inApplicationDao.queryById(id);
    }

    /**
     * 分页查询
     *
     * @param inApplication 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @Override
    public Page<InApplication> queryByPage(InApplication inApplication, PageRequest pageRequest) {
        long total = this.inApplicationDao.count(inApplication);
        return new PageImpl<>(this.inApplicationDao.queryAllByLimit(inApplication, pageRequest), pageRequest, total);
    }

    /**
     * 新增数据
     *
     * @param inApplication 实例对象
     * @return 实例对象
     */
    @Override
    public InApplication insert(InApplication inApplication) {
        this.inApplicationDao.insert(inApplication);
        return inApplication;
    }

    /**
     * 修改数据
     *
     * @param inApplication 实例对象
     * @return 实例对象
     */
    @Override
    public InApplication update(InApplication inApplication) {
        this.inApplicationDao.update(inApplication);
        return this.queryById(inApplication.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.inApplicationDao.deleteById(id) > 0;
    }
}
