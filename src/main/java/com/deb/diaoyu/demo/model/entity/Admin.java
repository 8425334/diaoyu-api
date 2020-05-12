package com.deb.diaoyu.demo.model.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;

/**
 * 管理员
 */
@Entity
@EqualsAndHashCode(callSuper = true)
@Data
@ToString
@Table(name = "g_admin")
public class Admin extends BaseEntity {
    /**
     * 主键
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 用户名
     */
    @Column(nullable = false)
    private String username;

    /**
     * 密码
     */
    @Column(nullable = false)
    private String password;

    /**
     * 超级管理员 0:否 1:是
     */
    @Column(length = 1)
    @ColumnDefault(value = "0")
    private Integer isSuper;

    private String nickname;

    @Override
    public void prePersist() {
        super.prePersist();
        if (isSuper == null){
            isSuper = 0;
        }
        if (nickname == null){
            nickname = "管理员";
        }
    }
}
