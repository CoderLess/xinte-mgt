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
 * @createTime：2021年1月10日
 */
@Data
@ApiModel(value = "生产商基本信息",description = "生产商基本信息")
public class FactoryBaseVO {

    private static final long serialVersionUID = 1L;

    /**
     * @description: 主键
     * @author：RenBin
     * @createTime：2021年1月10日
     */
    @ApiModelProperty(value="主键", name = "id")
    private Long id;
    /**
     * @description: 生产商名称
     * @author：RenBin
     * @createTime：2021年1月10日
     */
    @ApiModelProperty(value="生产商名称", name = "name")
    private String name;
    /**
     * @description: 简称
     * @author：RenBin
     * @createTime：2021年1月10日
     */
    @ApiModelProperty(value="简称", name = "shortName")
    private String shortName;
    }
