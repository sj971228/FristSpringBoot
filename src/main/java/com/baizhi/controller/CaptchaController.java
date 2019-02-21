package com.baizhi.controller;

import cn.hutool.captcha.CaptchaUtil;
import cn.hutool.captcha.CircleCaptcha;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.OutputStream;

@Controller
@RequestMapping("/captcha")
public class CaptchaController {
    @Autowired
    private HttpSession session;

    @RequestMapping("/cap")
    public void captcha(HttpServletResponse response) throws IOException {
        //获得一个验证码对象
        CircleCaptcha Captcha = CaptchaUtil.createCircleCaptcha(80, 30, 4, 2);
        //获得验证码图片中的字符串
        String code = Captcha.getCode();
        session.setAttribute("code",code);
        //
        OutputStream os = response.getOutputStream();
        Captcha.write(os);
    }

}
