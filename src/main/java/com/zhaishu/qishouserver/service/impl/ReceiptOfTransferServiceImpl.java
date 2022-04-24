package com.zhaishu.qishouserver.service.impl;

import com.zhaishu.qishouserver.entity.ReceiptOfTransfer;
import com.zhaishu.qishouserver.dao.ReceiptOfTransferDao;
import com.zhaishu.qishouserver.service.ReceiptOfTransferService;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import javax.annotation.Resource;

/**
 * 转账回执单(ReceiptOfTransfer)表服务实现类
 *
 * @author makejava
 * @since 2022-04-18 19:22:41
 */
@Service("receiptOfTransferService")
public class ReceiptOfTransferServiceImpl implements ReceiptOfTransferService {
    @Resource
    private ReceiptOfTransferDao receiptOfTransferDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public ReceiptOfTransfer queryById(Integer id) {
        return this.receiptOfTransferDao.queryById(id);
    }

    /**
     * 分页查询
     *
     * @param receiptOfTransfer 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @Override
    public Page<ReceiptOfTransfer> queryByPage(ReceiptOfTransfer receiptOfTransfer, PageRequest pageRequest) {
        long total = this.receiptOfTransferDao.count(receiptOfTransfer);
        return new PageImpl<>(this.receiptOfTransferDao.queryAllByLimit(receiptOfTransfer, pageRequest), pageRequest, total);
    }

    /**
     * 新增数据
     *
     * @param receiptOfTransfer 实例对象
     * @return 实例对象
     */
    @Override
    public ReceiptOfTransfer insert(ReceiptOfTransfer receiptOfTransfer) {
        this.receiptOfTransferDao.insert(receiptOfTransfer);
        return receiptOfTransfer;
    }

    /**
     * 修改数据
     *
     * @param receiptOfTransfer 实例对象
     * @return 实例对象
     */
    @Override
    public ReceiptOfTransfer update(ReceiptOfTransfer receiptOfTransfer) {
        this.receiptOfTransferDao.update(receiptOfTransfer);
        return this.queryById(receiptOfTransfer.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.receiptOfTransferDao.deleteById(id) > 0;
    }
}
