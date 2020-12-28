package com.ibn.xinte.entity;

import lombok.Data;

/**
 * @version 1.0
 * @description:
 * @projectName：xinte
 * @see: com.ibn.xinte.entity
 * @author： RenBin
 * @createTime：2020年12月28日
 */
@Data
public class LoginLogDO {

    private static final long serialVersionUID = 1L;

    /**
     * @description: 主键
     * @author：RenBin
     * @createTime：2020年12月28日
     */
    private Long id;
    /**
     * @description: 管理员id
     * @author：RenBin
     * @createTime：2020年12月28日
     */
    private Long adminId;
    /**
     * @description: 登录时间
     * @author：RenBin
     * @createTime：2020年12月28日
     */
    private Long loginTime;
    /**
     * @description: 登入终端ip
     * @author：RenBin
     * @createTime：2020年12月28日
     */
    private String ip;
    }
