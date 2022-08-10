package com.zhaishu.qishouserver.service;

import com.zhaishu.qishouserver.entity.TOrderRecord;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.List;

/**
 * (TOrderRecord)表服务接口
 *
 * @author makejava
 * @since 2022-07-18 11:54:53
 */
public interface TOrderRecordService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    TOrderRecord queryById(Long id);

    /**
     * 分页查询
     *
     * @param tOrderRecord 筛选条件

     * @return 查询结果
     */
    List<TOrderRecord> queryByPage(TOrderRecord tOrderRecord, Integer offset, Integer limit);

    /**
     * 新增数据
     *
     * @param tOrderRecord 实例对象
     * @return 实例对象
     */
    TOrderRecord insert(TOrderRecord tOrderRecord);

    /**
     * 修改数据
     *
     * @param tOrderRecord 实例对象
     * @return 实例对象
     */
    TOrderRecord update(TOrderRecord tOrderRecord);
    
    int count(TOrderRecord tOrderRecord);
    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Long id);
    
    

}
