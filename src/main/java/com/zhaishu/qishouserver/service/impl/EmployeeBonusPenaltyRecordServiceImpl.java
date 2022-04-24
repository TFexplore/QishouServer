package com.zhaishu.qishouserver.service.impl;

import com.zhaishu.qishouserver.entity.EmployeeBonusPenaltyRecord;
import com.zhaishu.qishouserver.dao.EmployeeBonusPenaltyRecordDao;
import com.zhaishu.qishouserver.service.EmployeeBonusPenaltyRecordService;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import javax.annotation.Resource;

/**
 * 奖罚记录表(EmployeeBonusPenaltyRecord)表服务实现类
 *
 * @author makejava
 * @since 2022-04-18 19:22:40
 */
@Service("employeeBonusPenaltyRecordService")
public class EmployeeBonusPenaltyRecordServiceImpl implements EmployeeBonusPenaltyRecordService {
    @Resource
    private EmployeeBonusPenaltyRecordDao employeeBonusPenaltyRecordDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public EmployeeBonusPenaltyRecord queryById(Integer id) {
        return this.employeeBonusPenaltyRecordDao.queryById(id);
    }

    /**
     * 分页查询
     *
     * @param employeeBonusPenaltyRecord 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @Override
    public Page<EmployeeBonusPenaltyRecord> queryByPage(EmployeeBonusPenaltyRecord employeeBonusPenaltyRecord, PageRequest pageRequest) {
        long total = this.employeeBonusPenaltyRecordDao.count(employeeBonusPenaltyRecord);
        return new PageImpl<>(this.employeeBonusPenaltyRecordDao.queryAllByLimit(employeeBonusPenaltyRecord, pageRequest), pageRequest, total);
    }

    /**
     * 新增数据
     *
     * @param employeeBonusPenaltyRecord 实例对象
     * @return 实例对象
     */
    @Override
    public EmployeeBonusPenaltyRecord insert(EmployeeBonusPenaltyRecord employeeBonusPenaltyRecord) {
        this.employeeBonusPenaltyRecordDao.insert(employeeBonusPenaltyRecord);
        return employeeBonusPenaltyRecord;
    }

    /**
     * 修改数据
     *
     * @param employeeBonusPenaltyRecord 实例对象
     * @return 实例对象
     */
    @Override
    public EmployeeBonusPenaltyRecord update(EmployeeBonusPenaltyRecord employeeBonusPenaltyRecord) {
        this.employeeBonusPenaltyRecordDao.update(employeeBonusPenaltyRecord);
        return this.queryById(employeeBonusPenaltyRecord.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.employeeBonusPenaltyRecordDao.deleteById(id) > 0;
    }
}
