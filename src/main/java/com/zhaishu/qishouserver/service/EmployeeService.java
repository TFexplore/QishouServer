package com.zhaishu.qishouserver.service;

import com.zhaishu.qishouserver.entity.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

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

    /**
     * 分页查询
     *
     * @param employee 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    Page<Employee> queryByPage(Employee employee, PageRequest pageRequest);

    /**
     * 新增数据
     *
     * @param employee 实例对象
     * @return 实例对象
     */
    Employee insert(Employee employee);

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
