package com.application.audit.module.user.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

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
    @GeneratedValue
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


}
