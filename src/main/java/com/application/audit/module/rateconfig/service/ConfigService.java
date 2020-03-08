package com.application.audit.module.rateconfig.service;

import com.application.audit.module.rateconfig.entity.ConfigBO;

/**
 * @description:
 * @author: lyc yuechuan.lian@luckincoffee.com
 * @time: 2020/3/7 17:39
 */
public interface ConfigService {
    ConfigBO getConfig();

    ConfigBO updateConfig(ConfigBO configBO);
}
