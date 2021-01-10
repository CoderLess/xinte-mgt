package com.ibn.xinte.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.google.common.collect.Lists;
import com.ibn.xinte.dao.MedicineBaseDao;
import com.ibn.xinte.dao.MedicineCheckInOutDao;
import com.ibn.xinte.domain.MedicineCheckInOutDTO;
import com.ibn.xinte.entity.MedicineBaseDO;
import com.ibn.xinte.entity.MedicineCheckInOutDO;
import com.ibn.xinte.enumeration.MedicineCheckInOutTypeEnum;
import com.ibn.xinte.service.MedicineBaseService;
import com.ibn.xinte.service.MedicineCheckInOutService;
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
@Service("medicineCheckInOutSerive")
public class MedicineCheckInOutServiceImpl implements MedicineCheckInOutService {

    private static final Logger logger = LoggerFactory.getLogger(BeanUtils.class);

    @Autowired
    private MedicineCheckInOutDao medicineCheckInOutDao;
    @Autowired
    private MedicineBaseDao medicineBaseDao;

    @Override
    public Long save(MedicineCheckInOutDTO medicineCheckInOutDTO) {
        if (null == medicineCheckInOutDTO) {
            return null;
        }
        MedicineCheckInOutDO medicineCheckInOutDO = new MedicineCheckInOutDO();
        BeanUtils.copyProperties(medicineCheckInOutDTO, medicineCheckInOutDO);
        medicineCheckInOutDao.save(medicineCheckInOutDO);
        MedicineBaseDO medicineBaseDO = medicineBaseDao.queryById(medicineCheckInOutDO.getMedicineId());
        MedicineBaseDO medicineBaseUpdateDO = new MedicineBaseDO();
        medicineBaseUpdateDO.setId(medicineBaseDO.getId());
        if (MedicineCheckInOutTypeEnum.IN.getCode().equals(medicineCheckInOutDO.getType())) {
            medicineBaseUpdateDO.setNumber(medicineBaseDO.getNumber().add(medicineCheckInOutDO.getNumber()));
        } else {
            medicineBaseUpdateDO.setNumber(medicineBaseDO.getNumber().subtract(medicineCheckInOutDO.getNumber()));
        }
        medicineBaseDao.updateById(medicineBaseUpdateDO);
        return medicineCheckInOutDO.getId();
    }

    @Override
    public Long saveBatch(List<MedicineCheckInOutDTO> medicineCheckInOutDTOList) {
        if (CollectionUtils.isEmpty(medicineCheckInOutDTOList)) {
            return null;
        }
        List<MedicineCheckInOutDO> medicineCheckInOutDOList;
        try {
            medicineCheckInOutDOList = BeanUtils.convertList(medicineCheckInOutDTOList, MedicineCheckInOutDO.class);
        } catch (Exception e) {
            String msg = String.format("MedicineCheckInOutServiceImp.saveBatch方法llist转换失败：%s",
                    JSONObject.toJSONString(medicineCheckInOutDTOList));
            logger.error(msg, e);
            return null;
        }
        return medicineCheckInOutDao.saveBatch(medicineCheckInOutDOList);
    }

    @Override
    public Integer updateById(MedicineCheckInOutDTO medicineCheckInOutDTO) {
        if (null == medicineCheckInOutDTO) {
            return null;
        }
        MedicineCheckInOutDO medicineCheckInOutDO = new MedicineCheckInOutDO();
        BeanUtils.copyProperties(medicineCheckInOutDTO, medicineCheckInOutDO);
        return medicineCheckInOutDao.updateById(medicineCheckInOutDO);
    }

    @Override
    public Integer deleteById(Long id) {
        if (null == id) {
            return null;
        }
        return medicineCheckInOutDao.deleteById(id);
    }

    @Override
    public MedicineCheckInOutDTO queryById(Long id) {
        if (null == id) {
            return null;
        }
        MedicineCheckInOutDO medicineCheckInOutDO = medicineCheckInOutDao.queryById(id);
        if (null == medicineCheckInOutDO) {
            return null;
        }
        MedicineCheckInOutDTO medicineCheckInOutDTO = new MedicineCheckInOutDTO();
        BeanUtils.copyProperties(medicineCheckInOutDO, medicineCheckInOutDTO);
        return medicineCheckInOutDTO;
    }

    @Override
    public List<MedicineCheckInOutDTO> queryList(MedicineCheckInOutDTO medicineCheckInOutDTO) {
        if (null == medicineCheckInOutDTO) {
            return null;
        }
        MedicineCheckInOutDO medicineCheckInOutDO = new MedicineCheckInOutDO();
        BeanUtils.copyProperties(medicineCheckInOutDTO, medicineCheckInOutDO);
        List<MedicineCheckInOutDO> medicineCheckInOutDOList = medicineCheckInOutDao.queryList(medicineCheckInOutDO);
        if (CollectionUtils.isEmpty(medicineCheckInOutDOList)) {
            return Lists.newArrayList();
        }
        List<MedicineCheckInOutDTO> medicineCheckInOutDTOList;
        try {
            medicineCheckInOutDTOList=BeanUtils.convertList(medicineCheckInOutDOList, MedicineCheckInOutDTO.class);
        } catch (Exception e) {
            String msg = String.format("MedicineCheckInOutServiceImpl.queryList方法list转换失败：%s",
                    JSONObject.toJSONString(medicineCheckInOutDOList));
            logger.error(msg, e);
            return Lists.newArrayList();
        }
        return medicineCheckInOutDTOList;
    }

    @Override
    public PageInfo<MedicineCheckInOutDTO> queryPageInfo(MedicineCheckInOutDTO medicineCheckInOutDTO, Integer pageNum, Integer pageSize) {
        if (null == medicineCheckInOutDTO) {
            return null;
        }
        MedicineCheckInOutDO medicineCheckInOutDO = new MedicineCheckInOutDO();
        BeanUtils.copyProperties(medicineCheckInOutDTO, medicineCheckInOutDO);
        if (null != pageNum && null != pageSize) {
            PageHelper.startPage(pageNum, pageSize);
        }
        Page<MedicineCheckInOutDO> medicineCheckInOutDOPage = medicineCheckInOutDao.queryList(medicineCheckInOutDO);
        PageInfo<MedicineCheckInOutDTO> medicineCheckInOutDTOPageInfo = new PageInfo<>();
        if (CollectionUtils.isEmpty(medicineCheckInOutDOPage)) {
            medicineCheckInOutDTOPageInfo.setTotal(0);
            return medicineCheckInOutDTOPageInfo;
        }
        List<MedicineCheckInOutDTO> medicineCheckInOutDTOList;
        try {
            medicineCheckInOutDTOList=BeanUtils.convertList(medicineCheckInOutDOPage, MedicineCheckInOutDTO.class);
        } catch (Exception e) {
            String msg = String.format("MedicineCheckInOutServiceImpl.queryPageInfo方法list转换失败：%s",
                    JSONObject.toJSONString(medicineCheckInOutDOPage));
            logger.error(msg, e);
            medicineCheckInOutDTOPageInfo.setTotal(0);
            return medicineCheckInOutDTOPageInfo;
        }
        medicineCheckInOutDTOPageInfo.setList(medicineCheckInOutDTOList);
        medicineCheckInOutDTOPageInfo.setTotal(medicineCheckInOutDOPage.getTotal());
        return medicineCheckInOutDTOPageInfo;
    }
}
