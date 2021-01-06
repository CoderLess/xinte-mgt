package com.ibn.xinte.dao;

import com.ibn.xinte.domain.PayStatisticDTO;
import com.ibn.xinte.domain.PaymentBaseDTO;
import com.ibn.xinte.entity.PaymentBaseDO;

/**
 * @version 1.0
 * @description:
 * @projectName：demo
 * @see: com.ibn.demo.dao
 * @author： RenBin
 * @createTime：2021年1月5日
 */
public interface PaymentBaseDao extends BaseDao<PaymentBaseDO> {
    /**
     * @description: 根据条件统计交易次数金额
     * @author：RenBin
     * @createTime：2021/1/5 20:00
     */
    PayStatisticDTO queryPayStatistic(PaymentBaseDTO paymentBaseDTO);
}
