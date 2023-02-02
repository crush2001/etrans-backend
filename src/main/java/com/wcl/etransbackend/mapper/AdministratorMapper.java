package com.wcl.etransbackend.mapper;

import com.wcl.etransbackend.domain.Administrator;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * (Administrator)表数据库访问层
 *
 * @author crush
 * @since 2023-01-12 00:04:00
 */
@Mapper
public interface AdministratorMapper {

    /**
     * 查询所有数据
     *
     * @return 实例对象集合
     */
    List<Administrator> queryAll();

    /**
     * 通过ID查询单条数据
     *
     * @param adminAccount 主键
     * @return 实例对象
     */
    Administrator queryById(String adminAccount);

    /**
     * 统计总行数
     *
     * @param administrator 查询条件
     * @return 总行数
     */
    long count(Administrator administrator);

    /**
     * 新增数据
     *
     * @param administrator 实例对象
     * @return 影响行数
     */
    int insert(Administrator administrator);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<Administrator> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<Administrator> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<Administrator> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<Administrator> entities);

    /**
     * 修改数据
     *
     * @param administrator 实例对象
     * @return 影响行数
     */
    int update(Administrator administrator);

    /**
     * 通过主键删除数据
     *
     * @param adminAccount 主键
     * @return 影响行数
     */
    int deleteById(String adminAccount);
}


