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
 * @createTime：2021年1月5日
 */
@Data
@ApiModel(value = "支付基本信息", description = "支付基本信息")
public class PaymentBaseVO {

    private static final long serialVersionUID = 1L;

    /**
     * @description: 主键
     * @author：RenBin
     * @createTime：2021年1月5日
     */
    @ApiModelProperty(value = "主键", name = "id")
    private Long id;
    /**
     * @description: 支付金额
     * @author：RenBin
     * @createTime：2021年1月5日
     */
    @ApiModelProperty(value = "支付金额", name = "amount")
    private BigDecimal amount;
    /**
     * @description: 创建时间
     * @author：RenBin
     * @createTime：2021年1月5日
     */
    @ApiModelProperty(value = "创建时间", name = "createTime")
    private Long createTime;
    /**
     * @description: 操作人
     * @author：RenBin
     * @createTime：2021年1月5日
     */
    @ApiModelProperty(value = "操作人", name = "creator")
    private Long creator;
    /**
     * @description: 药方id
     * @author：RenBin
     * @createTime：2021年1月5日
     */
    @ApiModelProperty(value = "药方id", name = "prescriptionId")
    private Long prescriptionId;
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
