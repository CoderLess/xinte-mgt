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
 * @createTime：2021年1月10日
 */
@Data
@ApiModel(value = "", description = "")
public class MedicinePriceVO {

    private static final long serialVersionUID = 1L;

    /**
     * @description: 主键
     * @author：RenBin
     * @createTime：2021年1月10日
     */
    @ApiModelProperty(value = "主键", name = "id")
    private Long id;
    /**
     * @description: 药品id
     * @author：RenBin
     * @createTime：2021年1月10日
     */
    @ApiModelProperty(value = "药品id", name = "medicineId")
    private Long medicineId;
    /**
     * @description: 售价
     * @author：RenBin
     * @createTime：2021年1月10日
     */
    @ApiModelProperty(value = "售价", name = "sellingPrice")
    private BigDecimal sellingPrice;
    /**
     * @description: 用户等级
     * @author：RenBin
     * @createTime：2021年1月10日
     */
    @ApiModelProperty(value = "用户等级", name = "userLevel")
    private Integer userLevel;
}
