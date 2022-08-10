package com.zhaishu.qishouserver.service;

import com.zhaishu.qishouserver.entity.ConfigBRider;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.List;

/**
 * 配置信息表，字典表(ConfigBRider)表服务接口
 *
 * @author makejava
 * @since 2022-05-26 09:58:56
 */
public interface ConfigBRiderService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    List<ConfigBRider> queryById(Integer id);

    /**
     * 分页查询
     *
     * @param configBRider 筛选条件
     * @return 查询结果
     */
    List<ConfigBRider> queryByLimit(ConfigBRider configBRider);

    /**
     * 新增数据
     *
     * @param configBRider 实例对象
     * @return 实例对象
     */
    ConfigBRider insert(ConfigBRider configBRider);

    /**
     * 修改数据
     *
     * @param configBRider 实例对象
     * @return 实例对象
     */
    ConfigBRider update(ConfigBRider configBRider);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Integer id);

}
