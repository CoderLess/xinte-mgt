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
@ApiModel(value = "登录日志信息",description = "登录日志信息")
public class LoginLogVO {

    private static final long serialVersionUID = 1L;

    /**
     * @description: 主键
     * @author：RenBin
     * @createTime：2020年12月28日
     */
    @ApiModelProperty(value="主键", name = "主键")
    private Long id;
    /**
     * @description: 管理员id
     * @author：RenBin
     * @createTime：2020年12月28日
     */
    @ApiModelProperty(value="管理员id", name = "管理员id")
    private Long adminId;
    /**
     * @description: 登录时间
     * @author：RenBin
     * @createTime：2020年12月28日
     */
    @ApiModelProperty(value="登录时间", name = "登录时间")
    private Long loginTime;
    /**
     * @description: 登入终端ip
     * @author：RenBin
     * @createTime：2020年12月28日
     */
    @ApiModelProperty(value="登入终端ip", name = "登入终端ip")
    private String ip;
    }
