package com.deb.diaoyu.demo.model.entity;

import com.deb.diaoyu.demo.model.entity.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import javax.persistence.*;

@Entity
@Data
@EqualsAndHashCode(callSuper = true)
@Table(name = "g_user")
@ToString
public class User extends BaseEntity {

    /**
     * 主键
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    /**
     * 账号
     */
    @Column(nullable = false, length = 64)
    private String username;

    /**
     * 密码
     */
    @Column(nullable = false, length = 64)
    private String password;

    /**
     * 游戏大区
     */
    @Column(nullable = false)
    private int areaId;

}
