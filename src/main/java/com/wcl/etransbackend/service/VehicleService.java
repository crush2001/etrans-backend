package com.wcl.etransbackend.service;

import com.github.pagehelper.PageInfo;
import com.wcl.etransbackend.domain.Vehicle;

import java.util.List;

/**
 * (Vehicle)表服务接口
 *
 * @author crush
 * @since 2023-01-12 00:04:06
 */
public interface VehicleService {

    /**
     * 查询所有数据
     *
     * @return 实例对象集合
     */
    List<Vehicle> queryAll();

    // 分页查询
    PageInfo<Vehicle> queryAllByPage(Integer pageNum, Integer pageSize);

    List<Vehicle> gainVehicleInfo();

    /**
     * 通过ID查询单条数据
     *
     * @param vehiclePlateNumber 主键
     * @return 实例对象
     */
    Vehicle queryById(String vehiclePlateNumber);

    List<Vehicle> queryVehicleByPlateNum(String vehiclePlateNumber);

    List<Vehicle> queryVehicleByDriver(String vehicleDriver);

    List<Vehicle> queryGroupByVehicleRoute();

    List<Vehicle> queryGroupByVehicleStatus();

    /**
     * 新增数据
     *
     * @param vehicle 实例对象
     * @return 实例对象
     */
    Vehicle insert(Vehicle vehicle);

    /**
     * 修改数据
     *
     * @param vehicle 实例对象
     * @return 实例对象
     */
    Vehicle update(Vehicle vehicle);

    /**
     * 通过主键删除数据
     *
     * @param vehiclePlateNumber 主键
     * @return 是否成功
     */
    boolean deleteById(String vehiclePlateNumber);

    long count(Vehicle vehicle);

}

