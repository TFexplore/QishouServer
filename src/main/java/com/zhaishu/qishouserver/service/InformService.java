package com.zhaishu.qishouserver.service;

import com.zhaishu.qishouserver.entity.Inform;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

/**
 * 通知公告表(Inform)表服务接口
 *
 * @author makejava
 * @since 2022-04-18 19:22:41
 */
public interface InformService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Inform queryById(Integer id);

    /**
     * 分页查询
     *
     * @param inform 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    Page<Inform> queryByPage(Inform inform, PageRequest pageRequest);

    /**
     * 新增数据
     *
     * @param inform 实例对象
     * @return 实例对象
     */
    Inform insert(Inform inform);

    /**
     * 修改数据
     *
     * @param inform 实例对象
     * @return 实例对象
     */
    Inform update(Inform inform);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Integer id);

}
