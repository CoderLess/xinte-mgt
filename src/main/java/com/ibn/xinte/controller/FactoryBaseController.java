package com.ibn.xinte.controller;

import com.alibaba.fastjson.JSONObject;
import com.ibn.xinte.common.ResultInfo;
import com.ibn.xinte.domain.FactoryBaseDTO;
import com.ibn.xinte.service.FactoryBaseService;
import com.ibn.xinte.util.BeanUtils;
import com.ibn.xinte.util.PinYinUtils;
import com.ibn.xinte.vo.FactoryBaseVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
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
@RequestMapping("factoryBase")
public class FactoryBaseController {

    private static final Logger logger = LoggerFactory.getLogger(FactoryBaseController.class);

    @Autowired
    private FactoryBaseService factoryBaseService;

    @PostMapping("save")
    public ResultInfo save(@RequestBody FactoryBaseVO factoryBaseVO) {
        if (null == factoryBaseVO) {
            return new ResultInfo().error("参数不能为空");
        }
        FactoryBaseDTO factoryBaseDTO = new FactoryBaseDTO();
        BeanUtils.copyProperties(factoryBaseVO, factoryBaseDTO);
        Long id = factoryBaseService.save(factoryBaseDTO);
        return new ResultInfo().success(id);
    }

    @PostMapping("saveBatch")
    public ResultInfo save(@RequestBody List<FactoryBaseVO> factoryBaseVOList) {
        if (CollectionUtils.isEmpty(factoryBaseVOList)) {
            return new ResultInfo().error("参数不能为空");
        }
        List<FactoryBaseDTO> factoryBaseDTOList = null;
        try {
            factoryBaseDTOList = BeanUtils.convertList(factoryBaseVOList, FactoryBaseDTO.class);
        } catch (Exception e) {
            String msg = String.format("FactoryBaseController.save中list转换失败：%s", JSONObject.toJSONString(factoryBaseDTOList));
            logger.error(msg, e);
        }
        factoryBaseService.saveBatch(factoryBaseDTOList);
        return new ResultInfo().success();
    }

    @PostMapping("updateById")
    public ResultInfo updateById(@RequestBody FactoryBaseVO factoryBaseVO) {
        if (null == factoryBaseVO) {
            return new ResultInfo().error("参数不能为空");
        }
        FactoryBaseDTO factoryBaseDTO = new FactoryBaseDTO();
        BeanUtils.copyProperties(factoryBaseVO, factoryBaseDTO);
        factoryBaseService.updateById(factoryBaseDTO);
        return new ResultInfo().success();
    }

    @PostMapping("deleteById")
    public ResultInfo deleteById(Long id) {
        if (null == id) {
            return new ResultInfo().error("参数不能为空");
        }
        factoryBaseService.deleteById(id);
        return new ResultInfo().success();
    }

    @GetMapping("queryById")
    public ResultInfo queryById(Long id) {
        if (null == id) {
            return new ResultInfo().error("参数不能为空");
        }
        FactoryBaseDTO factoryBaseDTO = factoryBaseService.queryById(id);
        return new ResultInfo().success(factoryBaseDTO);
    }

    @GetMapping("queryList")
    public ResultInfo queryList(@ModelAttribute FactoryBaseVO factoryBaseVO) {
        if (null == factoryBaseVO) {
            return new ResultInfo().error("参数不能为空");
        }
        FactoryBaseDTO factoryBaseDTO = new FactoryBaseDTO();
        BeanUtils.copyProperties(factoryBaseVO, factoryBaseDTO);
        List<FactoryBaseDTO> factoryBaseDTOList = factoryBaseService.queryList(factoryBaseDTO);
        return new ResultInfo().success(factoryBaseDTOList);
    }

}
