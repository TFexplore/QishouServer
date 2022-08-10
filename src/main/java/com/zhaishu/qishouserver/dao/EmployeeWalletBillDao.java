package com.zhaishu.qishouserver.dao;

import com.zhaishu.qishouserver.entity.EmployeeWalletBill;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;
import java.util.List;

/**
 * (EmployeeWalletBill)表数据库访问层
 *
 * @author makejava
 * @since 2022-08-03 18:11:34
 */
public interface EmployeeWalletBillDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    EmployeeWalletBill queryById(Long id);

    /**
     * 查询指定行数据
     *
     * @param employeeWalletBill 查询条件
     * @return 对象列表
     */
    List<EmployeeWalletBill> queryAllByLimit(@Param("param") EmployeeWalletBill employeeWalletBill,  Integer offset,Integer limit);

    /**
     * 统计总行数
     *
     * @param employeeWalletBill 查询条件
     * @return 总行数
     */
    int count(EmployeeWalletBill employeeWalletBill);

    /**
     * 新增数据
     *
     * @param employeeWalletBill 实例对象
     * @return 影响行数
     */
    int insert(EmployeeWalletBill employeeWalletBill);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<EmployeeWalletBill> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<EmployeeWalletBill> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<EmployeeWalletBill> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<EmployeeWalletBill> entities);

    /**
     * 修改数据
     *
     * @param employeeWalletBill 实例对象
     * @return 影响行数
     */
    int update(EmployeeWalletBill employeeWalletBill);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Long id);

}

