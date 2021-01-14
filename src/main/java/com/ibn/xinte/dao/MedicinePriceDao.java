package com.ibn.xinte.dao;

import com.ibn.xinte.domain.MedicinePriceDTO;
import com.ibn.xinte.entity.MedicinePriceDO;
import org.apache.ibatis.annotations.Param;

import java.math.BigDecimal;

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
    /**
     * @description: 查询产品价格信息
     * @author：RenBin
     * @createTime：2021/1/14 21:41
     */
    BigDecimal queryMedicinePriceInfo(@Param("prescriptionId") Long prescriptionId, @Param("medicineId") Long medicineId);
}
