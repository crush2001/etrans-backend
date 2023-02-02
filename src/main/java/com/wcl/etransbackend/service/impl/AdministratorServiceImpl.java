package com.wcl.etransbackend.service.impl;

import cn.dev33.satoken.secure.SaSecureUtil;
import cn.dev33.satoken.stp.SaTokenInfo;
import cn.dev33.satoken.stp.StpUtil;
import com.wcl.etransbackend.common.CommonResult;
import com.wcl.etransbackend.domain.Administrator;
import com.wcl.etransbackend.mapper.AdministratorMapper;
import com.wcl.etransbackend.service.AdministratorService;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;
import javax.annotation.Resource;

/**
 * (Administrator)表服务实现类
 *
 * @author crush
 * @since 2023-01-12 00:03:59
 */
@Slf4j
@Service("administratorService")
public class AdministratorServiceImpl implements AdministratorService {
    @Resource
    private AdministratorMapper administratorMapper;

    /**
     * 查询所有数据
     *
     * @return 实例对象集合
     */
    @Override
    public List<Administrator> queryAll() {
        return this.administratorMapper.queryAll();
    }

    /**
     * 通过ID查询单条数据
     *
     * @param adminAccount 主键
     * @return 实例对象
     */
    @Override
    public Administrator queryById(String adminAccount) {
        return this.administratorMapper.queryById(adminAccount);
    }

    /**
     * 新增数据
     *
     * @param administrator 实例对象
     * @return 实例对象
     */
    @Override
    public Administrator insert(Administrator administrator) {
        this.administratorMapper.insert(administrator);
        return administrator;
    }

    /**
     * 修改数据
     *
     * @param administrator 实例对象
     * @return 实例对象
     */
    @Override
    public Administrator update(Administrator administrator) {
        this.administratorMapper.update(administrator);
        return this.queryById(administrator.getAdminAccount());
    }

    /**
     * 通过主键删除数据
     *
     * @param adminAccount 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(String adminAccount) {
        return this.administratorMapper.deleteById(adminAccount) > 0;
    }

    // 登录认证
    @Override
    public SaTokenInfo login(String adminAccount, String adminPassword) {
        SaTokenInfo saTokenInfo = null;
        Administrator administrator = queryById(adminAccount);
        if (administrator == null) {
            return null;
        }
        if (!SaSecureUtil.md5(adminPassword).equals(administrator.getAdminPassword())) {
            return null;
        }
        StpUtil.login(administrator.getAdminAccount());
        saTokenInfo = StpUtil.getTokenInfo();
        return saTokenInfo;
    }
}

