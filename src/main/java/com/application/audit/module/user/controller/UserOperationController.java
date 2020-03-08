package com.application.audit.module.user.controller;

import com.application.audit.module.user.entity.UserBO;
import com.application.audit.module.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Objects;

/**
 * @description:
 * @author:
 * @time: 2020/3/7 9:59
 */
@RestController
@RequestMapping("/user")
public class UserOperationController {
    @Autowired
    private UserService userService;

    @RequestMapping("/login")
    private boolean login(UserBO userBO){
        return userService.findLoginAccountAndPasswordAndType(userBO);
    }

    @RequestMapping("/getInfo")
    private UserBO getPersonalInfo(Long userId){
        return userService.findById(userId);
    }

    @RequestMapping("/getAll")
    private List<UserBO> getAll(UserBO userBO){
        return userService.getAll(userBO);
    }

    @RequestMapping("/register")
    private Boolean register(UserBO userBO){
        UserBO save = userService.save(userBO);
        return Objects.nonNull(save);
    }

    @RequestMapping("/changePassword")
    private void changePassword(UserBO userBO){
        userService.changePassword(userBO);
    }

    @RequestMapping("/changeInfo")
    private void changeInfo(UserBO userBO){
        userService.changeInfo(userBO);
    }

}
