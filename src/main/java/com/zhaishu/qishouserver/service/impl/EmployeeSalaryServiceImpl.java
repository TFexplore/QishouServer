package com.zhaishu.qishouserver.service.impl;

import com.zhaishu.qishouserver.Vo.RiderSalaryVo;
import com.zhaishu.qishouserver.dao.EmployeeSalaryDao;
import com.zhaishu.qishouserver.entity.EmployeeSalary;
import com.zhaishu.qishouserver.service.EmployeeSalaryService;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import javax.annotation.Resource;
import java.util.List;

/**
 * 员工薪资表(EmployeeSalary)表服务实现类
 *
 * @author makejava
 * @since 2022-07-11 15:58:00
 */
@Service("employeeSalaryService")
public class EmployeeSalaryServiceImpl implements EmployeeSalaryService {
    @Resource
    private EmployeeSalaryDao employeeSalaryDao;

    @Override
    public EmployeeSalary queryByMonth(Integer monthId, Integer employeeId){
        return employeeSalaryDao.queryByMonth(monthId, employeeId);
    }


    @Override
    public List<RiderSalaryVo> getRiderSalaryList(RiderSalaryVo salaryVo, Integer limit, Integer offset){

        return this.employeeSalaryDao.getRiderSalaryList(salaryVo, limit, offset);
    }
    @Override
    public int countList(RiderSalaryVo salaryVo){

        return employeeSalaryDao.countList(salaryVo);
    }
    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public EmployeeSalary queryById(Integer id) {
        return this.employeeSalaryDao.queryById(id);
    }

    /**
     * 分页查询
     *
     * @param employeeSalary 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @Override
    public Page<EmployeeSalary> queryByPage(EmployeeSalary employeeSalary, PageRequest pageRequest) {
        long total = this.employeeSalaryDao.count(employeeSalary);
        return new PageImpl<>(this.employeeSalaryDao.queryAllByLimit(employeeSalary, pageRequest), pageRequest, total);
    }

    /**
     * 新增数据
     *
     * @param employeeSalary 实例对象
     * @return 实例对象
     */
    @Override
    public EmployeeSalary insert(EmployeeSalary employeeSalary) {
        this.employeeSalaryDao.insert(employeeSalary);
        return employeeSalary;
    }

    /**
     * 修改数据
     *
     * @param employeeSalary 实例对象
     * @return 实例对象
     */
    @Override
    public EmployeeSalary update(EmployeeSalary employeeSalary) {
        this.employeeSalaryDao.update(employeeSalary);
        return this.queryById(employeeSalary.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.employeeSalaryDao.deleteById(id) > 0;
    }
}
