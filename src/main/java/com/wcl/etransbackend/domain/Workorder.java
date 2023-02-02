package com.wcl.etransbackend.domain;

import java.util.Date;
import java.io.Serializable;

/**
 * (Workorder)实体类
 *
 * @author crush
 * @since 2023-01-12 00:04:08
 */
public class Workorder implements Serializable {
    private static final long serialVersionUID = -85361061414367490L;
    /**
     * 工单ID
     */
    private Integer workorderId;
    /**
     * 工单发布者
     */
    private String workorderPublisher;
    /**
     * 工单标题
     */
    private String workorderTitle;
    /**
     * 工单内容
     */
    private String workorderContent;
    /**
     * 工单类型
     */
    private String workorderType;
    /**
     * 工单提交时间
     */
    private Date workorderPublishTime;
    /**
     * 工单状态
     */
    private String workorderStatus;

    private Integer totalNum;


    public Integer getWorkorderId() {
        return workorderId;
    }

    public void setWorkorderId(Integer workorderId) {
        this.workorderId = workorderId;
    }

    public String getWorkorderPublisher() {
        return workorderPublisher;
    }

    public void setWorkorderPublisher(String workorderPublisher) {
        this.workorderPublisher = workorderPublisher;
    }

    public String getWorkorderTitle() {
        return workorderTitle;
    }

    public void setWorkorderTitle(String workorderTitle) {
        this.workorderTitle = workorderTitle;
    }

    public String getWorkorderContent() {
        return workorderContent;
    }

    public void setWorkorderContent(String workorderContent) {
        this.workorderContent = workorderContent;
    }

    public String getWorkorderType() {
        return workorderType;
    }

    public void setWorkorderType(String workorderType) {
        this.workorderType = workorderType;
    }

    public Date getWorkorderPublishTime() {
        return workorderPublishTime;
    }

    public void setWorkorderPublishTime(Date workorderPublishTime) {
        this.workorderPublishTime = workorderPublishTime;
    }

    public String getWorkorderStatus() {
        return workorderStatus;
    }

    public void setWorkorderStatus(String workorderStatus) {
        this.workorderStatus = workorderStatus;
    }

    public Integer getTotalNum() {
        return totalNum;
    }

    public void setTotalNum(Integer totalNum) {
        this.totalNum = totalNum;
    }
}


