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
public class UserBaseDO {

    private static final long serialVersionUID = 1L;

    /**
     * @description: 主键
     * @author：RenBin
     * @createTime：2020年12月28日
     */
    private Long id;
    /**
     * @description: 用户名
     * @author：RenBin
     * @createTime：2020年12月28日
     */
    private String username;
    /**
     * @description: 手机号
     * @author：RenBin
     * @createTime：2020年12月28日
     */
    private String mobile;
    /**
     * @description: 性别 1：男 2：女
     * @author：RenBin
     * @createTime：2020年12月28日
     */
    private Long sex;
    /**
     * @description: 出生日期
     * @author：RenBin
     * @createTime：2020年12月28日
     */
    private Long birthday;
    /**
     * @description: 禁用用户 0:否，1:是
     * @author：RenBin
     * @createTime：2020年12月28日
     */
    private Integer disable;
    /**
     * @description: 创建时间
     * @author：RenBin
     * @createTime：2020年12月28日
     */
    private Long createTime;
    /**
     * @description: 用户创建人
     * @author：RenBin
     * @createTime：2020年12月28日
     */
    private Long adminId;
    /**
     * @description: 会员等级
     * @author：RenBin
     * @createTime：2021/1/10 9:08
     */
    private Integer level;
}
