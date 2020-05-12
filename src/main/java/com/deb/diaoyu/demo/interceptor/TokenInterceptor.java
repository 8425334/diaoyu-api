package com.deb.diaoyu.demo.interceptor;

import com.deb.diaoyu.demo.exception.GlobalException;
import com.deb.diaoyu.demo.security.jwt.JWT;
import io.jsonwebtoken.Claims;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class TokenInterceptor implements HandlerInterceptor {

    @Autowired
    private JWT jwt;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String token = request.getHeader(jwt.getHeader());
        //未登录时header的token为空
        if (token == null){
            throw new GlobalException(1002, "您还未登录");
        }
        Claims claims = jwt.getClaims(token);
        //验证token是否过期
        if (jwt.isExpire(claims.getExpiration())){
            throw new GlobalException(1003 ,"token过期");
        }
        return true;
    }
}
