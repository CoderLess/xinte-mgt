package com.ibn.xinte.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @version 1.0
 * @description:
 * @projectName：xinte
 * @see: com.ibn.xinte.vo
 * @author： RenBin
 * @createTime：2020年12月28日
 */
@Data
@ApiModel(value = "药方基本信息",description = "药方基本信息")
public class PrescriptionBaseVO {

    private static final long serialVersionUID = 1L;

    /**
     * @description: 主键
     * @author：RenBin
     * @createTime：2020年12月28日
     */
    @ApiModelProperty(value="主键", name = "主键")
    private Long id;
    /**
     * @description: 医师
     * @author：RenBin
     * @createTime：2020年12月28日
     */
    @ApiModelProperty(value="医师", name = "医师")
    private Long adminId;
    /**
     * @description: 会员
     * @author：RenBin
     * @createTime：2020年12月28日
     */
    @ApiModelProperty(value="会员", name = "会员")
    private Long userId;
    /**
     * @description: 用药开始时间
     * @author：RenBin
     * @createTime：2020年12月28日
     */
    @ApiModelProperty(value="用药开始时间", name = "用药开始时间")
    private Long medicationTimeStart;
    /**
     * @description: 用药结束时间
     * @author：RenBin
     * @createTime：2020年12月28日
     */
    @ApiModelProperty(value="用药结束时间", name = "用药结束时间")
    private Long medicationTimeEnd;
    /**
     * @description: 病因
     * @author：RenBin
     * @createTime：2020年12月28日
     */
    @ApiModelProperty(value="病因", name = "病因")
    private String pathogeny;
    /**
     * @description: 备注
     * @author：RenBin
     * @createTime：2020年12月28日
     */
    @ApiModelProperty(value="备注", name = "备注")
    private String remark;
    /**
     * @description: 创建时间
     * @author：RenBin
     * @createTime：2020年12月28日
     */
    @ApiModelProperty(value="创建时间", name = "创建时间")
    private Long createTime;
    }
