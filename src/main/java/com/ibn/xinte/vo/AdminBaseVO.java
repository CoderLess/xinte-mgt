package com.ibn.xinte.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
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
@ApiModel(value = "管理人员信息", description = "管理人员信息")
public class AdminBaseVO implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * @description: 主键
     * @author：RenBin
     * @createTime：2020年12月28日
     */
    @ApiModelProperty(value = "主键", name = "id")
    private Long id;
    /**
     * @description: 手机号
     * @author：RenBin
     * @createTime：2020年12月28日
     */
    @ApiModelProperty(value = "手机号", name = "mobile")
    private String mobile;
    /**
     * @description: 密码
     * @author：RenBin
     * @createTime：2020年12月28日
     */
    @ApiModelProperty(value = "密码", name = "password")
    private String password;
    /**
     * @description: 角色id
     * @author：RenBin
     * @createTime：2020年12月28日
     */
    @ApiModelProperty(value = "角色id", name = "roleId")
    private Long roleId;
    /**
     * @description: 是否禁用 0:否，1:是
     * @author：RenBin
     * @createTime：2020年12月28日
     */
    @ApiModelProperty(value = "是否禁用 0:否，1:是", name = "disable")
    private Integer disable;
    /**
     * @description: 创建时间
     * @author：RenBin
     * @createTime：2020年12月28日
     */
    @ApiModelProperty(value = "创建时间", name = "createTime")
    private Long createTime;
    /**
     * @description: 提成比例
     * @author：RenBin
     * @createTime：2021/1/10 9:01
     */
    private BigDecimal commission;
    /**
     * @description: 创建人
     * @author：RenBin
     * @createTime：2020年12月28日
     */
    @ApiModelProperty(value = "创建人", name = "creatorId")
    private Long creatorId;
    /**
     * @description: 最后更新时间
     * @author：RenBin
     * @createTime：2020年12月28日
     */
    @ApiModelProperty(value = "最后更新时间", name = "lastAccess")
    private Long lastAccess;
    /**
     * @description: 姓名
     * @author：RenBin
     * @createTime：2020年12月28日
     */
    @ApiModelProperty(value = "姓名", name = "name")
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
