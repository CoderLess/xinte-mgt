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
@ApiModel(value = "药方基本信息", description = "药方基本信息")
public class PrescriptionBaseVO {

    private static final long serialVersionUID = 1L;

    /**
     * @description: 主键
     * @author：RenBin
     * @createTime：2020年12月28日
     */
    @ApiModelProperty(value = "主键", name = "id")
    private Long id;
    /**
     * @description: 医师
     * @author：RenBin
     * @createTime：2020年12月28日
     */
    @ApiModelProperty(value = "医师", name = "adminId")
    private Long adminId;
    /**
     * @description: 会员
     * @author：RenBin
     * @createTime：2020年12月28日
     */
    @ApiModelProperty(value = "会员", name = "userId")
    private Long userId;
    /**
     * @description: 用药开始时间
     * @author：RenBin
     * @createTime：2020年12月28日
     */
    @ApiModelProperty(value = "用药开始时间", name = "medicationTimeStart")
    private Long medicationTimeStart;
    /**
     * @description: 用药结束时间
     * @author：RenBin
     * @createTime：2020年12月28日
     */
    @ApiModelProperty(value = "用药结束时间", name = "medicationTimeEnd")
    private Long medicationTimeEnd;
    /**
     * @description: 病因
     * @author：RenBin
     * @createTime：2020年12月28日
     */
    @ApiModelProperty(value = "病因", name = "pathogeny")
    private String pathogeny;
    /**
     * @description: 备注
     * @author：RenBin
     * @createTime：2020年12月28日
     */
    @ApiModelProperty(value = "备注", name = "remark")
    private String remark;
    /**
     * @description: 创建时间
     * @author：RenBin
     * @createTime：2020年12月28日
     */
    @ApiModelProperty(value = "创建时间", name = "createTime")
    private Long createTime;
    /**
     * @description: 类型 0：诊断药单 1：临时药单
     * @author：RenBin
     * @createTime：2021/1/6 21:19
     */
    @ApiModelProperty(value = "类型 0：诊断药单 1：临时药单", name = "type")
    private Integer type;
    /**
     * @description: 是否已经付款 0：否 1：是
     * @author：RenBin
     * @createTime：2021/1/6 21:19
     */
    @ApiModelProperty(value = "是否已经付款 0：否 1：是", name = "payment")
    private Integer payment;
    /**
     * @description: 创建时间开始
     * @author：RenBin
     * @createTime：2020年12月28日
     */
    @ApiModelProperty(value = "创建时间", name = "createTimeStart")
    private Long createTimeStart;
    /**
     * @description: 创建时间结束
     * @author：RenBin
     * @createTime：2020年12月28日
     */
    @ApiModelProperty(value = "创建时间", name = "createTimeEnd")
    private Long createTimeEnd;
    /**
     * @description: 后台人员姓名
     * @author：RenBin
     * @createTime：2021/1/9 12:43
     */
    @ApiModelProperty(value = "后台人员姓名", name = "adminName")
    private String adminName;
    /**
     * @description: 会员姓名
     * @author：RenBin
     * @createTime：2021/1/9 12:43
     */
    @ApiModelProperty(value = "会员姓名", name = "username")
    private String username;
    /**
     * @description: 药单总价格
     * @author：RenBin
     * @createTime：2021/1/6 21:19
     */
    @ApiModelProperty(value = "药单总价格", name = "amount")
    private BigDecimal amount;
    /**
     * @description: 挂号费
     * @author：RenBin
     * @createTime：2021/1/6 21:19
     */
    @ApiModelProperty(value = "挂号费", name = "registrationFee")
    private BigDecimal registrationFee;
    /**
     * @description: 药品提成总额
     * @author：RenBin
     * @createTime：2020年12月28日
     */
    @ApiModelProperty(value = "药品提成总额", name = "commissionAmount")
    private BigDecimal commissionAmount;
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
