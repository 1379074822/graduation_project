package com.application.audit.module.works.dao;

import com.application.audit.module.works.entity.WorksBO;
import com.application.audit.module.works.entity.WorksListBO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @description:
 * @author:
 * @time: 2020/3/8 9:42
 */
@Repository
public interface WorksDAO extends JpaRepository<WorksBO,Long> {
    @Query(nativeQuery = true,
            value = "select new com.application.audit.module.works.entity.WorksListBO(" +
                    "w.id,)" +
                    "from WorksBO w,ScoreBO s,UserBO u " +
                    "where w.create_id = u.id and s.works_id = w.id")
    List<WorksListBO> allWithScore();
}
