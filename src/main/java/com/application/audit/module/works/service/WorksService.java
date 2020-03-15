package com.application.audit.module.works.service;

import com.application.audit.module.works.entity.CountWorksBO;
import com.application.audit.module.works.entity.WorksBO;
import com.application.audit.module.works.entity.WorksListBO;

import java.util.List;

/**
 * @description:
 * @author:
 * @time: 2020/3/8 9:42
 */
public interface WorksService {

    WorksBO saveWorks(WorksBO worksBO);

    List<WorksBO> all(WorksBO worksBO);

    List<WorksListBO> allWithScore(WorksBO worksBO);

    List<WorksListBO> allWithScoreSearch(WorksBO worksBO);

    List<CountWorksBO> getCount();
}
