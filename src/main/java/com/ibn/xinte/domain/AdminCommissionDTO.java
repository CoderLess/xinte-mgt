package com.ibn.xinte.domain;

import lombok.Data;

import java.math.BigDecimal;

/**
 * @version 1.0
 * @description:
 * @projectName：demo
 * @see: com.ibn.demo.domain
 * @author： RenBin
 * @createTime：2021年1月10日
 */
@Data
public class AdminCommissionDTO {

    private static final long serialVersionUID = 1L;

    /**
     * @description: 管理员id
     * @author：RenBin
     * @createTime：2021年1月10日
     */
    private Long adminId;
    /**
     * @description: 提成
     * @author：RenBin
     * @createTime：2021年1月10日
     */
    private BigDecimal commissionAmount;
    /**
     * @description: 提成比例
     * @author：RenBin
     * @createTime：2021年1月10日
     */
    private BigDecimal commission;
    /**
     * @description: 总价格
     * @author：RenBin
     * @createTime：2021年1月10日
     */
    private BigDecimal amount;
    /**
     * @description: 创建时间
     * @author：RenBin
     * @createTime：2021年1月10日
     */
    private Long createTime;
    /**
     * @description: 主键
     * @author：RenBin
     * @createTime：2021年1月10日
     */
    private Long id;
    /**
     * @description: 药方id
     * @author：RenBin
     * @createTime：2021年1月10日
     */
    private Long prescriptionId;
    /**
     * @description: 挂号费
     * @author：RenBin
     * @createTime：2021/1/17 21:00
     */
    private BigDecimal registrationFee;
    /**
     * @description: 挂号费提成
     * @author：RenBin
     * @createTime：2021/1/17 21:00
     */
    private BigDecimal registrationFeeAmount;
}
