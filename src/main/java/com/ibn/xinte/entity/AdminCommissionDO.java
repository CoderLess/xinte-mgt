package com.ibn.xinte.entity;

import lombok.Data;

import java.math.BigDecimal;

/**
 * @version 1.0
 * @description:
 * @projectName：demo
 * @see: com.ibn.demo.entity
 * @author： RenBin
 * @createTime：2021年1月10日
 */
@Data
public class AdminCommissionDO {

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
}
