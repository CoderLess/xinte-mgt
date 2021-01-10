package com.ibn.xinte.dao;

import com.ibn.xinte.domain.MedicinePriceDTO;
import com.ibn.xinte.entity.MedicinePriceDO;

/**
 * @version 1.0
 * @description:
 * @projectName：demo
 * @see: com.ibn.demo.dao
 * @author： RenBin
 * @createTime：2021年1月10日
 */
public interface MedicinePriceDao extends BaseDao<MedicinePriceDO> {
    MedicinePriceDO queryByIdLevel(Long id, Integer level);
}
