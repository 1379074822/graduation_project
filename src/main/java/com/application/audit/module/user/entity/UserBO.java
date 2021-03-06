package com.application.audit.module.user.entity;

import jdk.nashorn.internal.ir.annotations.Ignore;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;
import java.util.List;

/**
 * @description:
 * @author:
 * @time: 2020/3/7 10:59
 */
@Entity(name = "UserBO")
@Table(name = "t_user")
@Data
public class UserBO {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "user_name", nullable = false)
    private String userName;

    @Column(name = "login_account",nullable = false)
    private String loginAccount;

    @Column(name = "password",nullable = false)
    private String password;

    @Column(name = "phone_num")
    private String phoneNum;
    @Column(name = "age",nullable = false)
    private Integer age;
    @Column(name = "gender",nullable = true)
    private Integer gender;
    @Column(name = "profession",nullable = false)
    private Integer profession;
    @Column(name = "status",nullable = false)
    private Integer status;
    @Column(name = "type",nullable = false)
    private Integer type;
    @Column(name = "ticket",nullable = false)
    private Integer ticket;
    @Column(name = "create_time")
    private Date createTime;
    @Column(name = "level")
    private String level;

    @Column(name = "work_perform")
    private String workPerform;
    @Column(name = "research_result")
    private String researchResult;

    private String statusDesc;
    private String genderDesc;
    private String  createTimeDesc;
    private String  professionDesc;
    private String newPassword;
    private Integer isTemplate;
    @ElementCollection
    private List<String> paperworks;
}
