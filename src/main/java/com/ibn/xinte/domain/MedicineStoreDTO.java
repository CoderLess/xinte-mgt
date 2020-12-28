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
public class MedicineStoreDTO {

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
    private Long medicineId;
    /**
     * @description: 数量
     * @author：RenBin
     * @createTime：2020年12月28日
     */
    private BigDecimal number;
    }
