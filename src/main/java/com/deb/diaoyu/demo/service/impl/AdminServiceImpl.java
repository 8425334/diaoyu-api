package com.deb.diaoyu.demo.service.impl;

import com.deb.diaoyu.demo.exception.GlobalException;
import com.deb.diaoyu.demo.model.entity.Admin;
import com.deb.diaoyu.demo.model.param.LoginParam;
import com.deb.diaoyu.demo.repository.AdminRepository;
import com.deb.diaoyu.demo.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    private AdminRepository repository;

    @Override
    public Admin login(LoginParam param) {
        //从数据库中寻找用户 找不到就抛出异常
        return repository.findAdminByUsernameAndPassword(param.getUsername(), param.getPassword())
                .orElseThrow(() -> new GlobalException(1001 ,"账号或密码错误"));
    }

    @Override
    public void reg(Admin admin) {
        //先查找一下用户是否存在
        if (repository.existsAdminByUsername(admin.getUsername())){
            throw new GlobalException(1000, "admin exist");
        }
        //保存用户
        repository.save(admin);
    }
}
