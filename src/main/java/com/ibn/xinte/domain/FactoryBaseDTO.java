package com.ibn.xinte.domain;

import lombok.Data;

/**
 * @version 1.0
 * @description:
 * @projectName：xinte
 * @see: com.ibn.xinte.domain
 * @author： RenBin
 * @createTime：2021年1月10日
 */
@Data
public class FactoryBaseDTO {

    private static final long serialVersionUID = 1L;

    /**
     * @description: 主键
     * @author：RenBin
     * @createTime：2021年1月10日
     */
    private Long id;
    /**
     * @description: 生产商名称
     * @author：RenBin
     * @createTime：2021年1月10日
     */
    private String name;
    /**
     * @description: 简称
     * @author：RenBin
     * @createTime：2021年1月10日
     */
    private String shortName;
}
