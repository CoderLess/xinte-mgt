package com.ibn.xinte.controller;

import com.alibaba.fastjson.JSONObject;
import com.ibn.xinte.common.ResultInfo;
import com.ibn.xinte.domain.PrescriptionBaseDTO;
import com.ibn.xinte.service.PrescriptionBaseService;
import com.ibn.xinte.util.BeanUtils;
import com.ibn.xinte.vo.PrescriptionBaseVO;
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
@RequestMapping("prescriptionBase")
public class PrescriptionBaseController {

    private static final Logger logger = LoggerFactory.getLogger(PrescriptionBaseController.class);

    @Autowired
    private PrescriptionBaseService prescriptionBaseService;

    @PostMapping("save")
    public ResultInfo save(@RequestBody PrescriptionBaseVO prescriptionBaseVO) {
        if (null == prescriptionBaseVO) {
            return new ResultInfo().error("参数不能为空");
        }
        PrescriptionBaseDTO prescriptionBaseDTO = new PrescriptionBaseDTO();
        BeanUtils.copyProperties(prescriptionBaseVO, prescriptionBaseDTO);
        Long id = prescriptionBaseService.save(prescriptionBaseDTO);
        return new ResultInfo().success(id);
    }

    @PostMapping("saveBatch")
    public ResultInfo save(@RequestBody List<PrescriptionBaseVO> prescriptionBaseVOList) {
        if (CollectionUtils.isEmpty(prescriptionBaseVOList)) {
            return new ResultInfo().error("参数不能为空");
        }
        List<PrescriptionBaseDTO> prescriptionBaseDTOList = null;
        try {
            prescriptionBaseDTOList = BeanUtils.convertList(prescriptionBaseVOList, PrescriptionBaseDTO.class);
        } catch (Exception e) {
            String msg = String.format("PrescriptionBaseController.save中list转换失败：%s", JSONObject.toJSONString(prescriptionBaseDTOList));
            logger.error(msg, e);
        }
        prescriptionBaseService.saveBatch(prescriptionBaseDTOList);
        return new ResultInfo().success();
    }

    @PostMapping("updateById")
    public ResultInfo updateById(@RequestBody PrescriptionBaseVO prescriptionBaseVO) {
        if (null == prescriptionBaseVO) {
            return new ResultInfo().error("参数不能为空");
        }
        PrescriptionBaseDTO prescriptionBaseDTO = new PrescriptionBaseDTO();
        BeanUtils.copyProperties(prescriptionBaseVO, prescriptionBaseDTO);
        prescriptionBaseService.updateById(prescriptionBaseDTO);
        return new ResultInfo().success();
    }

    @PostMapping("deleteById")
    public ResultInfo deleteById(Long id) {
        if (null == id) {
            return new ResultInfo().error("参数不能为空");
        }
        prescriptionBaseService.deleteById(id);
        return new ResultInfo().success();
    }

    @GetMapping("queryById")
    public ResultInfo queryById(Long id) {
        if (null == id) {
            return new ResultInfo().error("参数不能为空");
        }
        PrescriptionBaseDTO prescriptionBaseDTO = prescriptionBaseService.queryById(id);
        return new ResultInfo().success(prescriptionBaseDTO);
    }

    @GetMapping("queryList")
    public ResultInfo queryList(@RequestBody PrescriptionBaseVO prescriptionBaseVO) {
        if (null == prescriptionBaseVO) {
            return new ResultInfo().error("参数不能为空");
        }
        PrescriptionBaseDTO prescriptionBaseDTO = new PrescriptionBaseDTO();
        BeanUtils.copyProperties(prescriptionBaseVO, prescriptionBaseDTO);
        List<PrescriptionBaseDTO> prescriptionBaseDTOList = prescriptionBaseService.queryList(prescriptionBaseDTO);
        return new ResultInfo().success(prescriptionBaseDTOList);
    }

}
