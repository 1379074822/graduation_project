package com.application.audit.module.works.entity;

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
 * @time: 2020/3/7 17:07
 */
@Entity(name = "WorksBO")
@Table(name = "t_works")
@Data
public class WorksBO {
    /**
     * 作品表主键id
     **/
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    /**
     * 创建人id
     **/
    @Column(name = "create_id", nullable = false)
    private Long createId;
    /**
     * 创建人
     **/
    @Column(name = "create_name", nullable = false)
    private String createName;
    /**
     * 创建时间
     **/
    @Column(name = "create_time", nullable = false)
    private Date createTime;
    /**
     * 文件路径
     **/
    @Column(name = "file_url", nullable = false)
    private String fileUrl;

    /**
     * 修改id
     **/
    @Column(name = "modify_id", nullable = false)
    private Long modifyId;
    /**
     * 修改人
     **/
    @Column(name = "modify_name", nullable = false)
    private String modifyName;
    /**
     * 修改时间
     **/
    @Column(name = "modify_time", nullable = false)
    private Date modifyTime;
    /**
     * 作品介绍
     **/
    @Column(name = "works_desc", nullable = false)
    private String worksDesc;
    /**
     * 作品名
     **/
    @Column(name = "works_name", nullable = false)
    private String worksName;
    /**
     * 批次
     **/
    @Column(name = "batch", nullable = false)
    private Integer batch;

    /**
     * 状态
     **/
    @Column(name = "status", nullable = false)
    private Integer status;

    /**
     * 类型
     **/
    @Column(name = "type", nullable = false)
    private Integer type;
}
