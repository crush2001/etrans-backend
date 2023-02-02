package com.wcl.etransbackend.controller;

import cn.dev33.satoken.stp.SaTokenInfo;
import cn.dev33.satoken.stp.StpUtil;
import com.github.pagehelper.PageInfo;
import com.wcl.etransbackend.common.CommonResult;
import com.wcl.etransbackend.domain.Staff;
import com.wcl.etransbackend.service.StaffService;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import static com.wcl.etransbackend.controller.CaptchaController.SESSION_KEY;

/**
 * (Staff)表控制层
 *
 * @author crush
 * @since 2023-01-12 00:04:04
 */
@RestController
@RequestMapping("staff")
public class StaffController {
    /**
     * 服务对象
     */
    @Resource
    private StaffService staffService;

    /**
     * 查询所有数据
     *
     * @return 实例对象集合
     */
    @GetMapping
    public ResponseEntity<List> queryAll() {
        return ResponseEntity.ok(this.staffService.queryAll());
    }

    @GetMapping("/gainStaffInfo")
    public ResponseEntity<List> gainStaffInfo() {
        return ResponseEntity.ok(this.staffService.gainStaffInfo());
    }

    // 分页查询
    @RequestMapping("/list")
    public PageInfo<Staff> queryAllByPage(@RequestParam(value = "pageNum",required = false,defaultValue = "1")Integer pageNum,
                                               @RequestParam(value = "pageSize",required = false,defaultValue = "3")Integer pageSize){
        return this.staffService.queryAllByPage(pageNum, pageSize);
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public ResponseEntity<Staff> queryById(@PathVariable("id") String id) {
        return ResponseEntity.ok(this.staffService.queryById(id));
    }

    @GetMapping("/search")
    public ResponseEntity<List> queryByTrueName(String staffTrueName) {
        return ResponseEntity.ok(this.staffService.queryByTrueName(staffTrueName));
    }

    @GetMapping("/queryGroupByStaffPosition")
    public ResponseEntity<List> queryGroupByStaffPosition() {
        return ResponseEntity.ok(this.staffService.queryGroupByStaffPosition());
    }

    @GetMapping("/queryGroupByStaffStatus")
    public ResponseEntity<List> queryGroupByStaffStatus() {
        return ResponseEntity.ok(this.staffService.queryGroupByStaffStatus());
    }

    /**
     * 新增数据
     *
     * @param staff 实体
     * @return 新增结果
     */
    @PostMapping
    public ResponseEntity<Staff> add(Staff staff) {
        return ResponseEntity.ok(this.staffService.insert(staff));
    }

    /**
     * 编辑数据
     *
     * @param staff 实体
     * @return 编辑结果
     */
    @PutMapping
    public ResponseEntity<Staff> edit(Staff staff) {
        return ResponseEntity.ok(this.staffService.update(staff));
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @DeleteMapping
    public ResponseEntity<Boolean> deleteById(String id) {
        return ResponseEntity.ok(this.staffService.deleteById(id));
    }

    // 统计总行数
    @GetMapping("/count")
    public ResponseEntity<Long> count(Staff staff) {
        return ResponseEntity.ok(this.staffService.count(staff));
    }

    // 登录认证
    @ApiOperation(value = "登录后返回token")
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult login(@RequestParam String staffAccount, @RequestParam String staffPassword, @RequestParam String inputCaptcha) {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        String authenticCaptcha = (String) request.getSession().getAttribute(SESSION_KEY);
        SaTokenInfo saTokenInfo = staffService.login(staffAccount, staffPassword);
        if (saTokenInfo == null) {
            return CommonResult.error("用户名或密码错误");
        }
        if (!inputCaptcha.equalsIgnoreCase(authenticCaptcha)) {
            return CommonResult.error("验证码错误");
        }
        Map<String, String> tokenMap = new HashMap<>();
        tokenMap.put("token", saTokenInfo.getTokenValue());
        tokenMap.put("tokenHead", saTokenInfo.getTokenName());
        return CommonResult.success(tokenMap);
    }

    //查询当前登录状态
    @ApiOperation(value = "查询当前登录状态")
    @RequestMapping(value = "/isLogin", method = RequestMethod.GET)
    public CommonResult isLogin() {
        return CommonResult.success(StpUtil.isLogin());
    }

    //查询当前登录信息
    @ApiOperation(value = "查询当前登录信息")
    @RequestMapping(value = "/tokenInfo", method = RequestMethod.GET)
    public CommonResult tokenInfo() {
        return CommonResult.success(StpUtil.getTokenInfo());
    }

    // 查询当前登录ID
    @ApiOperation(value = "查询当前登录ID")
    @RequestMapping(value = "/getLoginId", method = RequestMethod.GET)
    public CommonResult getLoginId(@RequestParam String token) {
        return CommonResult.success(StpUtil.getLoginIdByToken(token));
    }

    // 注销登录
    @ApiOperation(value = "注销当前登录的账号")
    @RequestMapping(value = "/logout", method = RequestMethod.POST)
    public CommonResult logout() {
        //System.out.println(StpUtil.getTokenValue());
        StpUtil.logoutByTokenValue(StpUtil.getTokenValue());
        return CommonResult.success("注销成功");
    }
}


