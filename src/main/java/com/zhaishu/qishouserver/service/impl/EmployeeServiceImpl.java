package com.zhaishu.qishouserver.service.impl;

import com.zhaishu.qishouserver.entity.Employee;
import com.zhaishu.qishouserver.dao.EmployeeDao;
import com.zhaishu.qishouserver.service.EmployeeService;
import org.apache.ibatis.annotations.Param;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

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


    @Override
    public int countAdmin(){

        return this.employeeDao.countAdmin();
    }
    @Override
    public int countAdminByStatus(Integer status){
        return employeeDao.countAdminByStatus(status);
    }
    @Override
    public int countAdminbyType(Integer type){
        return employeeDao.countAdminbyType(type);
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
        employee.setIsDelete(0);
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
    @Override
    public Employee queryById(Integer id) {
        return this.employeeDao.queryById(id);
    }

    @Override
    public Employee queryByType(int type){
        return this.employeeDao.queryByType(type);
    }
    @Override
    public Employee queryByName(String name){
        return this.employeeDao.queryByName(name);
    }

    /**
     * 分页查询
     *
     * @param
     * @param
     * @return 查询结果
     */
    @Override
    public List<Employee> queryAdminByPage(int offset, int limit) {
        return employeeDao.queryAdminByLimit(offset,limit);
    }
    @Override
   public List<Employee> queryAdminByStatus(int status,int offset, int limit){

        return employeeDao.queryAdminByStatus(status,offset,limit);
   }
   @Override
   public List<Employee> queryAdminByType(int type, int offset, int limit){

        return employeeDao.queryAdminByType(type,offset,limit);
    }
   @Override
   public List<Employee> queryByMap(Employee employee, int offset, int limit){

        return this.employeeDao.queryByMap(offset,limit,employee);
    }
    @Override
    public int countMap(@Param("employee") Employee employee){
        return this.employeeDao.countMap(employee);
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
