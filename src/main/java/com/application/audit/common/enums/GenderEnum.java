package com.application.audit.common.enums;

/**
 * @description:
 * @author:
 * @time: 2020/3/15 13:06
 */
public enum GenderEnum {
    MALE(1,"男"),
    FEMALE(2,"女");

    private Integer index;
    private String name;

    GenderEnum(Integer index, String name) {
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
        for (GenderEnum c : GenderEnum.values()) {
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
