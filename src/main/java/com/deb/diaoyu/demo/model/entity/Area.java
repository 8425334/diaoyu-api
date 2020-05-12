package com.deb.diaoyu.demo.model.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.*;

/**
 * 游戏大区
 */
@Data
@Entity
@EqualsAndHashCode(callSuper = true)
@ToString
@Table(name = "g_area")
public class Area extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    /**
     * 大区名字
     */
    @Column(nullable = false)
    private String areaName;

}