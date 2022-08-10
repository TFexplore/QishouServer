package com.zhaishu.qishouserver.service.impl;

import com.zhaishu.qishouserver.Vo.NoticeVo;
import com.zhaishu.qishouserver.entity.Employee;
import com.zhaishu.qishouserver.entity.Notice;
import com.zhaishu.qishouserver.dao.NoticeDao;
import com.zhaishu.qishouserver.service.NoticeService;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;

/**
 * (Notice)表服务实现类
 *
 * @author makejava
 * @since 2022-08-02 14:40:54
 */
@Service("noticeService")
public class NoticeServiceImpl implements NoticeService {
    @Resource
    private NoticeDao noticeDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public Notice queryById(Integer id) {
        return this.noticeDao.queryById(id);
    }
    @Override
    public List<Employee> getEmployeeList(){
        return noticeDao.getEmployeeList();
    }
    /**
     * 分页查询
     *
     * @param notice 筛选条件
     * @return 查询结果
     */
    @Override
    public List<NoticeVo> queryByPage(Notice notice, Integer offset, Integer limit) {
      
        return this.noticeDao.queryAllByLimit(notice, offset,limit);
    }

    /**
     * 新增数据
     *
     * @param notice 实例对象
     * @return 实例对象
     */
    @Override
    public Notice insert(Notice notice) {
        this.noticeDao.insert(notice);
        return notice;
    }

    /**
     * 修改数据
     *
     * @param notice 实例对象
     * @return 实例对象
     */
    @Override
    public Notice update(Notice notice) {
        this.noticeDao.update(notice);
        return this.queryById(notice.getId());
    }
    @Override
    public int count(Notice notice) {
        
        return this.noticeDao.count(notice); 
    }
    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.noticeDao.deleteById(id) > 0;
    }
}
