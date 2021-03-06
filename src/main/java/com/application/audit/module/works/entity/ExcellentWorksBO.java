package com.application.audit.module.works.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @description:
 * @author:
 * @time: 2020/3/7 17:13
 */
@Entity(name = "ExcellentWorksBO")
@Table(name = "t_excellent_works")
@Data
public class ExcellentWorksBO {
    /**
     * 优秀作品表主键
     **/
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    /**
     * 批次
     **/
    @Column(name = "batch", nullable = false)
    private Integer batch;
    /**
     * 票数
     **/
    @Column(name = "rate", nullable = false)
    private Integer rate;
    /**
     * 作品id
     **/
    @Column(name = "works_id", nullable = false)
    private Long worksId;
}
