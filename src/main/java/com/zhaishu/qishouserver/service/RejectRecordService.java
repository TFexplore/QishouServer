package com.zhaishu.qishouserver.service;

import com.zhaishu.qishouserver.entity.RejectRecord;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

/**
 * 拒接与超时记录表(RejectRecord)表服务接口
 *
 * @author makejava
 * @since 2022-04-19 11:08:13
 */
public interface RejectRecordService {

    /**
     * 通过ID查询单条数据
     *
     * @param goodsOrderId 主键
     * @return 实例对象
     */
    RejectRecord queryById(Integer goodsOrderId);

    /**
     * 分页查询
     *
     * @param rejectRecord 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    Page<RejectRecord> queryByPage(RejectRecord rejectRecord, PageRequest pageRequest);

    /**
     * 新增数据
     *
     * @param rejectRecord 实例对象
     * @return 实例对象
     */
    RejectRecord insert(RejectRecord rejectRecord);

    /**
     * 修改数据
     *
     * @param rejectRecord 实例对象
     * @return 实例对象
     */
    RejectRecord update(RejectRecord rejectRecord);

    /**
     * 通过主键删除数据
     *
     * @param goodsOrderId 主键
     * @return 是否成功
     */
    boolean deleteById(Integer goodsOrderId);

}
