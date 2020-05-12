package com.deb.diaoyu.demo.controller;

import cn.hutool.captcha.CaptchaUtil;
import cn.hutool.captcha.CircleCaptcha;

import org.springframework.cache.Cache;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.imageio.stream.ImageOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.awt.image.BufferedImage;

@Controller
public class VerifyController {

    /**
     * 验证码生成接口
     */
    @GetMapping(value = "/verify", produces = {MediaType.IMAGE_PNG_VALUE})
    @ResponseBody
    public byte[] verify(HttpServletRequest request){
        CircleCaptcha captcha = CaptchaUtil.createCircleCaptcha(200,50);
        //将验证码储存到session中
        request.getSession().setAttribute("captcha", captcha.getCode());
        return captcha.getImageBytes();
    }
}
