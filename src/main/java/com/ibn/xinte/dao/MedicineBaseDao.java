package com.ibn.xinte.dao;

import com.ibn.xinte.entity.MedicineBaseDO;

/**
 * @version 1.0
 * @description:
 * @projectName：xinte
 * @see: com.ibn.xinte.dao
 * @author： RenBin
 * @createTime：2020年12月28日
 */
public interface MedicineBaseDao extends BaseDao<MedicineBaseDO> {
    /**
     * @description: 药品卖出减少库存
     * @author：RenBin
     * @createTime：2021/1/6 22:16
     */
    void drugSales(Long id);
}
