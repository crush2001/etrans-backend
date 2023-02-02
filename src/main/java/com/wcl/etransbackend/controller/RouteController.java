package com.wcl.etransbackend.controller;

import com.github.pagehelper.PageInfo;
import com.wcl.etransbackend.domain.Route;
import com.wcl.etransbackend.service.RouteService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import javax.annotation.Resource;

/**
 * (Route)表控制层
 *
 * @author crush
 * @since 2023-01-12 00:04:01
 */
@RestController
@RequestMapping("route")
public class RouteController {
    /**
     * 服务对象
     */
    @Resource
    private RouteService routeService;

    /**
     * 查询所有数据
     *
     * @return 实例对象集合
     */
    @GetMapping
    public ResponseEntity<List> queryAll() {
        return ResponseEntity.ok(this.routeService.queryAll());
    }

    // 分页查询
    @GetMapping("/list")
    public PageInfo<Route> queryAllByPage(@RequestParam(value = "pageNum",required = false,defaultValue = "1")Integer pageNum,
                                          @RequestParam(value = "pageSize",required = false,defaultValue = "3")Integer pageSize) {
        return this.routeService.queryAllByPage(pageNum, pageSize);
    }

    @GetMapping("/gainRouteInfo")
    public ResponseEntity<List> gainRouteInfo() {
        return ResponseEntity.ok(this.routeService.gainRouteInfo());
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public ResponseEntity<Route> queryById(@PathVariable("id") String id) {
        return ResponseEntity.ok(this.routeService.queryById(id));
    }

    @GetMapping("/search")
    public ResponseEntity<List> queryRouteByNumber(String routeNumber) {
        return ResponseEntity.ok(this.routeService.queryRouteByNumber(routeNumber));
    }

    @GetMapping("/queryDriverRoute")
    public ResponseEntity<List> queryDriverRoute(String[] routeNumber) {
        return ResponseEntity.ok(this.routeService.queryDriverRoute(routeNumber));
    }

    /**
     * 新增数据
     *
     * @param route 实体
     * @return 新增结果
     */
    @PostMapping
    public ResponseEntity<Route> add(Route route) {
        return ResponseEntity.ok(this.routeService.insert(route));
    }

    /**
     * 编辑数据
     *
     * @param route 实体
     * @return 编辑结果
     */
    @PutMapping
    public ResponseEntity<Route> edit(Route route) {
        return ResponseEntity.ok(this.routeService.update(route));
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @DeleteMapping
    public ResponseEntity<Boolean> deleteById(String id) {
        return ResponseEntity.ok(this.routeService.deleteById(id));
    }

    // 统计总行数
    @GetMapping("/count")
    public ResponseEntity<Long> count(Route route) {
        return ResponseEntity.ok(this.routeService.count(route));
    }

}


