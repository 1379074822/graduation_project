package com.application.audit.module.user.dao;

import com.application.audit.module.user.entity.UserBO;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @description:
 * @author: lyc yuechuan.lian@luckincoffee.com
 * @time: 2020/3/7 11:39
 */

public interface UserDao extends JpaRepository<UserBO,Long> {
    UserBO findByLoginAccountAndPassword(String userName, String password);
}
