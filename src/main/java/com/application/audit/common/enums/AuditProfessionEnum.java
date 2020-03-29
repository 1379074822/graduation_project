package com.application.audit.common.enums;

/**
 * @description:
 * @author:
 * @time: 2020/3/18 21:55
 */
public enum AuditProfessionEnum {
    LL(1,"理论"),
    XW(2,"新闻"),
    CB(3,"出版"),
    WY(4,"文艺"),
    WH(5,"文化经营管理");

    private Integer index;
    private String name;

    AuditProfessionEnum(Integer index, String name) {
        this.index = index;
        this.name = name;
    }

    /**
     * 根据索引获取名称
     *
     * @param index 索引
     * @return name 名称
     */
    public static String getNameByIndex(Integer index) {
        for (AuditProfessionEnum c : AuditProfessionEnum.values()) {
            if (c.getIndex().equals(index)) {
                return c.name;
            }
        }
        return null;
    }

    public Integer getIndex() {
        return index;
    }

    public String getName() {
        return name;
    }
}
