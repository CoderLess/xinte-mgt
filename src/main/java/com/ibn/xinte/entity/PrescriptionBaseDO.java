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
public class PrescriptionBaseDO {

    private static final long serialVersionUID = 1L;

    /**
     * @description: 主键
     * @author：RenBin
     * @createTime：2020年12月28日
     */
    private Long id;
    /**
     * @description: 医师
     * @author：RenBin
     * @createTime：2020年12月28日
     */
    private Long adminId;
    /**
     * @description: 会员
     * @author：RenBin
     * @createTime：2020年12月28日
     */
    private Long userId;
    /**
     * @description: 用药开始时间
     * @author：RenBin
     * @createTime：2020年12月28日
     */
    private Long medicationTimeStart;
    /**
     * @description: 用药结束时间
     * @author：RenBin
     * @createTime：2020年12月28日
     */
    private Long medicationTimeEnd;
    /**
     * @description: 病因
     * @author：RenBin
     * @createTime：2020年12月28日
     */
    private String pathogeny;
    /**
     * @description: 备注
     * @author：RenBin
     * @createTime：2020年12月28日
     */
    private String remark;
    /**
     * @description: 创建时间
     * @author：RenBin
     * @createTime：2020年12月28日
     */
    private Long createTime;
    }
