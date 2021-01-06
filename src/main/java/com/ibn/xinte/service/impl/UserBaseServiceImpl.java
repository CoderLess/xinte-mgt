package com.ibn.xinte.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.google.common.collect.Lists;
import com.ibn.xinte.dao.UserBaseDao;
import com.ibn.xinte.domain.UserBaseDTO;
import com.ibn.xinte.entity.UserBaseDO;
import com.ibn.xinte.service.UserBaseService;
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
@Service("userBaseSerive")
public class UserBaseServiceImpl implements UserBaseService {

    private static final Logger logger = LoggerFactory.getLogger(BeanUtils.class);

    @Autowired
    private UserBaseDao userBaseDao;

    @Override
    public Long save(UserBaseDTO userBaseDTO) {
        if (null == userBaseDTO) {
            return null;
        }
        UserBaseDO userBaseDO = new UserBaseDO();
        BeanUtils.copyProperties(userBaseDTO, userBaseDO);
        userBaseDao.save(userBaseDO);
        return userBaseDO.getId();
    }

    @Override
    public Long saveBatch(List<UserBaseDTO> userBaseDTOList) {
        if (CollectionUtils.isEmpty(userBaseDTOList)) {
            return null;
        }
        List<UserBaseDO> userBaseDOList;
        try {
            userBaseDOList = BeanUtils.convertList(userBaseDTOList, UserBaseDO.class);
        } catch (Exception e) {
            String msg = String.format("UserBaseServiceImp.saveBatch方法llist转换失败：%s",
                    JSONObject.toJSONString(userBaseDTOList));
            logger.error(msg, e);
            return null;
        }
        return userBaseDao.saveBatch(userBaseDOList);
    }

    @Override
    public Integer updateById(UserBaseDTO userBaseDTO) {
        if (null == userBaseDTO) {
            return null;
        }
        UserBaseDO userBaseDO = new UserBaseDO();
        BeanUtils.copyProperties(userBaseDTO, userBaseDO);
        return userBaseDao.updateById(userBaseDO);
    }

    @Override
    public Integer deleteById(Long id) {
        if (null == id) {
            return null;
        }
        return userBaseDao.deleteById(id);
    }

    @Override
    public UserBaseDTO queryById(Long id) {
        if (null == id) {
            return null;
        }
        UserBaseDO userBaseDO = userBaseDao.queryById(id);
        if (null == userBaseDO) {
            return null;
        }
        UserBaseDTO userBaseDTO = new UserBaseDTO();
        BeanUtils.copyProperties(userBaseDO, userBaseDTO);
        return userBaseDTO;
    }

    @Override
    public List<UserBaseDTO> queryList(UserBaseDTO userBaseDTO) {
        return this.queryList(userBaseDTO, null, null);
    }

    @Override
    public List<UserBaseDTO> queryList(UserBaseDTO userBaseDTO, Integer pageNum, Integer pageSize) {
        if (null == userBaseDTO) {
            return null;
        }
        UserBaseDO userBaseDO = new UserBaseDO();
        BeanUtils.copyProperties(userBaseDTO, userBaseDO);
        if (null != pageNum && null != pageSize) {
            PageHelper.startPage(pageNum, pageSize);
        }
        List<UserBaseDO> userBaseDOList = userBaseDao.queryListByDTO(userBaseDTO);
        if (CollectionUtils.isEmpty(userBaseDOList)) {
            return Lists.newArrayList();
        }
        List<UserBaseDTO> userBaseDTOList;
        try {
            userBaseDTOList=BeanUtils.convertList(userBaseDOList, UserBaseDTO.class);
        } catch (Exception e) {
            String msg = String.format("UserBaseServiceImpl.queryList方法list转换失败：%s",
                    JSONObject.toJSONString(userBaseDOList));
            logger.error(msg, e);
            return Lists.newArrayList();
        }
        return userBaseDTOList;
    }

    @Override
    public Integer total(UserBaseDTO userBaseDTO) {
        return userBaseDao.total(userBaseDTO);
    }
}
