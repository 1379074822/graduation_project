package com.application.audit.module.rateconfig.controller;

import com.application.audit.module.rateconfig.entity.ConfigBO;
import com.application.audit.module.rateconfig.entity.MessageBO;
import com.application.audit.module.rateconfig.entity.MessageViewBO;
import com.application.audit.module.rateconfig.service.ConfigService;
import com.application.audit.module.rateconfig.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * @description:
 * @author:
 * @time: 2020/3/7 17:37
 */
@RestController
@RequestMapping("/message")
public class MessageController {
    @Autowired
    private MessageService messageService;

    @RequestMapping("getMessage")
    private List<MessageViewBO> getMessage(){
        List<MessageBO> message = messageService.getMessage();
        ArrayList<MessageViewBO> messageViewBOS = new ArrayList<>();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyy-MM-dd");
        for (int i = 0; i < message.size(); i++) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(message.get(i).getUserName()).append(" 评论了：").append(message.get(i).getText());
            MessageViewBO messageViewBO = new MessageViewBO();
            messageViewBO.setContent(stringBuilder.toString());
            messageViewBO.setTimestamp(simpleDateFormat.format(message.get(i).getCreateTime()));
            messageViewBOS.add(messageViewBO);
        }

        return messageViewBOS;
    }



    @RequestMapping("saveMessage")
    private MessageBO saveMessage(MessageBO messageBO){
        return messageService.saveMessage(messageBO);
    }



}
