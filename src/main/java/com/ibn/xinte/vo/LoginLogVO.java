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
@ApiModel(value = "登录日志信息", description = "登录日志信息")
public class LoginLogVO {

    private static final long serialVersionUID = 1L;

    /**
     * @description: 主键
     * @author：RenBin
     * @createTime：2020年12月28日
     */
    @ApiModelProperty(value = "主键", name = "id")
    private Long id;
    /**
     * @description: 管理员id
     * @author：RenBin
     * @createTime：2020年12月28日
     */
    @ApiModelProperty(value = "管理员id", name = "adminId")
    private Long adminId;
    /**
     * @description: 登录时间
     * @author：RenBin
     * @createTime：2020年12月28日
     */
    @ApiModelProperty(value = "登录时间", name = "loginTime")
    private Long loginTime;
    /**
     * @description: 登入终端ip
     * @author：RenBin
     * @createTime：2020年12月28日
     */
    @ApiModelProperty(value = "登入终端ip", name = "ip")
    private String ip;
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
