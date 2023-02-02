package com.wcl.etransbackend.domain;

import java.io.Serializable;

/**
 * (Station)实体类
 *
 * @author crush
 * @since 2023-01-12 00:04:05
 */
public class Station implements Serializable {
    private static final long serialVersionUID = -84346157098469805L;
    /**
     * 车站名
     */
    private String stationName;
    /**
     * 车站详情
     */
    private String stationInfo;
    /**
     * 车站状态
     */
    private String stationStatus;


    public String getStationName() {
        return stationName;
    }

    public void setStationName(String stationName) {
        this.stationName = stationName;
    }

    public String getStationInfo() {
        return stationInfo;
    }

    public void setStationInfo(String stationInfo) {
        this.stationInfo = stationInfo;
    }

    public String getStationStatus() {
        return stationStatus;
    }

    public void setStationStatus(String stationStatus) {
        this.stationStatus = stationStatus;
    }

}


