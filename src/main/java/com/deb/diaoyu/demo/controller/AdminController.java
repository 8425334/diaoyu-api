package com.deb.diaoyu.demo.controller;

import com.deb.diaoyu.demo.exception.GlobalException;
import com.deb.diaoyu.demo.model.entity.Admin;
import com.deb.diaoyu.demo.model.param.LoginParam;
import com.deb.diaoyu.demo.model.result.Result;
import com.deb.diaoyu.demo.model.result.ResultCode;
import com.deb.diaoyu.demo.model.result.ResultUtil;
import com.deb.diaoyu.demo.model.vo.AdminVO;
import com.deb.diaoyu.demo.security.jwt.JWT;
import com.deb.diaoyu.demo.service.AdminService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

/**
 * 管理员控制层
 */
@RestController
@RequestMapping("/admin")
@Slf4j
public class AdminController {

    @Autowired
    private AdminService adminService;
    @Autowired
    private JWT jwt;

    @PostMapping("/login")
    public Result login(@RequestBody @Valid  LoginParam param, HttpServletRequest request) {
        //从session中提取验证码
        String captcha = (String)request.getSession().getAttribute("captcha");
        //检查验证码合法性
        if (!param.getVerify().equals(captcha)){
            throw new GlobalException(ResultCode.CAPTCHA_INVALID);
        }
        Admin admin = adminService.login(param);
        //擦除session存储的验证码
        request.getSession().removeAttribute("captcha");
        //生成token
        String token = jwt.getToken(String.valueOf(admin.getId()));
        return ResultUtil.success(new AdminVO(admin, token));
    }

    @PostMapping("/reg")
    public Object reg(@RequestBody Admin admin){
        adminService.reg(admin);
        return "cuowu";
    }


}
