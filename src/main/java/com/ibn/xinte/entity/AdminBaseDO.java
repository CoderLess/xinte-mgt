package com.ibn.xinte.entity;

import lombok.Data;

import java.math.BigDecimal;

/**
 * @version 1.0
 * @description:
 * @projectName：xinte
 * @see: com.ibn.xinte.entity
 * @author： RenBin
 * @createTime：2020年12月28日
 */
@Data
public class AdminBaseDO {

    private static final long serialVersionUID = 1L;

    /**
     * @description: 主键
     * @author：RenBin
     * @createTime：2020年12月28日
     */
    private Long id;
    /**
     * @description: 手机号
     * @author：RenBin
     * @createTime：2020年12月28日
     */
    private String mobile;
    /**
     * @description: 密码
     * @author：RenBin
     * @createTime：2020年12月28日
     */
    private String password;
    /**
     * @description: 角色id
     * @author：RenBin
     * @createTime：2020年12月28日
     */
    private Long roleId;
    /**
     * @description: 是否禁用 0:否，1:是
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
    private Long creatorId;
    /**
     * @description: 最后更新时间
     * @author：RenBin
     * @createTime：2020年12月28日
     */
    private Long lastAccess;
    /**
     * @description: 姓名
     * @author：RenBin
     * @createTime：2020年12月28日
     */
    private String name;
    }
