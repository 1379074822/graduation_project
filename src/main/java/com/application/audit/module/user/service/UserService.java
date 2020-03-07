package com.application.audit.module.user.service;

import com.application.audit.module.user.entity.UserBO;

/**
 * @description:
 * @author: lyc yuechuan.lian@luckincoffee.com
 * @time: 2020/3/7 11:39
 */
public interface UserService {
    boolean findLoginAccountAndPasswordAndType(UserBO userBo);

    UserBO findById(Long userId);
}
