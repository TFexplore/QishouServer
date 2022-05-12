package com.zhaishu.qishouserver.service;

import com.zhaishu.qishouserver.entity.Employee;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.List;

/**
 * 员工信息表(Employee)表服务接口
 *
 * @author makejava
 * @since 2022-04-18 19:22:40
 */
public interface EmployeeService {

    int updateTypeByTel(Integer type,String tel);

    Integer getNextEmployeeId();

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Employee queryById(Integer id);

    Employee queryByTel(String tel);

    Employee queryByType(int type);

    Employee queryByName(String name);

    /**
     * 分页查询
     *
     * @param
     * @param
     * @return 查询结果
     */
    List<Employee> queryAdminByPage(int offset, int limit);
    List<Employee> queryAdminByStatus(int status,int offset, int limit);

    int countAdmin();

    int countAdminByStatus(Integer status);

    int countAdminbyType(Integer type);

    /**
     * 新增数据
     *
     * @param employee 实例对象
     * @return 实例对象
     */
    Employee insert(Employee employee);

    List<Employee> queryAdminByType(int type, int offset, int limit);

    List<Employee> queryByMap(Employee employee, int offset, int limit);

    int countMap(@Param("employee") Employee employee);

    /**
     * 修改数据
     *
     * @param employee 实例对象
     * @return 实例对象
     */
    Employee update(Employee employee);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Integer id);

}
