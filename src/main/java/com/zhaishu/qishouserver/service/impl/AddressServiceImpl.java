package com.zhaishu.qishouserver.service.impl;

import com.zhaishu.qishouserver.entity.Address;
import com.zhaishu.qishouserver.dao.AddressDao;
import com.zhaishu.qishouserver.service.AddressService;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import javax.annotation.Resource;

/**
 * (Address)表服务实现类
 *
 * @author makejava
 * @since 2022-04-28 21:42:19
 */
@Service("addressService")
public class AddressServiceImpl implements AddressService {
    @Resource
    private AddressDao addressDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public Address queryById(Integer id) {
        return this.addressDao.queryById(id);
    }

    /**
     * 分页查询
     *
     * @param address 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @Override
    public Page<Address> queryByPage(Address address, PageRequest pageRequest) {
        long total = this.addressDao.count(address);
        return new PageImpl<>(this.addressDao.queryAllByLimit(address, pageRequest), pageRequest, total);
    }

    /**
     * 新增数据
     *
     * @param address 实例对象
     * @return 实例对象
     */
    @Override
    public Address insert(Address address) {
        this.addressDao.insert(address);
        return address;
    }

    /**
     * 修改数据
     *
     * @param address 实例对象
     * @return 实例对象
     */
    @Override
    public Address update(Address address) {
        this.addressDao.update(address);
        return this.queryById(address.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.addressDao.deleteById(id) > 0;
    }
}
