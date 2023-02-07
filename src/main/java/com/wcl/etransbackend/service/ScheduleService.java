package com.wcl.etransbackend.service;

import com.github.pagehelper.PageInfo;
import com.wcl.etransbackend.domain.Schedule;

import java.util.List;

/**
 * (Schedule)表服务接口
 *
 * @author crush
 * @since 2023-01-23 20:40:46
 */
public interface ScheduleService {

    /**
     * 查询所有数据
     *
     * @return 实例对象集合
     */
    List<Schedule> queryAll();

    List<Schedule> queryDriverSchedule(String[] scheduledBus);

    List<Schedule> queryRecentSchedule(String[] scheduledBus);

    List<Schedule> queryFutureSchedule(String[] scheduledBus);
    // 分页查询
    PageInfo<Schedule> queryAllByPage(Integer pageNum, Integer pageSize);

    /**
     * 通过ID查询单条数据
     *
     * @param scheduledId 主键
     * @return 实例对象
     */
    Schedule queryById(Integer scheduledId);

    List<Schedule> queryScheduleByVehicle(String scheduledBus);

    /**
     * 新增数据
     *
     * @param schedule 实例对象
     * @return 实例对象
     */
    Schedule insert(Schedule schedule);

    /**
     * 修改数据
     *
     * @param schedule 实例对象
     * @return 实例对象
     */
    Schedule update(Schedule schedule);

    /**
     * 通过主键删除数据
     *
     * @param scheduledId 主键
     * @return 是否成功
     */
    boolean deleteById(Integer scheduledId);

    long count(Schedule schedule);

}

