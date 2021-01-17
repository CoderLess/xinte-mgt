package com.ibn.xinte.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import com.google.common.collect.Lists;
import com.ibn.xinte.dao.PrescriptionBaseDao;
import com.ibn.xinte.dao.PrescriptionMedicineDao;
import com.ibn.xinte.domain.PrescriptionMedicineDTO;
import com.ibn.xinte.entity.PrescriptionBaseDO;
import com.ibn.xinte.entity.PrescriptionMedicineDO;
import com.ibn.xinte.enumeration.YesOrNoEnum;
import com.ibn.xinte.exception.IbnException;
import com.ibn.xinte.service.PrescriptionBaseService;
import com.ibn.xinte.service.PrescriptionMedicineService;
import com.ibn.xinte.util.BeanUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.math.BigDecimal;
import java.util.List;

/**
 * @version 1.0
 * @description:
 * @projectName：xinte
 * @see: com.ibn.xinte.service.impl
 * @author： RenBin
 * @createTime：2020年12月28日
 */
@Service("prescriptionMedicineSerive")
public class PrescriptionMedicineServiceImpl implements PrescriptionMedicineService {

    private static final Logger logger = LoggerFactory.getLogger(BeanUtils.class);

    @Autowired
    private PrescriptionMedicineDao prescriptionMedicineDao;
    @Autowired
    private PrescriptionBaseDao prescriptionBaseDao;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Long save(PrescriptionMedicineDTO prescriptionMedicineDTO) throws IbnException {
        if (null == prescriptionMedicineDTO) {
            return null;
        }
        PrescriptionMedicineDO prescriptionMedicineDO = new PrescriptionMedicineDO();
        BeanUtils.copyProperties(prescriptionMedicineDTO, prescriptionMedicineDO);
        prescriptionMedicineDao.save(prescriptionMedicineDO);
        return prescriptionMedicineDO.getId();
    }

    @Override
    public Long saveBatch(List<PrescriptionMedicineDTO> prescriptionMedicineDTOList) {
        if (CollectionUtils.isEmpty(prescriptionMedicineDTOList)) {
            return null;
        }
        List<PrescriptionMedicineDO> prescriptionMedicineDOList;
        try {
            prescriptionMedicineDOList = BeanUtils.convertList(prescriptionMedicineDTOList, PrescriptionMedicineDO.class);
        } catch (Exception e) {
            String msg = String.format("PrescriptionMedicineServiceImp.saveBatch方法llist转换失败：%s",
                    JSONObject.toJSONString(prescriptionMedicineDTOList));
            logger.error(msg, e);
            return null;
        }
        return prescriptionMedicineDao.saveBatch(prescriptionMedicineDOList);
    }

    @Override
    public Integer updateById(PrescriptionMedicineDTO prescriptionMedicineDTO) {
        if (null == prescriptionMedicineDTO) {
            return null;
        }
        PrescriptionMedicineDO prescriptionMedicineDO = new PrescriptionMedicineDO();
        BeanUtils.copyProperties(prescriptionMedicineDTO, prescriptionMedicineDO);
        return prescriptionMedicineDao.updateById(prescriptionMedicineDO);
    }

    @Override
    public Integer deleteById(Long id) {
        if (null == id) {
            return null;
        }
        return prescriptionMedicineDao.deleteById(id);
    }

    @Override
    public PrescriptionMedicineDTO queryById(Long id) {
        if (null == id) {
            return null;
        }
        PrescriptionMedicineDO prescriptionMedicineDO = prescriptionMedicineDao.queryById(id);
        if (null == prescriptionMedicineDO) {
            return null;
        }
        PrescriptionMedicineDTO prescriptionMedicineDTO = new PrescriptionMedicineDTO();
        BeanUtils.copyProperties(prescriptionMedicineDO, prescriptionMedicineDTO);
        return prescriptionMedicineDTO;
    }

    @Override
    public List<PrescriptionMedicineDTO> queryList(PrescriptionMedicineDTO prescriptionMedicineDTO) {
        if (null == prescriptionMedicineDTO) {
            return null;
        }
        PrescriptionMedicineDO prescriptionMedicineDO = new PrescriptionMedicineDO();
        BeanUtils.copyProperties(prescriptionMedicineDTO, prescriptionMedicineDO);
        List<PrescriptionMedicineDO> prescriptionMedicineDOList = prescriptionMedicineDao.queryList(prescriptionMedicineDO);
        if (CollectionUtils.isEmpty(prescriptionMedicineDOList)) {
            return Lists.newArrayList();
        }
        List<PrescriptionMedicineDTO> prescriptionMedicineDTOList;
        try {
            prescriptionMedicineDTOList=BeanUtils.convertList(prescriptionMedicineDOList, PrescriptionMedicineDTO.class);
        } catch (Exception e) {
            String msg = String.format("PrescriptionMedicineServiceImpl.queryList方法list转换失败：%s",
                    JSONObject.toJSONString(prescriptionMedicineDOList));
            logger.error(msg, e);
            return Lists.newArrayList();
        }
        return prescriptionMedicineDTOList;
    }

    @Override
    public List<PrescriptionMedicineDTO> queryInfoList(PrescriptionMedicineDTO prescriptionMedicineDTO) {
        return prescriptionMedicineDao.queryInfoList(prescriptionMedicineDTO);
    }

    @Override
    public PageInfo<PrescriptionMedicineDTO> queryPageInfo(PrescriptionMedicineDTO prescriptionMedicineDTO, Integer pageNum, Integer pageSize) {
        if (null == prescriptionMedicineDTO) {
            return null;
        }
        PrescriptionMedicineDO prescriptionMedicineDO = new PrescriptionMedicineDO();
        BeanUtils.copyProperties(prescriptionMedicineDTO, prescriptionMedicineDO);
        Page<PrescriptionMedicineDO> prescriptionMedicineDOPage = prescriptionMedicineDao.queryList(prescriptionMedicineDO);
        PageInfo<PrescriptionMedicineDTO> prescriptionMedicineDTOPageInfo = new PageInfo<>();
        if (CollectionUtils.isEmpty(prescriptionMedicineDOPage)) {
            prescriptionMedicineDTOPageInfo.setTotal(0);
            return prescriptionMedicineDTOPageInfo;
        }
        List<PrescriptionMedicineDTO> prescriptionMedicineDTOList;
        try {
            prescriptionMedicineDTOList=BeanUtils.convertList(prescriptionMedicineDOPage, PrescriptionMedicineDTO.class);
        } catch (Exception e) {
            String msg = String.format("PrescriptionMedicineServiceImpl.queryPageInfo方法list转换失败：%s",
                    JSONObject.toJSONString(prescriptionMedicineDOPage));
            logger.error(msg, e);
            prescriptionMedicineDTOPageInfo.setTotal(0);
            return prescriptionMedicineDTOPageInfo;
        }
        prescriptionMedicineDTOPageInfo.setList(prescriptionMedicineDTOList);
        prescriptionMedicineDTOPageInfo.setTotal(prescriptionMedicineDOPage.getTotal());
        return prescriptionMedicineDTOPageInfo;
    }

    @Override
    public BigDecimal calculatePrice(Long prescriptionId) {
        PrescriptionMedicineDO prescriptionMedicineDO = new PrescriptionMedicineDO();
        prescriptionMedicineDO.setPrescriptionId(prescriptionId);
        Page<PrescriptionMedicineDO> prescriptionMedicineDOPage = prescriptionMedicineDao.queryList(prescriptionMedicineDO);
        if (CollectionUtils.isEmpty(prescriptionMedicineDOPage)) {
            return new BigDecimal(0);
        }
        // 计算总价格
        BigDecimal totalAmount = new BigDecimal("0");
        BigDecimal totalAmountCommissionAmount = new BigDecimal("0");
        for (PrescriptionMedicineDO curPrescriptionMedicineDO : prescriptionMedicineDOPage) {
            totalAmount = totalAmount.add(curPrescriptionMedicineDO.getSellingPrice().multiply(curPrescriptionMedicineDO.getNumber()));
            // 计算提成
            if (YesOrNoEnum.YES.getCode().equals(curPrescriptionMedicineDO.getHaveCommission())) {
                totalAmountCommissionAmount = totalAmountCommissionAmount.add(curPrescriptionMedicineDO.getSellingPrice().multiply(curPrescriptionMedicineDO.getNumber()));
            }
        }
        BigDecimal amount = totalAmount.setScale(2);
        PrescriptionBaseDO prescriptionBaseDO = new PrescriptionBaseDO();
        prescriptionBaseDO.setId(prescriptionId);
        prescriptionBaseDO.setAmount(amount);
        prescriptionBaseDO.setCommissionAmount(totalAmountCommissionAmount);
        prescriptionBaseDao.updateById(prescriptionBaseDO);
        return amount;
    }
}
