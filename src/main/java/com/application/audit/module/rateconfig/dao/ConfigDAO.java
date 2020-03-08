package com.application.audit.module.rateconfig.dao;

import com.application.audit.module.rateconfig.entity.ConfigBO;
import com.application.audit.module.user.entity.UserBO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 * @description:
 * @author:
 * @time: 2020/3/7 17:40
 */
@Repository
public interface ConfigDAO extends JpaRepository<ConfigBO,Long> {

    @Query(value = "select c from ConfigBO c where c.id =1 ")
    ConfigBO findConfig();



}
