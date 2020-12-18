package com.application.audit.common.timer;

import lombok.Data;

/**
 * @description:
 * @author: lyc yuechuan.lian@luckincoffee.com
 * @time: 2020/12/18 10:05
 */
@Data
public class ImageMessage {
    /**
     * 图片内容的base64编码
     * 注：图片（base64编码前）最大不能超过2M，支持JPG,PNG格式
     */
    private String base64;

    /**
     * 图片内容（base64编码前）的md5值
     */
    private String md5;
}
