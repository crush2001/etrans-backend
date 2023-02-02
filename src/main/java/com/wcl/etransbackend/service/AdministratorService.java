package com.wcl.etransbackend.service;

import cn.dev33.satoken.stp.SaTokenInfo;
import com.wcl.etransbackend.common.CommonResult;
import com.wcl.etransbackend.domain.Administrator;

import java.util.List;

/**
 * (Administrator)表服务接口
 *
 * @author crush
 * @since 2023-01-12 00:03:59
 */
public interface AdministratorService {

    /**
     * 查询所有数据
     *
     * @return 实例对象集合
     */
    List<Administrator> queryAll();

    /**
     * 通过ID查询单条数据
     *
     * @param adminAccount 主键
     * @return 实例对象
     */
    Administrator queryById(String adminAccount);

    /**
     * 新增数据
     *
     * @param administrator 实例对象
     * @return 实例对象
     */
    Administrator insert(Administrator administrator);

    /**
     * 修改数据
     *
     * @param administrator 实例对象
     * @return 实例对象
     */
    Administrator update(Administrator administrator);

    /**
     * 通过主键删除数据
     *
     * @param adminAccount 主键
     * @return 是否成功
     */
    boolean deleteById(String adminAccount);

    // 登录认证
    SaTokenInfo login(String adminAccount, String adminPassword);
}

