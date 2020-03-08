package com.application.audit.module.score.dao;

import com.application.audit.module.score.entity.ScoreBO;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @description:
 * @author:
 * @time: 2020/3/8 9:40
 */
public interface ScoreDAO extends JpaRepository<ScoreBO,Long> {
    ScoreBO findByWorksIdAndBatchAndRounds(Long worksId,Integer batch,Integer rounds);
}
