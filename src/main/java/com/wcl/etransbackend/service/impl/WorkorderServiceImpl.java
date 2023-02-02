package com.wcl.etransbackend.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wcl.etransbackend.domain.Workorder;
import com.wcl.etransbackend.mapper.WorkorderMapper;
import com.wcl.etransbackend.service.WorkorderService;
import org.springframework.stereotype.Service;

import java.util.List;
import javax.annotation.Resource;

/**
 * (Workorder)表服务实现类
 *
 * @author crush
 * @since 2023-01-12 00:04:08
 */
@Service("workorderService")
public class WorkorderServiceImpl implements WorkorderService {
    @Resource
    private WorkorderMapper workorderMapper;

    /**
     * 查询所有数据
     *
     * @return 实例对象集合
     */
    @Override
    public List<Workorder> queryAll() {
        return this.workorderMapper.queryAll();
    }

    // 分页查询
    public PageInfo<Workorder> queryAllByPage(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<Workorder> workorder = workorderMapper.queryAllByPage();
        PageInfo<Workorder> pageInfo = new PageInfo<>(workorder);
        return pageInfo;
    }

    public PageInfo<Workorder> queryOwnWorkorderByPage(String workorderPublisher, Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<Workorder> workorder = workorderMapper.queryOwnWorkorderByPage(workorderPublisher);
        PageInfo<Workorder> pageInfo = new PageInfo<>(workorder);
        return pageInfo;
    }

    /**
     * 通过ID查询单条数据
     *
     * @param workorderId 主键
     * @return 实例对象
     */
    @Override
    public Workorder queryById(Integer workorderId) {
        return this.workorderMapper.queryById(workorderId);
    }

    @Override
    public List<Workorder> queryWorkorderByStaff(String workorderPublisher) {
        return this.workorderMapper.queryWorkorderByStaff(workorderPublisher);
    }

    @Override
    public List<Workorder> queryWorkorderByStaffAndTitle(String workorderPublisher, String workorderTitle) {
        return this.workorderMapper.queryWorkorderByStaffAndTitle(workorderPublisher, workorderTitle);
    }

    @Override
    public List<Workorder> queryGroupByWorkorderType() {
        return this.workorderMapper.queryGroupByWorkorderType();
    }

    @Override
    public List<Workorder> queryGroupByWorkorderStatus() {
        return this.workorderMapper.queryGroupByWorkorderStatus();
    }

    /**
     * 新增数据
     *
     * @param workorder 实例对象
     * @return 实例对象
     */
    @Override
    public Workorder insert(Workorder workorder) {
        this.workorderMapper.insert(workorder);
        return workorder;
    }

    /**
     * 修改数据
     *
     * @param workorder 实例对象
     * @return 实例对象
     */
    @Override
    public Workorder update(Workorder workorder) {
        this.workorderMapper.update(workorder);
        return this.queryById(workorder.getWorkorderId());
    }

    /**
     * 通过主键删除数据
     *
     * @param workorderId 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer workorderId) {
        return this.workorderMapper.deleteById(workorderId) > 0;
    }

    // 统计总行数
    @Override
    public long count(Workorder workorder) {
        return this.workorderMapper.count(workorder);
    }
}

