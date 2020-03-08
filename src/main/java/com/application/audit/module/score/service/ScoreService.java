package com.application.audit.module.score.service;

import com.application.audit.module.score.entity.ScoreBO;

/**
 * @description:
 * @author: lyc yuechuan.lian@luckincoffee.com
 * @time: 2020/3/8 9:40
 */
public interface ScoreService {
    ScoreBO saveScore(ScoreBO scoreBO);

    ScoreBO savePoll(ScoreBO scoreBO);

    ScoreBO getScore(Long worksId,Integer batch,Integer rounds);
}
