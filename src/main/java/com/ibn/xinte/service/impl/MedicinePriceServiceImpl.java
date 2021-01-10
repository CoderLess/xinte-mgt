package com.ibn.xinte.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.google.common.collect.Lists;
import com.ibn.xinte.dao.MedicinePriceDao;
import com.ibn.xinte.domain.MedicinePriceDTO;
import com.ibn.xinte.entity.MedicinePriceDO;
import com.ibn.xinte.service.MedicinePriceService;
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
 * @createTime：2021年1月10日
 */
@Service("medicinePriceSerive")
public class MedicinePriceServiceImpl implements MedicinePriceService {

    private static final Logger logger = LoggerFactory.getLogger(BeanUtils.class);

    @Autowired
    private MedicinePriceDao medicinePriceDao;

    @Override
    public Long save(MedicinePriceDTO medicinePriceDTO) {
        if (null == medicinePriceDTO) {
            return null;
        }
        MedicinePriceDO medicinePriceDO = new MedicinePriceDO();
        BeanUtils.copyProperties(medicinePriceDTO, medicinePriceDO);
        medicinePriceDao.save(medicinePriceDO);
        return medicinePriceDO.getId();
    }

    @Override
    public Long saveBatch(List<MedicinePriceDTO> medicinePriceDTOList) {
        if (CollectionUtils.isEmpty(medicinePriceDTOList)) {
            return null;
        }
        List<MedicinePriceDO> medicinePriceDOList;
        try {
            medicinePriceDOList = BeanUtils.convertList(medicinePriceDTOList, MedicinePriceDO.class);
        } catch (Exception e) {
            String msg = String.format("MedicinePriceServiceImp.saveBatch方法llist转换失败：%s",
                    JSONObject.toJSONString(medicinePriceDTOList));
            logger.error(msg, e);
            return null;
        }
        return medicinePriceDao.saveBatch(medicinePriceDOList);
    }

    @Override
    public Integer updateById(MedicinePriceDTO medicinePriceDTO) {
        if (null == medicinePriceDTO) {
            return null;
        }
        MedicinePriceDO medicinePriceDO = new MedicinePriceDO();
        BeanUtils.copyProperties(medicinePriceDTO, medicinePriceDO);
        return medicinePriceDao.updateById(medicinePriceDO);
    }

    @Override
    public Integer deleteById(Long id) {
        if (null == id) {
            return null;
        }
        return medicinePriceDao.deleteById(id);
    }

    @Override
    public MedicinePriceDTO queryById(Long id) {
        if (null == id) {
            return null;
        }
        MedicinePriceDO medicinePriceDO = medicinePriceDao.queryById(id);
        if (null == medicinePriceDO) {
            return null;
        }
        MedicinePriceDTO medicinePriceDTO = new MedicinePriceDTO();
        BeanUtils.copyProperties(medicinePriceDO, medicinePriceDTO);
        return medicinePriceDTO;
    }

    @Override
    public MedicinePriceDTO queryByIdLevel(Long id, Integer level) {
        if (null == id) {
            return null;
        }
        MedicinePriceDO medicinePriceDO = medicinePriceDao.queryByIdLevel(id, level);
        if (null == medicinePriceDO) {
            return null;
        }
        MedicinePriceDTO medicinePriceDTO = new MedicinePriceDTO();
        BeanUtils.copyProperties(medicinePriceDO, medicinePriceDTO);
        return medicinePriceDTO;
    }

    @Override
    public List<MedicinePriceDTO> queryList(MedicinePriceDTO medicinePriceDTO) {
        if (null == medicinePriceDTO) {
            return null;
        }
        MedicinePriceDO medicinePriceDO = new MedicinePriceDO();
        BeanUtils.copyProperties(medicinePriceDTO, medicinePriceDO);
        List<MedicinePriceDO> medicinePriceDOList = medicinePriceDao.queryList(medicinePriceDO);
        if (CollectionUtils.isEmpty(medicinePriceDOList)) {
            return Lists.newArrayList();
        }
        List<MedicinePriceDTO> medicinePriceDTOList;
        try {
            medicinePriceDTOList=BeanUtils.convertList(medicinePriceDOList, MedicinePriceDTO.class);
        } catch (Exception e) {
            String msg = String.format("MedicinePriceServiceImpl.queryList方法list转换失败：%s",
                    JSONObject.toJSONString(medicinePriceDOList));
            logger.error(msg, e);
            return Lists.newArrayList();
        }
        return medicinePriceDTOList;
    }
}
