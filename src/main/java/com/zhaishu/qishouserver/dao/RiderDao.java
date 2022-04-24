package com.zhaishu.qishouserver.dao;

import com.zhaishu.qishouserver.entity.Rider;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;
import java.util.List;

/**
 * 骑手信息表(Rider)表数据库访问层
 *
 * @author makejava
 * @since 2022-04-18 19:22:41
 */
public interface RiderDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Rider queryById(Integer id);

    /**
     * 查询指定行数据
     *
     * @param rider 查询条件
     * @param pageable         分页对象
     * @return 对象列表
     */
    List<Rider> queryAllByLimit(Rider rider, @Param("pageable") Pageable pageable);

    /**
     * 统计总行数
     *
     * @param rider 查询条件
     * @return 总行数
     */
    long count(Rider rider);

    /**
     * 新增数据
     *
     * @param rider 实例对象
     * @return 影响行数
     */
    int insert(Rider rider);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<Rider> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<Rider> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<Rider> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<Rider> entities);

    /**
     * 修改数据
     *
     * @param rider 实例对象
     * @return 影响行数
     */
    int update(Rider rider);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Integer id);

}

