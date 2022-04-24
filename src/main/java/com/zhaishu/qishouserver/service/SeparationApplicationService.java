package com.zhaishu.qishouserver.service;

import com.zhaishu.qishouserver.entity.SeparationApplication;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

/**
 * 离职申请表(SeparationApplication)表服务接口
 *
 * @author makejava
 * @since 2022-04-18 19:22:41
 */
public interface SeparationApplicationService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    SeparationApplication queryById(Integer id);

    /**
     * 分页查询
     *
     * @param separationApplication 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    Page<SeparationApplication> queryByPage(SeparationApplication separationApplication, PageRequest pageRequest);

    /**
     * 新增数据
     *
     * @param separationApplication 实例对象
     * @return 实例对象
     */
    SeparationApplication insert(SeparationApplication separationApplication);

    /**
     * 修改数据
     *
     * @param separationApplication 实例对象
     * @return 实例对象
     */
    SeparationApplication update(SeparationApplication separationApplication);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Integer id);

}
