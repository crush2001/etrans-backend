package com.wcl.etransbackend.domain;

import java.util.Date;
import java.io.Serializable;

/**
 * (Vehicle)实体类
 *
 * @author crush
 * @since 2023-01-12 00:04:07
 */
public class Vehicle implements Serializable {
    private static final long serialVersionUID = -91549124684038216L;
    /**
     * 车辆车牌号
     */
    private String vehiclePlateNumber;
    /**
     * 车辆车型
     */
    private String vehicleType;
    /**
     * 车辆额定载客数
     */
    private Integer vehicleCapacity;
    /**
     * 车辆状态
     */
    private String vehicleStatus;
    /**
     * 车辆所属线路
     */
    private String vehicleRoute;
    /**
     * 车辆购买时间
     */
    private Date vehiclePurchaseTime;
    /**
     * 车辆驾驶员
     */
    private String vehicleDriver;

    private Integer totalNum;


    public String getVehiclePlateNumber() {
        return vehiclePlateNumber;
    }

    public void setVehiclePlateNumber(String vehiclePlateNumber) {
        this.vehiclePlateNumber = vehiclePlateNumber;
    }

    public String getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(String vehicleType) {
        this.vehicleType = vehicleType;
    }

    public Integer getVehicleCapacity() {
        return vehicleCapacity;
    }

    public void setVehicleCapacity(Integer vehicleCapacity) {
        this.vehicleCapacity = vehicleCapacity;
    }

    public String getVehicleStatus() {
        return vehicleStatus;
    }

    public void setVehicleStatus(String vehicleStatus) {
        this.vehicleStatus = vehicleStatus;
    }

    public String getVehicleRoute() {
        return vehicleRoute;
    }

    public void setVehicleRoute(String vehicleRoute) {
        this.vehicleRoute = vehicleRoute;
    }

    public Date getVehiclePurchaseTime() {
        return vehiclePurchaseTime;
    }

    public void setVehiclePurchaseTime(Date vehiclePurchaseTime) {
        this.vehiclePurchaseTime = vehiclePurchaseTime;
    }

    public String getVehicleDriver() {
        return vehicleDriver;
    }

    public void setVehicleDriver(String vehicleDriver) {
        this.vehicleDriver = vehicleDriver;
    }

    public Integer getTotalNum() {
        return totalNum;
    }

    public void setTotalNum(Integer totalNum) {
        this.totalNum = totalNum;
    }
}


