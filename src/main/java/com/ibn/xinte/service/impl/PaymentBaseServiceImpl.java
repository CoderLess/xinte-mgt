package com.ibn.xinte.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.google.common.collect.Lists;
import com.ibn.xinte.dao.MedicineBaseDao;
import com.ibn.xinte.dao.PaymentBaseDao;
import com.ibn.xinte.dao.PaymentDetailDao;
import com.ibn.xinte.dao.PrescriptionMedicineDao;
import com.ibn.xinte.domain.PayStatisticDTO;
import com.ibn.xinte.domain.PaymentBaseDTO;
import com.ibn.xinte.entity.PaymentBaseDO;
import com.ibn.xinte.entity.PaymentDetailDO;
import com.ibn.xinte.entity.PrescriptionMedicineDO;
import com.ibn.xinte.enumeration.YesOrNoEnum;
import com.ibn.xinte.service.PaymentBaseService;
import com.ibn.xinte.service.PaymentDetailService;
import com.ibn.xinte.util.BeanUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.util.List;

/**
 * @version 1.0
 * @description:
 * @projectName：demo
 * @see: com.ibn.demo.service.impl
 * @author： RenBin
 * @createTime：2021年1月5日
 */
@Service("paymentBaseSerive")
public class PaymentBaseServiceImpl implements PaymentBaseService {

    private static final Logger logger = LoggerFactory.getLogger(BeanUtils.class);

    @Autowired
    private PaymentBaseDao paymentBaseDao;
    @Autowired
    private MedicineBaseDao medicineBaseDao;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Long save(PaymentBaseDTO paymentBaseDTO) {
        if (null == paymentBaseDTO) {
            return null;
        }
        PaymentBaseDO paymentBaseDO = new PaymentBaseDO();
        BeanUtils.copyProperties(paymentBaseDTO, paymentBaseDO);
        // 药品卖出，减少库存
        medicineBaseDao.drugSales(paymentBaseDTO.getPrescriptionId());
        // 保存出售记录
        paymentBaseDao.save(paymentBaseDO);
        return paymentBaseDO.getId();
    }

    @Override
    public Long saveBatch(List<PaymentBaseDTO> paymentBaseDTOList) {
        if (CollectionUtils.isEmpty(paymentBaseDTOList)) {
            return null;
        }
        List<PaymentBaseDO> paymentBaseDOList;
        try {
            paymentBaseDOList = BeanUtils.convertList(paymentBaseDTOList, PaymentBaseDO.class);
        } catch (Exception e) {
            String msg = String.format("PaymentBaseServiceImp.saveBatch方法llist转换失败：%s",
                    JSONObject.toJSONString(paymentBaseDTOList));
            logger.error(msg, e);
            return null;
        }
        return paymentBaseDao.saveBatch(paymentBaseDOList);
    }

    @Override
    public Integer updateById(PaymentBaseDTO paymentBaseDTO) {
        if (null == paymentBaseDTO) {
            return null;
        }
        PaymentBaseDO paymentBaseDO = new PaymentBaseDO();
        BeanUtils.copyProperties(paymentBaseDTO, paymentBaseDO);
        return paymentBaseDao.updateById(paymentBaseDO);
    }

    @Override
    public Integer deleteById(Long id) {
        if (null == id) {
            return null;
        }
        return paymentBaseDao.deleteById(id);
    }

    @Override
    public PaymentBaseDTO queryById(Long id) {
        if (null == id) {
            return null;
        }
        PaymentBaseDO paymentBaseDO = paymentBaseDao.queryById(id);
        if (null == paymentBaseDO) {
            return null;
        }
        PaymentBaseDTO paymentBaseDTO = new PaymentBaseDTO();
        BeanUtils.copyProperties(paymentBaseDO, paymentBaseDTO);
        return paymentBaseDTO;
    }

    @Override
    public List<PaymentBaseDTO> queryList(PaymentBaseDTO paymentBaseDTO) {
        if (null == paymentBaseDTO) {
            return null;
        }
        PaymentBaseDO paymentBaseDO = new PaymentBaseDO();
        BeanUtils.copyProperties(paymentBaseDTO, paymentBaseDO);
        List<PaymentBaseDO> paymentBaseDOList = paymentBaseDao.queryList(paymentBaseDO);
        if (CollectionUtils.isEmpty(paymentBaseDOList)) {
            return Lists.newArrayList();
        }
        List<PaymentBaseDTO> paymentBaseDTOList;
        try {
            paymentBaseDTOList=BeanUtils.convertList(paymentBaseDOList, PaymentBaseDTO.class);
        } catch (Exception e) {
            String msg = String.format("PaymentBaseServiceImpl.queryList方法list转换失败：%s",
                    JSONObject.toJSONString(paymentBaseDOList));
            logger.error(msg, e);
            return Lists.newArrayList();
        }
        return paymentBaseDTOList;
    }

    @Override
    public PayStatisticDTO queryPayStatistic(PaymentBaseDTO paymentBaseDTO) {
        return paymentBaseDao.queryPayStatistic(paymentBaseDTO);
    }
}
