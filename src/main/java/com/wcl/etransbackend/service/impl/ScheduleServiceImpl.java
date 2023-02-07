package com.wcl.etransbackend.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wcl.etransbackend.domain.Schedule;
import com.wcl.etransbackend.mapper.ScheduleMapper;
import com.wcl.etransbackend.service.ScheduleService;
import org.springframework.stereotype.Service;

import java.util.List;
import javax.annotation.Resource;

/**
 * (Schedule)表服务实现类
 *
 * @author crush
 * @since 2023-01-23 20:40:46
 */
@Service("scheduleService")
public class ScheduleServiceImpl implements ScheduleService {
    @Resource
    private ScheduleMapper scheduleMapper;

    /**
     * 查询所有数据
     *
     * @return 实例对象集合
     */
    @Override
    public List<Schedule> queryAll() {
        return this.scheduleMapper.queryAll();
    }

    // 分页查询
    public PageInfo<Schedule> queryAllByPage(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<Schedule> schedule = scheduleMapper.queryAllByPage();
        PageInfo<Schedule> pageInfo = new PageInfo<>(schedule);
        return pageInfo;
    }

    /**
     * 通过ID查询单条数据
     *
     * @param scheduledId 主键
     * @return 实例对象
     */
    @Override
    public Schedule queryById(Integer scheduledId) {
        return this.scheduleMapper.queryById(scheduledId);
    }

    @Override
    public List<Schedule> queryScheduleByVehicle(String scheduledBus) {
        return this.scheduleMapper.queryScheduleByVehicle(scheduledBus);
    }

    @Override
    public List<Schedule> queryDriverSchedule(String[] scheduledBus) {
        return this.scheduleMapper.queryDriverSchedule(scheduledBus);
    }

    @Override
    public List<Schedule> queryRecentSchedule(String[] scheduledBus) {
        return this.scheduleMapper.queryRecentSchedule(scheduledBus);
    }

    @Override
    public List<Schedule> queryFutureSchedule(String[] scheduledBus) {
        return this.scheduleMapper.queryFutureSchedule(scheduledBus);
    }

    /**
     * 新增数据
     *
     * @param schedule 实例对象
     * @return 实例对象
     */
    @Override
    public Schedule insert(Schedule schedule) {
        this.scheduleMapper.insert(schedule);
        return schedule;
    }

    /**
     * 修改数据
     *
     * @param schedule 实例对象
     * @return 实例对象
     */
    @Override
    public Schedule update(Schedule schedule) {
        this.scheduleMapper.update(schedule);
        return this.queryById(schedule.getScheduledId());
    }

    /**
     * 通过主键删除数据
     *
     * @param scheduledId 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer scheduledId) {
        return this.scheduleMapper.deleteById(scheduledId) > 0;
    }

    // 统计总行数
    @Override
    public long count(Schedule schedule) {
        return this.scheduleMapper.count(schedule);
    }
}

