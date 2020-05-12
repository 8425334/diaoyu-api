package com.deb.diaoyu.demo.service;

import com.deb.diaoyu.demo.model.entity.Admin;
import com.deb.diaoyu.demo.model.param.LoginParam;

/**
 * 管理员服务层
 */
public interface AdminService {
    /**
     * 管理员登录
     */
    Admin login(LoginParam param);

    void reg(Admin admin);
}
