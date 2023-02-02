package com.wcl.etransbackend.mapper;

import com.wcl.etransbackend.domain.Route;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * (Route)表数据库访问层
 *
 * @author crush
 * @since 2023-01-12 00:04:02
 */
@Mapper
public interface RouteMapper {

    /**
     * 查询所有数据
     *
     * @return 实例对象集合
     */
    List<Route> queryAll();

    List<Route> gainRouteInfo();

    List<Route> queryRouteByNumber(String routeNumber);

    // 分页查询
    List<Route> queryAllByPage();

    List<Route> queryDriverRoute(String[] routeNumber);

    /**
     * 通过ID查询单条数据
     *
     * @param routeNumber 主键
     * @return 实例对象
     */
    Route queryById(String routeNumber);

    /**
     * 统计总行数
     *
     * @param route 查询条件
     * @return 总行数
     */
    long count(Route route);

    /**
     * 新增数据
     *
     * @param route 实例对象
     * @return 影响行数
     */
    int insert(Route route);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<Route> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<Route> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<Route> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<Route> entities);

    /**
     * 修改数据
     *
     * @param route 实例对象
     * @return 影响行数
     */
    int update(Route route);

    /**
     * 通过主键删除数据
     *
     * @param routeNumber 主键
     * @return 影响行数
     */
    int deleteById(String routeNumber);

}


