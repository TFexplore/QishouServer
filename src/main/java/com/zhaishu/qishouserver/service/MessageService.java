package com.zhaishu.qishouserver.service;

import com.zhaishu.qishouserver.entity.Message;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.List;

/**
 * (Message)表服务接口
 *
 * @author makejava
 * @since 2022-07-26 17:23:39
 */
public interface MessageService {

    void pushMessage(Integer messageId);

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Message queryById(Integer id);

    /**
     * 分页查询
     *
     * @param message 筛选条件
     * @return 查询结果
     */
    List<Message> queryByPage(Message message, Integer offset, Integer limit);

    /**
     * 新增数据
     *
     * @param message 实例对象
     * @return 实例对象
     */
    Message insert(Message message);

    /**
     * 修改数据
     *
     * @param message 实例对象
     * @return 实例对象
     */
    Message update(Message message);
    
    int count(Message message);
    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Integer id);
    
    

}
