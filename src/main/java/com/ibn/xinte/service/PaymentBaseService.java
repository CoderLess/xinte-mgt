package com.ibn.xinte.service;

import com.github.pagehelper.PageInfo;
import com.ibn.xinte.domain.PayStatisticDTO;
import com.ibn.xinte.domain.PaymentBaseDTO;

import java.util.List;

/**
 * @version 1.0
 * @description:
 * @projectName：xinte
 * @see: com.ibn.xinte.service
 * @author： RenBin
 * @createTime：2021年1月5日
 */
public interface PaymentBaseService {

    /**
     * @description: 保存支付信息
     * @author：RenBin
     * @createTime：2021年1月5日
     */
    Long save(PaymentBaseDTO paymentBaseDTO);

    /**
     * @description: 批量保存支付信息
     * @author：RenBin
     * @createTime：2021年1月5日
     */
    Long saveBatch(List<PaymentBaseDTO> paymentBaseDTOList);

    /**
     * @description: 更新支付信息
     * @author：RenBin
     * @createTime：2021年1月5日
     */
    Integer updateById(PaymentBaseDTO paymentBaseDTO);

    /**
     * @description: 根据Id删除支付信息
     * @author：RenBin
     * @createTime：2021年1月5日
     */
    Integer deleteById(Long id);

    /**
     * @description: 通过id查询支付信息
     * @author：RenBin
     * @createTime：2021年1月5日
     */
    PaymentBaseDTO queryById(Long id);

    /**
     * @description: 通过条件查询支付信息
     * @author：RenBin
     * @createTime：2021年1月5日
     */
    List<PaymentBaseDTO> queryList(PaymentBaseDTO paymentBaseDTO);

    /**
     * @description: 统计
     * @author：RenBin
     * @createTime：2021/1/5 19:53
     */
    PayStatisticDTO queryPayStatistic(PaymentBaseDTO paymentBaseDTO);
    /**
     * @description: 通过条件查询管理员信息
     * @author：RenBin
     * @createTime：2020年12月28日
     * @return
     */
    PageInfo<PaymentBaseDTO> queryPageInfo(PaymentBaseDTO paymentBaseDTO, Integer pageNum, Integer pageSize);
}
