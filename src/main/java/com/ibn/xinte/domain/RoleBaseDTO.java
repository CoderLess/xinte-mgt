package com.ibn.xinte.domain;

import lombok.Data;

import java.math.BigDecimal;

/**
 * @version 1.0
 * @description:
 * @projectName：xinte
 * @see: com.ibn.xinte.domain
 * @author： RenBin
 * @createTime：2020年12月28日
 */
@Data
public class RoleBaseDTO {

    private static final long serialVersionUID = 1L;

    /**
     * @description: 主键
     * @author：RenBin
     * @createTime：2020年12月28日
     */
    private Long id;
    /**
     * @description: 角色名
     * @author：RenBin
     * @createTime：2020年12月28日
     */
    private String name;
    /**
     * @description: 权限
     * @author：RenBin
     * @createTime：2020年12月28日
     */
    private String authority;
    /**
     * @description: 提成比例
     * @author：RenBin
     * @createTime：2020年12月28日
     */
    private BigDecimal commission;
}
