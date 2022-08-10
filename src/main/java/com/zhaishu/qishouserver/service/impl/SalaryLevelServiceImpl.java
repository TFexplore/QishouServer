package com.zhaishu.qishouserver.service.impl;

import com.zhaishu.qishouserver.entity.SalaryLevel;
import com.zhaishu.qishouserver.dao.SalaryLevelDao;
import com.zhaishu.qishouserver.service.SalaryLevelService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 员工薪酬奖罚条件模板(SalaryLevel)表服务实现类
 *
 * @author makejava
 * @since 2022-07-08 15:21:32
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
    @Override
    public SalaryLevel queryByEmId(Integer id){
        return this.salaryLevelDao.queryByEmId(id);
    }
    @Override
    public List<SalaryLevel> getList(SalaryLevel salaryLevel, Integer limit, Integer offset){


        return salaryLevelDao.getList(salaryLevel, limit, offset);
    }
    @Override
    public int count(SalaryLevel salaryLevel){
        return salaryLevelDao.count(salaryLevel);
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
