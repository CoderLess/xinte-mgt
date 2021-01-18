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
public class AdminCommissionStaticsDTO {

    private static final long serialVersionUID = 1L;

    /**
     * @description: 管理员id
     * @author：RenBin
     * @createTime：2021年1月10日
     */
    private Long adminId;
    /**
     * @description: 管理员姓名
     * @author：RenBin
     * @createTime：2021年1月10日
     */
    private String adminName;
    /**
     * @description: 药品提成总金额
     * @author：RenBin
     * @createTime：2021年1月10日
     */
    private BigDecimal commissionAmount;
    /**
     * @description: 总价格
     * @author：RenBin
     * @createTime：2021年1月10日
     */
    private BigDecimal amount;
    /**
     * @description: 药方数量
     * @author：RenBin
     * @createTime：2021年1月10日
     */
    private Long prescriptionNum;
    /**
     * @description: 挂号费提成
     * @author：RenBin
     * @createTime：2021/1/17 21:00
     */
    private BigDecimal registrationFeeAmount;
}
