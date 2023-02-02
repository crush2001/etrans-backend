package com.wcl.etransbackend.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalTime;
import java.util.Date;
import java.io.Serializable;

/**
 * (Route)实体类
 *
 * @author crush
 * @since 2023-01-12 00:04:02
 */
public class Route implements Serializable {
    private static final long serialVersionUID = -23004657158326495L;
    /**
     * 线路号
     */
    private String routeNumber;
    /**
     * 线路起点站
     */
    private String routeStartingStation;
    /**
     * 线路终点站
     */
    private String routeTerminalStation;
    /**
     * 线路途径车站
     */
    private String routeStations;
    /**
     * 线路首班时间
     */
    @DateTimeFormat(pattern = "HH:mm")
    @JsonFormat(pattern = "HH:mm",timezone = "GMT+8")
    private LocalTime routeStartingTime;
    /**
     * 线路末班时间
     */
    @DateTimeFormat(pattern = "HH:mm")
    @JsonFormat(pattern = "HH:mm",timezone = "GMT+8")
    private LocalTime routeTerminalTime;
    /**
     * 线路开线时间
     */
    private Date routeOpenupDate;


    public String getRouteNumber() {
        return routeNumber;
    }

    public void setRouteNumber(String routeNumber) {
        this.routeNumber = routeNumber;
    }

    public String getRouteStartingStation() {
        return routeStartingStation;
    }

    public void setRouteStartingStation(String routeStartingStation) {
        this.routeStartingStation = routeStartingStation;
    }

    public String getRouteTerminalStation() {
        return routeTerminalStation;
    }

    public void setRouteTerminalStation(String routeTerminalStation) {
        this.routeTerminalStation = routeTerminalStation;
    }

    public String getRouteStations() {
        return routeStations;
    }

    public void setRouteStations(String routeStations) {
        this.routeStations = routeStations;
    }

    public LocalTime getRouteStartingTime() {
        return routeStartingTime;
    }

    public void setRouteStartingTime(LocalTime routeStartingTime) {
        this.routeStartingTime = routeStartingTime;
    }

    public LocalTime getRouteTerminalTime() {
        return routeTerminalTime;
    }

    public void setRouteTerminalTime(LocalTime routeTerminalTime) {
        this.routeTerminalTime = routeTerminalTime;
    }

    public Date getRouteOpenupDate() {
        return routeOpenupDate;
    }

    public void setRouteOpenupDate(Date routeOpenupDate) {
        this.routeOpenupDate = routeOpenupDate;
    }

}


