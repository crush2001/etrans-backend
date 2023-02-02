package com.wcl.etransbackend.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wcl.etransbackend.domain.Announcement;
import com.wcl.etransbackend.mapper.AnnouncementMapper;
import com.wcl.etransbackend.service.AnnouncementService;
import org.springframework.stereotype.Service;

import java.util.List;
import javax.annotation.Resource;

/**
 * (Announcement)表服务实现类
 *
 * @author crush
 * @since 2023-01-12 00:04:01
 */
@Service("announcementService")
public class AnnouncementServiceImpl implements AnnouncementService {
    @Resource
    private AnnouncementMapper announcementMapper;

    /**
     * 查询所有数据
     *
     * @return 实例对象集合
     */
    @Override
    public List<Announcement> queryAll() {
        return this.announcementMapper.queryAll();
    }

    // 分页查询
    public PageInfo<Announcement> queryAllByPage(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<Announcement> announcement = announcementMapper.queryAllByPage();
        PageInfo<Announcement> pageInfo = new PageInfo<>(announcement);
        return pageInfo;
    }

    /**
     * 通过ID查询单条数据
     *
     * @param announcementId 主键
     * @return 实例对象
     */
    @Override
    public Announcement queryById(Integer announcementId) {
        return this.announcementMapper.queryById(announcementId);
    }

    @Override
    public List<Announcement> queryAnnouncementByTitle(String announcementTitle) {
        return this.announcementMapper.queryAnnouncementByTitle(announcementTitle);
    }

    /**
     * 新增数据
     *
     * @param announcement 实例对象
     * @return 实例对象
     */
    @Override
    public Announcement insert(Announcement announcement) {
        this.announcementMapper.insert(announcement);
        return announcement;
    }

    /**
     * 修改数据
     *
     * @param announcement 实例对象
     * @return 实例对象
     */
    @Override
    public Announcement update(Announcement announcement) {
        this.announcementMapper.update(announcement);
        return this.queryById(announcement.getAnnouncementId());
    }

    /**
     * 通过主键删除数据
     *
     * @param announcementId 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer announcementId) {
        return this.announcementMapper.deleteById(announcementId) > 0;
    }

    // 统计总行数
    @Override
    public long count(Announcement announcement) {
        return this.announcementMapper.count(announcement);
    }
}

