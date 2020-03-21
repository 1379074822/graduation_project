package com.application.audit.module.rateconfig.service;

import com.application.audit.module.rateconfig.entity.MessageBO;

import java.util.List;

/**
 * @description:
 * @author:
 */
public interface MessageService {
    List<MessageBO> getMessage();

    MessageBO saveMessage(MessageBO messageBO);


}
