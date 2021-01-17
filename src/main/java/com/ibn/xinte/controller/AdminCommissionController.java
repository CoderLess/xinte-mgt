package com.ibn.xinte.controller;

import com.alibaba.fastjson.JSONObject;
import com.ibn.xinte.common.ResultInfo;
import com.ibn.xinte.domain.AdminCommissionDTO;
import com.ibn.xinte.service.AdminCommissionService;
import com.ibn.xinte.util.BeanUtils;
import com.ibn.xinte.vo.AdminCommissionVO;
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
 * @createTime：2021年1月10日
 */
@RestController
@RequestMapping("adminCommission")
public class AdminCommissionController {

    private static final Logger logger = LoggerFactory.getLogger(AdminCommissionController.class);

    @Autowired
    private AdminCommissionService adminCommissionService;

    @PostMapping("updateById")
    public ResultInfo updateById(@RequestBody AdminCommissionVO adminCommissionVO) {
        if (null == adminCommissionVO) {
            return new ResultInfo().error("参数不能为空");
        }
        AdminCommissionDTO adminCommissionDTO = new AdminCommissionDTO();
        BeanUtils.copyProperties(adminCommissionVO, adminCommissionDTO);
        adminCommissionService.updateById(adminCommissionDTO);
        return new ResultInfo().success();
    }

    @PostMapping("deleteById")
    public ResultInfo deleteById(Long id) {
        if (null == id) {
            return new ResultInfo().error("参数不能为空");
        }
        adminCommissionService.deleteById(id);
        return new ResultInfo().success();
    }

    @GetMapping("queryById")
    public ResultInfo queryById(Long id) {
        if (null == id) {
            return new ResultInfo().error("参数不能为空");
        }
        AdminCommissionDTO adminCommissionDTO = adminCommissionService.queryById(id);
        return new ResultInfo().success(adminCommissionDTO);
    }

    @GetMapping("queryList")
    public ResultInfo queryList(@ModelAttribute AdminCommissionVO adminCommissionVO) {
        if (null == adminCommissionVO) {
            return new ResultInfo().error("参数不能为空");
        }
        AdminCommissionDTO adminCommissionDTO = new AdminCommissionDTO();
        BeanUtils.copyProperties(adminCommissionVO, adminCommissionDTO);
        List<AdminCommissionDTO> adminCommissionDTOList = adminCommissionService.queryList(adminCommissionDTO);
        return new ResultInfo().success(adminCommissionDTOList);
    }

}
