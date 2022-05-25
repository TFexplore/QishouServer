package com.zhaishu.qishouserver.service.impl;

import com.zhaishu.qishouserver.Vo.RiderVo;
import com.zhaishu.qishouserver.entity.Rider;
import com.zhaishu.qishouserver.dao.RiderDao;
import com.zhaishu.qishouserver.service.RiderService;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import javax.annotation.Resource;
import java.util.List;

/**
 * 骑手信息表(Rider)表服务实现类
 *
 * @author makejava
 * @since 2022-04-18 19:22:41
 */
@Service("riderService")
public class RiderServiceImpl implements RiderService {
    @Resource
    private RiderDao riderDao;

    @Override
    public List<RiderVo> getAllRiders(Integer offset, Integer limit, RiderVo riderVo){

        return this.riderDao.getAllRiders(offset,limit,riderVo);
    }
    @Override
    public List<RiderVo> getAllRidersIn(Integer offset, Integer limit, @Param("rider") RiderVo riderVo){
        return this.riderDao.getAllRidersIn(offset,limit,riderVo);
    }
    @Override
    public List<RiderVo> getAllRidersSe(Integer offset, Integer limit, @Param("rider") RiderVo riderVo){
        return this.riderDao.getAllRidersSe(offset,limit,riderVo);
    }
    @Override
    public int countAllRiders(@Param("rider") RiderVo riderVo)  {
        return this.riderDao.countAllRiders(riderVo);
    }
    @Override
    public int countAllRidersIn(@Param("rider") RiderVo riderVo){
        return this.riderDao.countAllRidersIn(riderVo);
    }
    @Override
    public int countAllRidersSe(@Param("rider") RiderVo riderVo){
        return this.riderDao.countAllRidersSe(riderVo);
    }

    @Override
    public Rider queryByEmployeeId(Integer id){

        return this.riderDao.queryByEmployeeId(id);
    }

    @Override
    public Rider queryById(Integer id) {
        return this.riderDao.queryById(id);
    }

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public RiderVo getRiderById(Integer id) {
        return this.riderDao.getRiderById(id);
    }

    /**
     * 分页查询
     *
     * @param rider 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @Override
    public Page<Rider> queryByPage(Rider rider, PageRequest pageRequest) {
        long total = this.riderDao.count(rider);
        return new PageImpl<>(this.riderDao.queryAllByLimit(rider, pageRequest), pageRequest, total);
    }

    /**
     * 新增数据
     *
     * @param rider 实例对象
     * @return 实例对象
     */
    @Override
    public int insert(Rider rider) {

        return this.riderDao.insert(rider);
    }

    /**
     * 修改数据
     *
     * @param rider 实例对象
     * @return 实例对象
     */
    @Override
    public int update(RiderVo rider) {

        return   this.riderDao.update(rider);
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.riderDao.deleteById(id) > 0;
    }
}
