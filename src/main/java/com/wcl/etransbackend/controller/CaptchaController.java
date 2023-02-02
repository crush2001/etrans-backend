package com.wcl.etransbackend.controller;

import com.wf.captcha.SpecCaptcha;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
public class CaptchaController {
    public static final String SESSION_KEY = "captcha";
    @RequestMapping("getCaptcha")
    public void getCaptcha(HttpServletRequest request, HttpServletResponse response) throws Exception {
        SpecCaptcha captcha = new SpecCaptcha();
        captcha.setLen(5);
        String result = captcha.text();
        request.getSession().setAttribute(SESSION_KEY, result.toLowerCase());
        captcha.out(response.getOutputStream());
    }
}
