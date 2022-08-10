package com.zhaishu.qishouserver.service.impl;

import com.zhaishu.qishouserver.dao.SalaryConditionDao;
import com.zhaishu.qishouserver.entity.SalaryCondition;
import com.zhaishu.qishouserver.service.SalaryConditionService;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.PageRequest;

import javax.annotation.Resource;
import java.util.List;

/**
 * (SalaryCondition)表服务实现类
 *
 * @author makejava
 * @since 2022-07-08 15:24:32
 */
@Service("salaryConditionService")
public class SalaryConditionServiceImpl implements SalaryConditionService {
    @Resource
    private SalaryConditionDao salaryConditionDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public SalaryCondition queryById(Integer id) {
        return this.salaryConditionDao.queryById(id);
    }

    /**
     * 分页查询
     *
     * @param salaryCondition 筛选条件
     * @return 查询结果
     */
    @Override
    public List<SalaryCondition> queryByPage(SalaryCondition salaryCondition,Integer limit,Integer offset) {

        return this.salaryConditionDao.queryAllByLimit(salaryCondition, limit,offset);
    }
    @Override
    public int count(SalaryCondition salaryCondition){
        return salaryConditionDao.count(salaryCondition);
    }
    /**
     * 新增数据
     *
     * @param salaryCondition 实例对象
     * @return 实例对象
     */
    @Override
    public SalaryCondition insert(SalaryCondition salaryCondition) {
        this.salaryConditionDao.insert(salaryCondition);
        return salaryCondition;
    }

    /**
     * 修改数据
     *
     * @param salaryCondition 实例对象
     * @return 实例对象
     */
    @Override
    public SalaryCondition update(SalaryCondition salaryCondition) {
        this.salaryConditionDao.update(salaryCondition);
        return this.queryById(salaryCondition.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.salaryConditionDao.deleteById(id) > 0;
    }
}
