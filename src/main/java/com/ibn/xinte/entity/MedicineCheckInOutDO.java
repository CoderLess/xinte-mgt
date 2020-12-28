package com.ibn.xinte.entity;

import lombok.Data;

import java.math.BigDecimal;

/**
 * @version 1.0
 * @description:
 * @projectName：xinte
 * @see: com.ibn.xinte.entity
 * @author： RenBin
 * @createTime：2020年12月28日
 */
@Data
public class MedicineCheckInOutDO {

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
     * @description: 入库数量
     * @author：RenBin
     * @createTime：2020年12月28日
     */
    private BigDecimal number;
    /**
     * @description: 药方id
     * @author：RenBin
     * @createTime：2020年12月28日
     */
    private Long prescriptionId;
    /**
     * @description: 类型 1：入库 2：出库
     * @author：RenBin
     * @createTime：2020年12月28日
     */
    private Integer type;
    /**
     * @description: 操作人id
     * @author：RenBin
     * @createTime：2020年12月28日
     */
    private Long adminId;
    /**
     * @description: 备注
     * @author：RenBin
     * @createTime：2020年12月28日
     */
    private String mark;
    /**
     * @description: 创建时间
     * @author：RenBin
     * @createTime：2020年12月28日
     */
    private Long createTime;
    }
