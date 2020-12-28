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
@ApiModel(value = "权限基本信息",description = "权限基本信息")
public class AuthorityBaseVO {

    private static final long serialVersionUID = 1L;

    /**
     * @description: 主键
     * @author：RenBin
     * @createTime：2020年12月28日
     */
    @ApiModelProperty(value="主键", name = "主键")
    private Long id;
    /**
     * @description: 权限名
     * @author：RenBin
     * @createTime：2020年12月28日
     */
    @ApiModelProperty(value="权限名", name = "权限名")
    private String name;
    /**
     * @description: 接口
     * @author：RenBin
     * @createTime：2020年12月28日
     */
    @ApiModelProperty(value="接口", name = "接口")
    private String url;
    }
