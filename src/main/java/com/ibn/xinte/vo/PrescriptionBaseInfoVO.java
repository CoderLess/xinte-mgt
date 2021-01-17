package com.ibn.xinte.vo;

import com.ibn.xinte.domain.PrescriptionMedicineDTO;
import lombok.Data;

import java.util.List;

/**
 * @version 1.0
 * @description:
 * @projectName：xinte
 * @see: com.ibn.xinte.vo
 * @author： RenBin
 * @createTime：2021/01/14 20:42
 */
@Data
public class PrescriptionBaseInfoVO {
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
     * @description: 用户基本信息
     * @author：RenBin
     * @createTime：2021/1/14 21:03
     */
    private UserInfoVO userInfoVO;

    /**
     * @description: 管理员基本信息
     * @author：RenBin
     * @createTime：2021/1/17 21:52
     */
    private AdminInfoVO adminInfoVO;

    /**
     * @description: 药方中的明细信息
     * @author：RenBin
     * @createTime：2021/1/11 22:48
     */
    private List<PrescriptionMedicineDTO> prescriptionMedicineDTOList;
}
