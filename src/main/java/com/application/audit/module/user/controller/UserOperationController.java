package com.application.audit.module.user.controller;

import com.application.audit.module.user.entity.UserBO;
import com.application.audit.module.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
