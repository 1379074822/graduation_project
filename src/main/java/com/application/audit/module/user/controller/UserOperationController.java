package com.application.audit.module.user.controller;

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
    @RequestMapping("/login")
    private String login(){
        return "hello";
    }
}
