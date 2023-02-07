package com.wcl.etransbackend.mapper;

import com.wcl.etransbackend.domain.Schedule;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * (Schedule)表数据库访问层
 *
 * @author crush
 * @since 2023-01-23 20:40:46
 */
@Mapper
public interface ScheduleMapper {

    /**
     * 查询所有数据
     *
     * @return 实例对象集合
     */
    List<Schedule> queryAll();

    // 分页查询
    List<Schedule> queryAllByPage();

    List<Schedule> queryScheduleByVehicle(String scheduledBus);

    List<Schedule> queryDriverSchedule(String[] scheduledBus);

    List<Schedule> queryRecentSchedule(String[] scheduledBus);

    List<Schedule> queryFutureSchedule(String[] scheduledBus);

    /**
     * 通过ID查询单条数据
     *
     * @param scheduledId 主键
     * @return 实例对象
     */
    Schedule queryById(Integer scheduledId);

    /**
     * 统计总行数
     *
     * @param schedule 查询条件
     * @return 总行数
     */
    long count(Schedule schedule);

    /**
     * 新增数据
     *
     * @param schedule 实例对象
     * @return 影响行数
     */
    int insert(Schedule schedule);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<Schedule> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<Schedule> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<Schedule> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<Schedule> entities);

    /**
     * 修改数据
     *
     * @param schedule 实例对象
     * @return 影响行数
     */
    int update(Schedule schedule);

    /**
     * 通过主键删除数据
     *
     * @param scheduledId 主键
     * @return 影响行数
     */
    int deleteById(Integer scheduledId);

}


