package com.application.audit.module.score.entity;

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
 * @time: 2020/3/7 17:15
 */
@Entity(name = "ScoreBO")
@Table(name = "t_score")
@Data
public class ScoreBO {
    /**
     * 作品评分表主键id
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
     * 意见
     **/
    @Column(name = "opinion", nullable = false)
    private String opinion;
    /**
     * 评分人id
     **/
    @Column(name = "rater_id", nullable = false)
    private Long raterId;
    /**
     * 轮次
     **/
    @Column(name = "rounds", nullable = false)
    private Integer rounds;
    /**
     * 得分/票数
     **/
    @Column(name = "score", nullable = false)
    private Float score;
    /**
     * 评分时间
     **/
    @Column(name = "score_time", nullable = false)
    private Date scoreTime;
    /**
     * 作品id
     **/
    @Column(name = "works_id", nullable = false)
    private Integer worksId;
}
