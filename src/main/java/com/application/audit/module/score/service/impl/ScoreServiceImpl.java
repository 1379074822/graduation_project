package com.application.audit.module.score.service.impl;

import com.application.audit.module.score.dao.ScoreDAO;
import com.application.audit.module.score.entity.ScoreBO;
import com.application.audit.module.score.service.ScoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @description:
 * @author: lyc yuechuan.lian@luckincoffee.com
 * @time: 2020/3/8 9:40
 */
@Service
public class ScoreServiceImpl implements ScoreService {
    @Autowired
    private ScoreDAO scoreDAO;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public ScoreBO saveScore(ScoreBO scoreBO) {
        return scoreDAO.save(scoreBO);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public ScoreBO savePoll(ScoreBO scoreBO) {
        return scoreDAO.save(scoreBO);
    }

    @Override
    public ScoreBO getScore(Long worksId,Integer batch,Integer rounds) {
        return scoreDAO.findByWorksIdAndBatchAndRounds(worksId,batch,rounds);
    }
}
