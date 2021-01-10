package com.ibn.xinte.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.google.common.collect.Lists;
import com.ibn.xinte.dao.FactoryBaseDao;
import com.ibn.xinte.domain.FactoryBaseDTO;
import com.ibn.xinte.entity.FactoryBaseDO;
import com.ibn.xinte.service.FactoryBaseService;
import com.ibn.xinte.util.BeanUtils;
import com.ibn.xinte.util.PinYinUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.util.List;

/**
 * @version 1.0
 * @description:
 * @projectName：xinte
 * @see: com.ibn.xinte.service.impl
 * @author： RenBin
 * @createTime：2021年1月10日
 */
@Service("factoryBaseSerive")
public class FactoryBaseServiceImpl implements FactoryBaseService {

    private static final Logger logger = LoggerFactory.getLogger(BeanUtils.class);

    @Autowired
    private FactoryBaseDao factoryBaseDao;

    @Override
    public Long save(FactoryBaseDTO factoryBaseDTO) {
        if (null == factoryBaseDTO) {
            return null;
        }
        FactoryBaseDO factoryBaseDO = new FactoryBaseDO();
        BeanUtils.copyProperties(factoryBaseDTO, factoryBaseDO);
        // 获取药品简称
        if (StringUtils.hasLength(factoryBaseDO.getName())) {
            factoryBaseDO.setShortName(PinYinUtils.getFirstSpell(factoryBaseDTO.getName()));
        }
        factoryBaseDao.save(factoryBaseDO);
        return factoryBaseDO.getId();
    }

    @Override
    public Long saveBatch(List<FactoryBaseDTO> factoryBaseDTOList) {
        if (CollectionUtils.isEmpty(factoryBaseDTOList)) {
            return null;
        }
        List<FactoryBaseDO> factoryBaseDOList;
        try {
            factoryBaseDOList = BeanUtils.convertList(factoryBaseDTOList, FactoryBaseDO.class);
        } catch (Exception e) {
            String msg = String.format("FactoryBaseServiceImp.saveBatch方法llist转换失败：%s",
                    JSONObject.toJSONString(factoryBaseDTOList));
            logger.error(msg, e);
            return null;
        }
        return factoryBaseDao.saveBatch(factoryBaseDOList);
    }

    @Override
    public Integer updateById(FactoryBaseDTO factoryBaseDTO) {
        if (null == factoryBaseDTO) {
            return null;
        }
        FactoryBaseDO factoryBaseDO = new FactoryBaseDO();
        BeanUtils.copyProperties(factoryBaseDTO, factoryBaseDO);
        return factoryBaseDao.updateById(factoryBaseDO);
    }

    @Override
    public Integer deleteById(Long id) {
        if (null == id) {
            return null;
        }
        return factoryBaseDao.deleteById(id);
    }

    @Override
    public FactoryBaseDTO queryById(Long id) {
        if (null == id) {
            return null;
        }
        FactoryBaseDO factoryBaseDO = factoryBaseDao.queryById(id);
        if (null == factoryBaseDO) {
            return null;
        }
        FactoryBaseDTO factoryBaseDTO = new FactoryBaseDTO();
        BeanUtils.copyProperties(factoryBaseDO, factoryBaseDTO);
        return factoryBaseDTO;
    }

    @Override
    public List<FactoryBaseDTO> queryList(FactoryBaseDTO factoryBaseDTO) {
        if (null == factoryBaseDTO) {
            return null;
        }
        FactoryBaseDO factoryBaseDO = new FactoryBaseDO();
        BeanUtils.copyProperties(factoryBaseDTO, factoryBaseDO);
        List<FactoryBaseDO> factoryBaseDOList = factoryBaseDao.queryList(factoryBaseDO);
        if (CollectionUtils.isEmpty(factoryBaseDOList)) {
            return Lists.newArrayList();
        }
        List<FactoryBaseDTO> factoryBaseDTOList;
        try {
            factoryBaseDTOList=BeanUtils.convertList(factoryBaseDOList, FactoryBaseDTO.class);
        } catch (Exception e) {
            String msg = String.format("FactoryBaseServiceImpl.queryList方法list转换失败：%s",
                    JSONObject.toJSONString(factoryBaseDOList));
            logger.error(msg, e);
            return Lists.newArrayList();
        }
        return factoryBaseDTOList;
    }

    @Override
    public PageInfo<FactoryBaseDTO> queryPageInfo(FactoryBaseDTO factoryBaseDTO, Integer pageNum, Integer pageSize) {
        if (null == factoryBaseDTO) {
            return null;
        }
        FactoryBaseDO factoryBaseDO = new FactoryBaseDO();
        BeanUtils.copyProperties(factoryBaseDTO, factoryBaseDO);
        if (null != pageNum && null != pageSize) {
            PageHelper.startPage(pageNum, pageSize);
        }
        Page<FactoryBaseDO> factoryBaseDOPage = factoryBaseDao.queryList(factoryBaseDO);
        PageInfo<FactoryBaseDTO> factoryBaseDTOPageInfo = new PageInfo<>();
        if (CollectionUtils.isEmpty(factoryBaseDOPage)) {
            return factoryBaseDTOPageInfo;
        }
        List<FactoryBaseDTO> factoryBaseDTOList;
        try {
            factoryBaseDTOList=BeanUtils.convertList(factoryBaseDOPage, FactoryBaseDTO.class);
        } catch (Exception e) {
            String msg = String.format("FactoryBaseServiceImpl.queryPageInfo方法list转换失败：%s",
                    JSONObject.toJSONString(factoryBaseDOPage));
            logger.error(msg, e);
            return factoryBaseDTOPageInfo;
        }
        factoryBaseDTOPageInfo.setList(factoryBaseDTOList);
        factoryBaseDTOPageInfo.setTotal(factoryBaseDOPage.getTotal());
        return factoryBaseDTOPageInfo;
    }
}
