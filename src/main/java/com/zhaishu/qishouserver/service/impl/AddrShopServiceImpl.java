package com.zhaishu.qishouserver.service.impl;

import com.zhaishu.qishouserver.entity.AddrShop;
import com.zhaishu.qishouserver.dao.AddrShopDao;
import com.zhaishu.qishouserver.service.AddrShopService;
import org.springframework.stereotype.Service;
import java.util.List;
import javax.annotation.Resource;

/**
 * (AddrShop)表服务实现类
 *
 * @author makejava
 * @since 2022-08-10 09:37:53
 */
@Service("addrShopService")
public class AddrShopServiceImpl implements AddrShopService {
    @Resource
    private AddrShopDao addrShopDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public AddrShop queryById(Integer id) {
        return this.addrShopDao.queryById(id);
    }

    /**
     * 分页查询
     *
     * @param addrShop 筛选条件
     * @return 查询结果
     */
    @Override
    public List<AddrShop> queryByPage(AddrShop addrShop,  Integer offset,Integer limit) {
      
        return this.addrShopDao.queryAllByLimit(addrShop, offset,limit);
    }

    /**
     * 新增数据
     *
     * @param addrShop 实例对象
     * @return 实例对象
     */
    @Override
    public AddrShop insert(AddrShop addrShop) {
        this.addrShopDao.insert(addrShop);
        return addrShop;
    }

    /**
     * 修改数据
     *
     * @param addrShop 实例对象
     * @return 实例对象
     */
    @Override
    public AddrShop update(AddrShop addrShop) {
        this.addrShopDao.update(addrShop);
        return this.queryById(addrShop.getAddrNum());
    }
    @Override
    public int count(AddrShop addrShop) {
        
        return this.addrShopDao.count(addrShop); 
    }
    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.addrShopDao.deleteById(id) > 0;
    }
}
