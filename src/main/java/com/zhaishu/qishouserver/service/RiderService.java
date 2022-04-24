package com.zhaishu.qishouserver.service;

import com.zhaishu.qishouserver.entity.Rider;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

/**
 * 骑手信息表(Rider)表服务接口
 *
 * @author makejava
 * @since 2022-04-18 19:22:41
 */
public interface RiderService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Rider queryById(Integer id);

    /**
     * 分页查询
     *
     * @param rider 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    Page<Rider> queryByPage(Rider rider, PageRequest pageRequest);

    /**
     * 新增数据
     *
     * @param rider 实例对象
     * @return 实例对象
     */
    Rider insert(Rider rider);

    /**
     * 修改数据
     *
     * @param rider 实例对象
     * @return 实例对象
     */
    Rider update(Rider rider);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Integer id);

}
