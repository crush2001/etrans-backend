package com.wcl.etransbackend.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wcl.etransbackend.domain.Route;
import com.wcl.etransbackend.mapper.RouteMapper;
import com.wcl.etransbackend.service.RouteService;
import org.springframework.stereotype.Service;

import java.util.List;
import javax.annotation.Resource;

/**
 * (Route)表服务实现类
 *
 * @author crush
 * @since 2023-01-12 00:04:02
 */
@Service("routeService")
public class RouteServiceImpl implements RouteService {
    @Resource
    private RouteMapper routeMapper;

    /**
     * 查询所有数据
     *
     * @return 实例对象集合
     */
    @Override
    public List<Route> queryAll() {
        return this.routeMapper.queryAll();
    }

    // 分页查询
    public PageInfo<Route> queryAllByPage(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<Route> route = routeMapper.queryAllByPage();
        PageInfo<Route> pageInfo = new PageInfo<>(route);
        return pageInfo;
    }

    @Override
    public List<Route> gainRouteInfo(){
        return this.routeMapper.gainRouteInfo();
    }

    /**
     * 通过ID查询单条数据
     *
     * @param routeNumber 主键
     * @return 实例对象
     */
    @Override
    public Route queryById(String routeNumber) {
        return this.routeMapper.queryById(routeNumber);
    }

    @Override
    public List<Route> queryRouteByNumber(String routeNumber) {
        return this.routeMapper.queryRouteByNumber(routeNumber);
    }

    @Override
    public List<Route> queryDriverRoute(String[] routeNumber) {
        return this.routeMapper.queryDriverRoute(routeNumber);
    }

    /**
     * 新增数据
     *
     * @param route 实例对象
     * @return 实例对象
     */
    @Override
    public Route insert(Route route) {
        this.routeMapper.insert(route);
        return route;
    }

    /**
     * 修改数据
     *
     * @param route 实例对象
     * @return 实例对象
     */
    @Override
    public Route update(Route route) {
        this.routeMapper.update(route);
        return this.queryById(route.getRouteNumber());
    }

    /**
     * 通过主键删除数据
     *
     * @param routeNumber 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(String routeNumber) {
        return this.routeMapper.deleteById(routeNumber) > 0;
    }

    // 统计总行数
    @Override
    public long count(Route route) {
        return this.routeMapper.count(route);
    }
}

