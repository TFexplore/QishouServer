package com.zhaishu.qishouserver.service.impl;

import com.zhaishu.qishouserver.entity.Employee;
import com.zhaishu.qishouserver.dao.EmployeeDao;
import com.zhaishu.qishouserver.service.EmployeeService;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import javax.annotation.Resource;
import java.util.zip.DataFormatException;

/**
 * 员工信息表(Employee)表服务实现类
 *
 * @author makejava
 * @since 2022-04-18 19:22:40
 */
@Service("employeeService")
public class EmployeeServiceImpl implements EmployeeService {
    @Resource
    private EmployeeDao employeeDao;

    public int updateTypeByTel(Integer type,String tel){
        return this.employeeDao.updateTypeByTel(type,tel);
    }

    /**
     * 新增数据
     *
     * @param employee 实例对象
     * @return 实例对象
     */
    @Override
    public synchronized Employee insert(Employee employee) throws DataAccessException {
        int employeeId = this.getNextEmployeeId();//获取记录数
        employee.setEmployeeId(employeeId);
        this.employeeDao.insert(employee);
        return employee;
    }

    @Override
    public Integer getNextEmployeeId(){
        if (this.employeeDao.getNextEmployeeId() == null){
            return 1;
        }
        return this.employeeDao.getNextEmployeeId()+1;
    }
    @Override
    public Employee queryByTel(String tel) {

        return this.employeeDao.queryByTel(tel);
    }

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */

    @Override
    public Employee queryById(Integer id) {
        return this.employeeDao.queryById(id);
    }

    /**
     * 分页查询
     *
     * @param employee 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @Override
    public Page<Employee> queryByPage(Employee employee, PageRequest pageRequest) {
        long total = this.employeeDao.count();
        return new PageImpl<>(this.employeeDao.queryAllByLimit(employee, pageRequest), pageRequest, total);
    }



    /**
     * 修改数据
     *
     * @param employee 实例对象
     * @return 实例对象
     */
    @Override
    public Employee update(Employee employee) {
        this.employeeDao.update(employee);
        return this.queryById(employee.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.employeeDao.deleteById(id) > 0;
    }
}
