package com.ibn.xinte.domain;

import lombok.Data;

import java.math.BigDecimal;

/**
 * @version 1.0
 * @description:
 * @projectName：demo
 * @see: com.ibn.demo.domain
 * @author： RenBin
 * @createTime：2021年1月5日
 */
@Data
public class PaymentDetailDTO {

    private static final long serialVersionUID = 1L;

    /**
     * @description: 支付金额
     * @author：RenBin
     * @createTime：2021年1月5日
     */
    private BigDecimal amount;
    /**
     * @description: 主键
     * @author：RenBin
     * @createTime：2021年1月5日
     */
    private Long id;
    /**
     * @description: 支付方式 1：现金 2：微信 3：支付宝 4：医保卡
     * @author：RenBin
     * @createTime：2021年1月5日
     */
    private Integer method;
    /**
     * @description: 支付信息id
     * @author：RenBin
     * @createTime：2021年1月5日
     */
    private Long paymentId;
    }
