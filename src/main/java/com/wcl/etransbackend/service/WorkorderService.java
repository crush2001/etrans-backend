package com.wcl.etransbackend.service;

import com.github.pagehelper.PageInfo;
import com.wcl.etransbackend.domain.Workorder;

import java.util.List;

/**
 * (Workorder)表服务接口
 *
 * @author crush
 * @since 2023-01-12 00:04:07
 */
public interface WorkorderService {

    /**
     * 查询所有数据
     *
     * @return 实例对象集合
     */
    List<Workorder> queryAll();

    // 分页查询
    PageInfo<Workorder> queryAllByPage(Integer pageNum, Integer pageSize);

    PageInfo<Workorder> queryOwnWorkorderByPage(String workorderPublisher, Integer pageNum, Integer pageSize);

    /**
     * 通过ID查询单条数据
     *
     * @param workorderId 主键
     * @return 实例对象
     */
    Workorder queryById(Integer workorderId);

    List<Workorder> queryWorkorderByStaff(String workorderPublisher);

    List<Workorder> queryWorkorderByStaffAndTitle(String workorderPublisher, String workorderTitle);

    List<Workorder> queryGroupByWorkorderType();

    List<Workorder> queryGroupByWorkorderStatus();

    /**
     * 新增数据
     *
     * @param workorder 实例对象
     * @return 实例对象
     */
    Workorder insert(Workorder workorder);

    /**
     * 修改数据
     *
     * @param workorder 实例对象
     * @return 实例对象
     */
    Workorder update(Workorder workorder);

    /**
     * 通过主键删除数据
     *
     * @param workorderId 主键
     * @return 是否成功
     */
    boolean deleteById(Integer workorderId);

    long count(Workorder workorder);

}

