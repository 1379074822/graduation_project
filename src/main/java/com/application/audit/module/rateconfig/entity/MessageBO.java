package com.application.audit.module.rateconfig.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * @description:
 * @author:
 * @time: 2020/3/7 17:18
 */
@Entity(name = "MessageBO")
@Table(name = "t_message")
@Data
public class MessageBO {
    /**
     * 配置表主键
     **/
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    /**
     * 评论id
     **/
    @Column(name = "user_id", nullable = false)
    private Long userId;
    /**
     * 内容
     **/
    @Column(name = "text", nullable = false)
    private String text;
    /**
     * 生成时间
     **/
    @Column(name = "create_time", nullable = false)
    private Date createTime;
    /**
     * 等级
     **/
    @Column(name = "level", nullable = false)
    private Integer level;


    private String userName;

    public MessageBO() {
    }

    public MessageBO( String text, Date createTime, Integer level, String userName) {
        this.text = text;
        this.createTime = createTime;
        this.level = level;
        this.userName = userName;
    }
}
