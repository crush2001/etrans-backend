package com.wcl.etransbackend.mapper;

import com.wcl.etransbackend.domain.Meeting;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;

/**
 * (Meeting)表数据库访问层
 *
 * @author crush
 * @since 2023-02-19 11:46:59
 */
@Mapper
public interface MeetingMapper {

    /**
     * 查询所有数据
     *
     * @return 实例对象集合
     */
    List<Meeting> queryAll();

    List<Meeting> queryMyMeeting(String singleParticipant);

    List<Meeting> queryAllByPage();

    List<Meeting> queryByMeetingTheme(String singleParticipant,String meetingTheme);

    /**
     * 通过ID查询单条数据
     *
     * @param meetingId 主键
     * @return 实例对象
     */
    Meeting queryById(Integer meetingId);

    /**
     * 统计总行数
     *
     * @param meeting 查询条件
     * @return 总行数
     */
    long count(Meeting meeting);

    /**
     * 新增数据
     *
     * @param meeting 实例对象
     * @return 影响行数
     */
    int insert(Meeting meeting);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<Meeting> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<Meeting> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<Meeting> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<Meeting> entities);

    /**
     * 修改数据
     *
     * @param meeting 实例对象
     * @return 影响行数
     */
    int update(Meeting meeting);

    /**
     * 通过主键删除数据
     *
     * @param meetingId 主键
     * @return 影响行数
     */
    int deleteById(Integer meetingId);

}


