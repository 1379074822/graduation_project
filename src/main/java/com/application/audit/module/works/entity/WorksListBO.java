package com.application.audit.module.works.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * @description:
 * @author:
 * @time: 2020/3/7 17:07
 */

@Data
public class WorksListBO {
    /**
     * 作品表主键id
     **/
    @Id
    private Long id;
    /**
     * 创建人id
     **/
    @JsonProperty( "create_id")
    private Long createId;
    /**
     * 创建人
     **/
    @JsonProperty(  "create_name")
    private String createName;
    /**
     * 创建时间
     **/
    @JsonProperty(  "create_time")
    private Date createTime;
    /**
     * 文件路径
     **/
    @JsonProperty(  "file_url")
    private String fileUrl;

    /**
     * 修改id
     **/
    @JsonProperty(  "modify_id")
    private Long modifyId;
    /**
     * 修改人
     **/
    @JsonProperty(  "modify_name")
    private String modifyName;
    /**
     * 修改时间
     **/
    @JsonProperty(  "modify_time")
    private Date modifyTime;
    /**
     * 作品介绍
     **/
    @JsonProperty(  "works_desc")
    private String worksDesc;
    /**
     * 作品名
     **/
    @JsonProperty(  "works_name")
    private String worksName;

    /**
     * 总分/票数
     */
    @JsonProperty(  "score")
    private Float score;

    /**
     * 排名
     */
    @JsonProperty(  "ranking")
    private Integer  ranking;

    /**
     * 批次
     **/
    @JsonProperty(  "batch")
    private Integer batch;
    /**
     * 意见
     **/
    @JsonProperty(  "opinion")
    private String opinion;

    /**
     * 轮次
     **/
    @JsonProperty(  "rounds")
    private Integer rounds;
}
