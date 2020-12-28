package com.ibn.xinte.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;

/**
 * @version 1.0
 * @description:
 * @projectName：xinte
 * @see: com.ibn.xinte.vo
 * @author： RenBin
 * @createTime：2020年12月28日
 */
@Data
@ApiModel(value = "药方对应药品信息",description = "药方对应药品信息")
public class PrescriptionMedicineVO {

    private static final long serialVersionUID = 1L;

    /**
     * @description: 主键
     * @author：RenBin
     * @createTime：2020年12月28日
     */
    @ApiModelProperty(value="主键", name = "主键")
    private Long id;
    /**
     * @description: 药方id
     * @author：RenBin
     * @createTime：2020年12月28日
     */
    @ApiModelProperty(value="药方id", name = "药方id")
    private Long prescriptionId;
    /**
     * @description: 药品id
     * @author：RenBin
     * @createTime：2020年12月28日
     */
    @ApiModelProperty(value="药品id", name = "药品id")
    private Long medicinalId;
    /**
     * @description: 售出 0:否，1:是
     * @author：RenBin
     * @createTime：2020年12月28日
     */
    @ApiModelProperty(value="售出 0:否，1:是", name = "售出 0:否，1:是")
    private Integer sold;
    /**
     * @description: 售出数量
     * @author：RenBin
     * @createTime：2020年12月28日
     */
    @ApiModelProperty(value="售出数量", name = "售出数量")
    private BigDecimal number;
    /**
     * @description: 售出价格
     * @author：RenBin
     * @createTime：2020年12月28日
     */
    @ApiModelProperty(value="售出价格", name = "售出价格")
    private BigDecimal sellingPrice;
    /**
     * @description: 药品进价
     * @author：RenBin
     * @createTime：2020年12月28日
     */
    @ApiModelProperty(value="药品进价", name = "药品进价")
    private BigDecimal purchasePrice;
    /**
     * @description: 创建时间
     * @author：RenBin
     * @createTime：2020年12月28日
     */
    @ApiModelProperty(value="创建时间", name = "创建时间")
    private Long createTime;
    }
