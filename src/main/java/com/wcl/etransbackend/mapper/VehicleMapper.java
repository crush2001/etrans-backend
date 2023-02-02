package com.wcl.etransbackend.mapper;

import com.wcl.etransbackend.domain.Vehicle;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * (Vehicle)表数据库访问层
 *
 * @author crush
 * @since 2023-01-12 00:04:07
 */
@Mapper
public interface VehicleMapper {

    /**
     * 查询所有数据
     *
     * @return 实例对象集合
     */
    List<Vehicle> queryAll();

    // 分页查询
    List<Vehicle> queryAllByPage();

    List<Vehicle> queryVehicleByPlateNum(String vehiclePlateNumber);

    List<Vehicle> gainVehicleInfo();

    List<Vehicle> queryVehicleByDriver(String vehicleDriver);

    List<Vehicle> queryGroupByVehicleRoute();

    List<Vehicle> queryGroupByVehicleStatus();

    /**
     * 通过ID查询单条数据
     *
     * @param vehiclePlateNumber 主键
     * @return 实例对象
     */
    Vehicle queryById(String vehiclePlateNumber);

    /**
     * 统计总行数
     *
     * @param vehicle 查询条件
     * @return 总行数
     */
    long count(Vehicle vehicle);

    /**
     * 新增数据
     *
     * @param vehicle 实例对象
     * @return 影响行数
     */
    int insert(Vehicle vehicle);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<Vehicle> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<Vehicle> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<Vehicle> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<Vehicle> entities);

    /**
     * 修改数据
     *
     * @param vehicle 实例对象
     * @return 影响行数
     */
    int update(Vehicle vehicle);

    /**
     * 通过主键删除数据
     *
     * @param vehiclePlateNumber 主键
     * @return 影响行数
     */
    int deleteById(String vehiclePlateNumber);

}


