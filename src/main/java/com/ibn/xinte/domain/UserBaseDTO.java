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
public class UserBaseDTO {

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
     * @description: 创建时间开始
     * @author：RenBin
     * @createTime：2020年12月28日
     */
    private Long createTimeStart;
    /**
     * @description: 创建时间结束
     * @author：RenBin
     * @createTime：2020年12月28日
     */
    private Long createTimeEnd;
    /**
     * @description: 用户创建人
     * @author：RenBin
     * @createTime：2020年12月28日
     */
    private Long adminId;
    /**
     * @description: 手机号模糊匹配
     * @author：RenBin
     * @createTime：2021/1/6 20:57
     */
    private String mobileLike;
    /**
     * @description: 会员等级
     * @author：RenBin
     * @createTime：2021/1/10 9:08
     */
    private Integer level;
    /**
     * @description: 就诊次数
     * @author：RenBin
     * @createTime：2021/1/10 9:08
     */
    private Integer number;
    /**
     * @description: 总金额
     * @author：RenBin
     * @createTime：2021/1/10 9:08
     */
    private BigDecimal amount;
}
