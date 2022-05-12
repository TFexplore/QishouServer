package com.zhaishu.qishouserver.dao;

import com.zhaishu.qishouserver.entity.InApplication;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;
import java.util.List;

/**
 * 入职申请表(InApplication)表数据库访问层
 *
 * @author makejava
 * @since 2022-04-18 19:22:40
 */
public interface InApplicationDao {


    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    InApplication queryById(Integer id);



    /**
     * 查询指定行数据
     *
     * @param inApplication 查询条件
     * @param pageable         分页对象
     * @return 对象列表
     */
    List<InApplication> queryAllByLimit(InApplication inApplication, @Param("pageable") Pageable pageable);

    /**
     * 统计总行数
     *
     * @param inApplication 查询条件
     * @return 总行数
     */
    long count(InApplication inApplication);

    /**
     * 新增数据
     *
     * @param inApplication 实例对象
     * @return 影响行数
     */
    int insert(InApplication inApplication);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<InApplication> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<InApplication> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<InApplication> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<InApplication> entities);

    /**
     * 修改数据
     *
     * @param inApplication 实例对象
     * @return 影响行数
     */
    int update(InApplication inApplication);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Integer id);

}

