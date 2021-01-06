package com.ibn.xinte.domain;

import lombok.Data;

import java.math.BigDecimal;

/**
 * @version 1.0
 * @description: 统计支付相关基本信息
 * @projectName：xinte-mgt
 * @see: com.ibn.xinte.domain
 * @author： RenBin
 * @createTime：2021/01/05 19:50
 */
@Data
public class PayStatisticDTO {

    /**
     * @description: 用户支付订单数量统计
     * @author：RenBin
     * @createTime：2021/1/5 19:51
     */
    private Integer totalNumber;
    /**
     * @description: 支付金额统计
     * @author：RenBin
     * @createTime：2021/1/5 19:52
     */
    private BigDecimal totalAmount;
}
