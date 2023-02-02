package com.wcl.etransbackend.service.impl;

import cn.dev33.satoken.secure.SaSecureUtil;
import cn.dev33.satoken.stp.SaTokenInfo;
import cn.dev33.satoken.stp.StpUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wcl.etransbackend.domain.Administrator;
import com.wcl.etransbackend.domain.Staff;
import com.wcl.etransbackend.mapper.StaffMapper;
import com.wcl.etransbackend.service.StaffService;
import org.springframework.stereotype.Service;

import java.util.List;
import javax.annotation.Resource;

/**
 * (Staff)表服务实现类
 *
 * @author crush
 * @since 2023-01-12 00:04:04
 */
@Service("staffService")
public class StaffServiceImpl implements StaffService {
    @Resource
    private StaffMapper staffMapper;

    /**
     * 查询所有数据
     *
     * @return 实例对象集合
     */
    @Override
    public List<Staff> queryAll() {
        return this.staffMapper.queryAll();
    }

    @Override
    public List<Staff> gainStaffInfo() {
        return this.staffMapper.gainStaffInfo();
    }

    // 分页查询
    public PageInfo<Staff> queryAllByPage(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<Staff> staff = staffMapper.queryAllByPage();
        PageInfo<Staff> pageInfo = new PageInfo<>(staff);
        return pageInfo;
    }

    /**
     * 通过ID查询单条数据
     *
     * @param staffAccount 主键
     * @return 实例对象
     */
    @Override
    public Staff queryById(String staffAccount) {
        return this.staffMapper.queryById(staffAccount);
    }

    @Override
    public List<Staff> queryByTrueName(String staffTrueName) {
        return this.staffMapper.queryByTrueName(staffTrueName);
    }

    @Override
    public List<Staff> queryGroupByStaffPosition() {
        return this.staffMapper.queryGroupByStaffPosition();
    }

    @Override
    public List<Staff> queryGroupByStaffStatus() {
        return this.staffMapper.queryGroupByStaffStatus();
    }

    /**
     * 新增数据
     *
     * @param staff 实例对象
     * @return 实例对象
     */
    @Override
    public Staff insert(Staff staff) {
        this.staffMapper.insert(staff);
        return staff;
    }

    /**
     * 修改数据
     *
     * @param staff 实例对象
     * @return 实例对象
     */
    @Override
    public Staff update(Staff staff) {
        this.staffMapper.update(staff);
        return this.queryById(staff.getStaffAccount());
    }

    /**
     * 通过主键删除数据
     *
     * @param staffAccount 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(String staffAccount) {
        return this.staffMapper.deleteById(staffAccount) > 0;
    }

    // 统计总行数
    @Override
    public long count(Staff staff) {
        return this.staffMapper.count(staff);
    }

    // 登录认证
    @Override
    public SaTokenInfo login(String staffAccount, String staffPassword) {
        SaTokenInfo saTokenInfo = null;
        Staff staff = queryById(staffAccount);
        if (staff == null) {
            return null;
        }
        if (!SaSecureUtil.md5(staffPassword).equals(staff.getStaffPassword())) {
            return null;
        }
        StpUtil.login(staff.getStaffAccount());
        saTokenInfo = StpUtil.getTokenInfo();
        return saTokenInfo;
    }
}

