package com.ibn.xinte.enumeration;

import com.google.common.collect.Maps;

import java.util.Map;

/**
 * @version 1.0
 * @description: 药方类型枚举
 * @projectName：xinte-mgt
 * @see: com.ibn.xinte.enumeration
 * @author： RenBin
 * @createTime：2021/01/01 01:10
 */
public enum PrescriptionBaseTypeEnum {
    DIAGNOSTIC_LIST(1,"诊断药单"),
    TEMPORARY_MEDICINE_LIST(2,"临时药单");

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

    PrescriptionBaseTypeEnum(Integer code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public static Map<Integer, String> allEnum() {
        Map<Integer, String> allEnumMap = Maps.newHashMap();
        PrescriptionBaseTypeEnum[] values = PrescriptionBaseTypeEnum.values();
        if (null == values) {
            return allEnumMap;
        }
        for (PrescriptionBaseTypeEnum value : values) {
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
