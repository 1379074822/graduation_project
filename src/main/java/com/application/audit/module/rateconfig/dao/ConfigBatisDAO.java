package com.application.audit.module.rateconfig.dao;

import com.application.audit.module.rateconfig.entity.ConfigBO;
import com.application.audit.module.works.entity.WorksBO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @description:
 * @author:
 * @time: 2020/3/7 17:40
 */
@Mapper
public interface ConfigBatisDAO  {

    ConfigBO findConfig();

    void saveGoodWorks(List<WorksBO> list);

    List<WorksBO> selectGood(ConfigBO configBO);
}
