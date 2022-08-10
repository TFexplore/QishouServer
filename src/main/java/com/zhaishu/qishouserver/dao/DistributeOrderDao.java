package com.zhaishu.qishouserver.dao;

import com.zhaishu.qishouserver.Vo.OrderVo;
import com.zhaishu.qishouserver.Vo.ShipRiderVo;
import com.zhaishu.qishouserver.entity.DistributeOrder;
import com.zhaishu.qishouserver.entity.TGoodsSs;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;
import java.util.List;

/**
 * 骑手配送信息表(DistributeOrder)表数据库访问层
 *
 * @author makejava
 * @since 2022-04-18 19:22:40
 */
public interface DistributeOrderDao {

    List<TGoodsSs> getGoodsList(Integer orderId);

    List<OrderVo> getOrdersAll(@Param("order") OrderVo orderVo,Integer limit,Integer offset);
    int countOrders(OrderVo orderVo);
    int countOrdersOnDeal(OrderVo orderVo);
    int updateOrders(OrderVo orderVo);

    List<DistributeOrder> queryAllByMap(DistributeOrder distributeOrder);
    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    DistributeOrder queryById(Integer id);

    /**
     * 查询指定行数据
     *
     * @param distributeOrder 查询条件
     * @param pageable         分页对象
     * @return 对象列表
     */
    List<DistributeOrder> queryAllByLimit(DistributeOrder distributeOrder, @Param("pageable") Pageable pageable);

    /**
     * 统计总行数
     *
     * @param distributeOrder 查询条件
     * @return 总行数
     */
    long count(DistributeOrder distributeOrder);

    /**
     * 新增数据
     *
     * @param distributeOrder 实例对象
     * @return 影响行数
     */
    int insert(DistributeOrder distributeOrder);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<DistributeOrder> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<DistributeOrder> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<DistributeOrder> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<DistributeOrder> entities);

    /**
     * 修改数据
     *
     * @param distributeOrder 实例对象
     * @return 影响行数
     */
    int update(DistributeOrder distributeOrder);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Integer id);

}

