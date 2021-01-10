package com.ibn.xinte.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import com.google.common.collect.Lists;
import com.ibn.xinte.dao.PaymentDetailDao;
import com.ibn.xinte.domain.PaymentDetailDTO;
import com.ibn.xinte.entity.PaymentDetailDO;
import com.ibn.xinte.service.PaymentDetailService;
import com.ibn.xinte.util.BeanUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;

/**
 * @version 1.0
 * @description:
 * @projectName：xinte
 * @see: com.ibn.xinte.service.impl
 * @author： RenBin
 * @createTime：2021年1月5日
 */
@Service("paymentDetailSerive")
public class PaymentDetailServiceImpl implements PaymentDetailService {

    private static final Logger logger = LoggerFactory.getLogger(BeanUtils.class);

    @Autowired
    private PaymentDetailDao paymentDetailDao;

    @Override
    public Long save(PaymentDetailDTO paymentDetailDTO) {
        if (null == paymentDetailDTO) {
            return null;
        }
        PaymentDetailDO paymentDetailDO = new PaymentDetailDO();
        BeanUtils.copyProperties(paymentDetailDTO, paymentDetailDO);
        paymentDetailDao.save(paymentDetailDO);
        return paymentDetailDO.getId();
    }

    @Override
    public Long saveBatch(List<PaymentDetailDTO> paymentDetailDTOList) {
        if (CollectionUtils.isEmpty(paymentDetailDTOList)) {
            return null;
        }
        List<PaymentDetailDO> paymentDetailDOList;
        try {
            paymentDetailDOList = BeanUtils.convertList(paymentDetailDTOList, PaymentDetailDO.class);
        } catch (Exception e) {
            String msg = String.format("PaymentDetailServiceImp.saveBatch方法llist转换失败：%s",
                    JSONObject.toJSONString(paymentDetailDTOList));
            logger.error(msg, e);
            return null;
        }
        return paymentDetailDao.saveBatch(paymentDetailDOList);
    }

    @Override
    public Integer updateById(PaymentDetailDTO paymentDetailDTO) {
        if (null == paymentDetailDTO) {
            return null;
        }
        PaymentDetailDO paymentDetailDO = new PaymentDetailDO();
        BeanUtils.copyProperties(paymentDetailDTO, paymentDetailDO);
        return paymentDetailDao.updateById(paymentDetailDO);
    }

    @Override
    public Integer deleteById(Long id) {
        if (null == id) {
            return null;
        }
        return paymentDetailDao.deleteById(id);
    }

    @Override
    public PaymentDetailDTO queryById(Long id) {
        if (null == id) {
            return null;
        }
        PaymentDetailDO paymentDetailDO = paymentDetailDao.queryById(id);
        if (null == paymentDetailDO) {
            return null;
        }
        PaymentDetailDTO paymentDetailDTO = new PaymentDetailDTO();
        BeanUtils.copyProperties(paymentDetailDO, paymentDetailDTO);
        return paymentDetailDTO;
    }

    @Override
    public List<PaymentDetailDTO> queryList(PaymentDetailDTO paymentDetailDTO) {
        if (null == paymentDetailDTO) {
            return null;
        }
        PaymentDetailDO paymentDetailDO = new PaymentDetailDO();
        BeanUtils.copyProperties(paymentDetailDTO, paymentDetailDO);
        List<PaymentDetailDO> paymentDetailDOList = paymentDetailDao.queryList(paymentDetailDO);
        if (CollectionUtils.isEmpty(paymentDetailDOList)) {
            return Lists.newArrayList();
        }
        List<PaymentDetailDTO> paymentDetailDTOList;
        try {
            paymentDetailDTOList=BeanUtils.convertList(paymentDetailDOList, PaymentDetailDTO.class);
        } catch (Exception e) {
            String msg = String.format("PaymentDetailServiceImpl.queryList方法list转换失败：%s",
                    JSONObject.toJSONString(paymentDetailDOList));
            logger.error(msg, e);
            return Lists.newArrayList();
        }
        return paymentDetailDTOList;
    }

    @Override
    public PageInfo<PaymentDetailDTO> queryPageInfo(PaymentDetailDTO paymentDetailDTO, Integer pageNum, Integer pageSize) {
        if (null == paymentDetailDTO) {
            return null;
        }
        PaymentDetailDO paymentDetailDO = new PaymentDetailDO();
        BeanUtils.copyProperties(paymentDetailDTO, paymentDetailDO);
        Page<PaymentDetailDO> paymentDetailDOPage = paymentDetailDao.queryList(paymentDetailDO);
        PageInfo<PaymentDetailDTO> paymentDetailDTOPageInfo = new PageInfo<>();
        if (CollectionUtils.isEmpty(paymentDetailDOPage)) {
            paymentDetailDTOPageInfo.setTotal(0);
            return paymentDetailDTOPageInfo;
        }
        List<PaymentDetailDTO> paymentDetailDTOList;
        try {
            paymentDetailDTOList=BeanUtils.convertList(paymentDetailDOPage, PaymentDetailDTO.class);
        } catch (Exception e) {
            String msg = String.format("PaymentDetailServiceImpl.queryPageInfo方法list转换失败：%s",
                    JSONObject.toJSONString(paymentDetailDOPage));
            logger.error(msg, e);
            paymentDetailDTOPageInfo.setTotal(0);
            return paymentDetailDTOPageInfo;
        }
        paymentDetailDTOPageInfo.setList(paymentDetailDTOList);
        paymentDetailDTOPageInfo.setTotal(paymentDetailDOPage.getTotal());
        return paymentDetailDTOPageInfo;
    }
}
