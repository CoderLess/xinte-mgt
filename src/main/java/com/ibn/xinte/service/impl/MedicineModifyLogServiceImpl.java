package com.ibn.xinte.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.google.common.collect.Lists;
import com.ibn.xinte.dao.MedicineModifyLogDao;
import com.ibn.xinte.domain.MedicineModifyLogDTO;
import com.ibn.xinte.entity.MedicineModifyLogDO;
import com.ibn.xinte.service.MedicineModifyLogService;
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
@Service("medicineModifyLogSerive")
public class MedicineModifyLogServiceImpl implements MedicineModifyLogService {

    private static final Logger logger = LoggerFactory.getLogger(BeanUtils.class);

    @Autowired
    private MedicineModifyLogDao medicineModifyLogDao;

    @Override
    public Long save(MedicineModifyLogDTO medicineModifyLogDTO) {
        if (null == medicineModifyLogDTO) {
            return null;
        }
        MedicineModifyLogDO medicineModifyLogDO = new MedicineModifyLogDO();
        BeanUtils.copyProperties(medicineModifyLogDTO, medicineModifyLogDO);
        medicineModifyLogDao.save(medicineModifyLogDO);
        return medicineModifyLogDO.getId();
    }

    @Override
    public Long saveBatch(List<MedicineModifyLogDTO> medicineModifyLogDTOList) {
        if (CollectionUtils.isEmpty(medicineModifyLogDTOList)) {
            return null;
        }
        List<MedicineModifyLogDO> medicineModifyLogDOList;
        try {
            medicineModifyLogDOList = BeanUtils.convertList(medicineModifyLogDTOList, MedicineModifyLogDO.class);
        } catch (Exception e) {
            String msg = String.format("MedicineModifyLogServiceImp.saveBatch方法llist转换失败：%s",
                    JSONObject.toJSONString(medicineModifyLogDTOList));
            logger.error(msg, e);
            return null;
        }
        return medicineModifyLogDao.saveBatch(medicineModifyLogDOList);
    }

    @Override
    public Integer updateById(MedicineModifyLogDTO medicineModifyLogDTO) {
        if (null == medicineModifyLogDTO) {
            return null;
        }
        MedicineModifyLogDO medicineModifyLogDO = new MedicineModifyLogDO();
        BeanUtils.copyProperties(medicineModifyLogDTO, medicineModifyLogDO);
        return medicineModifyLogDao.updateById(medicineModifyLogDO);
    }

    @Override
    public Integer deleteById(Long id) {
        if (null == id) {
            return null;
        }
        return medicineModifyLogDao.deleteById(id);
    }

    @Override
    public MedicineModifyLogDTO queryById(Long id) {
        if (null == id) {
            return null;
        }
        MedicineModifyLogDO medicineModifyLogDO = medicineModifyLogDao.queryById(id);
        if (null == medicineModifyLogDO) {
            return null;
        }
        MedicineModifyLogDTO medicineModifyLogDTO = new MedicineModifyLogDTO();
        BeanUtils.copyProperties(medicineModifyLogDO, medicineModifyLogDTO);
        return medicineModifyLogDTO;
    }

    @Override
    public List<MedicineModifyLogDTO> queryList(MedicineModifyLogDTO medicineModifyLogDTO) {
        if (null == medicineModifyLogDTO) {
            return null;
        }
        MedicineModifyLogDO medicineModifyLogDO = new MedicineModifyLogDO();
        BeanUtils.copyProperties(medicineModifyLogDTO, medicineModifyLogDO);
        List<MedicineModifyLogDO> medicineModifyLogDOList = medicineModifyLogDao.queryList(medicineModifyLogDO);
        if (CollectionUtils.isEmpty(medicineModifyLogDOList)) {
            return Lists.newArrayList();
        }
        List<MedicineModifyLogDTO> medicineModifyLogDTOList;
        try {
            medicineModifyLogDTOList=BeanUtils.convertList(medicineModifyLogDOList, MedicineModifyLogDTO.class);
        } catch (Exception e) {
            String msg = String.format("MedicineModifyLogServiceImpl.queryList方法list转换失败：%s",
                    JSONObject.toJSONString(medicineModifyLogDOList));
            logger.error(msg, e);
            return Lists.newArrayList();
        }
        return medicineModifyLogDTOList;
    }
}
