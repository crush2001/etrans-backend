package com.wcl.etransbackend.domain;

import java.io.Serializable;

/**
 * (Administrator)实体类
 *
 * @author crush
 * @since 2023-01-12 00:03:59
 */
public class Administrator implements Serializable {
    private static final long serialVersionUID = -36767983489384814L;
    /**
     * 管理员账号
     */
    private String adminAccount;
    /**
     * 管理员密码
     */
    private String adminPassword;


    public String getAdminAccount() {
        return adminAccount;
    }

    public void setAdminAccount(String adminAccount) {
        this.adminAccount = adminAccount;
    }

    public String getAdminPassword() {
        return adminPassword;
    }

    public void setAdminPassword(String adminPassword) {
        this.adminPassword = adminPassword;
    }

}


