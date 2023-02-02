package com.wcl.etransbackend.controller;

import com.github.pagehelper.PageInfo;
import com.wcl.etransbackend.domain.Announcement;
import com.wcl.etransbackend.service.AnnouncementService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import javax.annotation.Resource;

/**
 * (Announcement)表控制层
 *
 * @author crush
 * @since 2023-01-12 00:04:00
 */
@RestController
@RequestMapping("announcement")
public class AnnouncementController {
    /**
     * 服务对象
     */
    @Resource
    private AnnouncementService announcementService;

    /**
     * 查询所有数据
     *
     * @return 实例对象集合
     */
    @GetMapping
    public ResponseEntity<List> queryAll() {
        return ResponseEntity.ok(this.announcementService.queryAll());
    }

    // 分页查询
    @RequestMapping("/list")
    public PageInfo<Announcement> queryAllByPage(@RequestParam(value = "pageNum",required = false,defaultValue = "1")Integer pageNum,
                                            @RequestParam(value = "pageSize",required = false,defaultValue = "3")Integer pageSize) {
        return this.announcementService.queryAllByPage(pageNum, pageSize);
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public ResponseEntity<Announcement> queryById(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(this.announcementService.queryById(id));
    }

    @GetMapping("/search")
    public ResponseEntity<List> queryAnnouncementByTitle(String announcementTitle) {
        return ResponseEntity.ok(this.announcementService.queryAnnouncementByTitle((announcementTitle)));
    }

    /**
     * 新增数据
     *
     * @param announcement 实体
     * @return 新增结果
     */
    @PostMapping
    public ResponseEntity<Announcement> add(Announcement announcement) {
        return ResponseEntity.ok(this.announcementService.insert(announcement));
    }

    /**
     * 编辑数据
     *
     * @param announcement 实体
     * @return 编辑结果
     */
    @PutMapping
    public ResponseEntity<Announcement> edit(Announcement announcement) {
        return ResponseEntity.ok(this.announcementService.update(announcement));
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @DeleteMapping
    public ResponseEntity<Boolean> deleteById(Integer id) {
        return ResponseEntity.ok(this.announcementService.deleteById(id));
    }

    // 统计总行数
    @GetMapping("/count")
    public ResponseEntity<Long> count(Announcement announcement) {
        return ResponseEntity.ok(this.announcementService.count(announcement));
    }

}


