package com.zhaishu.qishouserver.service.impl;

import com.zhaishu.qishouserver.entity.Message;
import com.zhaishu.qishouserver.dao.MessageDao;
import com.zhaishu.qishouserver.http.OkHttpCli;
import com.zhaishu.qishouserver.service.MessageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * (Message)表服务实现类
 *
 * @author makejava
 * @since 2022-07-26 17:23:39
 */
@Service("messageService")
@Slf4j
public class MessageServiceImpl implements MessageService {
    @Resource
    private MessageDao messageDao;
    @Resource
    OkHttpCli httpCli;


    @Override
    public void pushMessage(Integer messageId){
        log.info("#######生成消息：" +messageId);
        if (messageDao.queryById(messageId)!=null){
            String url = "https://47.108.14.168:443/message/receivedMessage";
            Map<String,String> map=new HashMap<>();
            map.put("messageId", String.valueOf(messageId));
            log.info("#######消息通知：" +messageId);
            httpCli.doEnPost(url,map);

        }
        log.info("#######消息通知成功：" +messageId);

    }

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public Message queryById(Integer id) {
        return this.messageDao.queryById(id);
    }

    /**
     * 分页查询
     *
     * @param
     * @return 查询结果
     */
    @Override
    public List<Message> queryByPage(Message message, Integer offset, Integer limit) {
      
        return this.messageDao.queryAllByLimit(message, offset,limit);
    }

    /**
     * 新增数据
     *
     * @param message 实例对象
     * @return 实例对象
     */
    @Override
    public Message insert(Message message) {
        this.messageDao.insert(message);

        return message;
    }

    /**
     * 修改数据
     *
     * @param message 实例对象
     * @return 实例对象
     */
    @Override
    public Message update(Message message) {
        this.messageDao.update(message);
        return this.queryById(message.getId());
    }
    @Override
    public int count(Message message) {
        
        return this.messageDao.count(message); 
    }
    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.messageDao.deleteById(id) > 0;
    }
}
