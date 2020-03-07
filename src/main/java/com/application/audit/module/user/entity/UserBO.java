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
public class UserBO {


    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "user_name", nullable = false, unique = true)
    private String userName;

    @Column(name = "login_account",nullable = false)
    private String loginAccount;

    @Column(name = "password",nullable = false, unique = true)
    private String password;

    @Column(name = "phone_num",nullable = true, unique = true)
    private String phoneNum;
    @Column(name = "age",nullable = false)
    private Integer age;
    @Column(name = "gender",nullable = false)
    private Integer gender;
    @Column(name = "profession",nullable = false)
    private Integer profession;
    @Column(name = "status",nullable = false)
    private Integer status;
    @Column(name = "type",nullable = false)
    private Integer type;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getLoginAccount() {
        return loginAccount;
    }

    public void setLoginAccount(String loginAccount) {
        this.loginAccount = loginAccount;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public Integer getProfession() {
        return profession;
    }

    public void setProfession(Integer profession) {
        this.profession = profession;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "UserBO{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", loginAccount='" + loginAccount + '\'' +
                ", password='" + password + '\'' +
                ", phoneNum='" + phoneNum + '\'' +
                ", age='" + age + '\'' +
                ", gender='" + gender + '\'' +
                ", profession='" + profession + '\'' +
                ", status='" + status + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}
