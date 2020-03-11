package com.application.audit.module.works.service.impl;

import com.application.audit.module.works.dao.WorksDAO;
import com.application.audit.module.works.entity.WorksBO;
import com.application.audit.module.works.entity.WorksListBO;
import com.application.audit.module.works.service.WorksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @description:
 * @author: lyc yuechuan.lian@luckincoffee.com
 * @time: 2020/3/8 9:42
 */
@Service
public class WorksServiceImpl implements WorksService {
    @Autowired
    private WorksDAO worksDAO;
    @Override
    @Transactional(rollbackFor = Exception.class)
    public WorksBO saveWorks(WorksBO worksBO) {
        return worksDAO.save(worksBO);
    }

    @Override
    public List<WorksBO> all(WorksBO worksBO) {
        return worksDAO.findAll();
    }

    @Override
    public List<WorksListBO> allWithScore(WorksBO worksBO) {
        return worksDAO.allWithScore();
    }
}
