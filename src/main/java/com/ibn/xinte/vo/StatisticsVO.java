package com.ibn.xinte.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;

/**
 * @version 1.0
 * @description:
 * @projectName：xinte-mgt
 * @see: com.ibn.xinte.vo
 * @author： RenBin
 * @createTime：2021/01/05 20:13
 */
@Data
@ApiModel(value = "首页统计相关信息", description = "首页统计相关信息")
public class StatisticsVO {
    /**
     * @description: 会员总人数
     * @author：RenBin
     * @createTime：2021/1/5 20:15
     */
    @ApiModelProperty(value = "会员总人数", name = "userCount")
    private Integer userCount;
    /**
     * @description: 今日会员总人数
     * @author：RenBin
     * @createTime：2021/1/5 20:15
     */
    @ApiModelProperty(value = "今日会员总人数", name = "userCountTody")
    private Integer userCountTody;
    /**
     * @description: 当日交易次数
     * @author：RenBin
     * @createTime：2021/1/5 20:15
     */
    @ApiModelProperty(value = "当日交易次数", name = "totalNumber")
    private Integer totalNumber;
    /**
     * @description: 当日交易额
     * @author：RenBin
     * @createTime：2021/1/5 20:15
     */
    @ApiModelProperty(value = "当日交易额", name = "totalAmount")
    private BigDecimal totalAmount;

}
