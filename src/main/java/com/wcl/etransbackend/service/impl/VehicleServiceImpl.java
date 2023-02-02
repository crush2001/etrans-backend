package com.wcl.etransbackend.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wcl.etransbackend.domain.Vehicle;
import com.wcl.etransbackend.mapper.VehicleMapper;
import com.wcl.etransbackend.service.VehicleService;
import org.springframework.stereotype.Service;

import java.util.List;
import javax.annotation.Resource;

/**
 * (Vehicle)表服务实现类
 *
 * @author crush
 * @since 2023-01-12 00:04:07
 */
@Service("vehicleService")
public class VehicleServiceImpl implements VehicleService {
    @Resource
    private VehicleMapper vehicleMapper;

    /**
     * 查询所有数据
     *
     * @return 实例对象集合
     */
    @Override
    public List<Vehicle> queryAll() {
        return this.vehicleMapper.queryAll();
    }

    // 分页查询
    public PageInfo<Vehicle> queryAllByPage(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<Vehicle> vehicle = vehicleMapper.queryAllByPage();
        PageInfo<Vehicle> pageInfo = new PageInfo<>(vehicle);
        return pageInfo;
    }

    @Override
    public List<Vehicle> gainVehicleInfo() {
        return this.vehicleMapper.gainVehicleInfo();
    }

    /**
     * 通过ID查询单条数据
     *
     * @param vehiclePlateNumber 主键
     * @return 实例对象
     */
    @Override
    public Vehicle queryById(String vehiclePlateNumber) {
        return this.vehicleMapper.queryById(vehiclePlateNumber);
    }

    @Override
    public List<Vehicle> queryVehicleByPlateNum(String vehiclePlateNumber) {
        return this.vehicleMapper.queryVehicleByPlateNum(vehiclePlateNumber);
    }

    @Override
    public List<Vehicle> queryVehicleByDriver(String vehicleDriver) {
        return this.vehicleMapper.queryVehicleByDriver(vehicleDriver);
    }

    @Override
    public List<Vehicle> queryGroupByVehicleRoute() {
        return this.vehicleMapper.queryGroupByVehicleRoute();
    }

    @Override
    public List<Vehicle> queryGroupByVehicleStatus() {
        return this.vehicleMapper.queryGroupByVehicleStatus();
    }

    /**
     * 新增数据
     *
     * @param vehicle 实例对象
     * @return 实例对象
     */
    @Override
    public Vehicle insert(Vehicle vehicle) {
        this.vehicleMapper.insert(vehicle);
        return vehicle;
    }

    /**
     * 修改数据
     *
     * @param vehicle 实例对象
     * @return 实例对象
     */
    @Override
    public Vehicle update(Vehicle vehicle) {
        this.vehicleMapper.update(vehicle);
        return this.queryById(vehicle.getVehiclePlateNumber());
    }

    /**
     * 通过主键删除数据
     *
     * @param vehiclePlateNumber 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(String vehiclePlateNumber) {
        return this.vehicleMapper.deleteById(vehiclePlateNumber) > 0;
    }

    // 统计总行数
    @Override
    public long count(Vehicle vehicle) {
        return this.vehicleMapper.count(vehicle);
    }
}

