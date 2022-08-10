package com.zhaishu.qishouserver.service.impl;

import com.zhaishu.qishouserver.entity.ConfigBRider;
import com.zhaishu.qishouserver.dao.ConfigBRiderDao;
import com.zhaishu.qishouserver.service.ConfigBRiderService;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import javax.annotation.Resource;
import java.util.List;

/**
 * 配置信息表，字典表(ConfigBRider)表服务实现类
 *
 * @author makejava
 * @since 2022-05-26 09:58:56
 */
@Service("configBRiderService")
public class ConfigBRiderServiceImpl implements ConfigBRiderService {
    @Resource
    private ConfigBRiderDao configBRiderDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public List<ConfigBRider> queryById(Integer id) {
        return this.configBRiderDao.queryById(id);
    }

    /**
     * 分页查询
     *
     * @param configBRider 筛选条件
     * @return 查询结果
     */
    @Override
    public List<ConfigBRider> queryByLimit(ConfigBRider configBRider) {

        return this.configBRiderDao.queryByLimit(configBRider);
    }

    /**
     * 新增数据
     *
     * @param configBRider 实例对象
     * @return 实例对象
     */
    @Override
    public ConfigBRider insert(ConfigBRider configBRider) {
        this.configBRiderDao.insert(configBRider);
        return configBRider;
    }

    /**
     * 修改数据
     *
     * @param configBRider 实例对象
     * @return 实例对象
     */
    @Override
    public ConfigBRider update(ConfigBRider configBRider) {
        this.configBRiderDao.update(configBRider);
        return configBRider;
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.configBRiderDao.deleteById(id) > 0;
    }
}
