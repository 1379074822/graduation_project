package com.application.audit.common.timer;

import com.application.audit.module.user.dao.UserBatisDao;
import com.application.audit.module.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

/**
 * @description:
 * @author: lyc yuechuan.lian@luckincoffee.com
 * @time: 2020/3/18 22:06
 */
@Configuration      //1.主要用于标记配置类，兼备Component的效果。
@EnableScheduling   // 2.开启定时任务
public class TimerTask {

    @Autowired
    private UserService userService;
    @Scheduled(cron = "0 0 0  * * ?")

    private void configureTasks() {
       userService.freezeAudit();
    }
}
