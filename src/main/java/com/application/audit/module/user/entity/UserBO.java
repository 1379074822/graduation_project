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
    private String age;
    @Column(name = "gender",nullable = false)
    private String gender;
    @Column(name = "profession",nullable = false)
    private String profession;
    @Column(name = "status",nullable = false)
    private String status;
    @Column(name = "type",nullable = false)
    private String type;

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

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
