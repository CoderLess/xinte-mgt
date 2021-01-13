package com.ibn.xinte.dao;

import com.ibn.xinte.domain.PrescriptionMedicineDTO;
import com.ibn.xinte.entity.PrescriptionMedicineDO;

import java.util.List;

/**
 * @version 1.0
 * @description:
 * @projectName：xinte
 * @see: com.ibn.xinte.dao
 * @author： RenBin
 * @createTime：2020年12月28日
 */
public interface PrescriptionMedicineDao extends BaseDao<PrescriptionMedicineDO> {
    /**
     * @description: 根据条件查询药品相关信息
     * @author：RenBin
     * @createTime：2021/1/11 23:00
     */
    List<PrescriptionMedicineDTO> queryInfoList(PrescriptionMedicineDTO prescriptionMedicineDTO);
}
