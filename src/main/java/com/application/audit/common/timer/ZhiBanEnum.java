package com.application.audit.common.timer;

/**
 * @description:
 * @author: lyc yuechuan.lian@luckincoffee.com
 * @time: 2020/12/18 10:17
 */
public enum ZhiBanEnum {

    lyc(1, "连跃川","lianyuechuan"),
    cxy(2, "崔修印","cuixiuyin"),
    wr(3, "王蓉","wangrong01"),
    wdx(4, "王德馨","wangdexin"),
    ylv(5, "杨吕锦","yanglvjin"),
    no(6, "无人值班",""),
    ;

    private  int week;
    private  String name;
    private  String pinyin;

    public int getWeek() {
        return week;
    }

    public String getName() {
        return name;
    }

    public String getPinyin() {
        return pinyin;
    }

    ZhiBanEnum(int week, String name, String pinyin) {
        this.week = week;
        this.name = name;
        this.pinyin = pinyin;
    }

    /**
     * 根据值返回枚举
     *
     * @param week
     * @return
     */
    public static ZhiBanEnum getEnumByWeek(int week) {
        for (ZhiBanEnum value : ZhiBanEnum.values()) {
            if(value.week==week){
                return value;
            }
        }
        return no;
    }

}
