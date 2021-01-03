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
@ApiModel(value = "药品出入库记录", description = "药品出入库记录")
public class MedicineCheckInOutVO {

    private static final long serialVersionUID = 1L;

    /**
     * @description: 主键
     * @author：RenBin
     * @createTime：2020年12月28日
     */
    @ApiModelProperty(value = "主键", name = "id")
    private Long id;
    /**
     * @description: 药品id
     * @author：RenBin
     * @createTime：2020年12月28日
     */
    @ApiModelProperty(value = "药品id", name = "medicineId")
    private Long medicineId;
    /**
     * @description: 入库数量
     * @author：RenBin
     * @createTime：2020年12月28日
     */
    @ApiModelProperty(value = "入库数量", name = "number")
    private BigDecimal number;
    /**
     * @description: 出入库价格
     * @author：RenBin
     * @createTime：2020年12月28日
     */
    @ApiModelProperty(value = "出入库价格", name = "price")
    private BigDecimal price;
    /**
     * @description: 药方id
     * @author：RenBin
     * @createTime：2020年12月28日
     */
    @ApiModelProperty(value = "药方id", name = "prescriptionId")
    private Long prescriptionId;
    /**
     * @description: 类型 1：入库 2：出库
     * @author：RenBin
     * @createTime：2020年12月28日
     */
    @ApiModelProperty(value = "类型 1：入库 2：出库", name = "type")
    private Integer type;
    /**
     * @description: 操作人id
     * @author：RenBin
     * @createTime：2020年12月28日
     */
    @ApiModelProperty(value = "操作人id", name = "adminId")
    private Long adminId;
    /**
     * @description: 备注
     * @author：RenBin
     * @createTime：2020年12月28日
     */
    @ApiModelProperty(value = "备注", name = "mark")
    private String mark;
    /**
     * @description: 创建时间
     * @author：RenBin
     * @createTime：2020年12月28日
     */
    @ApiModelProperty(value = "创建时间", name = "createTime")
    private Long createTime;
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
