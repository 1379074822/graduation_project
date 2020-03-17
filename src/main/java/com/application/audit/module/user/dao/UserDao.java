package com.application.audit.module.user.dao;

import com.application.audit.module.user.entity.UserBO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @description:
 * @author: lyc yuechuan.lian@luckincoffee.com
 * @time: 2020/3/7 11:39
 */

public interface UserDao extends JpaRepository<UserBO,Long> {
    UserBO findByLoginAccountAndPasswordAndTypeAndStatus(String userName, String password,Integer type,Integer Status);
    @Modifying
    @Query("update UserBO u set u.password = ?1 where u.id = ?2")
    void changePassword(String password,Long id);

    List<UserBO> findByType(Integer type);

    UserBO findByIdAndPassword(Long id, String encryptPassword);
}
