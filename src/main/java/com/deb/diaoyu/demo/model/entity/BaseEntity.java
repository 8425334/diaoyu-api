package com.deb.diaoyu.demo.model.entity;

import com.deb.diaoyu.demo.util.DateUtil;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import java.util.Date;

/**
 * 基础实体
 */
@MappedSuperclass
@ToString
@Data
@EqualsAndHashCode
public class BaseEntity {
    private Date createTime;
    private Date updateTime;

    @PrePersist
    public void prePersist(){
        Date now = DateUtil.now();
        if (createTime == null){
            createTime = now;
        }
        if (updateTime == null){
            updateTime = now;
        }
    }

    @PreUpdate
    public void preUpdate(){
        updateTime = DateUtil.now();
    }
}
