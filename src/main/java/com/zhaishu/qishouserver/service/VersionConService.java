package com.zhaishu.qishouserver.service;

import com.zhaishu.qishouserver.entity.VersionCon;

import java.util.List;

/**
 * (VersionCon)表服务接口
 *
 * @author makejava
 * @since 2022-07-28 20:32:20
 */
public interface VersionConService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    VersionCon queryById(Integer id);

    /**
     * 分页查询
     *
     * @param versionCon 筛选条件
     * @return 查询结果
     */
    List<VersionCon> queryByPage(VersionCon versionCon, Integer offset, Integer limit);

    /**
     * 新增数据
     *
     * @param versionCon 实例对象
     * @return 实例对象
     */
    VersionCon insert(VersionCon versionCon);

    /**
     * 修改数据
     *
     * @param versionCon 实例对象
     * @return 实例对象
     */
    VersionCon update(VersionCon versionCon);
    
    int count(VersionCon versionCon);
    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Integer id);
    
    

}
