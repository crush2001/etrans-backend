package com.wcl.etransbackend.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.io.Serializable;

/**
 * (Schedule)实体类
 *
 * @author crush
 * @since 2023-01-23 20:40:46
 */
public class Schedule implements Serializable {
    private static final long serialVersionUID = -67992620517370735L;
    /**
     * 分配班次的车辆
     */
    private String scheduledBus;
    /**
     * 班次始发时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date scheduledTime;
    /**
     * 班次序号
     */
    private Integer scheduledId;


    public String getScheduledBus() {
        return scheduledBus;
    }

    public void setScheduledBus(String scheduledBus) {
        this.scheduledBus = scheduledBus;
    }

    public Date getScheduledTime() {
        return scheduledTime;
    }

    public void setScheduledTime(Date scheduledTime) {
        this.scheduledTime = scheduledTime;
    }

    public Integer getScheduledId() {
        return scheduledId;
    }

    public void setScheduledId(Integer scheduledId) {
        this.scheduledId = scheduledId;
    }

}


