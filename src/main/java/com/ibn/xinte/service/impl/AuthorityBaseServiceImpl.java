package com.ibn.xinte.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.google.common.collect.Lists;
import com.ibn.xinte.dao.AuthorityBaseDao;
import com.ibn.xinte.domain.AuthorityBaseDTO;
import com.ibn.xinte.entity.AuthorityBaseDO;
import com.ibn.xinte.service.AuthorityBaseService;
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
@Service("authorityBaseSerive")
public class AuthorityBaseServiceImpl implements AuthorityBaseService {

    private static final Logger logger = LoggerFactory.getLogger(BeanUtils.class);

    @Autowired
    private AuthorityBaseDao authorityBaseDao;

    @Override
    public Long save(AuthorityBaseDTO authorityBaseDTO) {
        if (null == authorityBaseDTO) {
            return null;
        }
        AuthorityBaseDO authorityBaseDO = new AuthorityBaseDO();
        BeanUtils.copyProperties(authorityBaseDTO, authorityBaseDO);
        authorityBaseDao.save(authorityBaseDO);
        return authorityBaseDO.getId();
    }

    @Override
    public Long saveBatch(List<AuthorityBaseDTO> authorityBaseDTOList) {
        if (CollectionUtils.isEmpty(authorityBaseDTOList)) {
            return null;
        }
        List<AuthorityBaseDO> authorityBaseDOList;
        try {
            authorityBaseDOList = BeanUtils.convertList(authorityBaseDTOList, AuthorityBaseDO.class);
        } catch (Exception e) {
            String msg = String.format("AuthorityBaseServiceImp.saveBatch方法llist转换失败：%s",
                    JSONObject.toJSONString(authorityBaseDTOList));
            logger.error(msg, e);
            return null;
        }
        return authorityBaseDao.saveBatch(authorityBaseDOList);
    }

    @Override
    public Integer updateById(AuthorityBaseDTO authorityBaseDTO) {
        if (null == authorityBaseDTO) {
            return null;
        }
        AuthorityBaseDO authorityBaseDO = new AuthorityBaseDO();
        BeanUtils.copyProperties(authorityBaseDTO, authorityBaseDO);
        return authorityBaseDao.updateById(authorityBaseDO);
    }

    @Override
    public Integer deleteById(Long id) {
        if (null == id) {
            return null;
        }
        return authorityBaseDao.deleteById(id);
    }

    @Override
    public AuthorityBaseDTO queryById(Long id) {
        if (null == id) {
            return null;
        }
        AuthorityBaseDO authorityBaseDO = authorityBaseDao.queryById(id);
        if (null == authorityBaseDO) {
            return null;
        }
        AuthorityBaseDTO authorityBaseDTO = new AuthorityBaseDTO();
        BeanUtils.copyProperties(authorityBaseDO, authorityBaseDTO);
        return authorityBaseDTO;
    }

    @Override
    public List<AuthorityBaseDTO> queryList(AuthorityBaseDTO authorityBaseDTO) {
        if (null == authorityBaseDTO) {
            return null;
        }
        AuthorityBaseDO authorityBaseDO = new AuthorityBaseDO();
        BeanUtils.copyProperties(authorityBaseDTO, authorityBaseDO);
        List<AuthorityBaseDO> authorityBaseDOList = authorityBaseDao.queryList(authorityBaseDO);
        if (CollectionUtils.isEmpty(authorityBaseDOList)) {
            return Lists.newArrayList();
        }
        List<AuthorityBaseDTO> authorityBaseDTOList;
        try {
            authorityBaseDTOList=BeanUtils.convertList(authorityBaseDOList, AuthorityBaseDTO.class);
        } catch (Exception e) {
            String msg = String.format("AuthorityBaseServiceImpl.queryList方法list转换失败：%s",
                    JSONObject.toJSONString(authorityBaseDOList));
            logger.error(msg, e);
            return Lists.newArrayList();
        }
        return authorityBaseDTOList;
    }

    @Override
    public PageInfo<AuthorityBaseDTO> queryPageInfo(AuthorityBaseDTO authorityBaseDTO, Integer pageNum, Integer pageSize) {
        if (null == authorityBaseDTO) {
            return null;
        }
        AuthorityBaseDO authorityBaseDO = new AuthorityBaseDO();
        BeanUtils.copyProperties(authorityBaseDTO, authorityBaseDO);
        if (null != pageNum && null != pageSize) {
            PageHelper.startPage(pageNum, pageSize);
        }
        Page<AuthorityBaseDO> authorityBaseDOPage = authorityBaseDao.queryList(authorityBaseDO);
        PageInfo<AuthorityBaseDTO> authorityBaseDTOPageInfo=new PageInfo<>();
        if (CollectionUtils.isEmpty(authorityBaseDOPage)) {
            authorityBaseDTOPageInfo.setTotal(0);
            return authorityBaseDTOPageInfo;
        }
        List<AuthorityBaseDTO> authorityBaseDTOList;
        try {
            authorityBaseDTOList=BeanUtils.convertList(authorityBaseDOPage, AuthorityBaseDTO.class);
        } catch (Exception e) {
            String msg = String.format("AuthorityBaseServiceImpl.queryPageInfo方法list转换失败：%s",
                    JSONObject.toJSONString(authorityBaseDOPage));
            logger.error(msg, e);
            authorityBaseDTOPageInfo.setTotal(0);
            return authorityBaseDTOPageInfo;
        }
        authorityBaseDTOPageInfo.setList(authorityBaseDTOList);
        authorityBaseDTOPageInfo.setTotal(authorityBaseDOPage.getTotal());
        return authorityBaseDTOPageInfo;
    }
}
