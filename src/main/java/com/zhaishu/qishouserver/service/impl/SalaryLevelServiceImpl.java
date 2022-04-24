package com.zhaishu.qishouserver.service.impl;

import com.zhaishu.qishouserver.entity.SalaryLevel;
import com.zhaishu.qishouserver.dao.SalaryLevelDao;
import com.zhaishu.qishouserver.service.SalaryLevelService;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import javax.annotation.Resource;

/**
 * 员工薪酬等级表(SalaryLevel)表服务实现类
 *
 * @author makejava
 * @since 2022-04-18 19:22:41
 */
@Service("salaryLevelService")
public class SalaryLevelServiceImpl implements SalaryLevelService {
    @Resource
    private SalaryLevelDao salaryLevelDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public SalaryLevel queryById(Integer id) {
        return this.salaryLevelDao.queryById(id);
    }

    /**
     * 分页查询
     *
     * @param salaryLevel 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @Override
    public Page<SalaryLevel> queryByPage(SalaryLevel salaryLevel, PageRequest pageRequest) {
        long total = this.salaryLevelDao.count(salaryLevel);
        return new PageImpl<>(this.salaryLevelDao.queryAllByLimit(salaryLevel, pageRequest), pageRequest, total);
    }

    /**
     * 新增数据
     *
     * @param salaryLevel 实例对象
     * @return 实例对象
     */
    @Override
    public SalaryLevel insert(SalaryLevel salaryLevel) {
        this.salaryLevelDao.insert(salaryLevel);
        return salaryLevel;
    }

    /**
     * 修改数据
     *
     * @param salaryLevel 实例对象
     * @return 实例对象
     */
    @Override
    public SalaryLevel update(SalaryLevel salaryLevel) {
        this.salaryLevelDao.update(salaryLevel);
        return this.queryById(salaryLevel.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.salaryLevelDao.deleteById(id) > 0;
    }
}
