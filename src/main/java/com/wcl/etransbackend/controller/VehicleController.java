package com.wcl.etransbackend.controller;

import com.github.pagehelper.PageInfo;
import com.wcl.etransbackend.domain.Vehicle;
import com.wcl.etransbackend.service.VehicleService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import javax.annotation.Resource;

/**
 * (Vehicle)表控制层
 *
 * @author crush
 * @since 2023-01-12 00:04:05
 */
@RestController
@RequestMapping("vehicle")
public class VehicleController {
    /**
     * 服务对象
     */
    @Resource
    private VehicleService vehicleService;

    /**
     * 查询所有数据
     *
     * @return 实例对象集合
     */
    @GetMapping
    public ResponseEntity<List> queryAll() {
        return ResponseEntity.ok(this.vehicleService.queryAll());
    }

    // 分页查询
    @RequestMapping("/list")
    public PageInfo<Vehicle> queryAllByPage(@RequestParam(value = "pageNum",required = false,defaultValue = "1")Integer pageNum,
                                             @RequestParam(value = "pageSize",required = false,defaultValue = "3")Integer pageSize) {
        return this.vehicleService.queryAllByPage(pageNum, pageSize);
    }

    @GetMapping("/gainVehicleInfo")
    public ResponseEntity<List> gainVehicleInfo() {
        return ResponseEntity.ok(this.vehicleService.gainVehicleInfo());
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public ResponseEntity<Vehicle> queryById(@PathVariable("id") String id) {
        return ResponseEntity.ok(this.vehicleService.queryById(id));
    }

    @GetMapping("/search")
    public ResponseEntity<List> queryVehicleByPlateNum(String vehiclePlateNumber) {
        return ResponseEntity.ok(this.vehicleService.queryVehicleByPlateNum(vehiclePlateNumber));
    }

    @GetMapping("/queryVehicleByDriver")
    public ResponseEntity<List> queryVehicleByDriver(String vehicleDriver) {
        return ResponseEntity.ok(this.vehicleService.queryVehicleByDriver(vehicleDriver));
    }

    @GetMapping("/queryGroupByVehicleRoute")
    public ResponseEntity<List> queryGroupByVehicleRoute() {
        return ResponseEntity.ok(this.vehicleService.queryGroupByVehicleRoute());
    }

    @GetMapping("/queryGroupByVehicleStatus")
    public ResponseEntity<List> queryGroupByVehicleStatus() {
        return ResponseEntity.ok(this.vehicleService.queryGroupByVehicleStatus());
    }

    /**
     * 新增数据
     *
     * @param vehicle 实体
     * @return 新增结果
     */
    @PostMapping
    public ResponseEntity<Vehicle> add(Vehicle vehicle) {
        return ResponseEntity.ok(this.vehicleService.insert(vehicle));
    }

    /**
     * 编辑数据
     *
     * @param vehicle 实体
     * @return 编辑结果
     */
    @PutMapping
    public ResponseEntity<Vehicle> edit(Vehicle vehicle) {
        return ResponseEntity.ok(this.vehicleService.update(vehicle));
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @DeleteMapping
    public ResponseEntity<Boolean> deleteById(String id) {
        return ResponseEntity.ok(this.vehicleService.deleteById(id));
    }

    // 统计总行数
    @GetMapping("/count")
    public ResponseEntity<Long> count(Vehicle vehicle) {
        return ResponseEntity.ok(this.vehicleService.count(vehicle));
    }

}


