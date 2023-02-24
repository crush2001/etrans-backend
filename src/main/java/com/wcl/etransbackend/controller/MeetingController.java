package com.wcl.etransbackend.controller;

import com.github.pagehelper.PageInfo;
import com.wcl.etransbackend.domain.Meeting;
import com.wcl.etransbackend.service.MeetingService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import javax.annotation.Resource;

/**
 * (Meeting)表控制层
 *
 * @author crush
 * @since 2023-02-19 11:46:59
 */
@RestController
@RequestMapping("meeting")
public class MeetingController {
    /**
     * 服务对象
     */
    @Resource
    private MeetingService meetingService;

    /**
     * 查询所有数据
     *
     * @return 实例对象集合
     */
    @GetMapping
    public ResponseEntity<List> queryAll() {
        return ResponseEntity.ok(this.meetingService.queryAll());
    }

    @RequestMapping("/list")
    public PageInfo<Meeting> queryAllByPage(@RequestParam(value = "pageNum",required = false,defaultValue = "1")Integer pageNum,
                                            @RequestParam(value = "pageSize",required = false,defaultValue = "3")Integer pageSize) {
        return this.meetingService.queryAllByPage(pageNum, pageSize);
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public ResponseEntity<Meeting> queryById(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(this.meetingService.queryById(id));
    }

    @GetMapping("/search")
    public ResponseEntity<List> queryByMeetingTheme(String singleParticipant,String meetingTheme) {
        return ResponseEntity.ok(this.meetingService.queryByMeetingTheme(singleParticipant, meetingTheme));
    }

    @GetMapping("/queryByTheme")
    public ResponseEntity<List> queryByTheme(String meetingTheme) {
        return ResponseEntity.ok(this.meetingService.queryByTheme(meetingTheme));
    }

    @GetMapping("/queryMyMeeting")
    public PageInfo<Meeting> queryMyMeeting(@RequestParam(value = "pageNum",required = false,defaultValue = "1")Integer pageNum,
                                            @RequestParam(value = "pageSize",required = false,defaultValue = "3")Integer pageSize,
                                            String singleParticipant) {
        return this.meetingService.queryMyMeeting(singleParticipant,pageNum,pageSize);
    }

    /**
     * 新增数据
     *
     * @param meeting 实体
     * @return 新增结果
     */
    @PostMapping
    public ResponseEntity<Meeting> add(Meeting meeting) {
        return ResponseEntity.ok(this.meetingService.insert(meeting));
    }

    /**
     * 编辑数据
     *
     * @param meeting 实体
     * @return 编辑结果
     */
    @PutMapping
    public ResponseEntity<Meeting> edit(Meeting meeting) {
        return ResponseEntity.ok(this.meetingService.update(meeting));
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @DeleteMapping
    public ResponseEntity<Boolean> deleteById(Integer id) {
        return ResponseEntity.ok(this.meetingService.deleteById(id));
    }

}


