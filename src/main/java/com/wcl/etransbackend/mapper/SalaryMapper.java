package com.wcl.etransbackend.mapper;

import com.wcl.etransbackend.domain.Salary;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;

/**
 * (Salary)表数据库访问层
 *
 * @author crush
 * @since 2023-02-08 14:58:09
 */
@Mapper
public interface SalaryMapper {

    /**
     * 查询所有数据
     *
     * @return 实例对象集合
     */
    List<Salary> queryAll();

    List<Salary> queryAllByPage();

    List<Salary> querySalaryByStaffAccount(String staffAccount);

    /**
     * 通过ID查询单条数据
     *
     * @param staffAccount 主键
     * @return 实例对象
     */
    Salary queryById(String staffAccount);

    /**
     * 统计总行数
     *
     * @param salary 查询条件
     * @return 总行数
     */
    long count(Salary salary);

    /**
     * 新增数据
     *
     * @param salary 实例对象
     * @return 影响行数
     */
    int insert(Salary salary);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<Salary> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<Salary> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<Salary> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<Salary> entities);

    /**
     * 修改数据
     *
     * @param salary 实例对象
     * @return 影响行数
     */
    int update(Salary salary);

    /**
     * 通过主键删除数据
     *
     * @param staffAccount 主键
     * @return 影响行数
     */
    int deleteById(String staffAccount);

}


