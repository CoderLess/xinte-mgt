package com.ibn.xinte.dao;

import com.github.pagehelper.Page;
import com.ibn.xinte.domain.PrescriptionBaseDTO;
import com.ibn.xinte.entity.PrescriptionBaseDO;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;

/**
 * @version 1.0
 * @description:
 * @projectName：xinte
 * @see: com.ibn.xinte.dao
 * @author： RenBin
 * @createTime：2020年12月28日
 */
public interface PrescriptionBaseDao extends BaseDao<PrescriptionBaseDO> {

    /**
     * @description: 根据条件查询
     * @author：RenBin
     * @createTime：2021/1/4 20:21
     */
    List<PrescriptionBaseDO> queryListByDTO(PrescriptionBaseDTO prescriptionBaseDTO);
    /**
     * @description: 根据条件查询dto
     * @author：RenBin
     * @createTime：2021/1/9 12:38
     */
    Page<PrescriptionBaseDTO> queryListInfo(PrescriptionBaseDTO prescriptionBaseDTO);

    /**
     * @description: 根据药方查询管理员的提成比例
     * @author：RenBin
     * @createTime：2021/1/10 12:02
     */
    BigDecimal queryAdminCommission(Long prescriptionId);
}
