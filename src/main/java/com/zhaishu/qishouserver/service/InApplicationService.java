package com.zhaishu.qishouserver.service;

import com.zhaishu.qishouserver.entity.InApplication;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

/**
 * 入职申请表(InApplication)表服务接口
 *
 * @author makejava
 * @since 2022-04-18 19:22:40
 */
public interface InApplicationService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    InApplication queryById(Integer id);

    /**
     * 分页查询
     *
     * @param inApplication 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    Page<InApplication> queryByPage(InApplication inApplication, PageRequest pageRequest);

    /**
     * 新增数据
     *
     * @param inApplication 实例对象
     * @return 实例对象
     */
    InApplication insert(InApplication inApplication);

    /**
     * 修改数据
     *
     * @param inApplication 实例对象
     * @return 实例对象
     */
    InApplication update(InApplication inApplication);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Integer id);

}
