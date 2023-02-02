package com.wcl.etransbackend.mapper;

import com.wcl.etransbackend.domain.Workorder;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * (Workorder)表数据库访问层
 *
 * @author crush
 * @since 2023-01-12 00:04:08
 */
@Mapper
public interface WorkorderMapper {

    /**
     * 查询所有数据
     *
     * @return 实例对象集合
     */
    List<Workorder> queryAll();

    List<Workorder> queryWorkorderByStaff(String workorderPublisher);

    // 分页查询
    List<Workorder> queryAllByPage();

    List<Workorder> queryOwnWorkorderByPage(String workorderPublisher);

    List<Workorder> queryWorkorderByStaffAndTitle(String workorderPublisher, String workorderTitle);

    List<Workorder> queryGroupByWorkorderType();

    List<Workorder> queryGroupByWorkorderStatus();

    /**
     * 通过ID查询单条数据
     *
     * @param workorderId 主键
     * @return 实例对象
     */
    Workorder queryById(Integer workorderId);

    /**
     * 统计总行数
     *
     * @param workorder 查询条件
     * @return 总行数
     */
    long count(Workorder workorder);

    /**
     * 新增数据
     *
     * @param workorder 实例对象
     * @return 影响行数
     */
    int insert(Workorder workorder);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<Workorder> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<Workorder> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<Workorder> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<Workorder> entities);

    /**
     * 修改数据
     *
     * @param workorder 实例对象
     * @return 影响行数
     */
    int update(Workorder workorder);

    /**
     * 通过主键删除数据
     *
     * @param workorderId 主键
     * @return 影响行数
     */
    int deleteById(Integer workorderId);

}


