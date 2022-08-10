package com.zhaishu.qishouserver.service.impl;

import com.zhaishu.qishouserver.Vo.ApplyDrawVo;
import com.zhaishu.qishouserver.entity.ApplyWithdraw;
import com.zhaishu.qishouserver.dao.ApplyWithdrawDao;
import com.zhaishu.qishouserver.service.ApplyWithdrawService;
import org.springframework.stereotype.Service;
import java.util.List;
import javax.annotation.Resource;

/**
 * (ApplyWithdraw)表服务实现类
 *
 * @author makejava
 * @since 2022-08-06 11:21:08
 */
@Service("applyWithdrawService")
public class ApplyWithdrawServiceImpl implements ApplyWithdrawService {
    @Resource
    private ApplyWithdrawDao applyWithdrawDao;

    @Override
    public Double getAmountByDate(Integer flag, Long startTime, Long endTime){
        return applyWithdrawDao.getAmountByDate(flag, startTime, endTime);
    }
    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public ApplyWithdraw queryById(String id) {
        return this.applyWithdrawDao.queryById(id);
    }

    /**
     * 分页查询
     *
     * @param applyWithdraw 筛选条件
     * @return 查询结果
     */
    @Override
    public List<ApplyDrawVo> queryByPage(ApplyDrawVo applyWithdraw, Integer offset, Integer limit) {
      
        return this.applyWithdrawDao.queryAllByLimit(applyWithdraw, offset,limit);
    }

    /**
     * 新增数据
     *
     * @param applyWithdraw 实例对象
     * @return 实例对象
     */
    @Override
    public ApplyWithdraw insert(ApplyWithdraw applyWithdraw) {
        this.applyWithdrawDao.insert(applyWithdraw);
        return applyWithdraw;
    }

    /**
     * 修改数据
     *
     * @param applyWithdraw 实例对象
     * @return 实例对象
     */
    @Override
    public ApplyWithdraw update(ApplyWithdraw applyWithdraw) {
        this.applyWithdrawDao.update(applyWithdraw);
        return this.queryById(applyWithdraw.getId());
    }
    @Override
    public int count(ApplyWithdraw applyWithdraw) {
        
        return this.applyWithdrawDao.count(applyWithdraw); 
    }
    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.applyWithdrawDao.deleteById(id) > 0;
    }
}
