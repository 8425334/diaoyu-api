package com.deb.diaoyu.demo.security.shiro;

import lombok.Data;
import lombok.ToString;

@ToString
@Data
public class Permissions {
    private int id;

    /**
     * 对应权限的名称
     */
    private String permissionName;

}
