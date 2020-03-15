package com.application.audit.module.score.dao;

import com.application.audit.module.score.entity.ScoreBO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @description:
 * @author:
 * @time: 2020/3/8 9:40
 */
@Mapper
public interface ScoreBatisDAO  {
    ScoreBO findByWorksIdAndBatchAndRounds(Long worksId, Integer batch, Integer rounds);
}
