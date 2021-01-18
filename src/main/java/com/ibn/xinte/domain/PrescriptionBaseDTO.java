package com.ibn.xinte.domain;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

/**
 * @version 1.0
 * @description:
 * @projectName：xinte
 * @see: com.ibn.xinte.domain
 * @author： RenBin
 * @createTime：2020年12月28日
 */
@Data
public class PrescriptionBaseDTO {

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
    /**
     * @description: 类型 0：诊断药单 1：临时药单
     * @author：RenBin
     * @createTime：2021/1/6 21:19
     */
    private Integer type;
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
     * @description: 是否已经付款 0：否 1：是
     * @author：RenBin
     * @createTime：2021/1/6 21:19
     */
    private Integer payment;
    /**
     * @description: 后台人员姓名
     * @author：RenBin
     * @createTime：2021/1/9 12:43
     */
    private String adminName;
    /**
     * @description: 会员姓名
     * @author：RenBin
     * @createTime：2021/1/9 12:43
     */
    private String username;
    /**
     * @description: 药单总价格
     * @author：RenBin
     * @createTime：2021/1/6 21:19
     */
    private BigDecimal amount;
    /**
     * @description: 挂号费
     * @author：RenBin
     * @createTime：2021/1/6 21:19
     */
    private BigDecimal registrationFee;
    /**
     * @description: 药品提成总额
     * @author：RenBin
     * @createTime：2020年12月28日
     */
    private BigDecimal commissionAmount;
    /**
     * @description: 就诊次数
     * @author：RenBin
     * @createTime：2020年12月28日
     */
    private Integer number;

    /**
     * @description: 药方中的明细信息
     * @author：RenBin
     * @createTime：2021/1/11 22:48
     */
    private List<PrescriptionMedicineDTO> prescriptionMedicineDTOList;
}
