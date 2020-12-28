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
@ApiModel(value = "管理人员信息",description = "管理人员信息")
public class AdminBaseVO {

    private static final long serialVersionUID = 1L;

    /**
     * @description: 主键
     * @author：RenBin
     * @createTime：2020年12月28日
     */
    @ApiModelProperty(value="主键", name = "主键")
    private Long id;
    /**
     * @description: 手机号
     * @author：RenBin
     * @createTime：2020年12月28日
     */
    @ApiModelProperty(value="手机号", name = "手机号")
    private String mobile;
    /**
     * @description: 密码
     * @author：RenBin
     * @createTime：2020年12月28日
     */
    @ApiModelProperty(value="密码", name = "密码")
    private String password;
    /**
     * @description: 角色id
     * @author：RenBin
     * @createTime：2020年12月28日
     */
    @ApiModelProperty(value="角色id", name = "角色id")
    private Long roleId;
    /**
     * @description: 是否禁用 0:否，1:是
     * @author：RenBin
     * @createTime：2020年12月28日
     */
    @ApiModelProperty(value="是否禁用 0:否，1:是", name = "是否禁用 0:否，1:是")
    private Integer disable;
    /**
     * @description: 创建时间
     * @author：RenBin
     * @createTime：2020年12月28日
     */
    @ApiModelProperty(value="创建时间", name = "创建时间")
    private Long createTime;
    /**
     * @description: 创建人
     * @author：RenBin
     * @createTime：2020年12月28日
     */
    @ApiModelProperty(value="创建人", name = "创建人")
    private Long creatorId;
    /**
     * @description: 最后更新时间
     * @author：RenBin
     * @createTime：2020年12月28日
     */
    @ApiModelProperty(value="最后更新时间", name = "最后更新时间")
    private Long lastAccess;
    /**
     * @description: 姓名
     * @author：RenBin
     * @createTime：2020年12月28日
     */
    @ApiModelProperty(value="姓名", name = "姓名")
    private String name;
    }
