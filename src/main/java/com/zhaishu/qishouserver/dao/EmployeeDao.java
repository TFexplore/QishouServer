package com.zhaishu.qishouserver.dao;

import com.zhaishu.qishouserver.entity.Employee;
import org.apache.ibatis.annotations.Param;
import org.springframework.dao.DataAccessException;
import org.springframework.data.domain.Pageable;
import java.util.List;

/**
 * 员工信息表(Employee)表数据库访问层
 *
 * @author makejava
 * @since 2022-04-18 19:22:40
 */
public interface EmployeeDao {

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
     * 查询指定行数据
     *
     * @param
     * @return 对象列表
     */
    List<Employee> queryByMap(int offset,int limit,@Param("employee") Employee employee);
    int countMap(@Param("employee") Employee employee);
    List<Employee> queryAdminByLimit(int offset, int limit);

    List<Employee> queryAdminByStatus(int status,int offset, int limit);

    List<Employee> queryAdminByType(int type,int offset, int limit);
    /**
     * 统计总行数
     *
     * @return 总行数
     */
    int count();
    /**
     * 统计管理员总行数
     *
     * @return 总行数
     */
    int countAdmin();

    int countAdminByStatus(Integer status);

    int countAdminbyType(Integer type);


    /**
     * 新增数据
     *
     * @param employee 实例对象
     * @return 影响行数
     */
    int insert(Employee employee) throws DataAccessException;

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<Employee> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<Employee> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<Employee> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<Employee> entities);

    /**
     * 修改数据
     *
     * @param employee 实例对象
     * @return 影响行数
     */
    int update(Employee employee);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Integer id);

}

