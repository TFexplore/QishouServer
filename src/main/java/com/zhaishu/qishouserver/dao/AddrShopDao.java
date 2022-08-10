package com.zhaishu.qishouserver.dao;

import com.zhaishu.qishouserver.entity.AddrShop;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * (AddrShop)表数据库访问层
 *
 * @author makejava
 * @since 2022-08-10 09:37:52
 */
public interface AddrShopDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    AddrShop queryById(Integer id);

    /**
     * 查询指定行数据
     *
     * @param addrShop 查询条件
     * @return 对象列表
     */
    List<AddrShop> queryAllByLimit(@Param("param") AddrShop addrShop,  Integer offset,Integer limit);

    /**
     * 统计总行数
     *
     * @param addrShop 查询条件
     * @return 总行数
     */
    int count(AddrShop addrShop);

    /**
     * 新增数据
     *
     * @param addrShop 实例对象
     * @return 影响行数
     */
    int insert(AddrShop addrShop);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<AddrShop> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<AddrShop> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<AddrShop> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<AddrShop> entities);

    /**
     * 修改数据
     *
     * @param addrShop 实例对象
     * @return 影响行数
     */
    int update(AddrShop addrShop);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Integer id);

}

