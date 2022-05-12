package com.zhaishu.qishouserver.service;

import com.zhaishu.qishouserver.Vo.RiderVo;
import com.zhaishu.qishouserver.entity.InApplication;
import com.zhaishu.qishouserver.entity.Rider;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.List;

/**
 * 骑手信息表(Rider)表服务接口
 *
 * @author makejava
 * @since 2022-04-18 19:22:41
 */
public interface RiderService {

    List<RiderVo> getAllRiders(Integer offset, Integer limit, RiderVo riderVo);

    List<RiderVo> getAllRidersIn(Integer offset, Integer limit, @Param("rider") RiderVo riderVo);

    List<RiderVo> getAllRidersSe(Integer offset, Integer limit, @Param("rider") RiderVo riderVo);

    int countAllRiders(@Param("rider") RiderVo riderVo);

    int countAllRidersIn(@Param("rider") RiderVo riderVo);

    int countAllRidersSe(@Param("rider") RiderVo riderVo);

    Rider queryByEmployeeId(Integer id);

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Rider queryById(Integer id);

    RiderVo getRiderById(Integer id);

    /**
     * 分页查询
     *
     * @param rider 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    Page<Rider> queryByPage(Rider rider, PageRequest pageRequest);

    /**
     * 新增数据
     *
     * @param rider 实例对象
     * @return 实例对象
     */
    int insert(Rider rider);

    /**
     * 修改数据
     *
     * @param rider 实例对象
     * @return 实例对象
     */
    int update(RiderVo rider);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Integer id);

}
