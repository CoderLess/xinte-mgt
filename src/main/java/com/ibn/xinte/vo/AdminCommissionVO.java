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
public class AdminCommissionVO {

    private static final long serialVersionUID = 1L;

    /**
     * @description: 管理员id
     * @author：RenBin
     * @createTime：2021年1月10日
     */
    @ApiModelProperty(value = "管理员id", name = "adminId")
    private Long adminId;
    /**
     * @description: 提成
     * @author：RenBin
     * @createTime：2021年1月10日
     */
    @ApiModelProperty(value = "提成", name = "commissionAmount")
    private BigDecimal commissionAmount;
    /**
     * @description: 提成比例
     * @author：RenBin
     * @createTime：2021年1月10日
     */
    @ApiModelProperty(value = "提成比例", name = "commission")
    private BigDecimal commission;
    /**
     * @description: 提成比例
     * @author：RenBin
     * @createTime：2021年1月10日
     */
    @ApiModelProperty(value = "总价格", name = "amount")
    private BigDecimal amount;
    /**
     * @description: 创建时间
     * @author：RenBin
     * @createTime：2021年1月10日
     */
    @ApiModelProperty(value = "创建时间", name = "createTime")
    private Long createTime;
    /**
     * @description: 主键
     * @author：RenBin
     * @createTime：2021年1月10日
     */
    @ApiModelProperty(value = "主键", name = "id")
    private Long id;
    /**
     * @description: 药方id
     * @author：RenBin
     * @createTime：2021年1月10日
     */
    @ApiModelProperty(value = "药方id", name = "prescriptionId")
    private Long prescriptionId;
    /**
     * @description: 挂号费
     * @author：RenBin
     * @createTime：2021/1/17 21:00
     */
    private BigDecimal registrationFee;
    /**
     * @description: 挂号费提成
     * @author：RenBin
     * @createTime：2021/1/17 21:00
     */
    private BigDecimal registrationFeeAmount;
}
