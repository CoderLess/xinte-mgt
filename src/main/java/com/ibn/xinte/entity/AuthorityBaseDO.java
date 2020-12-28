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
public class AuthorityBaseDO {

    private static final long serialVersionUID = 1L;

    /**
     * @description: 主键
     * @author：RenBin
     * @createTime：2020年12月28日
     */
    private Long id;
    /**
     * @description: 权限名
     * @author：RenBin
     * @createTime：2020年12月28日
     */
    private String name;
    /**
     * @description: 接口
     * @author：RenBin
     * @createTime：2020年12月28日
     */
    private String url;
    }
