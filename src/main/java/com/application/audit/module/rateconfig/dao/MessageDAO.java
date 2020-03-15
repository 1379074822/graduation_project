package com.application.audit.module.rateconfig.dao;

import com.application.audit.module.rateconfig.entity.ConfigBO;
import com.application.audit.module.rateconfig.entity.MessageBO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @description:
 * @author:
 * @time: 2020/3/7 17:40
 */
@Repository
public interface MessageDAO extends JpaRepository<MessageBO,Long> {

@Query("select new com.application.audit.module.rateconfig.entity.MessageBO( m.text,m.createTime,m.level,u.userName) from MessageBO m,UserBO u where u.id=m.userId")
    List<MessageBO> findAllBySearch();
}
