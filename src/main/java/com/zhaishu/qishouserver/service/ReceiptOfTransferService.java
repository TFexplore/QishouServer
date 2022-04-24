package com.zhaishu.qishouserver.service;

import com.zhaishu.qishouserver.entity.ReceiptOfTransfer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

/**
 * 转账回执单(ReceiptOfTransfer)表服务接口
 *
 * @author makejava
 * @since 2022-04-18 19:22:41
 */
public interface ReceiptOfTransferService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    ReceiptOfTransfer queryById(Integer id);

    /**
     * 分页查询
     *
     * @param receiptOfTransfer 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    Page<ReceiptOfTransfer> queryByPage(ReceiptOfTransfer receiptOfTransfer, PageRequest pageRequest);

    /**
     * 新增数据
     *
     * @param receiptOfTransfer 实例对象
     * @return 实例对象
     */
    ReceiptOfTransfer insert(ReceiptOfTransfer receiptOfTransfer);

    /**
     * 修改数据
     *
     * @param receiptOfTransfer 实例对象
     * @return 实例对象
     */
    ReceiptOfTransfer update(ReceiptOfTransfer receiptOfTransfer);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Integer id);

}
