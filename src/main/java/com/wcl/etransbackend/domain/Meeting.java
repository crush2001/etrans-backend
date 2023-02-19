package com.wcl.etransbackend.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.io.Serializable;

/**
 * (Meeting)实体类
 *
 * @author crush
 * @since 2023-02-19 11:46:59
 */
public class Meeting implements Serializable {
    private static final long serialVersionUID = -10027414344246211L;
    /**
     * 会议ID
     */
    private Integer meetingId;
    /**
     * 会议主题
     */
    private String meetingTheme;
    /**
     * 会议详情
     */
    private String meetingDetails;
    /**
     * 会议类型
     */
    private String meetingType;
    /**
     * 会议时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date meetingTime;
    /**
     * 会议安排者
     */
    private String meetingArranger;
    /**
     * 会议参加者
     */
    private String meetingParticipant;


    public Integer getMeetingId() {
        return meetingId;
    }

    public void setMeetingId(Integer meetingId) {
        this.meetingId = meetingId;
    }

    public String getMeetingTheme() {
        return meetingTheme;
    }

    public void setMeetingTheme(String meetingTheme) {
        this.meetingTheme = meetingTheme;
    }

    public String getMeetingDetails() {
        return meetingDetails;
    }

    public void setMeetingDetails(String meetingDetails) {
        this.meetingDetails = meetingDetails;
    }

    public String getMeetingType() {
        return meetingType;
    }

    public void setMeetingType(String meetingType) {
        this.meetingType = meetingType;
    }

    public Date getMeetingTime() {
        return meetingTime;
    }

    public void setMeetingTime(Date meetingTime) {
        this.meetingTime = meetingTime;
    }

    public String getMeetingArranger() {
        return meetingArranger;
    }

    public void setMeetingArranger(String meetingArranger) {
        this.meetingArranger = meetingArranger;
    }

    public String getMeetingParticipant() {
        return meetingParticipant;
    }

    public void setMeetingParticipant(String meetingParticipant) {
        this.meetingParticipant = meetingParticipant;
    }

}


