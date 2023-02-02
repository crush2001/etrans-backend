package com.wcl.etransbackend.service;

import cn.dev33.satoken.stp.SaTokenInfo;
import com.github.pagehelper.PageInfo;
import com.wcl.etransbackend.domain.Staff;

import java.util.List;

/**
 * (Staff)表服务接口
 *
 * @author crush
 * @since 2023-01-12 00:04:04
 */
public interface StaffService {

    /**
     * 查询所有数据
     *
     * @return 实例对象集合
     */
    List<Staff> queryAll();

    List<Staff> gainStaffInfo();

    // 分页查询
    PageInfo<Staff> queryAllByPage(Integer pageNum, Integer pageSize);

    /**
     * 通过ID查询单条数据
     *
     * @param staffAccount 主键
     * @return 实例对象
     */
    Staff queryById(String staffAccount);

    List<Staff> queryByTrueName(String staffTrueName);

    List<Staff> queryGroupByStaffPosition();

    List<Staff> queryGroupByStaffStatus();

    /**
     * 新增数据
     *
     * @param staff 实例对象
     * @return 实例对象
     */
    Staff insert(Staff staff);

    /**
     * 修改数据
     *
     * @param staff 实例对象
     * @return 实例对象
     */
    Staff update(Staff staff);

    /**
     * 通过主键删除数据
     *
     * @param staffAccount 主键
     * @return 是否成功
     */
    boolean deleteById(String staffAccount);

    // 统计总行数
    long count(Staff staff);

    // 登录认证
    SaTokenInfo login(String staffAccount, String staffPassword);
}

