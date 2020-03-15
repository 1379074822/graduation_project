package com.application.audit.common.enums;

/**
 * @description:
 * @author:
 * @time: 2020/3/15 13:06
 */
public enum ProfessionEnum {
    NATURE(1,"自然"),
    TECH(4,"科技"),
    GEO(2,"地理"),
    AESTHETICS(3,"美学");

    private Integer index;
    private String name;

    ProfessionEnum(Integer index, String name) {
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
        for (ProfessionEnum c : ProfessionEnum.values()) {
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
