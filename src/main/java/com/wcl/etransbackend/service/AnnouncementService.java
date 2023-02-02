package com.wcl.etransbackend.service;

import cn.dev33.satoken.stp.SaTokenInfo;
import com.github.pagehelper.PageInfo;
import com.wcl.etransbackend.domain.Announcement;

import java.util.List;

/**
 * (Announcement)表服务接口
 *
 * @author crush
 * @since 2023-01-12 00:04:01
 */
public interface AnnouncementService {

    /**
     * 查询所有数据
     *
     * @return 实例对象集合
     */
    List<Announcement> queryAll();

    // 分页查询
    PageInfo<Announcement> queryAllByPage(Integer pageNum, Integer pageSize);

    /**
     * 通过ID查询单条数据
     *
     * @param announcementId 主键
     * @return 实例对象
     */
    Announcement queryById(Integer announcementId);

    List<Announcement> queryAnnouncementByTitle(String announcementTitle);

    /**
     * 新增数据
     *
     * @param announcement 实例对象
     * @return 实例对象
     */
    Announcement insert(Announcement announcement);

    /**
     * 修改数据
     *
     * @param announcement 实例对象
     * @return 实例对象
     */
    Announcement update(Announcement announcement);

    /**
     * 通过主键删除数据
     *
     * @param announcementId 主键
     * @return 是否成功
     */
    boolean deleteById(Integer announcementId);

    long count(Announcement announcement);

}

