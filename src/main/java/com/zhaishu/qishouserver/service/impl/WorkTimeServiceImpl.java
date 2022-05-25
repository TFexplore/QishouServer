package com.zhaishu.qishouserver.service.impl;

import com.zhaishu.qishouserver.entity.WorkTime;
import com.zhaishu.qishouserver.dao.WorkTimeDao;
import com.zhaishu.qishouserver.service.WorkTimeService;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import javax.annotation.Resource;
import java.util.List;

/**
 * 工作时段表(WorkTime)表服务实现类
 *
 * @author makejava
 * @since 2022-04-18 19:22:42
 */
@Service("workTimeService")
public class WorkTimeServiceImpl implements WorkTimeService {
    @Resource
    private WorkTimeDao workTimeDao;

    @Override
    public List<WorkTime> queryByMap(WorkTime workTime){
        return this.workTimeDao.queryByMap(workTime);
    }
    @Override
    public List<WorkTime> getTemplates(){
        WorkTime workTime = new WorkTime();
        workTime.setDateId(20190808);//模板开始日期20000101
        return this.workTimeDao.getTemplates(workTime);
    }
    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public WorkTime queryById(Integer id) {
        return this.workTimeDao.queryById(id);
    }

    /**
     * 分页查询
     *
     * @param workTime 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @Override
    public Page<WorkTime> queryByPage(WorkTime workTime, PageRequest pageRequest) {
        long total = this.workTimeDao.count(workTime);
        return new PageImpl<>(this.workTimeDao.queryAllByLimit(workTime, pageRequest), pageRequest, total);
    }

    /**
     * 新增数据
     *
     * @param workTime 实例对象
     * @return 实例对象
     */
    @Override
    public WorkTime insert(WorkTime workTime) {
        Integer id = this.workTimeDao.getNextId(workTime.getDateId());
        if (id==null){
            id=workTime.getDateId()*100;
        }
        workTime.setWorktimeId(id+1);
        this.workTimeDao.insert(workTime);
        return workTime;
    }

    /**
     * 修改数据
     *
     * @param workTime 实例对象
     * @return 实例对象
     */
    @Override
    public WorkTime update(WorkTime workTime) {
        this.workTimeDao.update(workTime);
        return this.queryById(workTime.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.workTimeDao.deleteById(id) > 0;
    }
}
