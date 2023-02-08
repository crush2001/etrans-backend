package com.wcl.etransbackend.controller;

import com.github.pagehelper.PageInfo;
import com.wcl.etransbackend.domain.Salary;
import com.wcl.etransbackend.service.SalaryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import javax.annotation.Resource;

/**
 * (Salary)表控制层
 *
 * @author crush
 * @since 2023-02-08 14:58:09
 */
@RestController
@RequestMapping("salary")
public class SalaryController {
    /**
     * 服务对象
     */
    @Resource
    private SalaryService salaryService;

    /**
     * 查询所有数据
     *
     * @return 实例对象集合
     */
    @GetMapping
    public ResponseEntity<List> queryAll() {
        return ResponseEntity.ok(this.salaryService.queryAll());
    }

    @RequestMapping("/list")
    public PageInfo<Salary> queryAllByPage(@RequestParam(value = "pageNum",required = false,defaultValue = "1")Integer pageNum,
                                           @RequestParam(value = "pageSize",required = false,defaultValue = "3")Integer pageSize) {
        return this.salaryService.queryAllByPage(pageNum, pageSize);
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public ResponseEntity<Salary> queryById(@PathVariable("id") String id) {
        return ResponseEntity.ok(this.salaryService.queryById(id));
    }

    @GetMapping("/search")
    public ResponseEntity<List> querySalaryByStaffAccount(String staffAccount) {
        return ResponseEntity.ok(this.salaryService.querySalaryByStaffAccount(staffAccount));
    }

    /**
     * 新增数据
     *
     * @param salary 实体
     * @return 新增结果
     */
    @PostMapping
    public ResponseEntity<Salary> add(Salary salary) {
        return ResponseEntity.ok(this.salaryService.insert(salary));
    }

    /**
     * 编辑数据
     *
     * @param salary 实体
     * @return 编辑结果
     */
    @PutMapping
    public ResponseEntity<Salary> edit(Salary salary) {
        return ResponseEntity.ok(this.salaryService.update(salary));
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @DeleteMapping
    public ResponseEntity<Boolean> deleteById(String id) {
        return ResponseEntity.ok(this.salaryService.deleteById(id));
    }

}


