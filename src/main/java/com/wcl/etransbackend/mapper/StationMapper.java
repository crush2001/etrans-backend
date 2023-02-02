package com.wcl.etransbackend.mapper;

import com.wcl.etransbackend.domain.Station;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * (Station)表数据库访问层
 *
 * @author crush
 * @since 2023-01-12 00:04:05
 */
@Mapper
public interface StationMapper {

    /**
     * 查询所有数据
     *
     * @return 实例对象集合
     */
    List<Station> queryAll();

    List<Station> gainStationInfo();

    // 分页查询
    List<Station> queryAllByPage();

    List<Station> queryStationByName(String stationName);

    /**
     * 通过ID查询单条数据
     *
     * @param stationName 主键
     * @return 实例对象
     */
    Station queryById(String stationName);

    /**
     * 统计总行数
     *
     * @param station 查询条件
     * @return 总行数
     */
    long count(Station station);

    /**
     * 新增数据
     *
     * @param station 实例对象
     * @return 影响行数
     */
    int insert(Station station);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<Station> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<Station> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<Station> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<Station> entities);

    /**
     * 修改数据
     *
     * @param station 实例对象
     * @return 影响行数
     */
    int update(Station station);

    /**
     * 通过主键删除数据
     *
     * @param stationName 主键
     * @return 影响行数
     */
    int deleteById(String stationName);

}


