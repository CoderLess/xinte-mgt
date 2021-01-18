package com.ibn.xinte.dao;

import com.github.pagehelper.Page;
import com.ibn.xinte.domain.MedicineCheckInOutDTO;
import com.ibn.xinte.entity.MedicineCheckInOutDO;

/**
 * @version 1.0
 * @description:
 * @projectName：xinte
 * @see: com.ibn.xinte.dao
 * @author： RenBin
 * @createTime：2020年12月28日
 */
public interface MedicineCheckInOutDao extends BaseDao<MedicineCheckInOutDO> {
    Page<MedicineCheckInOutDTO> queryInfoList(MedicineCheckInOutDO medicineCheckInOutDO);
}
