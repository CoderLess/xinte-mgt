package com.ibn.xinte.enumeration;

import com.google.common.collect.Maps;

import java.util.Map;

/**
 * @version 1.0
 * @description: 出入库枚举
 * @projectName：xinte-mgt
 * @see: com.ibn.xinte.enumeration
 * @author： RenBin
 * @createTime：2021/01/01 01:10
 */
public enum MedicineCheckInOutTypeEnum {
    IN(1,"入库"),
    OUT(2,"出库");

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

    MedicineCheckInOutTypeEnum(Integer code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public static Map<Integer, String> allEnum() {
        Map<Integer, String> allEnumMap = Maps.newHashMap();
        MedicineCheckInOutTypeEnum[] values = MedicineCheckInOutTypeEnum.values();
        if (null == values) {
            return allEnumMap;
        }
        for (MedicineCheckInOutTypeEnum value : values) {
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
