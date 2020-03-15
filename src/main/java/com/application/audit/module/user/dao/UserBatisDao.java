package com.application.audit.module.user.dao;

import com.application.audit.module.user.entity.UserBO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * @description:
 * @author: lyc yuechuan.lian@luckincoffee.com
 * @time: 2020/3/7 11:39
 */
@Mapper
public interface UserBatisDao  {

    List<UserBO> getUserListSearch(UserBO userBO);
}
