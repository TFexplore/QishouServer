package com.zhaishu.qishouserver.service.impl;

import com.zhaishu.qishouserver.entity.RejectRecord;
import com.zhaishu.qishouserver.dao.RejectRecordDao;
import com.zhaishu.qishouserver.service.RejectRecordService;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import javax.annotation.Resource;

/**
 * 拒接与超时记录表(RejectRecord)表服务实现类
 *
 * @author makejava
 * @since 2022-04-19 11:08:13
 */
@Service("rejectRecordService")
public class RejectRecordServiceImpl implements RejectRecordService {
    @Resource
    private RejectRecordDao rejectRecordDao;

    /**
     * 通过ID查询单条数据
     *
     * @param goodsOrderId 主键
     * @return 实例对象
     */
    @Override
    public RejectRecord queryById(Integer goodsOrderId) {
        return this.rejectRecordDao.queryById(goodsOrderId);
    }

    /**
     * 分页查询
     *
     * @param rejectRecord 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @Override
    public Page<RejectRecord> queryByPage(RejectRecord rejectRecord, PageRequest pageRequest) {
        long total = this.rejectRecordDao.count(rejectRecord);
        return new PageImpl<>(this.rejectRecordDao.queryAllByLimit(rejectRecord, pageRequest), pageRequest, total);
    }

    /**
     * 新增数据
     *
     * @param rejectRecord 实例对象
     * @return 实例对象
     */
    @Override
    public RejectRecord insert(RejectRecord rejectRecord) {
        this.rejectRecordDao.insert(rejectRecord);
        return rejectRecord;
    }

    /**
     * 修改数据
     *
     * @param rejectRecord 实例对象
     * @return 实例对象
     */
    @Override
    public RejectRecord update(RejectRecord rejectRecord) {
        this.rejectRecordDao.update(rejectRecord);
        return this.queryById(rejectRecord.getGoodsOrderId());
    }

    /**
     * 通过主键删除数据
     *
     * @param goodsOrderId 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer goodsOrderId) {
        return this.rejectRecordDao.deleteById(goodsOrderId) > 0;
    }
}
