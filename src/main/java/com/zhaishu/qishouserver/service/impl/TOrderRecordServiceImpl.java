package com.zhaishu.qishouserver.service.impl;

import com.zhaishu.qishouserver.entity.TOrderRecord;
import com.zhaishu.qishouserver.dao.TOrderRecordDao;
import com.zhaishu.qishouserver.service.TOrderRecordService;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import javax.annotation.Resource;
import java.util.List;

/**
 * (TOrderRecord)表服务实现类
 *
 * @author makejava
 * @since 2022-07-18 11:54:53
 */
@Service("tOrderRecordService")
public class TOrderRecordServiceImpl implements TOrderRecordService {
    @Resource
    private TOrderRecordDao tOrderRecordDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public TOrderRecord queryById(Long id) {
        return this.tOrderRecordDao.queryById(id);
    }

    /**
     * 分页查询
     *
     * @param tOrderRecord 筛选条件
     * @return 查询结果
     */
    @Override
    public List<TOrderRecord> queryByPage(TOrderRecord tOrderRecord, Integer offset, Integer limit) {
      
        return this.tOrderRecordDao.queryAllByLimit(tOrderRecord, offset,limit);
    }

    /**
     * 新增数据
     *
     * @param tOrderRecord 实例对象
     * @return 实例对象
     */
    @Override
    public TOrderRecord insert(TOrderRecord tOrderRecord) {
        this.tOrderRecordDao.insert(tOrderRecord);
        return tOrderRecord;
    }

    /**
     * 修改数据
     *
     * @param tOrderRecord 实例对象
     * @return 实例对象
     */
    @Override
    public TOrderRecord update(TOrderRecord tOrderRecord) {
        this.tOrderRecordDao.update(tOrderRecord);
        return this.queryById(tOrderRecord.getId());
    }
    @Override
    public int count(TOrderRecord tOrderRecord) {
        
        return this.tOrderRecordDao.count(tOrderRecord); 
    }
    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Long id) {
        return this.tOrderRecordDao.deleteById(id) > 0;
    }
}
