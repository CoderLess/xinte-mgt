package com.ibn.xinte.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.google.common.collect.Lists;
import com.ibn.xinte.dao.MedicineBaseDao;
import com.ibn.xinte.domain.MedicineBaseDTO;
import com.ibn.xinte.entity.MedicineBaseDO;
import com.ibn.xinte.service.MedicineBaseService;
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
@Service("medicineBaseSerive")
public class MedicineBaseServiceImpl implements MedicineBaseService {

    private static final Logger logger = LoggerFactory.getLogger(BeanUtils.class);

    @Autowired
    private MedicineBaseDao medicineBaseDao;

    @Override
    public Long save(MedicineBaseDTO medicineBaseDTO) {
        if (null == medicineBaseDTO) {
            return null;
        }
        MedicineBaseDO medicineBaseDO = new MedicineBaseDO();
        BeanUtils.copyProperties(medicineBaseDTO, medicineBaseDO);
        medicineBaseDao.save(medicineBaseDO);
        return medicineBaseDO.getId();
    }

    @Override
    public Long saveBatch(List<MedicineBaseDTO> medicineBaseDTOList) {
        if (CollectionUtils.isEmpty(medicineBaseDTOList)) {
            return null;
        }
        List<MedicineBaseDO> medicineBaseDOList;
        try {
            medicineBaseDOList = BeanUtils.convertList(medicineBaseDTOList, MedicineBaseDO.class);
        } catch (Exception e) {
            String msg = String.format("MedicineBaseServiceImp.saveBatch方法llist转换失败：%s",
                    JSONObject.toJSONString(medicineBaseDTOList));
            logger.error(msg, e);
            return null;
        }
        return medicineBaseDao.saveBatch(medicineBaseDOList);
    }

    @Override
    public Integer updateById(MedicineBaseDTO medicineBaseDTO) {
        if (null == medicineBaseDTO) {
            return null;
        }
        MedicineBaseDO medicineBaseDO = new MedicineBaseDO();
        BeanUtils.copyProperties(medicineBaseDTO, medicineBaseDO);
        return medicineBaseDao.updateById(medicineBaseDO);
    }

    @Override
    public Integer deleteById(Long id) {
        if (null == id) {
            return null;
        }
        return medicineBaseDao.deleteById(id);
    }

    @Override
    public MedicineBaseDTO queryById(Long id) {
        if (null == id) {
            return null;
        }
        MedicineBaseDO medicineBaseDO = medicineBaseDao.queryById(id);
        if (null == medicineBaseDO) {
            return null;
        }
        MedicineBaseDTO medicineBaseDTO = new MedicineBaseDTO();
        BeanUtils.copyProperties(medicineBaseDO, medicineBaseDTO);
        return medicineBaseDTO;
    }

    @Override
    public List<MedicineBaseDTO> queryList(MedicineBaseDTO medicineBaseDTO) {
        if (null == medicineBaseDTO) {
            return null;
        }
        MedicineBaseDO medicineBaseDO = new MedicineBaseDO();
        BeanUtils.copyProperties(medicineBaseDTO, medicineBaseDO);
        List<MedicineBaseDO> medicineBaseDOList = medicineBaseDao.queryList(medicineBaseDO);
        if (CollectionUtils.isEmpty(medicineBaseDOList)) {
            return Lists.newArrayList();
        }
        List<MedicineBaseDTO> medicineBaseDTOList;
        try {
            medicineBaseDTOList=BeanUtils.convertList(medicineBaseDOList, MedicineBaseDTO.class);
        } catch (Exception e) {
            String msg = String.format("MedicineBaseServiceImpl.queryList方法list转换失败：%s",
                    JSONObject.toJSONString(medicineBaseDOList));
            logger.error(msg, e);
            return Lists.newArrayList();
        }
        return medicineBaseDTOList;
    }
}
