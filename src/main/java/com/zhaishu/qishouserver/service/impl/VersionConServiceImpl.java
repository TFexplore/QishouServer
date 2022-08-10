package com.zhaishu.qishouserver.service.impl;

import com.zhaishu.qishouserver.dao.VersionConDao;
import com.zhaishu.qishouserver.entity.VersionCon;
import com.zhaishu.qishouserver.service.VersionConService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (VersionCon)表服务实现类
 *
 * @author makejava
 * @since 2022-07-28 21:03:43
 */
@Service("versionConService")
public class VersionConServiceImpl implements VersionConService {
    @Resource
    private VersionConDao versionConDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public VersionCon queryById(Integer id) {
        return this.versionConDao.queryById(id);
    }

    /**
     * 分页查询
     *
     * @param versionCon 筛选条件
     * @return 查询结果
     */
    @Override
    public List<VersionCon> queryByPage(VersionCon versionCon, Integer offset, Integer limit) {
      
        return this.versionConDao.queryAllByLimit(versionCon, offset,limit);
    }

    /**
     * 新增数据
     *
     * @param versionCon 实例对象
     * @return 实例对象
     */
    @Override
    public VersionCon insert(VersionCon versionCon) {
        this.versionConDao.insert(versionCon);
        return versionCon;
    }

    /**
     * 修改数据
     *
     * @param versionCon 实例对象
     * @return 实例对象
     */
    @Override
    public VersionCon update(VersionCon versionCon) {
        this.versionConDao.update(versionCon);
        return this.queryById(versionCon.getId());
    }
    @Override
    public int count(VersionCon versionCon) {
        
        return this.versionConDao.count(versionCon); 
    }
    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.versionConDao.deleteById(id) > 0;
    }
}
