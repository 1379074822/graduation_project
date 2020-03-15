package com.application.audit.module.rateconfig.service;

import com.application.audit.module.rateconfig.entity.ConfigBO;
import com.application.audit.module.rateconfig.entity.MessageBO;

import java.util.List;

/**
 * @description:
 * @author: lyc yuechuan.lian@luckincoffee.com
 * @time: 2020/3/7 17:39
 */
public interface MessageService {
    List<MessageBO> getMessage();

    MessageBO saveMessage(MessageBO messageBO);


}
