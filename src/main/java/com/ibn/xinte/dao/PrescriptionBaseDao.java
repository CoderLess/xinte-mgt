package com.ibn.xinte.dao;

import com.ibn.xinte.domain.PrescriptionBaseDTO;
import com.ibn.xinte.entity.PrescriptionBaseDO;

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
}
