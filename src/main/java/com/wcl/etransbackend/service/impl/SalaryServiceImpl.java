package com.wcl.etransbackend.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wcl.etransbackend.domain.Salary;
import com.wcl.etransbackend.mapper.SalaryMapper;
import com.wcl.etransbackend.service.SalaryService;
import io.swagger.models.auth.In;
import org.springframework.stereotype.Service;
import java.util.List;
import javax.annotation.Resource;

/**
 * (Salary)表服务实现类
 *
 * @author crush
 * @since 2023-02-08 14:58:09
 */
@Service("salaryService")
public class SalaryServiceImpl implements SalaryService {
    @Resource
    private SalaryMapper salaryMapper;

    /**
     * 查询所有数据
     *
     * @return 实例对象集合
     */
    @Override
    public List<Salary> queryAll() {
        return this.salaryMapper.queryAll();
    }

    public PageInfo<Salary> queryAllByPage(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<Salary> salary = salaryMapper.queryAllByPage();
        PageInfo<Salary> pageInfo = new PageInfo<>(salary);
        return pageInfo;
    }

    public List<Salary> querySalaryByStaffAccount(String staffAccount) {
        return this.salaryMapper.querySalaryByStaffAccount(staffAccount);
    }

    /**
     * 通过ID查询单条数据
     *
     * @param staffAccount 主键
     * @return 实例对象
     */
    @Override
    public Salary queryById(String staffAccount) {
        return this.salaryMapper.queryById(staffAccount);
    }

    /**
     * 新增数据
     *
     * @param salary 实例对象
     * @return 实例对象
     */
    @Override
    public Salary insert(Salary salary) {
        this.salaryMapper.insert(salary);
        return salary;
    }

    /**
     * 修改数据
     *
     * @param salary 实例对象
     * @return 实例对象
     */
    @Override
    public Salary update(Salary salary) {
        this.salaryMapper.update(salary);
        return this.queryById(salary.getStaffAccount());
    }

    /**
     * 通过主键删除数据
     *
     * @param staffAccount 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(String staffAccount) {
        return this.salaryMapper.deleteById(staffAccount) > 0;
    }
}

