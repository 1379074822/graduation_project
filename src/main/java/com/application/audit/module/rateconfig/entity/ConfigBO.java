package com.application.audit.module.rateconfig.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @description:
 * @author:
 * @time: 2020/3/7 17:18
 */
@Entity(name = "WorksBO")
@Table(name = "t_works")
@Data
public class ConfigBO {
    /**
     * 配置表主键
     **/
    @Id
    @GeneratedValue
    private Long id;
    /**
     * 通过人数启用状态
     **/
    @Column(name = "num_status", nullable = false)
    private Integer numStatus;
    /**
     * 通过人数
     **/
    @Column(name = "pass_num", nullable = false)
    private Integer passNum;
    /**
     * 通过率
     **/
    @Column(name = "pass_rate", nullable = false)
    private Float passRate;
    /**
     * 通过率启用状态
     **/
    @Column(name = "rate_status", nullable = false)
    private Integer rateStatus;
}
