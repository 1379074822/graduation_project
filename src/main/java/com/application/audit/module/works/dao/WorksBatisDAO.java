package com.application.audit.module.works.dao;

import com.application.audit.module.works.entity.CountWorksBO;
import com.application.audit.module.works.entity.WorksBO;
import com.application.audit.module.works.entity.WorksListBO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @description:
 * @author:
 * @time: 2020/3/8 9:42
 */
@Mapper
public interface WorksBatisDAO  {
    List<WorksListBO> allWithScoreSearch(WorksBO worksBO);
    List<CountWorksBO> getCountWorks();
}
