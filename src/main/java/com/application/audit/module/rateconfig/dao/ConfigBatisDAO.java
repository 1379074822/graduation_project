package com.application.audit.module.rateconfig.dao;

import com.application.audit.module.rateconfig.entity.ConfigBO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 * @description:
 * @author:
 * @time: 2020/3/7 17:40
 */
@Mapper
public interface ConfigBatisDAO  {

    ConfigBO findConfig();

}
