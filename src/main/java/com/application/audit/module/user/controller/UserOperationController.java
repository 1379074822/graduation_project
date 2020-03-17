package com.application.audit.module.user.controller;

import com.application.audit.common.enums.GenderEnum;
import com.application.audit.common.enums.ProfessionEnum;
import com.application.audit.common.enums.StatusEnum;
import com.application.audit.module.user.entity.UserBO;
import com.application.audit.module.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
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
    private UserBO login(@RequestBody UserBO userBO){
        return userService.findLoginAccountAndPasswordAndType(userBO);
    }

    @RequestMapping("/getInfo")
    private UserBO getInfo(Long userId){
        return userService.findById(userId);
    }

    @RequestMapping("/getAll")
    private List<UserBO> getAll(@RequestBody UserBO userBO){
        return userService.getAll(userBO);
    }

    @RequestMapping("/register")
    private Boolean register(UserBO userBO){
        UserBO save = userService.save(userBO);
        return Objects.nonNull(save);
    }

    @RequestMapping("/changePassword")
    private boolean changePassword(@RequestBody UserBO userBO){
        return  userService.changePassword(userBO);
    }

    @RequestMapping("/changeInfo")
    private UserBO changeInfo(@RequestBody UserBO userBO){
        return userService.changeInfo(userBO);
    }

    @RequestMapping("/getUserListSearch")
    private List<UserBO> getUserListSearch(@RequestBody UserBO userBO){
        List<UserBO> list = userService.getUserListSearch(userBO);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        for (UserBO bo : list) {
            bo.setStatusDesc(StatusEnum.getNameByIndex(bo.getStatus()));
            bo.setCreateTimeDesc(simpleDateFormat.format(bo.getCreateTime()));
            bo.setGenderDesc(GenderEnum.getNameByIndex(bo.getGender()));
            if(userBO.getType()==3){
            bo.setProfessionDesc(ProfessionEnum.getNameByIndex(bo.getProfession()));
            }
        }
        return list;
    }

}
