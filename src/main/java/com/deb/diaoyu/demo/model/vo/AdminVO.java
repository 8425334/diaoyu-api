package com.deb.diaoyu.demo.model.vo;

import com.deb.diaoyu.demo.model.entity.Admin;
import lombok.Data;
import org.springframework.beans.BeanUtils;

/**
 * 管理员视图对象
 */
@Data
public class AdminVO {

    private String nickname;
    private String username;
    private int isSuper;
    private String token;

    public AdminVO(Admin admin, String token) {
        //将admin的属性赋值到this
        BeanUtils.copyProperties(admin, this);
        this.token = token;
//        nickname = admin.getNickname();
//        username = admin.getUsername();
//        isSuper = admin.getIsSuper();
    }
}
