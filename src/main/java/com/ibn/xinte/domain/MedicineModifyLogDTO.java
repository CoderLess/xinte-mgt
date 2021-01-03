package com.ibn.xinte.domain;

import lombok.Data;

import java.math.BigDecimal;

/**
 * @version 1.0
 * @description:
 * @projectName：xinte
 * @see: com.ibn.xinte.domain
 * @author： RenBin
 * @createTime：2020年12月28日
 */
@Data
public class MedicineModifyLogDTO {

    private static final long serialVersionUID = 1L;

    /**
     * @description: 主键
     * @author：RenBin
     * @createTime：2020年12月28日
     */
    private Long id;
    /**
     * @description: 药品id
     * @author：RenBin
     * @createTime：2020年12月28日
     */
    private Long medicinalId;
    /**
     * @description: 编号
     * @author：RenBin
     * @createTime：2020年12月28日
     */
    private String code;
    /**
     * @description: 厂家
     * @author：RenBin
     * @createTime：2020年12月28日
     */
    private Long factoryId;
    /**
     * @description: 规格
     * @author：RenBin
     * @createTime：2020年12月28日
     */
    private String spec;
    /**
     * @description: 数量
     * @author：RenBin
     * @createTime：2020年12月28日
     */
    private BigDecimal number;
    /**
     * @description: 进价
     * @author：RenBin
     * @createTime：2020年12月28日
     */
    private BigDecimal purchasePrice;
    /**
     * @description: 售价
     * @author：RenBin
     * @createTime：2020年12月28日
     */
    private BigDecimal sellingPrice;
    /**
     * @description: 创建人
     * @author：RenBin
     * @createTime：2020年12月28日
     */
    private Long creatorId;
    /**
     * @description: 创建时间
     * @author：RenBin
     * @createTime：2020年12月28日
     */
    private Long createTime;
    /**
     * @description: 更新人
     * @author：RenBin
     * @createTime：2020年12月28日
     */
    private Long updateId;
    /**
     * @description: 更新时间
     * @author：RenBin
     * @createTime：2020年12月28日
     */
    private Long updateTime;
    /**
     * @description: 记录创建时间
     * @author：RenBin
     * @createTime：2020年12月28日
     */
    private Long recordCreateTime;
}
