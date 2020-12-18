package com.application.audit.common.timer;

import lombok.Data;

/**
 * @description:
 * @author: lyc yuechuan.lian@luckincoffee.com
 * @time: 2020/12/18 11:17
 */
@Data
public class Weather {
    private String date;
    private String ymd;
    private String week;
    private String sunrise;
    private String high;
    private String low;
    private String sunset;
    private String aqi;
    private String fx;
    private String fl;
    private String type;
    private String notice;
}
