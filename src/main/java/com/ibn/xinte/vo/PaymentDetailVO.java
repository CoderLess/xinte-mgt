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
@ApiModel(value = "支付详情信息", description = "支付详情信息")
public class PaymentDetailVO {

    private static final long serialVersionUID = 1L;

    /**
     * @description: 支付金额
     * @author：RenBin
     * @createTime：2021年1月5日
     */
    @ApiModelProperty(value = "支付金额", name = "amount")
    private BigDecimal amount;
    /**
     * @description: 主键
     * @author：RenBin
     * @createTime：2021年1月5日
     */
    @ApiModelProperty(value = "主键", name = "id")
    private Long id;
    /**
     * @description: 支付方式 1：现金 2：微信 3：支付宝 4：医保卡
     * @author：RenBin
     * @createTime：2021年1月5日
     */
    @ApiModelProperty(value = "支付方式 1：现金 2：微信 3：支付宝 4：医保卡", name = "method")
    private Integer method;
    /**
     * @description: 支付信息id
     * @author：RenBin
     * @createTime：2021年1月5日
     */
    @ApiModelProperty(value = "支付信息id", name = "paymentId")
    private Long paymentId;
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
