package com.ibn.xinte.controller;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageInfo;
import com.ibn.xinte.common.ResultInfo;
import com.ibn.xinte.domain.RoleBaseDTO;
import com.ibn.xinte.service.RoleBaseService;
import com.ibn.xinte.util.BeanUtils;
import com.ibn.xinte.vo.RoleBaseVO;
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
@RequestMapping("roleBase")
public class RoleBaseController {

    private static final Logger logger = LoggerFactory.getLogger(RoleBaseController.class);

    @Autowired
    private RoleBaseService roleBaseService;

    @PostMapping("save")
    public ResultInfo save(@RequestBody RoleBaseVO roleBaseVO) {
        if (null == roleBaseVO) {
            return new ResultInfo().error("参数不能为空");
        }
        RoleBaseDTO roleBaseDTO = new RoleBaseDTO();
        BeanUtils.copyProperties(roleBaseVO, roleBaseDTO);
        Long id = roleBaseService.save(roleBaseDTO);
        return new ResultInfo().success(id);
    }

    @PostMapping("saveBatch")
    public ResultInfo save(@RequestBody List<RoleBaseVO> roleBaseVOList) {
        if (CollectionUtils.isEmpty(roleBaseVOList)) {
            return new ResultInfo().error("参数不能为空");
        }
        List<RoleBaseDTO> roleBaseDTOList = null;
        try {
            roleBaseDTOList = BeanUtils.convertList(roleBaseVOList, RoleBaseDTO.class);
        } catch (Exception e) {
            String msg = String.format("RoleBaseController.save中list转换失败：%s", JSONObject.toJSONString(roleBaseDTOList));
            logger.error(msg, e);
        }
        roleBaseService.saveBatch(roleBaseDTOList);
        return new ResultInfo().success();
    }

    @PostMapping("updateById")
    public ResultInfo updateById(@RequestBody RoleBaseVO roleBaseVO) {
        if (null == roleBaseVO) {
            return new ResultInfo().error("参数不能为空");
        }
        RoleBaseDTO roleBaseDTO = new RoleBaseDTO();
        BeanUtils.copyProperties(roleBaseVO, roleBaseDTO);
        roleBaseService.updateById(roleBaseDTO);
        return new ResultInfo().success();
    }

    @PostMapping("deleteById")
    public ResultInfo deleteById(Long id) {
        if (null == id) {
            return new ResultInfo().error("参数不能为空");
        }
        roleBaseService.deleteById(id);
        return new ResultInfo().success();
    }

    @GetMapping("queryById")
    public ResultInfo queryById(Long id) {
        if (null == id) {
            return new ResultInfo().error("参数不能为空");
        }
        RoleBaseDTO roleBaseDTO = roleBaseService.queryById(id);
        return new ResultInfo().success(roleBaseDTO);
    }

    @GetMapping("queryList")
    public ResultInfo queryList(@ModelAttribute RoleBaseVO roleBaseVO) {
        if (null == roleBaseVO) {
            return new ResultInfo().error("参数不能为空");
        }
        RoleBaseDTO roleBaseDTO = new RoleBaseDTO();
        BeanUtils.copyProperties(roleBaseVO, roleBaseDTO);
        PageInfo<RoleBaseDTO> roleBaseDTOPageInfo = roleBaseService.queryPageInfo(roleBaseDTO, roleBaseVO.getPageNum(), roleBaseVO.getPageSize());
        return new ResultInfo().success(roleBaseDTOPageInfo);
    }

}
