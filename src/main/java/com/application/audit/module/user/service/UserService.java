package com.application.audit.module.user.service;

import com.application.audit.module.user.entity.UserBO;

import java.util.List;

/**
 * @description:
 * @author: lyc yuechuan.lian@luckincoffee.com
 * @time: 2020/3/7 11:39
 */
public interface UserService {
    UserBO findLoginAccountAndPasswordAndType(UserBO userBo);

    UserBO findById(Long userId);

    UserBO save(UserBO userBO);

    void changePassword(UserBO userBO);

    void changeInfo(UserBO userBO);

    List<UserBO> getAll(UserBO userBO);

    List<UserBO> getUserListSearch(UserBO userBO);
}
