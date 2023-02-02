package com.wcl.etransbackend.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wcl.etransbackend.domain.Station;
import com.wcl.etransbackend.mapper.StationMapper;
import com.wcl.etransbackend.service.StationService;
import org.springframework.stereotype.Service;

import java.util.List;
import javax.annotation.Resource;

/**
 * (Station)表服务实现类
 *
 * @author crush
 * @since 2023-01-12 00:04:05
 */
@Service("stationService")
public class StationServiceImpl implements StationService {
    @Resource
    private StationMapper stationMapper;

    /**
     * 查询所有数据
     *
     * @return 实例对象集合
     */
    @Override
    public List<Station> queryAll() {
        return this.stationMapper.queryAll();
    }

    // 分页查询
    public PageInfo<Station> queryAllByPage(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<Station> station = stationMapper.queryAllByPage();
        PageInfo<Station> pageInfo = new PageInfo<>(station);
        return pageInfo;
    }

    @Override
    public List<Station> gainStationInfo() {
        return this.stationMapper.gainStationInfo();
    }

    /**
     * 通过ID查询单条数据
     *
     * @param stationName 主键
     * @return 实例对象
     */
    @Override
    public Station queryById(String stationName) {
        return this.stationMapper.queryById(stationName);
    }

    @Override
    public List<Station> queryStationByName(String stationName) {
        return this.stationMapper.queryStationByName(stationName);
    }

    /**
     * 新增数据
     *
     * @param station 实例对象
     * @return 实例对象
     */
    @Override
    public Station insert(Station station) {
        this.stationMapper.insert(station);
        return station;
    }

    /**
     * 修改数据
     *
     * @param station 实例对象
     * @return 实例对象
     */
    @Override
    public Station update(Station station) {
        this.stationMapper.update(station);
        return this.queryById(station.getStationName());
    }

    /**
     * 通过主键删除数据
     *
     * @param stationName 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(String stationName) {
        return this.stationMapper.deleteById(stationName) > 0;
    }

    // 统计总行数
    @Override
    public long count(Station station) {
        return this.stationMapper.count(station);
    }
}

