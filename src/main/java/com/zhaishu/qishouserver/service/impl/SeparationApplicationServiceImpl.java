package com.zhaishu.qishouserver.service.impl;

import com.zhaishu.qishouserver.entity.SeparationApplication;
import com.zhaishu.qishouserver.dao.SeparationApplicationDao;
import com.zhaishu.qishouserver.service.SeparationApplicationService;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import javax.annotation.Resource;

/**
 * 离职申请表(SeparationApplication)表服务实现类
 *
 * @author makejava
 * @since 2022-04-18 19:22:41
 */
@Service("separationApplicationService")
public class SeparationApplicationServiceImpl implements SeparationApplicationService {
    @Resource
    private SeparationApplicationDao separationApplicationDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public SeparationApplication queryById(Integer id) {
        return this.separationApplicationDao.queryById(id);
    }

    /**
     * 分页查询
     *
     * @param separationApplication 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @Override
    public Page<SeparationApplication> queryByPage(SeparationApplication separationApplication, PageRequest pageRequest) {
        long total = this.separationApplicationDao.count(separationApplication);
        return new PageImpl<>(this.separationApplicationDao.queryAllByLimit(separationApplication, pageRequest), pageRequest, total);
    }

    /**
     * 新增数据
     *
     * @param separationApplication 实例对象
     * @return 实例对象
     */
    @Override
    public SeparationApplication insert(SeparationApplication separationApplication) {
        this.separationApplicationDao.insert(separationApplication);
        return separationApplication;
    }

    /**
     * 修改数据
     *
     * @param separationApplication 实例对象
     * @return 实例对象
     */
    @Override
    public SeparationApplication update(SeparationApplication separationApplication) {
        this.separationApplicationDao.update(separationApplication);
        return this.queryById(separationApplication.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.separationApplicationDao.deleteById(id) > 0;
    }
}
