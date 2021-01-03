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
@ApiModel(value = "角色基本信息表", description = "角色基本信息表")
public class RoleBaseVO {

    private static final long serialVersionUID = 1L;

    /**
     * @description: 主键
     * @author：RenBin
     * @createTime：2020年12月28日
     */
    @ApiModelProperty(value = "主键", name = "id")
    private Long id;
    /**
     * @description: 角色名
     * @author：RenBin
     * @createTime：2020年12月28日
     */
    @ApiModelProperty(value = "角色名", name = "name")
    private String name;
    /**
     * @description: 权限
     * @author：RenBin
     * @createTime：2020年12月28日
     */
    @ApiModelProperty(value = "权限", name = "authority")
    private String authority;
    /**
     * @description: 提成比例
     * @author：RenBin
     * @createTime：2020年12月28日
     */
    @ApiModelProperty(value = "提成比例", name = "commission")
    private BigDecimal commission;
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
