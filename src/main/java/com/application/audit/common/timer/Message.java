package com.application.audit.common.timer;

import com.alibaba.fastjson.JSONObject;
import lombok.Data;

/**
 * @description:
 * @author: lyc yuechuan.lian@luckincoffee.com
 * @time: 2020/12/18 10:05
 */
@Data
public class Message {
    /**
     * 消息类型
     */
    private MessageTypeEnum msgtype;
    /**
     * 文本消息
     */
    private JSONObject text;

    /**
     * 图片消息
     */
    private JSONObject image;

    /**
     * 表示是否是保密消息，0表示否，1表示是，默认0
     */
    private Integer safe;
}
