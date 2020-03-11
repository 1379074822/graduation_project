package com.application.audit.module.works.controller;

import com.application.audit.module.works.entity.WorksBO;
import com.application.audit.module.works.entity.WorksListBO;
import com.application.audit.module.works.service.WorksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @description:
 * @author: lyc yuechuan.lian@luckincoffee.com
 * @time: 2020/3/8 9:42
 */
@RequestMapping("/works")
@RestController
public class WorksController {
    @Autowired
    private WorksService worksService;

    @RequestMapping("/saveWorks")
    private WorksBO saveWorks(WorksBO worksBO){
        return worksService.saveWorks(worksBO);
    }

    @RequestMapping("/updateWorks")
    private WorksBO updateWorks(WorksBO worksBO){
        return worksService.saveWorks(worksBO);
    }

    @RequestMapping("/all")
    private List<WorksBO> all(WorksBO worksBO){
        return worksService.all(worksBO);
    }

    /**
     * 查询作品
     * @param worksBO
     * @return
     */
    @RequestMapping("/getByQuery")
    private List<WorksBO> getByQuery(WorksBO worksBO){
        return worksService.all(worksBO);
    }

    /**
     * 汇总作品
     * @param worksBO
     * @return
     */
    @RequestMapping("/getSort")
    private List<WorksBO> getSort(WorksBO worksBO){
        return worksService.all(worksBO);
    }

    /**
     * 汇总作品(带评分）
     * @param worksBO
     * @return
     */
    @RequestMapping("/getAllWithScore")
    private List<WorksListBO> getAllWithScore(WorksBO worksBO){
        return worksService.allWithScore(worksBO);
    }
    //todo 作品导出
    //todo 评审结果
}
