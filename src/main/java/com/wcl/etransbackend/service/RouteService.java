package com.wcl.etransbackend.service;

import com.github.pagehelper.PageInfo;
import com.wcl.etransbackend.domain.Route;

import java.util.List;

/**
 * (Route)表服务接口
 *
 * @author crush
 * @since 2023-01-12 00:04:02
 */
public interface RouteService {

    /**
     * 查询所有数据
     *
     * @return 实例对象集合
     */
    List<Route> queryAll();

    List<Route> gainRouteInfo();

    List<Route> queryDriverRoute(String[] routeNumber);

    // 分页查询
    PageInfo<Route> queryAllByPage(Integer pageNum, Integer pageSize);

    /**
     * 通过ID查询单条数据
     *
     * @param routeNumber 主键
     * @return 实例对象
     */
    Route queryById(String routeNumber);

    List<Route> queryRouteByNumber(String routeNumber);

    /**
     * 新增数据
     *
     * @param route 实例对象
     * @return 实例对象
     */
    Route insert(Route route);

    /**
     * 修改数据
     *
     * @param route 实例对象
     * @return 实例对象
     */
    Route update(Route route);

    /**
     * 通过主键删除数据
     *
     * @param routeNumber 主键
     * @return 是否成功
     */
    boolean deleteById(String routeNumber);

    long count(Route route);

}

