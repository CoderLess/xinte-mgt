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
@ApiModel(value = "角色基本信息表",description = "角色基本信息表")
public class RoleBaseVO {

    private static final long serialVersionUID = 1L;

    /**
     * @description: 主键
     * @author：RenBin
     * @createTime：2020年12月28日
     */
    @ApiModelProperty(value="主键", name = "主键")
    private Long id;
    /**
     * @description: 角色名
     * @author：RenBin
     * @createTime：2020年12月28日
     */
    @ApiModelProperty(value="角色名", name = "角色名")
    private String name;
    /**
     * @description: 权限
     * @author：RenBin
     * @createTime：2020年12月28日
     */
    @ApiModelProperty(value="权限", name = "权限")
    private String authority;
    }
