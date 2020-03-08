package com.application.audit.module.score.controller;

import com.application.audit.module.score.dao.ScoreDAO;
import com.application.audit.module.score.entity.ScoreBO;
import com.application.audit.module.score.service.ScoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description:
 * @author:
 * @time: 2020/3/8 9:39
 */
@RestController
@RequestMapping("/score")
public class ScoreController {
    @Autowired
    private ScoreService scoreService;

    /**
     * 保存得分（评分时插入）
     * @param scoreBO
     * @return
     */
    @RequestMapping("/saveScore")
    private ScoreBO saveScore(ScoreBO scoreBO){
        return scoreService.saveScore(scoreBO);
    }

    /**
     * 保存票数（确定晋级作品插入）
     * @param scoreBO
     * @return
     */
    @RequestMapping("/savePoll")
    private ScoreBO savePoll(ScoreBO scoreBO){
        return scoreService.savePoll(scoreBO);
    }

    @RequestMapping("/getScore")
    private ScoreBO getScore(Long worksId,Integer batch,Integer rounds){
        return scoreService.getScore(worksId,batch,rounds);
    }
}
