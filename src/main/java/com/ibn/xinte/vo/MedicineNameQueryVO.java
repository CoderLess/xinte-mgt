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
@ApiModel(value = "根据药品名和分页信息查询药品", description = "根据药品名和分页信息查询药品")
public class MedicineNameQueryVO {

    private static final long serialVersionUID = 1L;

    /**
     * @description: 药品名
     * @author：RenBin
     * @createTime：2020年12月28日
     */
    @ApiModelProperty(value = "药品名", name = "name")
    private String name;
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
