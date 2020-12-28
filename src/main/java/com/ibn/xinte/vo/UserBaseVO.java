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
@ApiModel(value = "用户基本信息",description = "用户基本信息")
public class UserBaseVO {

    private static final long serialVersionUID = 1L;

    /**
     * @description: 主键
     * @author：RenBin
     * @createTime：2020年12月28日
     */
    @ApiModelProperty(value="主键", name = "主键")
    private Long id;
    /**
     * @description: 用户名
     * @author：RenBin
     * @createTime：2020年12月28日
     */
    @ApiModelProperty(value="用户名", name = "用户名")
    private String username;
    /**
     * @description: 手机号
     * @author：RenBin
     * @createTime：2020年12月28日
     */
    @ApiModelProperty(value="手机号", name = "手机号")
    private String mobile;
    /**
     * @description: 性别 1：男 2：女
     * @author：RenBin
     * @createTime：2020年12月28日
     */
    @ApiModelProperty(value="性别 1：男 2：女", name = "性别 1：男 2：女")
    private Long sex;
    /**
     * @description: 出生日期
     * @author：RenBin
     * @createTime：2020年12月28日
     */
    @ApiModelProperty(value="出生日期", name = "出生日期")
    private Long birthday;
    /**
     * @description: 禁用用户 0:否，1:是
     * @author：RenBin
     * @createTime：2020年12月28日
     */
    @ApiModelProperty(value="禁用用户 0:否，1:是", name = "禁用用户 0:否，1:是")
    private Integer disable;
    /**
     * @description: 创建时间
     * @author：RenBin
     * @createTime：2020年12月28日
     */
    @ApiModelProperty(value="创建时间", name = "创建时间")
    private Long createTime;
    /**
     * @description: 用户创建人
     * @author：RenBin
     * @createTime：2020年12月28日
     */
    @ApiModelProperty(value="用户创建人", name = "用户创建人")
    private Long adminId;
    }
