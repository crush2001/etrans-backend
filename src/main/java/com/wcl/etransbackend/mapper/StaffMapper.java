package com.wcl.etransbackend.mapper;

import com.wcl.etransbackend.domain.Staff;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * (Staff)表数据库访问层
 *
 * @author crush
 * @since 2023-01-12 00:04:04
 */
@Mapper
public interface StaffMapper {

    /**
     * 查询所有数据
     *
     * @return 实例对象集合
     */
    List<Staff> queryAll();
    // 分页查询
    List<Staff> queryAllByPage();

    List<Staff> gainStaffInfo();

    List<Staff> queryByTrueName(String staffTrueName);

    List<Staff> queryGroupByStaffPosition();

    List<Staff> queryGroupByStaffStatus();

    /**
     * 通过ID查询单条数据
     *
     * @param staffAccount 主键
     * @return 实例对象
     */
    Staff queryById(String staffAccount);

    /**
     * 统计总行数
     *
     * @param staff 查询条件
     * @return 总行数
     */
    long count(Staff staff);

    /**
     * 新增数据
     *
     * @param staff 实例对象
     * @return 影响行数
     */
    int insert(Staff staff);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<Staff> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<Staff> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<Staff> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<Staff> entities);

    /**
     * 修改数据
     *
     * @param staff 实例对象
     * @return 影响行数
     */
    int update(Staff staff);

    /**
     * 通过主键删除数据
     *
     * @param staffAccount 主键
     * @return 影响行数
     */
    int deleteById(String staffAccount);

}


