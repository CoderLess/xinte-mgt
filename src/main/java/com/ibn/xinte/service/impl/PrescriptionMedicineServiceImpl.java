package com.ibn.xinte.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.google.common.collect.Lists;
import com.ibn.xinte.dao.PrescriptionMedicineDao;
import com.ibn.xinte.domain.PrescriptionMedicineDTO;
import com.ibn.xinte.entity.PrescriptionMedicineDO;
import com.ibn.xinte.service.PrescriptionMedicineService;
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
 * @createTime：2020年12月28日
 */
@Service("prescriptionMedicineSerive")
public class PrescriptionMedicineServiceImpl implements PrescriptionMedicineService {

    private static final Logger logger = LoggerFactory.getLogger(BeanUtils.class);

    @Autowired
    private PrescriptionMedicineDao prescriptionMedicineDao;

    @Override
    public Long save(PrescriptionMedicineDTO prescriptionMedicineDTO) {
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
}