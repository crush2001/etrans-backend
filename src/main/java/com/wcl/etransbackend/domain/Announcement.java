package com.wcl.etransbackend.domain;

import java.util.Date;
import java.io.Serializable;

/**
 * (Announcement)实体类
 *
 * @author crush
 * @since 2023-01-12 00:04:01
 */
public class Announcement implements Serializable {
    private static final long serialVersionUID = -11509054390036134L;
    /**
     * 公告ID
     */
    private Integer announcementId;
    /**
     * 公告标题
     */
    private String announcementTitle;
    /**
     * 公告内容
     */
    private String announcementContent;
    /**
     * 公告发布者
     */
    private String announcementPublisher;
    /**
     * 公告发布时间
     */
    private Date announcementPublishTime;


    public Integer getAnnouncementId() {
        return announcementId;
    }

    public void setAnnouncementId(Integer announcementId) {
        this.announcementId = announcementId;
    }

    public String getAnnouncementTitle() {
        return announcementTitle;
    }

    public void setAnnouncementTitle(String announcementTitle) {
        this.announcementTitle = announcementTitle;
    }

    public String getAnnouncementContent() {
        return announcementContent;
    }

    public void setAnnouncementContent(String announcementContent) {
        this.announcementContent = announcementContent;
    }

    public String getAnnouncementPublisher() {
        return announcementPublisher;
    }

    public void setAnnouncementPublisher(String announcementPublisher) {
        this.announcementPublisher = announcementPublisher;
    }

    public Date getAnnouncementPublishTime() {
        return announcementPublishTime;
    }

    public void setAnnouncementPublishTime(Date announcementPublishTime) {
        this.announcementPublishTime = announcementPublishTime;
    }

}


