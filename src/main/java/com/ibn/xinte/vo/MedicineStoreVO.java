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
@ApiModel(value = "药品仓库基本信息",description = "药品仓库基本信息")
public class MedicineStoreVO {

    private static final long serialVersionUID = 1L;

    /**
     * @description: 主键
     * @author：RenBin
     * @createTime：2020年12月28日
     */
    @ApiModelProperty(value="主键", name = "主键")
    private Long id;
    /**
     * @description: 药品id
     * @author：RenBin
     * @createTime：2020年12月28日
     */
    @ApiModelProperty(value="药品id", name = "药品id")
    private Long medicineId;
    /**
     * @description: 数量
     * @author：RenBin
     * @createTime：2020年12月28日
     */
    @ApiModelProperty(value="数量", name = "数量")
    private BigDecimal number;
    }
