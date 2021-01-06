package com.ibn.xinte.entity;

import lombok.Data;

import java.math.BigDecimal;

/**
 * @version 1.0
 * @description:
 * @projectName：demo
 * @see: com.ibn.demo.entity
 * @author： RenBin
 * @createTime：2021年1月5日
 */
@Data
public class PaymentBaseDO {

    private static final long serialVersionUID = 1L;

    /**
     * @description: 主键
     * @author：RenBin
     * @createTime：2021年1月5日
     */
    private Long id;
    /**
     * @description: 支付金额
     * @author：RenBin
     * @createTime：2021年1月5日
     */
    private BigDecimal amount;
    /**
     * @description: 创建时间
     * @author：RenBin
     * @createTime：2021年1月5日
     */
    private Long createTime;
    /**
     * @description: 操作人
     * @author：RenBin
     * @createTime：2021年1月5日
     */
    private Long creator;
    /**
     * @description: 药方id
     * @author：RenBin
     * @createTime：2021年1月5日
     */
    private Long prescriptionId;
}
