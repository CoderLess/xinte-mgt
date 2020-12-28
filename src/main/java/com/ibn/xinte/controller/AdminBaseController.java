package com.ibn.xinte.controller;

import com.alibaba.fastjson.JSONObject;
import com.ibn.xinte.common.ResultInfo;
import com.ibn.xinte.domain.AdminBaseDTO;
import com.ibn.xinte.service.AdminBaseService;
import com.ibn.xinte.util.BeanUtils;
import com.ibn.xinte.vo.AdminBaseVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @version 1.0
 * @description:
 * @projectName：xinte
 * @see: com.ibn.xinte.controller
 * @author： RenBin
 * @createTime：2020年12月28日
 */
@RestController
@RequestMapping("adminBase")
public class AdminBaseController {

    private static final Logger logger = LoggerFactory.getLogger(AdminBaseController.class);

    @Autowired
    private AdminBaseService adminBaseService;

    @PostMapping("save")
    public ResultInfo save(@RequestBody AdminBaseVO adminBaseVO) {
        if (null == adminBaseVO) {
            return new ResultInfo().error("参数不能为空");
        }
        AdminBaseDTO adminBaseDTO = new AdminBaseDTO();
        BeanUtils.copyProperties(adminBaseVO, adminBaseDTO);
        Long id = adminBaseService.save(adminBaseDTO);
        return new ResultInfo().success(id);
    }

    @PostMapping("saveBatch")
    public ResultInfo save(@RequestBody List<AdminBaseVO> adminBaseVOList) {
        if (CollectionUtils.isEmpty(adminBaseVOList)) {
            return new ResultInfo().error("参数不能为空");
        }
        List<AdminBaseDTO> adminBaseDTOList = null;
        try {
            adminBaseDTOList = BeanUtils.convertList(adminBaseVOList, AdminBaseDTO.class);
        } catch (Exception e) {
            String msg = String.format("AdminBaseController.save中list转换失败：%s", JSONObject.toJSONString(adminBaseDTOList));
            logger.error(msg, e);
        }
        adminBaseService.saveBatch(adminBaseDTOList);
        return new ResultInfo().success();
    }

    @PostMapping("updateById")
    public ResultInfo updateById(@RequestBody AdminBaseVO adminBaseVO) {
        if (null == adminBaseVO) {
            return new ResultInfo().error("参数不能为空");
        }
        AdminBaseDTO adminBaseDTO = new AdminBaseDTO();
        BeanUtils.copyProperties(adminBaseVO, adminBaseDTO);
        adminBaseService.updateById(adminBaseDTO);
        return new ResultInfo().success();
    }

    @PostMapping("deleteById")
    public ResultInfo deleteById(Long id) {
        if (null == id) {
            return new ResultInfo().error("参数不能为空");
        }
        adminBaseService.deleteById(id);
        return new ResultInfo().success();
    }

    @GetMapping("queryById")
    public ResultInfo queryById(Long id) {
        if (null == id) {
            return new ResultInfo().error("参数不能为空");
        }
        AdminBaseDTO adminBaseDTO = adminBaseService.queryById(id);
        return new ResultInfo().success(adminBaseDTO);
    }

    @GetMapping("queryList")
    public ResultInfo queryList(@RequestBody AdminBaseVO adminBaseVO) {
        if (null == adminBaseVO) {
            return new ResultInfo().error("参数不能为空");
        }
        AdminBaseDTO adminBaseDTO = new AdminBaseDTO();
        BeanUtils.copyProperties(adminBaseVO, adminBaseDTO);
        List<AdminBaseDTO> adminBaseDTOList = adminBaseService.queryList(adminBaseDTO);
        return new ResultInfo().success(adminBaseDTOList);
    }

}
