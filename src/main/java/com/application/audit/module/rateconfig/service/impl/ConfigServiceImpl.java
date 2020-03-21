package com.application.audit.module.rateconfig.service.impl;

import com.application.audit.module.rateconfig.dao.ConfigBatisDAO;
import com.application.audit.module.rateconfig.dao.ConfigDAO;
import com.application.audit.module.rateconfig.entity.ConfigBO;
import com.application.audit.module.rateconfig.service.ConfigService;
import com.application.audit.module.works.entity.WorksBO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @description:
 * @author:
 * @time: 2020/3/7 17:39
 */
@Service
public class ConfigServiceImpl implements ConfigService {
    @Autowired
    private ConfigDAO configDAO;

    @Autowired
    private ConfigBatisDAO configBatisDAO;
    @Override
    public ConfigBO getConfig() {

        return configDAO.findConfig();
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public ConfigBO updateConfig(ConfigBO configBO) {
        List<WorksBO> list = configBatisDAO.selectGood(configBO);
        configBatisDAO.saveGoodWorks(list);
        return configDAO.save(configBO);
    }


    @Override
    public ConfigBO findConfig() {
        return configBatisDAO.findConfig();
    }

    @Override
    public ConfigBO updateVote(ConfigBO configBO) {
        return configDAO.save(configBO);
    }
}
