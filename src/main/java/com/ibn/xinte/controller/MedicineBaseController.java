package com.ibn.xinte.controller;

import com.alibaba.fastjson.JSONObject;
import com.ibn.xinte.common.ResultInfo;
import com.ibn.xinte.domain.MedicineBaseDTO;
import com.ibn.xinte.service.MedicineBaseService;
import com.ibn.xinte.util.BeanUtils;
import com.ibn.xinte.vo.MedicineBaseVO;
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
@RequestMapping("medicineBase")
public class MedicineBaseController {

    private static final Logger logger = LoggerFactory.getLogger(MedicineBaseController.class);

    @Autowired
    private MedicineBaseService medicineBaseService;

    @PostMapping("save")
    public ResultInfo save(@RequestBody MedicineBaseVO medicineBaseVO) {
        if (null == medicineBaseVO) {
            return new ResultInfo().error("参数不能为空");
        }
        MedicineBaseDTO medicineBaseDTO = new MedicineBaseDTO();
        BeanUtils.copyProperties(medicineBaseVO, medicineBaseDTO);
        Long id = medicineBaseService.save(medicineBaseDTO);
        return new ResultInfo().success(id);
    }

    @PostMapping("saveBatch")
    public ResultInfo save(@RequestBody List<MedicineBaseVO> medicineBaseVOList) {
        if (CollectionUtils.isEmpty(medicineBaseVOList)) {
            return new ResultInfo().error("参数不能为空");
        }
        List<MedicineBaseDTO> medicineBaseDTOList = null;
        try {
            medicineBaseDTOList = BeanUtils.convertList(medicineBaseVOList, MedicineBaseDTO.class);
        } catch (Exception e) {
            String msg = String.format("MedicineBaseController.save中list转换失败：%s", JSONObject.toJSONString(medicineBaseDTOList));
            logger.error(msg, e);
        }
        medicineBaseService.saveBatch(medicineBaseDTOList);
        return new ResultInfo().success();
    }

    @PostMapping("updateById")
    public ResultInfo updateById(@RequestBody MedicineBaseVO medicineBaseVO) {
        if (null == medicineBaseVO) {
            return new ResultInfo().error("参数不能为空");
        }
        MedicineBaseDTO medicineBaseDTO = new MedicineBaseDTO();
        BeanUtils.copyProperties(medicineBaseVO, medicineBaseDTO);
        medicineBaseService.updateById(medicineBaseDTO);
        return new ResultInfo().success();
    }

    @PostMapping("deleteById")
    public ResultInfo deleteById(Long id) {
        if (null == id) {
            return new ResultInfo().error("参数不能为空");
        }
        medicineBaseService.deleteById(id);
        return new ResultInfo().success();
    }

    @GetMapping("queryById")
    public ResultInfo queryById(Long id) {
        if (null == id) {
            return new ResultInfo().error("参数不能为空");
        }
        MedicineBaseDTO medicineBaseDTO = medicineBaseService.queryById(id);
        return new ResultInfo().success(medicineBaseDTO);
    }

    @GetMapping("queryList")
    public ResultInfo queryList(@RequestBody MedicineBaseVO medicineBaseVO) {
        if (null == medicineBaseVO) {
            return new ResultInfo().error("参数不能为空");
        }
        MedicineBaseDTO medicineBaseDTO = new MedicineBaseDTO();
        BeanUtils.copyProperties(medicineBaseVO, medicineBaseDTO);
        List<MedicineBaseDTO> medicineBaseDTOList = medicineBaseService.queryList(medicineBaseDTO);
        return new ResultInfo().success(medicineBaseDTOList);
    }

}
