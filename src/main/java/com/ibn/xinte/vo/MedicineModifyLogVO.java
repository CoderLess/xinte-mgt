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
@ApiModel(value = "药品修改日志信息", description = "药品修改日志信息")
public class MedicineModifyLogVO {

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
    @ApiModelProperty(value = "药品id", name = "medicinalId")
    private Long medicinalId;
    /**
     * @description: 编号
     * @author：RenBin
     * @createTime：2020年12月28日
     */
    @ApiModelProperty(value = "编号", name = "code")
    private String code;
    /**
     * @description: 厂家
     * @author：RenBin
     * @createTime：2020年12月28日
     */
    @ApiModelProperty(value = "厂家", name = "factoryId")
    private Long factoryId;
    /**
     * @description: 规格
     * @author：RenBin
     * @createTime：2020年12月28日
     */
    @ApiModelProperty(value = "规格", name = "spec")
    private String spec;
    /**
     * @description: 数量
     * @author：RenBin
     * @createTime：2020年12月28日
     */
    @ApiModelProperty(value = "数量", name = "number")
    private BigDecimal number;
    /**
     * @description: 进价
     * @author：RenBin
     * @createTime：2020年12月28日
     */
    @ApiModelProperty(value = "进价", name = "purchasePrice")
    private BigDecimal purchasePrice;
    /**
     * @description: 售价
     * @author：RenBin
     * @createTime：2020年12月28日
     */
    @ApiModelProperty(value = "售价", name = "sellingPrice")
    private BigDecimal sellingPrice;
    /**
     * @description: 创建人
     * @author：RenBin
     * @createTime：2020年12月28日
     */
    @ApiModelProperty(value = "创建人", name = "creatorId")
    private Long creatorId;
    /**
     * @description: 创建时间
     * @author：RenBin
     * @createTime：2020年12月28日
     */
    @ApiModelProperty(value = "创建时间", name = "createTime")
    private Long createTime;
    /**
     * @description: 更新人
     * @author：RenBin
     * @createTime：2020年12月28日
     */
    @ApiModelProperty(value = "更新人", name = "updateId")
    private Long updateId;
    /**
     * @description: 更新时间
     * @author：RenBin
     * @createTime：2020年12月28日
     */
    @ApiModelProperty(value = "更新时间", name = "updateTime")
    private Long updateTime;
    /**
     * @description: 记录创建时间
     * @author：RenBin
     * @createTime：2020年12月28日
     */
    @ApiModelProperty(value = "记录创建时间", name = "recordCreateTime")
    private Long recordCreateTime;
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
