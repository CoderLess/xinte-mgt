package com.ibn.xinte.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.google.common.collect.Lists;
import com.ibn.xinte.dao.AdminBaseDao;
import com.ibn.xinte.dao.AdminCommissionDao;
import com.ibn.xinte.domain.AdminBaseDTO;
import com.ibn.xinte.domain.AdminCommissionDTO;
import com.ibn.xinte.domain.AdminCommissionStaticsDTO;
import com.ibn.xinte.entity.AdminBaseDO;
import com.ibn.xinte.entity.AdminCommissionDO;
import com.ibn.xinte.exception.IbnException;
import com.ibn.xinte.service.AdminCommissionService;
import com.ibn.xinte.util.BeanUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.math.BigDecimal;
import java.util.List;

/**
 * @version 1.0
 * @description:
 * @projectName：xinte
 * @see: com.ibn.xinte.service.impl
 * @author： RenBin
 * @createTime：2021年1月10日
 */
@Service("adminCommissionSerive")
public class AdminCommissionServiceImpl implements AdminCommissionService {

    private static final Logger logger = LoggerFactory.getLogger(BeanUtils.class);

    @Autowired
    private AdminCommissionDao adminCommissionDao;
    @Autowired
    private AdminBaseDao adminBaseDao;

    @Override
    public Long save(AdminCommissionDTO adminCommissionDTO) {
        if (null == adminCommissionDTO) {
            return null;
        }
        AdminCommissionDO adminCommissionDO = new AdminCommissionDO();
        BeanUtils.copyProperties(adminCommissionDTO, adminCommissionDO);
        adminCommissionDao.save(adminCommissionDO);
        return adminCommissionDO.getId();
    }

    @Override
    public void calculationSave(AdminCommissionDTO adminCommissionDTO) throws IbnException {
        Long adminId = adminCommissionDTO.getAdminId();
        if (Long.valueOf(0).equals(adminId)) {
            return;
        }
        AdminBaseDO adminBaseDO = adminBaseDao.queryById(adminId);
        if (null == adminBaseDO) {
            throw new IbnException("获取管理员信息失败");
        }
        AdminCommissionDO adminCommissionSaveDO = new AdminCommissionDO();
        adminCommissionSaveDO.setPrescriptionId(adminCommissionDTO.getPrescriptionId());
        adminCommissionSaveDO.setAdminId(adminId);
        adminCommissionSaveDO.setCreateTime(System.currentTimeMillis());
        BigDecimal amount = adminBaseDO.getCommission().multiply(adminCommissionDTO.getCommissionAmount()).setScale(2);
        // 药品提成比例
        adminCommissionSaveDO.setCommission(adminBaseDO.getCommission());
        // 药品提成金额
        adminCommissionSaveDO.setCommissionAmount(adminCommissionDTO.getCommissionAmount());

        // 挂号费
        if (null != adminCommissionDTO.getRegistrationFee()) {
            adminCommissionSaveDO.setRegistrationFee(adminCommissionDTO.getRegistrationFee());
            adminCommissionSaveDO.setRegistrationFee(adminCommissionDTO.getRegistrationFee());
            amount = amount.add(adminCommissionDTO.getRegistrationFee().multiply(adminBaseDO.getRegistrationFeeCommission()).setScale(2));
        }
        adminCommissionSaveDO.setAmount(amount);

        adminCommissionDao.save(adminCommissionSaveDO);
    }

    @Override
    public Long saveBatch(List<AdminCommissionDTO> adminCommissionDTOList) {
        if (CollectionUtils.isEmpty(adminCommissionDTOList)) {
            return null;
        }
        List<AdminCommissionDO> adminCommissionDOList;
        try {
            adminCommissionDOList = BeanUtils.convertList(adminCommissionDTOList, AdminCommissionDO.class);
        } catch (Exception e) {
            String msg = String.format("AdminCommissionServiceImp.saveBatch方法llist转换失败：%s",
                    JSONObject.toJSONString(adminCommissionDTOList));
            logger.error(msg, e);
            return null;
        }
        return adminCommissionDao.saveBatch(adminCommissionDOList);
    }

    @Override
    public Integer updateById(AdminCommissionDTO adminCommissionDTO) {
        if (null == adminCommissionDTO) {
            return null;
        }
        AdminCommissionDO adminCommissionDO = new AdminCommissionDO();
        BeanUtils.copyProperties(adminCommissionDTO, adminCommissionDO);
        return adminCommissionDao.updateById(adminCommissionDO);
    }

    @Override
    public Integer deleteById(Long id) {
        if (null == id) {
            return null;
        }
        return adminCommissionDao.deleteById(id);
    }

    @Override
    public AdminCommissionDTO queryById(Long id) {
        if (null == id) {
            return null;
        }
        AdminCommissionDO adminCommissionDO = adminCommissionDao.queryById(id);
        if (null == adminCommissionDO) {
            return null;
        }
        AdminCommissionDTO adminCommissionDTO = new AdminCommissionDTO();
        BeanUtils.copyProperties(adminCommissionDO, adminCommissionDTO);
        return adminCommissionDTO;
    }

    @Override
    public List<AdminCommissionDTO> queryList(AdminCommissionDTO adminCommissionDTO) {
        if (null == adminCommissionDTO) {
            return null;
        }
        AdminCommissionDO adminCommissionDO = new AdminCommissionDO();
        BeanUtils.copyProperties(adminCommissionDTO, adminCommissionDO);
        List<AdminCommissionDO> adminCommissionDOList = adminCommissionDao.queryList(adminCommissionDO);
        if (CollectionUtils.isEmpty(adminCommissionDOList)) {
            return Lists.newArrayList();
        }
        List<AdminCommissionDTO> adminCommissionDTOList;
        try {
            adminCommissionDTOList=BeanUtils.convertList(adminCommissionDOList, AdminCommissionDTO.class);
        } catch (Exception e) {
            String msg = String.format("AdminCommissionServiceImpl.queryList方法list转换失败：%s",
                    JSONObject.toJSONString(adminCommissionDOList));
            logger.error(msg, e);
            return Lists.newArrayList();
        }
        return adminCommissionDTOList;
    }

    @Override
    public PageInfo<AdminCommissionStaticsDTO> queryPageInfo(AdminCommissionDTO adminCommissionDTO, Integer pageNum, Integer pageSize) {
        if (null == adminCommissionDTO) {
            return null;
        }
        if (null != pageNum && null != pageSize) {
            PageHelper.startPage(pageNum, pageSize);
        }
        Page<AdminCommissionStaticsDTO> adminCommissionStaticsDTOPage = adminCommissionDao.queryPage(adminCommissionDTO);
        PageInfo<AdminCommissionStaticsDTO> adminCommissionStaticsDTOPageInfo=new PageInfo<>();
        if (CollectionUtils.isEmpty(adminCommissionStaticsDTOPage)) {
            return adminCommissionStaticsDTOPageInfo;
        }
        adminCommissionStaticsDTOPageInfo.setList(adminCommissionStaticsDTOPage);
        adminCommissionStaticsDTOPageInfo.setTotal(adminCommissionStaticsDTOPage.getTotal());
        return adminCommissionStaticsDTOPageInfo;
    }
}
