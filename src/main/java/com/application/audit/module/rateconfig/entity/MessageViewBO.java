package com.application.audit.module.rateconfig.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @description:
 * @author:
 * @time: 2020/3/7 17:18
 */

@Data
public class MessageViewBO {
    private String content;
    private String timestamp;
}
