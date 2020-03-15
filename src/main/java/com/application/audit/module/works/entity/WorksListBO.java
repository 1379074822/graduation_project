package com.application.audit.module.works.entity;

import lombok.Data;

import javax.persistence.Id;
import java.util.Date;

/**
 * @description:
 * @author:
 * @time: 2020/3/7 17:07
 */

@Data
public class WorksListBO {
    public WorksListBO() {
    }

    /**
     * 作品表主键id
     **/
    @Id
    private Long id;
    /**
     * 创建人id
     **/
    private Long createId;
    /**
     * 创建人
     **/
    private String createName;
    /**
     * 创建时间
     **/
    private Date createTime;
    /**
     * 创建字符串
     **/
    private String createTimeDesc;

    /**
     * 状态
     **/
    private Integer status;
    /**
     * 状态
     **/
    private String statusDesc;



    /**
     * 文件路径
     **/
    private String fileUrl;

    /**
     * 修改id
     **/
    private Long modifyId;
    /**
     * 修改人
     **/
    private String modifyName;
    /**
     * 修改时间
     **/
    private Date modifyTime;
    /**
     * 作品介绍
     **/
    private String worksDesc;
    /**
     * 作品名
     **/
    private String worksName;

    /**
     * 总分/票数
     */
    private Float score;



    /**
     * 批次
     **/
    private Integer batch;
    /**
     * 意见
     **/
    private String opinion;

    /**
     * 轮次
     **/
    private Integer rounds;

    public WorksListBO(Long id, Long createId, String createName, Date createTime, String fileUrl, Long modifyId, String modifyName, Date modifyTime, String worksDesc, String worksName, Float score, Integer batch, String opinion, Integer rounds) {
        this.id = id;
        this.createId = createId;
        this.createName = createName;
        this.createTime = createTime;
        this.fileUrl = fileUrl;
        this.modifyId = modifyId;
        this.modifyName = modifyName;
        this.modifyTime = modifyTime;
        this.worksDesc = worksDesc;
        this.worksName = worksName;
        this.score = score;
        this.batch = batch;
        this.opinion = opinion;
        this.rounds = rounds;
    }


}
