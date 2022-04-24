package com.zhaishu.qishouserver.service;

import com.zhaishu.qishouserver.entity.WorkTime;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

/**
 * 工作时段表(WorkTime)表服务接口
 *
 * @author makejava
 * @since 2022-04-18 19:22:41
 */
public interface WorkTimeService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    WorkTime queryById(Integer id);

    /**
     * 分页查询
     *
     * @param workTime 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    Page<WorkTime> queryByPage(WorkTime workTime, PageRequest pageRequest);

    /**
     * 新增数据
     *
     * @param workTime 实例对象
     * @return 实例对象
     */
    WorkTime insert(WorkTime workTime);

    /**
     * 修改数据
     *
     * @param workTime 实例对象
     * @return 实例对象
     */
    WorkTime update(WorkTime workTime);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Integer id);

}
