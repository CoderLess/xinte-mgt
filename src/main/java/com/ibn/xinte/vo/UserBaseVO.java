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
@ApiModel(value = "用户基本信息", description = "用户基本信息")
public class UserBaseVO {

    private static final long serialVersionUID = 1L;

    /**
     * @description: 主键
     * @author：RenBin
     * @createTime：2020年12月28日
     */
    @ApiModelProperty(value = "主键", name = "id")
    private Long id;
    /**
     * @description: 用户名
     * @author：RenBin
     * @createTime：2020年12月28日
     */
    @ApiModelProperty(value = "用户名", name = "username")
    private String username;
    /**
     * @description: 手机号
     * @author：RenBin
     * @createTime：2020年12月28日
     */
    @ApiModelProperty(value = "手机号", name = "mobile")
    private String mobile;
    /**
     * @description: 性别 1：男 2：女
     * @author：RenBin
     * @createTime：2020年12月28日
     */
    @ApiModelProperty(value = "性别 1：男 2：女", name = "sex")
    private Long sex;
    /**
     * @description: 出生日期
     * @author：RenBin
     * @createTime：2020年12月28日
     */
    @ApiModelProperty(value = "出生日期", name = "birthday")
    private Long birthday;
    /**
     * @description: 禁用用户 0:否，1:是
     * @author：RenBin
     * @createTime：2020年12月28日
     */
    @ApiModelProperty(value = "禁用用户 0:否，1:是", name = "disable")
    private Integer disable;
    /**
     * @description: 创建时间
     * @author：RenBin
     * @createTime：2020年12月28日
     */
    @ApiModelProperty(value = "创建时间", name = "createTime")
    private Long createTime;
    /**
     * @description: 用户创建人
     * @author：RenBin
     * @createTime：2020年12月28日
     */
    @ApiModelProperty(value = "用户创建人", name = "adminId")
    private Long adminId;
    /**
     * @description: 创建时间开始
     * @author：RenBin
     * @createTime：2020年12月28日
     */
    @ApiModelProperty(value = "创建时间开始", name = "createTimeStart")
    private Long createTimeStart;
    /**
     * @description: 创建时间结束
     * @author：RenBin
     * @createTime：2020年12月28日
     */
    @ApiModelProperty(value = "创建时间结束", name = "createTimeEnd")
    private Long createTimeEnd;
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
