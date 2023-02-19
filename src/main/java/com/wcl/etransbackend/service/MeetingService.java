package com.wcl.etransbackend.service;

import com.github.pagehelper.PageInfo;
import com.wcl.etransbackend.domain.Meeting;
import java.util.List;

/**
 * (Meeting)表服务接口
 *
 * @author crush
 * @since 2023-02-19 11:46:59
 */
public interface MeetingService {

    /**
     * 查询所有数据
     *
     * @return 实例对象集合
     */
    List<Meeting> queryAll();

    PageInfo<Meeting> queryAllByPage(Integer pageNum, Integer pageSize);

    List<Meeting> queryByMeetingTheme(String meetingTheme);

    /**
     * 通过ID查询单条数据
     *
     * @param meetingId 主键
     * @return 实例对象
     */
    Meeting queryById(Integer meetingId);

    /**
     * 新增数据
     *
     * @param meeting 实例对象
     * @return 实例对象
     */
    Meeting insert(Meeting meeting);

    /**
     * 修改数据
     *
     * @param meeting 实例对象
     * @return 实例对象
     */
    Meeting update(Meeting meeting);

    /**
     * 通过主键删除数据
     *
     * @param meetingId 主键
     * @return 是否成功
     */
    boolean deleteById(Integer meetingId);

}

