package com.ibn.xinte.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.google.common.collect.Lists;
import com.ibn.xinte.dao.MedicineBaseDao;
import com.ibn.xinte.domain.MedicineBaseDTO;
import com.ibn.xinte.domain.MedicineModifyLogDTO;
import com.ibn.xinte.domain.MedicinePriceDTO;
import com.ibn.xinte.entity.MedicineBaseDO;
import com.ibn.xinte.service.MedicineBaseService;
import com.ibn.xinte.service.MedicineModifyLogService;
import com.ibn.xinte.service.MedicinePriceService;
import com.ibn.xinte.util.BeanUtils;
import com.ibn.xinte.util.PinYinUtils;
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
    @Autowired
    private MedicineModifyLogService medicineModifyLogService;
    @Autowired
    private MedicinePriceService medicinePriceService;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Long save(MedicineBaseDTO medicineBaseDTO) {
        if (null == medicineBaseDTO) {
            return null;
        }
        MedicineBaseDO medicineBaseDO = new MedicineBaseDO();
        BeanUtils.copyProperties(medicineBaseDTO, medicineBaseDO);
        // 获取药品简称
//        if (null == medicineBaseDO.getShortName()) {
//            medicineBaseDO.setShortName(PinYinUtils.getFirstSpell(medicineBaseDTO.getName()));
//        }
        medicineBaseDao.save(medicineBaseDO);
        if (!CollectionUtils.isEmpty(medicineBaseDTO.getPriceList())) {
            List<MedicinePriceDTO> medicinePriceDTOList = Lists.newArrayList();
            for (int i = 0; i < medicineBaseDTO.getPriceList().size(); i++) {
                MedicinePriceDTO medicinePriceDTO = new MedicinePriceDTO();
                medicinePriceDTO.setMedicineId(medicineBaseDO.getId());
                medicinePriceDTO.setUserLevel(i+1);
                medicinePriceDTO.setSellingPrice(medicineBaseDTO.getPriceList().get(i));
                medicinePriceDTOList.add(medicinePriceDTO);
            }
            medicinePriceService.saveBatch(medicinePriceDTOList);
        }
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
        medicineBaseDTO.setCreateTime(null);
        medicineBaseDTO.setCreatorId(null);
        MedicineBaseDO medicineBaseDO = new MedicineBaseDO();
        BeanUtils.copyProperties(medicineBaseDTO, medicineBaseDO);
        medicineBaseDO.setUpdateTime(System.currentTimeMillis());
        MedicineModifyLogDTO medicineModifyLogDTO = new MedicineModifyLogDTO();
        BeanUtils.copyProperties(medicineBaseDTO, medicineModifyLogDTO);
        medicineModifyLogDTO.setId(null);
        medicineModifyLogDTO.setMedicinalId(medicineBaseDTO.getId());
        medicineModifyLogDTO.setRecordCreateTime(System.currentTimeMillis());
        medicineModifyLogService.save(medicineModifyLogDTO);
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
    public List<MedicineBaseDTO> queryList(MedicineBaseDTO medicineBaseDTO, Integer pageNum, Integer pageSize) {
        if (null == medicineBaseDTO) {
            return null;
        }
        if (null != pageNum && null != pageSize) {
            PageHelper.startPage(pageNum, pageSize);
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

    @Override
    public PageInfo<MedicineBaseDTO> queryPageInfo(MedicineBaseDTO medicineBaseDTO, Integer pageNum, Integer pageSize) {
        if (null == medicineBaseDTO) {
            return null;
        }
        if (null != pageNum && null != pageSize) {
            PageHelper.startPage(pageNum, pageSize);
        }
        MedicineBaseDO medicineBaseDO = new MedicineBaseDO();
        BeanUtils.copyProperties(medicineBaseDTO, medicineBaseDO);
        Page<MedicineBaseDO> medicineBaseDOPage = medicineBaseDao.queryList(medicineBaseDO);
        PageInfo<MedicineBaseDTO> medicineBaseDTOPageInfo = new PageInfo<>();
        if (CollectionUtils.isEmpty(medicineBaseDOPage)) {
            medicineBaseDTOPageInfo.setTotal(0);
            return medicineBaseDTOPageInfo;
        }
        List<MedicineBaseDTO> medicineBaseDTOList;
        try {
            medicineBaseDTOList=BeanUtils.convertList(medicineBaseDOPage, MedicineBaseDTO.class);
        } catch (Exception e) {
            String msg = String.format("MedicineBaseServiceImpl.queryPageInfo方法list转换失败：%s",
                    JSONObject.toJSONString(medicineBaseDOPage));
            logger.error(msg, e);
            medicineBaseDTOPageInfo.setTotal(0);
            return medicineBaseDTOPageInfo;
        }
        medicineBaseDTOPageInfo.setList(medicineBaseDTOList);
        medicineBaseDTOPageInfo.setTotal(medicineBaseDOPage.getTotal());
        return medicineBaseDTOPageInfo;
    }
}
