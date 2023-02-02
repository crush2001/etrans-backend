package com.wcl.etransbackend.controller;

import com.github.pagehelper.PageInfo;
import com.wcl.etransbackend.domain.Schedule;
import com.wcl.etransbackend.service.ScheduleService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import javax.annotation.Resource;

/**
 * (Schedule)表控制层
 *
 * @author crush
 * @since 2023-01-23 20:40:45
 */
@RestController
@RequestMapping("schedule")
public class ScheduleController {
    /**
     * 服务对象
     */
    @Resource
    private ScheduleService scheduleService;

    /**
     * 查询所有数据
     *
     * @return 实例对象集合
     */
    @GetMapping
    public ResponseEntity<List> queryAll() {
        return ResponseEntity.ok(this.scheduleService.queryAll());
    }

    // 分页查询
    @RequestMapping("/list")
    public PageInfo<Schedule> queryAllByPage(@RequestParam(value = "pageNum",required = false,defaultValue = "1")Integer pageNum,
                                             @RequestParam(value = "pageSize",required = false,defaultValue = "3")Integer pageSize) {
        return this.scheduleService.queryAllByPage(pageNum, pageSize);
    }
    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public ResponseEntity<Schedule> queryById(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(this.scheduleService.queryById(id));
    }

    @GetMapping("/search")
    public ResponseEntity<List> queryScheduleByVehicle(String scheduledBus) {
        return ResponseEntity.ok(this.scheduleService.queryScheduleByVehicle(scheduledBus));
    }

    @GetMapping("/queryDriverSchedule")
    public ResponseEntity<List> queryDriverSchedule(String[] scheduledBus) {
        return ResponseEntity.ok(this.scheduleService.queryDriverSchedule(scheduledBus));
    }

    /**
     * 新增数据
     *
     * @param schedule 实体
     * @return 新增结果
     */
    @PostMapping
    public ResponseEntity<Schedule> add(Schedule schedule) {
        return ResponseEntity.ok(this.scheduleService.insert(schedule));
    }

    /**
     * 编辑数据
     *
     * @param schedule 实体
     * @return 编辑结果
     */
    @PutMapping
    public ResponseEntity<Schedule> edit(Schedule schedule) {
        return ResponseEntity.ok(this.scheduleService.update(schedule));
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @DeleteMapping
    public ResponseEntity<Boolean> deleteById(Integer id) {
        return ResponseEntity.ok(this.scheduleService.deleteById(id));
    }

    // 统计总行数
    @GetMapping("/count")
    public ResponseEntity<Long> count(Schedule schedule) {
        return ResponseEntity.ok(this.scheduleService.count(schedule));
    }
}


