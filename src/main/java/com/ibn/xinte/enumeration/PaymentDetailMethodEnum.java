package com.ibn.xinte.enumeration;

import com.google.common.collect.Maps;

import java.util.Map;

/**
 * @version 1.0
 * @description: 支付方式枚举
 * @projectName：xinte-mgt
 * @see: com.ibn.xinte.enumeration
 * @author： RenBin
 * @createTime：2021/01/01 01:10
 */
public enum PaymentDetailMethodEnum {
    CASH(1,"现金"),
    WECHAT(2,"微信"),
    ZHIFUBAO(3,"支付宝"),
    MEDICAL_INSURANCE_CARD(4,"医保卡");

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

    PaymentDetailMethodEnum(Integer code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public static Map<Integer, String> allEnum() {
        Map<Integer, String> allEnumMap = Maps.newHashMap();
        PaymentDetailMethodEnum[] values = PaymentDetailMethodEnum.values();
        if (null == values) {
            return allEnumMap;
        }
        for (PaymentDetailMethodEnum value : values) {
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
