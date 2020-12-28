package com.ibn.xinte.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.google.common.collect.Lists;
import com.ibn.xinte.dao.MedicineStoreDao;
import com.ibn.xinte.domain.MedicineStoreDTO;
import com.ibn.xinte.entity.MedicineStoreDO;
import com.ibn.xinte.service.MedicineStoreService;
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
@Service("medicineStoreSerive")
public class MedicineStoreServiceImpl implements MedicineStoreService {

    private static final Logger logger = LoggerFactory.getLogger(BeanUtils.class);

    @Autowired
    private MedicineStoreDao medicineStoreDao;

    @Override
    public Long save(MedicineStoreDTO medicineStoreDTO) {
        if (null == medicineStoreDTO) {
            return null;
        }
        MedicineStoreDO medicineStoreDO = new MedicineStoreDO();
        BeanUtils.copyProperties(medicineStoreDTO, medicineStoreDO);
        medicineStoreDao.save(medicineStoreDO);
        return medicineStoreDO.getId();
    }

    @Override
    public Long saveBatch(List<MedicineStoreDTO> medicineStoreDTOList) {
        if (CollectionUtils.isEmpty(medicineStoreDTOList)) {
            return null;
        }
        List<MedicineStoreDO> medicineStoreDOList;
        try {
            medicineStoreDOList = BeanUtils.convertList(medicineStoreDTOList, MedicineStoreDO.class);
        } catch (Exception e) {
            String msg = String.format("MedicineStoreServiceImp.saveBatch方法llist转换失败：%s",
                    JSONObject.toJSONString(medicineStoreDTOList));
            logger.error(msg, e);
            return null;
        }
        return medicineStoreDao.saveBatch(medicineStoreDOList);
    }

    @Override
    public Integer updateById(MedicineStoreDTO medicineStoreDTO) {
        if (null == medicineStoreDTO) {
            return null;
        }
        MedicineStoreDO medicineStoreDO = new MedicineStoreDO();
        BeanUtils.copyProperties(medicineStoreDTO, medicineStoreDO);
        return medicineStoreDao.updateById(medicineStoreDO);
    }

    @Override
    public Integer deleteById(Long id) {
        if (null == id) {
            return null;
        }
        return medicineStoreDao.deleteById(id);
    }

    @Override
    public MedicineStoreDTO queryById(Long id) {
        if (null == id) {
            return null;
        }
        MedicineStoreDO medicineStoreDO = medicineStoreDao.queryById(id);
        if (null == medicineStoreDO) {
            return null;
        }
        MedicineStoreDTO medicineStoreDTO = new MedicineStoreDTO();
        BeanUtils.copyProperties(medicineStoreDO, medicineStoreDTO);
        return medicineStoreDTO;
    }

    @Override
    public List<MedicineStoreDTO> queryList(MedicineStoreDTO medicineStoreDTO) {
        if (null == medicineStoreDTO) {
            return null;
        }
        MedicineStoreDO medicineStoreDO = new MedicineStoreDO();
        BeanUtils.copyProperties(medicineStoreDTO, medicineStoreDO);
        List<MedicineStoreDO> medicineStoreDOList = medicineStoreDao.queryList(medicineStoreDO);
        if (CollectionUtils.isEmpty(medicineStoreDOList)) {
            return Lists.newArrayList();
        }
        List<MedicineStoreDTO> medicineStoreDTOList;
        try {
            medicineStoreDTOList=BeanUtils.convertList(medicineStoreDOList, MedicineStoreDTO.class);
        } catch (Exception e) {
            String msg = String.format("MedicineStoreServiceImpl.queryList方法list转换失败：%s",
                    JSONObject.toJSONString(medicineStoreDOList));
            logger.error(msg, e);
            return Lists.newArrayList();
        }
        return medicineStoreDTOList;
    }
}
