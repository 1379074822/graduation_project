package com.application.audit.module.works.service.impl;

import com.application.audit.module.user.dao.UserBatisDao;
import com.application.audit.module.user.dao.UserDao;
import com.application.audit.module.user.entity.UserBO;
import com.application.audit.module.works.dao.WorksBatisDAO;
import com.application.audit.module.works.dao.WorksDAO;
import com.application.audit.module.works.entity.CountWorksBO;
import com.application.audit.module.works.entity.WorksBO;
import com.application.audit.module.works.entity.WorksListBO;
import com.application.audit.module.works.service.WorksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * @description:
 * @author:
 * @time: 2020/3/8 9:42
 */
@Service
public class WorksServiceImpl implements WorksService {
    @Autowired
    private WorksDAO worksDAO;
    @Autowired
    private WorksBatisDAO worksBatisDAO;
    @Autowired
    private UserDao userDao;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public WorksBO saveWorks(WorksBO worksBO) {
        worksBO.setCreateTime(new Date());
        worksBO.setStatus(1);
        worksBO.setBatch(1);
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

    @Override
    public List<WorksListBO> allWithScoreSearch(WorksBO worksBO) {
        return worksBatisDAO.allWithScoreSearch(worksBO);
    }

    @Override
    public List<CountWorksBO> getCount() {
        return worksBatisDAO.getCountWorks();
    }

    @Override
    public List<String> getNew() {
        return worksBatisDAO.getNew();
    }

    @Override
    public List<WorksListBO> getHighScore() {
        return worksBatisDAO.getHighScore();
    }

    @Override
    public List<WorksListBO> getWorksByUser(Long createId) {
        return worksBatisDAO.getWorksByUser(createId);
    }

    @Override
    public List<WorksListBO> getWorksUnScore(Long id) {
        return worksBatisDAO.getWorksUnScore(id);
    }

    @Override
    public List<WorksListBO> getHighRate(Integer batch) {
        return worksBatisDAO.getHighRate(batch);
    }

    @Override
    public String vote(WorksBO worksBO) {
        UserBO userBO = userDao.findById(worksBO.getCreateId()).get();
        if(userBO.getTicket()<1){
            return "您的票数为0，无法继续投票";
        }
        worksBatisDAO.vote(worksBO);
        userBO.setTicket(userBO.getTicket()-1);
        userDao.save(userBO);
        return "为他投票成功！剩余票数："+(userBO.getTicket()-1);
    }
}
