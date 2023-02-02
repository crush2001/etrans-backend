package com.wcl.etransbackend.mapper;

import com.wcl.etransbackend.domain.Announcement;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * (Announcement)表数据库访问层
 *
 * @author crush
 * @since 2023-01-12 00:04:01
 */
@Mapper
public interface AnnouncementMapper {

    /**
     * 查询所有数据
     *
     * @return 实例对象集合
     */
    List<Announcement> queryAll();

    // 分页查询
    List<Announcement> queryAllByPage();

    List<Announcement> queryAnnouncementByTitle(String announcementTitle);

    /**
     * 通过ID查询单条数据
     *
     * @param announcementId 主键
     * @return 实例对象
     */
    Announcement queryById(Integer announcementId);

    /**
     * 统计总行数
     *
     * @param announcement 查询条件
     * @return 总行数
     */
    long count(Announcement announcement);

    /**
     * 新增数据
     *
     * @param announcement 实例对象
     * @return 影响行数
     */
    int insert(Announcement announcement);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<Announcement> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<Announcement> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<Announcement> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<Announcement> entities);

    /**
     * 修改数据
     *
     * @param announcement 实例对象
     * @return 影响行数
     */
    int update(Announcement announcement);

    /**
     * 通过主键删除数据
     *
     * @param announcementId 主键
     * @return 影响行数
     */
    int deleteById(Integer announcementId);

}


