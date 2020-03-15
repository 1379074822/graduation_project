package com.application.audit.module.works.controller;

import com.application.audit.common.enums.ProfessionEnum;
import com.application.audit.common.enums.StatusEnum;
import com.application.audit.module.works.entity.CountWorksAO;
import com.application.audit.module.works.entity.CountWorksBO;
import com.application.audit.module.works.entity.WorksBO;
import com.application.audit.module.works.entity.WorksListBO;
import com.application.audit.module.works.service.WorksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
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
    private WorksBO saveWorks(@RequestBody WorksBO worksBO){
        return worksService.saveWorks(worksBO);
    }

    @RequestMapping("/updateWorks")
    private WorksBO updateWorks(@RequestBody WorksBO worksBO){
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
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        List<WorksListBO> worksListBOS = worksService.allWithScore(worksBO);
        for (WorksListBO worksListBO : worksListBOS) {
            worksListBO.setCreateTimeDesc(simpleDateFormat.format(worksListBO.getCreateTime()));
        }
        return worksListBOS;
    }

    /**
     * 汇总作品(带评分）
     * @param worksBO
     * @return
     */
    @RequestMapping("/getAllWithScoreSearch")
    private List<WorksListBO> getAllWithScoreSearch(@RequestBody  WorksBO worksBO){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        List<WorksListBO> worksListBOS = worksService.allWithScoreSearch(worksBO);
        for (WorksListBO worksListBO : worksListBOS) {
            worksListBO.setCreateTimeDesc(simpleDateFormat.format(worksListBO.getCreateTime()));
            worksListBO.setStatusDesc(StatusEnum.getNameByIndex(worksListBO.getStatus()));
        }
        return worksListBOS;
    }


    @RequestMapping("/getCount")
    private List<CountWorksAO> getCount(){
        List<CountWorksBO> list = worksService.getCount();
        ArrayList<CountWorksAO> countWorksAOS = new ArrayList<>();
        for (CountWorksBO countWorksBO : list) {
            CountWorksAO countWorksAO = new CountWorksAO();
            countWorksAO.setName(ProfessionEnum.getNameByIndex(countWorksBO.getType()));
            countWorksAO.setValue(countWorksBO.getValue());
            countWorksAOS.add(countWorksAO);
        }

        return countWorksAOS;
    }
    //todo 作品导出
    //todo 评审结果
}
