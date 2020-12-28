package com.ibn.xinte.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.google.common.collect.Lists;
import com.ibn.xinte.dao.RoleBaseDao;
import com.ibn.xinte.domain.RoleBaseDTO;
import com.ibn.xinte.entity.RoleBaseDO;
import com.ibn.xinte.service.RoleBaseService;
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
@Service("roleBaseSerive")
public class RoleBaseServiceImpl implements RoleBaseService {

    private static final Logger logger = LoggerFactory.getLogger(BeanUtils.class);

    @Autowired
    private RoleBaseDao roleBaseDao;

    @Override
    public Long save(RoleBaseDTO roleBaseDTO) {
        if (null == roleBaseDTO) {
            return null;
        }
        RoleBaseDO roleBaseDO = new RoleBaseDO();
        BeanUtils.copyProperties(roleBaseDTO, roleBaseDO);
        roleBaseDao.save(roleBaseDO);
        return roleBaseDO.getId();
    }

    @Override
    public Long saveBatch(List<RoleBaseDTO> roleBaseDTOList) {
        if (CollectionUtils.isEmpty(roleBaseDTOList)) {
            return null;
        }
        List<RoleBaseDO> roleBaseDOList;
        try {
            roleBaseDOList = BeanUtils.convertList(roleBaseDTOList, RoleBaseDO.class);
        } catch (Exception e) {
            String msg = String.format("RoleBaseServiceImp.saveBatch方法llist转换失败：%s",
                    JSONObject.toJSONString(roleBaseDTOList));
            logger.error(msg, e);
            return null;
        }
        return roleBaseDao.saveBatch(roleBaseDOList);
    }

    @Override
    public Integer updateById(RoleBaseDTO roleBaseDTO) {
        if (null == roleBaseDTO) {
            return null;
        }
        RoleBaseDO roleBaseDO = new RoleBaseDO();
        BeanUtils.copyProperties(roleBaseDTO, roleBaseDO);
        return roleBaseDao.updateById(roleBaseDO);
    }

    @Override
    public Integer deleteById(Long id) {
        if (null == id) {
            return null;
        }
        return roleBaseDao.deleteById(id);
    }

    @Override
    public RoleBaseDTO queryById(Long id) {
        if (null == id) {
            return null;
        }
        RoleBaseDO roleBaseDO = roleBaseDao.queryById(id);
        if (null == roleBaseDO) {
            return null;
        }
        RoleBaseDTO roleBaseDTO = new RoleBaseDTO();
        BeanUtils.copyProperties(roleBaseDO, roleBaseDTO);
        return roleBaseDTO;
    }

    @Override
    public List<RoleBaseDTO> queryList(RoleBaseDTO roleBaseDTO) {
        if (null == roleBaseDTO) {
            return null;
        }
        RoleBaseDO roleBaseDO = new RoleBaseDO();
        BeanUtils.copyProperties(roleBaseDTO, roleBaseDO);
        List<RoleBaseDO> roleBaseDOList = roleBaseDao.queryList(roleBaseDO);
        if (CollectionUtils.isEmpty(roleBaseDOList)) {
            return Lists.newArrayList();
        }
        List<RoleBaseDTO> roleBaseDTOList;
        try {
            roleBaseDTOList=BeanUtils.convertList(roleBaseDOList, RoleBaseDTO.class);
        } catch (Exception e) {
            String msg = String.format("RoleBaseServiceImpl.queryList方法list转换失败：%s",
                    JSONObject.toJSONString(roleBaseDOList));
            logger.error(msg, e);
            return Lists.newArrayList();
        }
        return roleBaseDTOList;
    }
}
