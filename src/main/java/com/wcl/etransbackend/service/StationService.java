package com.wcl.etransbackend.service;

import com.github.pagehelper.PageInfo;
import com.wcl.etransbackend.domain.Station;

import java.util.List;

/**
 * (Station)表服务接口
 *
 * @author crush
 * @since 2023-01-12 00:04:05
 */
public interface StationService {

    /**
     * 查询所有数据
     *
     * @return 实例对象集合
     */
    List<Station> queryAll();

    List<Station> gainStationInfo();

    // 分页查询
    PageInfo<Station> queryAllByPage(Integer pageNum, Integer pageSize);

    /**
     * 通过ID查询单条数据
     *
     * @param stationName 主键
     * @return 实例对象
     */
    Station queryById(String stationName);

    List<Station> queryStationByName(String stationName);

    /**
     * 新增数据
     *
     * @param station 实例对象
     * @return 实例对象
     */
    Station insert(Station station);

    /**
     * 修改数据
     *
     * @param station 实例对象
     * @return 实例对象
     */
    Station update(Station station);

    /**
     * 通过主键删除数据
     *
     * @param stationName 主键
     * @return 是否成功
     */
    boolean deleteById(String stationName);

    // 统计总行数
    long count(Station station);

}

