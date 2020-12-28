package com.ibn.xinte.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.google.common.collect.Lists;
import com.ibn.xinte.dao.LoginLogDao;
import com.ibn.xinte.domain.LoginLogDTO;
import com.ibn.xinte.entity.LoginLogDO;
import com.ibn.xinte.service.LoginLogService;
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
@Service("loginLogSerive")
public class LoginLogServiceImpl implements LoginLogService {

    private static final Logger logger = LoggerFactory.getLogger(BeanUtils.class);

    @Autowired
    private LoginLogDao loginLogDao;

    @Override
    public Long save(LoginLogDTO loginLogDTO) {
        if (null == loginLogDTO) {
            return null;
        }
        LoginLogDO loginLogDO = new LoginLogDO();
        BeanUtils.copyProperties(loginLogDTO, loginLogDO);
        loginLogDao.save(loginLogDO);
        return loginLogDO.getId();
    }

    @Override
    public Long saveBatch(List<LoginLogDTO> loginLogDTOList) {
        if (CollectionUtils.isEmpty(loginLogDTOList)) {
            return null;
        }
        List<LoginLogDO> loginLogDOList;
        try {
            loginLogDOList = BeanUtils.convertList(loginLogDTOList, LoginLogDO.class);
        } catch (Exception e) {
            String msg = String.format("LoginLogServiceImp.saveBatch方法llist转换失败：%s",
                    JSONObject.toJSONString(loginLogDTOList));
            logger.error(msg, e);
            return null;
        }
        return loginLogDao.saveBatch(loginLogDOList);
    }

    @Override
    public Integer updateById(LoginLogDTO loginLogDTO) {
        if (null == loginLogDTO) {
            return null;
        }
        LoginLogDO loginLogDO = new LoginLogDO();
        BeanUtils.copyProperties(loginLogDTO, loginLogDO);
        return loginLogDao.updateById(loginLogDO);
    }

    @Override
    public Integer deleteById(Long id) {
        if (null == id) {
            return null;
        }
        return loginLogDao.deleteById(id);
    }

    @Override
    public LoginLogDTO queryById(Long id) {
        if (null == id) {
            return null;
        }
        LoginLogDO loginLogDO = loginLogDao.queryById(id);
        if (null == loginLogDO) {
            return null;
        }
        LoginLogDTO loginLogDTO = new LoginLogDTO();
        BeanUtils.copyProperties(loginLogDO, loginLogDTO);
        return loginLogDTO;
    }

    @Override
    public List<LoginLogDTO> queryList(LoginLogDTO loginLogDTO) {
        if (null == loginLogDTO) {
            return null;
        }
        LoginLogDO loginLogDO = new LoginLogDO();
        BeanUtils.copyProperties(loginLogDTO, loginLogDO);
        List<LoginLogDO> loginLogDOList = loginLogDao.queryList(loginLogDO);
        if (CollectionUtils.isEmpty(loginLogDOList)) {
            return Lists.newArrayList();
        }
        List<LoginLogDTO> loginLogDTOList;
        try {
            loginLogDTOList=BeanUtils.convertList(loginLogDOList, LoginLogDTO.class);
        } catch (Exception e) {
            String msg = String.format("LoginLogServiceImpl.queryList方法list转换失败：%s",
                    JSONObject.toJSONString(loginLogDOList));
            logger.error(msg, e);
            return Lists.newArrayList();
        }
        return loginLogDTOList;
    }
}
