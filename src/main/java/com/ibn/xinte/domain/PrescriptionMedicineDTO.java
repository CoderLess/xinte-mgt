package com.ibn.xinte.domain;

import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

/**
 * @version 1.0
 * @description:
 * @projectName：xinte
 * @see: com.ibn.xinte.domain
 * @author： RenBin
 * @createTime：2020年12月28日
 */
@Data
public class PrescriptionMedicineDTO {

    private static final long serialVersionUID = 1L;

    /**
     * @description: 主键
     * @author：RenBin
     * @createTime：2020年12月28日
     */
    private Long id;
    /**
     * @description: 药品名称
     * @author：RenBin
     * @createTime：2021/1/11 23:03
     */
    private String name;
    /**
     * @description: 药方id
     * @author：RenBin
     * @createTime：2020年12月28日
     */
    private Long prescriptionId;
    /**
     * @description: 药品id
     * @author：RenBin
     * @createTime：2020年12月28日
     */
    private Long medicinalId;
    /**
     * @description: 售出 0:否，1:是
     * @author：RenBin
     * @createTime：2020年12月28日
     */
    private Integer sold;
    /**
     * @description: 售出数量
     * @author：RenBin
     * @createTime：2020年12月28日
     */
    private BigDecimal number;
    /**
     * @description: 售出价格
     * @author：RenBin
     * @createTime：2020年12月28日
     */
    private BigDecimal sellingPrice;
    /**
     * @description: 药品进价
     * @author：RenBin
     * @createTime：2020年12月28日
     */
    private BigDecimal purchasePrice;
    /**
     * @description: 创建时间
     * @author：RenBin
     * @createTime：2020年12月28日
     */
    private Long createTime;
    /**
     * @description: 厂家
     * @author：RenBin
     * @createTime：2020年12月28日
     */
    private String factory;
    /**
     * @description: 编码
     * @author：RenBin
     * @createTime：2020年12月28日
     */
    private String code;
    /**
     * @description: 药品是否有提成 0:否 1：是
     * @author：RenBin
     * @createTime：2020年12月28日
     */
    private Integer haveCommission;
}
