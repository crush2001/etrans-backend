package com.wcl.etransbackend.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wcl.etransbackend.domain.Meeting;
import com.wcl.etransbackend.mapper.MeetingMapper;
import com.wcl.etransbackend.service.MeetingService;
import org.springframework.stereotype.Service;
import java.util.List;
import javax.annotation.Resource;

/**
 * (Meeting)表服务实现类
 *
 * @author crush
 * @since 2023-02-19 11:46:59
 */
@Service("meetingService")
public class MeetingServiceImpl implements MeetingService {
    @Resource
    private MeetingMapper meetingMapper;

    /**
     * 查询所有数据
     *
     * @return 实例对象集合
     */
    @Override
    public List<Meeting> queryAll() {
        return this.meetingMapper.queryAll();
    }

    public PageInfo<Meeting> queryAllByPage(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<Meeting> meeting = meetingMapper.queryAllByPage();
        PageInfo<Meeting> pageInfo = new PageInfo<>(meeting);
        return pageInfo;
    }

    @Override
    public List<Meeting> queryByMeetingTheme(String meetingTheme) {
        return this.meetingMapper.queryByMeetingTheme(meetingTheme);
    }

    /**
     * 通过ID查询单条数据
     *
     * @param meetingId 主键
     * @return 实例对象
     */
    @Override
    public Meeting queryById(Integer meetingId) {
        return this.meetingMapper.queryById(meetingId);
    }

    /**
     * 新增数据
     *
     * @param meeting 实例对象
     * @return 实例对象
     */
    @Override
    public Meeting insert(Meeting meeting) {
        this.meetingMapper.insert(meeting);
        return meeting;
    }

    /**
     * 修改数据
     *
     * @param meeting 实例对象
     * @return 实例对象
     */
    @Override
    public Meeting update(Meeting meeting) {
        this.meetingMapper.update(meeting);
        return this.queryById(meeting.getMeetingId());
    }

    /**
     * 通过主键删除数据
     *
     * @param meetingId 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer meetingId) {
        return this.meetingMapper.deleteById(meetingId) > 0;
    }
}

