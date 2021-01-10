package com.ibn.xinte.domain;

import com.ibn.xinte.vo.PaymentDetailVO;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

/**
 * @version 1.0
 * @description:
 * @projectName：xinte
 * @see: com.ibn.xinte.domain
 * @author： RenBin
 * @createTime：2021年1月5日
 */
@Data
public class PaymentBaseDTO {

    private static final long serialVersionUID = 1L;
    /**
     * @description: 主键
     * @author：RenBin
     * @createTime：2021年1月5日
     */
    private Long id;
    /**
     * @description: 支付金额
     * @author：RenBin
     * @createTime：2021年1月5日
     */
    private BigDecimal amount;
    /**
     * @description: 创建时间
     * @author：RenBin
     * @createTime：2021年1月5日
     */
    private Long createTime;
    /**
     * @description: 创建时间开始
     * @author：RenBin
     * @createTime：2021年1月5日
     */
    private Long createTimeStart;
    /**
     * @description: 创建时间结束
     * @author：RenBin
     * @createTime：2021年1月5日
     */
    private Long createTimeEnd;
    /**
     * @description: 操作人
     * @author：RenBin
     * @createTime：2021年1月5日
     */
    private Long creator;
    /**
     * @description: 药方id
     * @author：RenBin
     * @createTime：2021年1月5日
     */
    private Long prescriptionId;
    /**
     * @description: 支付方式
     * @author：RenBin
     * @createTime：2021/1/10 12:37
     */
    private List<PaymentDetailVO> paymentDetailVOList;
}
