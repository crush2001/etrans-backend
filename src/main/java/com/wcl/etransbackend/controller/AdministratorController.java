package com.wcl.etransbackend.controller;

import cn.dev33.satoken.stp.SaTokenInfo;
import cn.dev33.satoken.stp.StpUtil;
import com.wcl.etransbackend.common.CommonResult;
import com.wcl.etransbackend.domain.Administrator;
import com.wcl.etransbackend.service.AdministratorService;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.ResponseEntity;
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
 * (Administrator)表控制层
 *
 * @author crush
 * @since 2023-01-12 00:03:58
 */
@RestController
@RequestMapping("administrator")
public class AdministratorController {
    /**
     * 服务对象
     */
    @Resource
    private AdministratorService administratorService;

    /**
     * 查询所有数据
     *
     * @return 实例对象集合
     */
    @GetMapping
    public ResponseEntity<List> queryAll() {
        return ResponseEntity.ok(this.administratorService.queryAll());
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public ResponseEntity<Administrator> queryById(@PathVariable("id") String id) {
        return ResponseEntity.ok(this.administratorService.queryById(id));
    }

    /**
     * 新增数据
     *
     * @param administrator 实体
     * @return 新增结果
     */
    @PostMapping
    public ResponseEntity<Administrator> add(Administrator administrator) {
        return ResponseEntity.ok(this.administratorService.insert(administrator));
    }

    /**
     * 编辑数据
     *
     * @param administrator 实体
     * @return 编辑结果
     */
    @PutMapping
    public ResponseEntity<Administrator> edit(Administrator administrator) {
        return ResponseEntity.ok(this.administratorService.update(administrator));
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @DeleteMapping
    public ResponseEntity<Boolean> deleteById(String id) {
        return ResponseEntity.ok(this.administratorService.deleteById(id));
    }

    // 登录认证
    @ApiOperation(value = "登录后返回token")
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult login(@RequestParam String adminAccount, @RequestParam String adminPassword, @RequestParam String inputCaptcha) {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        String authenticCaptcha = (String) request.getSession().getAttribute(SESSION_KEY);
        SaTokenInfo saTokenInfo = administratorService.login(adminAccount, adminPassword);
        if (saTokenInfo == null) {
            return CommonResult.error("用户名或密码错误");
        }
        if (!inputCaptcha.equalsIgnoreCase(authenticCaptcha)) {
            return CommonResult.error("验证码错误");
        }
        Map<String, String> tokenMap = new HashMap<>();
        tokenMap.put("token", saTokenInfo.getTokenValue());
        tokenMap.put("tokenHead", saTokenInfo.getTokenName());
        System.out.println(tokenMap.get("token"));
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


