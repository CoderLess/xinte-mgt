package com.ibn.xinte.service;

import com.github.pagehelper.PageInfo;
import com.ibn.xinte.domain.AdminBaseDTO;
import com.ibn.xinte.domain.PaymentDetailDTO;

import java.util.List;

/**
 * @version 1.0
 * @description:
 * @projectName：xinte
 * @see: com.ibn.xinte.service
 * @author： RenBin
 * @createTime：2021年1月5日
 */
public interface PaymentDetailService {

    /**
     * @description: 保存用户信息
     * @author：RenBin
     * @createTime：2021年1月5日
     */
    Long save(PaymentDetailDTO paymentDetailDTO);

    /**
     * @description: 批量保存用户信息
     * @author：RenBin
     * @createTime：2021年1月5日
     */
    Long saveBatch(List<PaymentDetailDTO> paymentDetailDTOList);

    /**
     * @description: 更新用户信息
     * @author：RenBin
     * @createTime：2021年1月5日
     */
    Integer updateById(PaymentDetailDTO paymentDetailDTO);

    /**
     * @description: 根据Id删除用户信息
     * @author：RenBin
     * @createTime：2021年1月5日
     */
    Integer deleteById(Long id);

    /**
     * @description: 通过id查询用户信息
     * @author：RenBin
     * @createTime：2021年1月5日
     */
    PaymentDetailDTO queryById(Long id);

    /**
     * @description: 通过条件查询用户信息
     * @author：RenBin
     * @createTime：2021年1月5日
     */
    List<PaymentDetailDTO> queryList(PaymentDetailDTO paymentDetailDTO);
    /**
     * @description: 通过条件查询管理员信息
     * @author：RenBin
     * @createTime：2020年12月28日
     */
    PageInfo<PaymentDetailDTO> queryPageInfo(PaymentDetailDTO paymentDetailDTO, Integer pageNum, Integer pageSize);
}
