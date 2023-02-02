package com.wcl.etransbackend.controller;

import com.github.pagehelper.PageInfo;
import com.wcl.etransbackend.domain.Station;
import com.wcl.etransbackend.service.StationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import javax.annotation.Resource;

/**
 * (Station)表控制层
 *
 * @author crush
 * @since 2023-01-12 00:04:05
 */
@RestController
@RequestMapping("station")
public class StationController {
    /**
     * 服务对象
     */
    @Resource
    private StationService stationService;

    /**
     * 查询所有数据
     *
     * @return 实例对象集合
     */
    @GetMapping
    public ResponseEntity<List> queryAll() {
        return ResponseEntity.ok(this.stationService.queryAll());
    }

    // 分页查询
    @RequestMapping("/list")
    public PageInfo<Station> queryAllByPage(@RequestParam(value = "pageNum",required = false,defaultValue = "1")Integer pageNum,
                                            @RequestParam(value = "pageSize",required = false,defaultValue = "3")Integer pageSize){
        return this.stationService.queryAllByPage(pageNum, pageSize);
    }

    @GetMapping("/gainStationInfo")
    public ResponseEntity<List> gainStationInfo() {
        return ResponseEntity.ok(this.stationService.gainStationInfo());
    }

    /**
    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public ResponseEntity<Station> queryById(@PathVariable("id") String id) {
        return ResponseEntity.ok(this.stationService.queryById(id));
    }

    @GetMapping("/search")
    public ResponseEntity<List> queryStationByName(String stationName) {
        return ResponseEntity.ok(this.stationService.queryStationByName(stationName));
    }

    /**
     * 新增数据
     *
     * @param station 实体
     * @return 新增结果
     */
    @PostMapping
    public ResponseEntity<Station> add(Station station) {
        return ResponseEntity.ok(this.stationService.insert(station));
    }

    /**
     * 编辑数据
     *
     * @param station 实体
     * @return 编辑结果
     */
    @PutMapping
    public ResponseEntity<Station> edit(Station station) {
        return ResponseEntity.ok(this.stationService.update(station));
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @DeleteMapping
    public ResponseEntity<Boolean> deleteById(String id) {
        return ResponseEntity.ok(this.stationService.deleteById(id));
    }

    // 统计总行数
    @GetMapping("/count")
    public ResponseEntity<Long> count(Station station) {
        return ResponseEntity.ok(this.stationService.count(station));
    }
}


