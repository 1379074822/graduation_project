package com.application.audit.module.user.service;

import com.application.audit.module.user.entity.UserBO;

import java.util.List;

/**
 * @description:
 * @author:
 * @time: 2020/3/7 11:39
 */
public interface UserService {
    UserBO findLoginAccountAndPasswordAndType(UserBO userBo);

    UserBO findById(Long userId);

    UserBO save(UserBO userBO);

    boolean changePassword(UserBO userBO);

    UserBO changeInfo(UserBO userBO);

    List<UserBO> getAll(UserBO userBO);

    List<UserBO> getUserListSearch(UserBO userBO);
    Integer freezeAudit();
}
