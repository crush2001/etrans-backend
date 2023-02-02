package com.wcl.etransbackend.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.io.Serializable;

/**
 * (Staff)实体类
 *
 * @author crush
 * @since 2023-01-12 00:04:04
 */
public class Staff implements Serializable {
    private static final long serialVersionUID = 322206938086800779L;
    /**
     * 员工账号
     */
    private String staffAccount;
    /**
     * 员工密码
     */
    private String staffPassword;
    /**
     * 员工姓名
     */
    private String staffTrueName;
    /**
     * 员工职位
     */
    private String staffPosition;
    /**
     * 员工手机号
     */
    private String staffPhoneNumber;
    /**
     * 员工身份证号
     */
    private String staffIdNumber;
    /**
     * 员工性别
     */
    private Boolean staffGender;
    /**
     * 员工生日
     */
    @DateTimeFormat(pattern="yyyy-MM-dd")
    @JsonFormat(pattern="yyyy-MM-dd",timezone = "GMT+8")
    private Date staffBirthday;
    /**
     * 员工住址
     */
    private String staffAddress;
    /**
     * 员工入职时间
     */
    private Date staffJoinDate;
    /**
     * 员工状态
     */
    private String staffStatus;

    private Integer totalNum;


    public String getStaffAccount() {
        return staffAccount;
    }

    public void setStaffAccount(String staffAccount) {
        this.staffAccount = staffAccount;
    }

    public String getStaffPassword() {
        return staffPassword;
    }

    public void setStaffPassword(String staffPassword) {
        this.staffPassword = staffPassword;
    }

    public String getStaffTrueName() {
        return staffTrueName;
    }

    public void setStaffTrueName(String staffTrueName) {
        this.staffTrueName = staffTrueName;
    }

    public String getStaffPosition() {
        return staffPosition;
    }

    public void setStaffPosition(String staffPosition) {
        this.staffPosition = staffPosition;
    }

    public String getStaffPhoneNumber() {
        return staffPhoneNumber;
    }

    public void setStaffPhoneNumber(String staffPhoneNumber) {
        this.staffPhoneNumber = staffPhoneNumber;
    }

    public String getStaffIdNumber() {
        return staffIdNumber;
    }

    public void setStaffIdNumber(String staffIdNumber) {
        this.staffIdNumber = staffIdNumber;
    }

    public Boolean getStaffGender() {
        return staffGender;
    }

    public void setStaffGender(Boolean staffGender) {
        this.staffGender = staffGender;
    }

    public Date getStaffBirthday() {
        return staffBirthday;
    }

    public void setStaffBirthday(Date staffBirthday) {
        this.staffBirthday = staffBirthday;
    }

    public String getStaffAddress() {
        return staffAddress;
    }

    public void setStaffAddress(String staffAddress) {
        this.staffAddress = staffAddress;
    }

    public Date getStaffJoinDate() {
        return staffJoinDate;
    }

    public void setStaffJoinDate(Date staffJoinDate) {
        this.staffJoinDate = staffJoinDate;
    }

    public String getStaffStatus() {
        return staffStatus;
    }

    public void setStaffStatus(String staffStatus) {
        this.staffStatus = staffStatus;
    }

    public Integer getTotalNum() {
        return totalNum;
    }

    public void setTotalNum(Integer totalNum) {
        this.totalNum = totalNum;
    }
}


