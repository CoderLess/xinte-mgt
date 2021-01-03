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
