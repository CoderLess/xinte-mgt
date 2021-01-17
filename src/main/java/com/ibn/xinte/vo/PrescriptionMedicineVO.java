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
@ApiModel(value = "药方对应药品信息", description = "药方对应药品信息")
public class PrescriptionMedicineVO {

    private static final long serialVersionUID = 1L;

    /**
     * @description: 主键
     * @author：RenBin
     * @createTime：2020年12月28日
     */
    @ApiModelProperty(value = "主键", name = "id")
    private Long id;
    /**
     * @description: 药方id
     * @author：RenBin
     * @createTime：2020年12月28日
     */
    @ApiModelProperty(value = "药方id", name = "prescriptionId")
    private Long prescriptionId;
    /**
     * @description: 药品id
     * @author：RenBin
     * @createTime：2020年12月28日
     */
    @ApiModelProperty(value = "药品id", name = "medicinalId")
    private Long medicinalId;
    /**
     * @description: 售出 0:否，1:是
     * @author：RenBin
     * @createTime：2020年12月28日
     */
    @ApiModelProperty(value = "售出 0:否，1:是", name = "sold")
    private Integer sold;
    /**
     * @description: 售出数量
     * @author：RenBin
     * @createTime：2020年12月28日
     */
    @ApiModelProperty(value = "售出数量", name = "number")
    private BigDecimal number;
    /**
     * @description: 售出价格
     * @author：RenBin
     * @createTime：2020年12月28日
     */
    @ApiModelProperty(value = "售出价格", name = "sellingPrice")
    private BigDecimal sellingPrice;
    /**
     * @description: 药品进价
     * @author：RenBin
     * @createTime：2020年12月28日
     */
    @ApiModelProperty(value = "药品进价", name = "purchasePrice")
    private BigDecimal purchasePrice;
    /**
     * @description: 创建时间
     * @author：RenBin
     * @createTime：2020年12月28日
     */
    @ApiModelProperty(value = "创建时间", name = "createTime")
    private Long createTime;
    /**
     * @description: 药品是否有提成 0:否 1：是
     * @author：RenBin
     * @createTime：2020年12月28日
     */
    private Integer haveCommission;
    /**
     * @description: 页码
     * @author：RenBin
     * @createTime：2021/1/3 15:58
     */
    @ApiModelProperty(value = "页码", name = "pageNum")
    private Integer pageNum;
    /**
     * @description: 条数
     * @author：RenBin
     * @createTime：2021/1/3 15:58
     */
    @ApiModelProperty(value = "条数", name = "pageSize")
    private Integer pageSize;
}
