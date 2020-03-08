package com.application.audit.module.rateconfig.controller;

import com.application.audit.module.rateconfig.entity.ConfigBO;
import com.application.audit.module.rateconfig.service.ConfigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description:
 * @author:
 * @time: 2020/3/7 17:37
 */
@RestController
@RequestMapping("/config")
public class ConfigController {
    @Autowired
    private ConfigService configService;

    @RequestMapping("getConfig")
    private ConfigBO getConfig(){
        return configService.getConfig();
    }

    @RequestMapping("updateConfig")
    private ConfigBO updateConfig(ConfigBO configBO){
        return configService.updateConfig(configBO);
    }

}
