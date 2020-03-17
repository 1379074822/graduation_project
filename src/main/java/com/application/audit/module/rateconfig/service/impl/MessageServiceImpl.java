package com.application.audit.module.rateconfig.service.impl;

import com.application.audit.module.rateconfig.dao.ConfigBatisDAO;
import com.application.audit.module.rateconfig.dao.ConfigDAO;
import com.application.audit.module.rateconfig.dao.MessageDAO;
import com.application.audit.module.rateconfig.entity.ConfigBO;
import com.application.audit.module.rateconfig.entity.MessageBO;
import com.application.audit.module.rateconfig.service.ConfigService;
import com.application.audit.module.rateconfig.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * @description:
 * @author:
 * @time: 2020/3/7 17:39
 */
@Service
public class MessageServiceImpl implements MessageService {
    @Autowired
    private MessageDAO messageDAO;


    @Override
    public List<MessageBO> getMessage() {
        return messageDAO.findAllBySearch();
    }

    @Override
    public MessageBO saveMessage(MessageBO messageBO) {
        messageBO.setCreateTime(new Date());
        return messageDAO.save(messageBO);
    }
}
