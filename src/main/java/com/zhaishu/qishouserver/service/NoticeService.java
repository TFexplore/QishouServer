package com.zhaishu.qishouserver.service;

import com.zhaishu.qishouserver.Vo.NoticeVo;
import com.zhaishu.qishouserver.entity.Employee;
import com.zhaishu.qishouserver.entity.Notice;

import java.util.List;

/**
 * (Notice)表服务接口
 *
 * @author makejava
 * @since 2022-08-02 14:40:54
 */
public interface NoticeService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Notice queryById(Integer id);

    List<Employee> getEmployeeList();

    /**
     * 分页查询
     *
     * @param notice 筛选条件
     * @return 查询结果
     */
    List<NoticeVo> queryByPage(Notice notice, Integer offset, Integer limit);

    /**
     * 新增数据
     *
     * @param notice 实例对象
     * @return 实例对象
     */
    Notice insert(Notice notice);

    /**
     * 修改数据
     *
     * @param notice 实例对象
     * @return 实例对象
     */
    Notice update(Notice notice);
    
    int count(Notice notice);
    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Integer id);
    
    

}
