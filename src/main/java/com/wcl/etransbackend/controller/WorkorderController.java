package com.wcl.etransbackend.controller;

import com.github.pagehelper.PageInfo;
import com.wcl.etransbackend.domain.Workorder;
import com.wcl.etransbackend.service.WorkorderService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import javax.annotation.Resource;

/**
 * (Workorder)表控制层
 *
 * @author crush
 * @since 2023-01-12 00:04:07
 */
@RestController
@RequestMapping("workorder")
public class WorkorderController {
    /**
     * 服务对象
     */
    @Resource
    private WorkorderService workorderService;

    /**
     * 查询所有数据
     *
     * @return 实例对象集合
     */
    @GetMapping
    public ResponseEntity<List> queryAll() {
        return ResponseEntity.ok(this.workorderService.queryAll());
    }

    // 分页查询
    @GetMapping("/list")
    public PageInfo<Workorder> queryAllByPage(@RequestParam(value = "pageNum",required = false,defaultValue = "1")Integer pageNum,
                                              @RequestParam(value = "pageSize",required = false,defaultValue = "3")Integer pageSize) {
        return this.workorderService.queryAllByPage(pageNum, pageSize);
    }

    @GetMapping("/listOwnWorkorder")
    public PageInfo<Workorder> queryOwnWorkorderByPage(@RequestParam(value = "workorderPublisher",required = true)String workorderPublisher,
                                                       @RequestParam(value = "pageNum",required = false,defaultValue = "1")Integer pageNum,
                                                       @RequestParam(value = "pageSize",required = false,defaultValue = "3")Integer pageSize) {
        return this.workorderService.queryOwnWorkorderByPage(workorderPublisher, pageNum, pageSize);
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public ResponseEntity<Workorder> queryById(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(this.workorderService.queryById(id));
    }

    @GetMapping("/search")
    public ResponseEntity<List> queryWorkorderByStaff(String workorderPublisher) {
        return ResponseEntity.ok(this.workorderService.queryWorkorderByStaff(workorderPublisher));
    }

    @GetMapping("/searchTitle")
    public ResponseEntity<List> queryWorkorderByStaffAndTitle(String workorderPublisher, String workorderTitle) {
        return ResponseEntity.ok(this.workorderService.queryWorkorderByStaffAndTitle(workorderPublisher, workorderTitle));
    }

    @GetMapping("/queryGroupByWorkorderType")
    public ResponseEntity<List> queryGroupByWorkorderType() {
        return ResponseEntity.ok(this.workorderService.queryGroupByWorkorderType());
    }

    @GetMapping("/queryGroupByWorkorderStatus")
    public ResponseEntity<List> queryGroupByWorkorderStatus() {
        return ResponseEntity.ok(this.workorderService.queryGroupByWorkorderStatus());
    }

    /**
     * 新增数据
     *
     * @param workorder 实体
     * @return 新增结果
     */
    @PostMapping
    public ResponseEntity<Workorder> add(Workorder workorder) {
        return ResponseEntity.ok(this.workorderService.insert(workorder));
    }

    /**
     * 编辑数据
     *
     * @param workorder 实体
     * @return 编辑结果
     */
    @PutMapping
    public ResponseEntity<Workorder> edit(Workorder workorder) {
        return ResponseEntity.ok(this.workorderService.update(workorder));
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @DeleteMapping
    public ResponseEntity<Boolean> deleteById(Integer id) {
        return ResponseEntity.ok(this.workorderService.deleteById(id));
    }

    // 统计总行数
    @GetMapping("/count")
    public ResponseEntity<Long> count(Workorder workorder) {
        return ResponseEntity.ok(this.workorderService.count(workorder));
    }

}


