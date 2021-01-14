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
public class UserInfoVO {

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
     * @description: 会员等级
     * @author：RenBin
     * @createTime：2021/1/10 9:08
     */
    @ApiModelProperty(value = "会员等级", name = "level")
    private Integer level;
    /**
     * @description: 年龄
     * @author：RenBin
     * @createTime：2021/1/10 9:08
     */
    @ApiModelProperty(value = "年龄", name = "age")
    private Integer age;
}
