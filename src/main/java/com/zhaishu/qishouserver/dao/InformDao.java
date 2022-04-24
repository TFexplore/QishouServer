package com.zhaishu.qishouserver.dao;

import com.zhaishu.qishouserver.entity.Inform;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;
import java.util.List;

/**
 * 通知公告表(Inform)表数据库访问层
 *
 * @author makejava
 * @since 2022-04-18 19:22:41
 */
public interface InformDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Inform queryById(Integer id);

    /**
     * 查询指定行数据
     *
     * @param inform 查询条件
     * @param pageable         分页对象
     * @return 对象列表
     */
    List<Inform> queryAllByLimit(Inform inform, @Param("pageable") Pageable pageable);

    /**
     * 统计总行数
     *
     * @param inform 查询条件
     * @return 总行数
     */
    long count(Inform inform);

    /**
     * 新增数据
     *
     * @param inform 实例对象
     * @return 影响行数
     */
    int insert(Inform inform);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<Inform> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<Inform> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<Inform> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<Inform> entities);

    /**
     * 修改数据
     *
     * @param inform 实例对象
     * @return 影响行数
     */
    int update(Inform inform);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Integer id);

}

