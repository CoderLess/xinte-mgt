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
public class MedicinePriceDTO {

    private static final long serialVersionUID = 1L;

    /**
     * @description: 主键
     * @author：RenBin
     * @createTime：2021年1月10日
     */
    private Long id;
    /**
     * @description: 药品id
     * @author：RenBin
     * @createTime：2021年1月10日
     */
    private Long medicineId;
    /**
     * @description: 售价
     * @author：RenBin
     * @createTime：2021年1月10日
     */
    private BigDecimal sellingPrice;
    /**
     * @description: 用户等级
     * @author：RenBin
     * @createTime：2021年1月10日
     */
    private Integer userLevel;
}
