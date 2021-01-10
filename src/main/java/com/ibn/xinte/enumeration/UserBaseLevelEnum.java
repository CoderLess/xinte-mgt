package com.ibn.xinte.enumeration;

import com.google.common.collect.Maps;

import java.util.Map;

/**
 * @version 1.0
 * @description: 用户性别枚举
 * @projectName：xinte-mgt
 * @see: com.ibn.xinte.enumeration
 * @author： RenBin
 * @createTime：2021/01/01 00:57
 */
public enum UserBaseLevelEnum {

    FIRST_LEVEL_MEMBER(1,"一级会员"),
    SECOND_LEVEL_MEMBER(2,"二级会员"),
    THIRD_LEVEL_MEMBER(3,"三级会员"),
    FOURTH_LEVEL_MEMBER(4,"四级会员"),
    FIFTH_LEVEL_MEMBER(5,"五级会员");

    /**
     * @description: 枚举值
     * @author：RenBin
     * @createTime：2021/1/1 1:02
     */
    private Integer code;
    /**
     * @description: 枚举描述信息
     * @author：RenBin
     * @createTime：2021/1/1 1:03
     */
    private String desc;

    UserBaseLevelEnum(Integer code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public static Map<Integer, String> allEnum() {
        Map<Integer, String> allEnumMap = Maps.newHashMap();
        UserBaseLevelEnum[] values = UserBaseLevelEnum.values();
        if (null == values) {
            return allEnumMap;
        }
        for (UserBaseLevelEnum value : values) {
            allEnumMap.put(value.getCode(), value.getDesc());
        }
        return allEnumMap;
    }

    public Integer getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }
}
