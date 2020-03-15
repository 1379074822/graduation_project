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
    @Query(
            value = "select new com.application.audit.module.works.entity.WorksListBO(" +
                    "w.id,w.createId,w.createName,w.createTime,w.fileUrl,w.modifyId,w.modifyName," +
                    "w.modifyTime,w.worksDesc,w.worksName,s.score,w.batch,s.opinion,s.rounds)" +
                    "from WorksBO w,ScoreBO s,UserBO u " +
                    "where w.createId = u.id and s.worksId = w.id")
    List<WorksListBO> allWithScore();

     @Query(
            value = "select new com.application.audit.module.works.entity.WorksListBO(" +
                    "w.id,w.createId,w.createName,w.createTime,w.fileUrl,w.modifyId,w.modifyName," +
                    "w.modifyTime,w.worksDesc,w.worksName,s.score,w.batch,s.opinion,s.rounds)" +
                    "from WorksBO w,ScoreBO s,UserBO u " +
                    "where w.createId = u.id and s.worksId = w.id and w.createName like ?1 and w.worksName like ?2")
    List<WorksListBO> allWithScoreSearch(String createName, String worksName);
}
