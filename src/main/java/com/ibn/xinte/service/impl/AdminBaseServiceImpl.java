package com.ibn.xinte.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.google.common.collect.Lists;
import com.ibn.xinte.dao.AdminBaseDao;
import com.ibn.xinte.domain.AdminBaseDTO;
import com.ibn.xinte.entity.AdminBaseDO;
import com.ibn.xinte.service.AdminBaseService;
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
@Service("adminBaseSerive")
public class AdminBaseServiceImpl implements AdminBaseService {

    private static final Logger logger = LoggerFactory.getLogger(BeanUtils.class);

    @Autowired
    private AdminBaseDao adminBaseDao;

    @Override
    public Long save(AdminBaseDTO adminBaseDTO) {
        if (null == adminBaseDTO) {
            return null;
        }
        AdminBaseDO adminBaseDO = new AdminBaseDO();
        BeanUtils.copyProperties(adminBaseDTO, adminBaseDO);
        adminBaseDao.save(adminBaseDO);
        return adminBaseDO.getId();
    }

    @Override
    public Long saveBatch(List<AdminBaseDTO> adminBaseDTOList) {
        if (CollectionUtils.isEmpty(adminBaseDTOList)) {
            return null;
        }
        List<AdminBaseDO> adminBaseDOList;
        try {
            adminBaseDOList = BeanUtils.convertList(adminBaseDTOList, AdminBaseDO.class);
        } catch (Exception e) {
            String msg = String.format("AdminBaseServiceImp.saveBatch方法llist转换失败：%s",
                    JSONObject.toJSONString(adminBaseDTOList));
            logger.error(msg, e);
            return null;
        }
        return adminBaseDao.saveBatch(adminBaseDOList);
    }

    @Override
    public Integer updateById(AdminBaseDTO adminBaseDTO) {
        if (null == adminBaseDTO) {
            return null;
        }
        AdminBaseDO adminBaseDO = new AdminBaseDO();
        BeanUtils.copyProperties(adminBaseDTO, adminBaseDO);
        return adminBaseDao.updateById(adminBaseDO);
    }

    @Override
    public Integer deleteById(Long id) {
        if (null == id) {
            return null;
        }
        return adminBaseDao.deleteById(id);
    }

    @Override
    public AdminBaseDTO queryById(Long id) {
        if (null == id) {
            return null;
        }
        AdminBaseDO adminBaseDO = adminBaseDao.queryById(id);
        if (null == adminBaseDO) {
            return null;
        }
        adminBaseDO.setPassword(null);
        AdminBaseDTO adminBaseDTO = new AdminBaseDTO();
        BeanUtils.copyProperties(adminBaseDO, adminBaseDTO);
        return adminBaseDTO;
    }

    @Override
    public PageInfo<AdminBaseDTO> queryPageInfo(AdminBaseDTO adminBaseDTO, Integer pageNum, Integer pageSize) {
        if (null == adminBaseDTO) {
            return null;
        }
        AdminBaseDO adminBaseDO = new AdminBaseDO();
        BeanUtils.copyProperties(adminBaseDTO, adminBaseDO);
        if (null != pageNum && null != pageSize) {
            PageHelper.startPage(pageNum, pageSize);
        }
        Page<AdminBaseDO> adminBaseDOPage = adminBaseDao.queryList(adminBaseDO);
        PageInfo<AdminBaseDTO> adminBaseDTOPageInfo=new PageInfo<>();
        if (CollectionUtils.isEmpty(adminBaseDOPage)) {
            adminBaseDTOPageInfo.setTotal(0);
            return adminBaseDTOPageInfo;
        }
        List<AdminBaseDTO> adminBaseDTOList;
        try {
            adminBaseDTOList=BeanUtils.convertList(adminBaseDOPage, AdminBaseDTO.class);
        } catch (Exception e) {
            String msg = String.format("AdminBaseServiceImpl.queryPageInfo方法list转换失败：%s",
                    JSONObject.toJSONString(adminBaseDOPage));
            logger.error(msg, e);
            adminBaseDTOPageInfo.setTotal(0);
            return adminBaseDTOPageInfo;
        }
        adminBaseDTOPageInfo.setList(adminBaseDTOList);
        adminBaseDTOPageInfo.setTotal(adminBaseDOPage.getTotal());
        return adminBaseDTOPageInfo;
    }

    @Override
    public List<AdminBaseDTO> queryList(AdminBaseDTO adminBaseDTO) {
        PageInfo<AdminBaseDTO> adminBaseDTOPageInfo = this.queryPageInfo(adminBaseDTO, null, null);
        if (null == adminBaseDTOPageInfo) {
            return Lists.newArrayList();
        }
        return adminBaseDTOPageInfo.getList();
    }
}
