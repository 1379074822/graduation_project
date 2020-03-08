package com.application.audit.module.rateconfig.service.impl;

import com.application.audit.module.rateconfig.dao.ConfigDAO;
import com.application.audit.module.rateconfig.entity.ConfigBO;
import com.application.audit.module.rateconfig.service.ConfigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @description:
 * @author:
 * @time: 2020/3/7 17:39
 */
@Service
public class ConfigServiceImpl implements ConfigService {
    @Autowired
    private ConfigDAO configDAO;
    @Override
    public ConfigBO getConfig() {

        return configDAO.findConfig();
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public ConfigBO updateConfig(ConfigBO configBO) {
        return configDAO.save(configBO);
    }
}
