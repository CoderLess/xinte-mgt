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
@ApiModel(value = "药品修改日志信息",description = "药品修改日志信息")
public class MedicineModifyLogVO {

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
    private Long medicinalId;
    /**
     * @description: 编号
     * @author：RenBin
     * @createTime：2020年12月28日
     */
    @ApiModelProperty(value="编号", name = "编号")
    private String code;
    /**
     * @description: 厂家
     * @author：RenBin
     * @createTime：2020年12月28日
     */
    @ApiModelProperty(value="厂家", name = "厂家")
    private Long factoryId;
    /**
     * @description: 规格
     * @author：RenBin
     * @createTime：2020年12月28日
     */
    @ApiModelProperty(value="规格", name = "规格")
    private String spec;
    /**
     * @description: 数量
     * @author：RenBin
     * @createTime：2020年12月28日
     */
    @ApiModelProperty(value="数量", name = "数量")
    private BigDecimal number;
    /**
     * @description: 进价
     * @author：RenBin
     * @createTime：2020年12月28日
     */
    @ApiModelProperty(value="进价", name = "进价")
    private BigDecimal purchasePrice;
    /**
     * @description: 售价
     * @author：RenBin
     * @createTime：2020年12月28日
     */
    @ApiModelProperty(value="售价", name = "售价")
    private BigDecimal sellingPrice;
    /**
     * @description: 创建人
     * @author：RenBin
     * @createTime：2020年12月28日
     */
    @ApiModelProperty(value="创建人", name = "创建人")
    private Long creatorId;
    /**
     * @description: 创建时间
     * @author：RenBin
     * @createTime：2020年12月28日
     */
    @ApiModelProperty(value="创建时间", name = "创建时间")
    private Long createTime;
    /**
     * @description: 更新人
     * @author：RenBin
     * @createTime：2020年12月28日
     */
    @ApiModelProperty(value="更新人", name = "更新人")
    private Long updateId;
    /**
     * @description: 更新时间
     * @author：RenBin
     * @createTime：2020年12月28日
     */
    @ApiModelProperty(value="更新时间", name = "更新时间")
    private Long updateTime;
    /**
     * @description: 记录创建时间
     * @author：RenBin
     * @createTime：2020年12月28日
     */
    @ApiModelProperty(value="记录创建时间", name = "记录创建时间")
    private Long recordCreateTime;
    }
