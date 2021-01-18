package com.ibn.xinte.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.google.common.collect.Lists;
import com.ibn.xinte.dao.PrescriptionBaseDao;
import com.ibn.xinte.domain.PrescriptionBaseDTO;
import com.ibn.xinte.entity.PrescriptionBaseDO;
import com.ibn.xinte.service.PrescriptionBaseService;
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
@Service("prescriptionBaseSerive")
public class PrescriptionBaseServiceImpl implements PrescriptionBaseService {

    private static final Logger logger = LoggerFactory.getLogger(BeanUtils.class);

    @Autowired
    private PrescriptionBaseDao prescriptionBaseDao;

    @Override
    public Long save(PrescriptionBaseDTO prescriptionBaseDTO) {
        if (null == prescriptionBaseDTO) {
            return null;
        }
        PrescriptionBaseDO prescriptionBaseDO = new PrescriptionBaseDO();
        BeanUtils.copyProperties(prescriptionBaseDTO, prescriptionBaseDO);
        prescriptionBaseDao.save(prescriptionBaseDO);
        return prescriptionBaseDO.getId();
    }

    @Override
    public Long saveBatch(List<PrescriptionBaseDTO> prescriptionBaseDTOList) {
        if (CollectionUtils.isEmpty(prescriptionBaseDTOList)) {
            return null;
        }
        List<PrescriptionBaseDO> prescriptionBaseDOList;
        try {
            prescriptionBaseDOList = BeanUtils.convertList(prescriptionBaseDTOList, PrescriptionBaseDO.class);
        } catch (Exception e) {
            String msg = String.format("PrescriptionBaseServiceImp.saveBatch方法llist转换失败：%s",
                    JSONObject.toJSONString(prescriptionBaseDTOList));
            logger.error(msg, e);
            return null;
        }
        return prescriptionBaseDao.saveBatch(prescriptionBaseDOList);
    }

    @Override
    public Integer updateById(PrescriptionBaseDTO prescriptionBaseDTO) {
        if (null == prescriptionBaseDTO) {
            return null;
        }
        PrescriptionBaseDO prescriptionBaseDO = new PrescriptionBaseDO();
        BeanUtils.copyProperties(prescriptionBaseDTO, prescriptionBaseDO);
        return prescriptionBaseDao.updateById(prescriptionBaseDO);
    }

    @Override
    public Integer deleteById(Long id) {
        if (null == id) {
            return null;
        }
        return prescriptionBaseDao.deleteById(id);
    }

    @Override
    public PrescriptionBaseDTO queryById(Long id) {
        if (null == id) {
            return null;
        }
        PrescriptionBaseDO prescriptionBaseDO = prescriptionBaseDao.queryById(id);
        if (null == prescriptionBaseDO) {
            return null;
        }
        PrescriptionBaseDTO prescriptionBaseDTO = new PrescriptionBaseDTO();
        BeanUtils.copyProperties(prescriptionBaseDO, prescriptionBaseDTO);
        return prescriptionBaseDTO;
    }

    @Override
    public List<PrescriptionBaseDTO> queryList(PrescriptionBaseDTO prescriptionBaseDTO) {
        if (null == prescriptionBaseDTO) {
            return null;
        }
        PrescriptionBaseDO prescriptionBaseDO = new PrescriptionBaseDO();
        BeanUtils.copyProperties(prescriptionBaseDTO, prescriptionBaseDO);
        List<PrescriptionBaseDO> prescriptionBaseDOList = prescriptionBaseDao.queryList(prescriptionBaseDO);
        if (CollectionUtils.isEmpty(prescriptionBaseDOList)) {
            return Lists.newArrayList();
        }
        List<PrescriptionBaseDTO> prescriptionBaseDTOList;
        try {
            prescriptionBaseDTOList=BeanUtils.convertList(prescriptionBaseDOList, PrescriptionBaseDTO.class);
        } catch (Exception e) {
            String msg = String.format("PrescriptionBaseServiceImpl.queryList方法list转换失败：%s",
                    JSONObject.toJSONString(prescriptionBaseDOList));
            logger.error(msg, e);
            return Lists.newArrayList();
        }
        return prescriptionBaseDTOList;
    }

    @Override
    public List<PrescriptionBaseDTO> queryListByDTO(PrescriptionBaseDTO prescriptionBaseDTO) {
        if (null == prescriptionBaseDTO) {
            return Lists.newArrayList();
        }
        List<PrescriptionBaseDO> prescriptionBaseDOList = prescriptionBaseDao.queryListByDTO(prescriptionBaseDTO);
        if (CollectionUtils.isEmpty(prescriptionBaseDOList)) {
            return Lists.newArrayList();
        }
        List<PrescriptionBaseDTO> prescriptionBaseDTOList;
        try {
            prescriptionBaseDTOList=BeanUtils.convertList(prescriptionBaseDOList, PrescriptionBaseDTO.class);
        } catch (Exception e) {
            String msg = String.format("PrescriptionBaseServiceImpl.queryListByDTO方法list转换失败：%s",
                    JSONObject.toJSONString(prescriptionBaseDOList));
            logger.error(msg, e);
            return Lists.newArrayList();
        }
        return prescriptionBaseDTOList;
    }

    @Override
    public PageInfo<PrescriptionBaseDTO> queryPageInfo(PrescriptionBaseDTO prescriptionBaseDTO, Integer pageNum, Integer pageSize) {
        if (null == prescriptionBaseDTO) {
            return null;
        }
        if (null != pageNum && null != pageSize) {
            PageHelper.startPage(pageNum, pageSize);
        }
        Page<PrescriptionBaseDTO> prescriptionBaseDTOPage = prescriptionBaseDao.queryListInfo(prescriptionBaseDTO);
        PageInfo<PrescriptionBaseDTO> prescriptionBaseDTOPageInfo = new PageInfo<>();
        if (CollectionUtils.isEmpty(prescriptionBaseDTOPage)) {
            return prescriptionBaseDTOPageInfo;
        }
        prescriptionBaseDTOPageInfo.setList(prescriptionBaseDTOPage);
        prescriptionBaseDTOPageInfo.setTotal(prescriptionBaseDTOPage.getTotal());
        return prescriptionBaseDTOPageInfo;
    }

    @Override
    public List<PrescriptionBaseDTO> queryStaticByUserId(List<Long> userIdList) {
        return prescriptionBaseDao.queryStaticByUserId(userIdList);
    }
}
