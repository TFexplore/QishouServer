package com.zhaishu.qishouserver.service.impl;

import com.zhaishu.qishouserver.entity.Inform;
import com.zhaishu.qishouserver.dao.InformDao;
import com.zhaishu.qishouserver.service.InformService;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import javax.annotation.Resource;

/**
 * 通知公告表(Inform)表服务实现类
 *
 * @author makejava
 * @since 2022-04-18 19:22:41
 */
@Service("informService")
public class InformServiceImpl implements InformService {
    @Resource
    private InformDao informDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public Inform queryById(Integer id) {
        return this.informDao.queryById(id);
    }

    /**
     * 分页查询
     *
     * @param inform 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @Override
    public Page<Inform> queryByPage(Inform inform, PageRequest pageRequest) {
        long total = this.informDao.count(inform);
        return new PageImpl<>(this.informDao.queryAllByLimit(inform, pageRequest), pageRequest, total);
    }

    /**
     * 新增数据
     *
     * @param inform 实例对象
     * @return 实例对象
     */
    @Override
    public Inform insert(Inform inform) {
        this.informDao.insert(inform);
        return inform;
    }

    /**
     * 修改数据
     *
     * @param inform 实例对象
     * @return 实例对象
     */
    @Override
    public Inform update(Inform inform) {
        this.informDao.update(inform);
        return this.queryById(inform.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.informDao.deleteById(id) > 0;
    }
}
