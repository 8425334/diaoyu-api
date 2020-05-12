package com.deb.diaoyu.demo.security.shiro;

import com.deb.diaoyu.demo.security.shiro.Permissions;
import lombok.Data;
import lombok.ToString;

import java.util.Set;

/**
 * 用户权限管理 shiro
 */
@ToString
@Data
public class Role {
    private int id;
    /**
     * 角色名称
     */
    private String roleName;

    /**
     * 角色对应权限集合
     */
    private Set<Permissions> permissions;
}
