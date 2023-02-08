package com.wcl.etransbackend.service;

import com.github.pagehelper.PageInfo;
import com.wcl.etransbackend.domain.Salary;
import io.swagger.models.auth.In;

import java.util.List;

/**
 * (Salary)表服务接口
 *
 * @author crush
 * @since 2023-02-08 14:58:09
 */
public interface SalaryService {

    /**
     * 查询所有数据
     *
     * @return 实例对象集合
     */
    List<Salary> queryAll();

    PageInfo<Salary> queryAllByPage(Integer pageNum, Integer pageSize);

    /**
     * 通过ID查询单条数据
     *
     * @param staffAccount 主键
     * @return 实例对象
     */
    Salary queryById(String staffAccount);

    List<Salary> querySalaryByStaffAccount(String staffAccount);

    /**
     * 新增数据
     *
     * @param salary 实例对象
     * @return 实例对象
     */
    Salary insert(Salary salary);

    /**
     * 修改数据
     *
     * @param salary 实例对象
     * @return 实例对象
     */
    Salary update(Salary salary);

    /**
     * 通过主键删除数据
     *
     * @param staffAccount 主键
     * @return 是否成功
     */
    boolean deleteById(String staffAccount);

}

