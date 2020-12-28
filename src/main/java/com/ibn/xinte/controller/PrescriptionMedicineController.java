package com.ibn.xinte.controller;

import com.alibaba.fastjson.JSONObject;
import com.ibn.xinte.common.ResultInfo;
import com.ibn.xinte.domain.PrescriptionMedicineDTO;
import com.ibn.xinte.service.PrescriptionMedicineService;
import com.ibn.xinte.util.BeanUtils;
import com.ibn.xinte.vo.PrescriptionMedicineVO;
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
@RequestMapping("prescriptionMedicine")
public class PrescriptionMedicineController {

    private static final Logger logger = LoggerFactory.getLogger(PrescriptionMedicineController.class);

    @Autowired
    private PrescriptionMedicineService prescriptionMedicineService;

    @PostMapping("save")
    public ResultInfo save(@RequestBody PrescriptionMedicineVO prescriptionMedicineVO) {
        if (null == prescriptionMedicineVO) {
            return new ResultInfo().error("参数不能为空");
        }
        PrescriptionMedicineDTO prescriptionMedicineDTO = new PrescriptionMedicineDTO();
        BeanUtils.copyProperties(prescriptionMedicineVO, prescriptionMedicineDTO);
        Long id = prescriptionMedicineService.save(prescriptionMedicineDTO);
        return new ResultInfo().success(id);
    }

    @PostMapping("saveBatch")
    public ResultInfo save(@RequestBody List<PrescriptionMedicineVO> prescriptionMedicineVOList) {
        if (CollectionUtils.isEmpty(prescriptionMedicineVOList)) {
            return new ResultInfo().error("参数不能为空");
        }
        List<PrescriptionMedicineDTO> prescriptionMedicineDTOList = null;
        try {
            prescriptionMedicineDTOList = BeanUtils.convertList(prescriptionMedicineVOList, PrescriptionMedicineDTO.class);
        } catch (Exception e) {
            String msg = String.format("PrescriptionMedicineController.save中list转换失败：%s", JSONObject.toJSONString(prescriptionMedicineDTOList));
            logger.error(msg, e);
        }
        prescriptionMedicineService.saveBatch(prescriptionMedicineDTOList);
        return new ResultInfo().success();
    }

    @PostMapping("updateById")
    public ResultInfo updateById(@RequestBody PrescriptionMedicineVO prescriptionMedicineVO) {
        if (null == prescriptionMedicineVO) {
            return new ResultInfo().error("参数不能为空");
        }
        PrescriptionMedicineDTO prescriptionMedicineDTO = new PrescriptionMedicineDTO();
        BeanUtils.copyProperties(prescriptionMedicineVO, prescriptionMedicineDTO);
        prescriptionMedicineService.updateById(prescriptionMedicineDTO);
        return new ResultInfo().success();
    }

    @PostMapping("deleteById")
    public ResultInfo deleteById(Long id) {
        if (null == id) {
            return new ResultInfo().error("参数不能为空");
        }
        prescriptionMedicineService.deleteById(id);
        return new ResultInfo().success();
    }

    @GetMapping("queryById")
    public ResultInfo queryById(Long id) {
        if (null == id) {
            return new ResultInfo().error("参数不能为空");
        }
        PrescriptionMedicineDTO prescriptionMedicineDTO = prescriptionMedicineService.queryById(id);
        return new ResultInfo().success(prescriptionMedicineDTO);
    }

    @GetMapping("queryList")
    public ResultInfo queryList(@RequestBody PrescriptionMedicineVO prescriptionMedicineVO) {
        if (null == prescriptionMedicineVO) {
            return new ResultInfo().error("参数不能为空");
        }
        PrescriptionMedicineDTO prescriptionMedicineDTO = new PrescriptionMedicineDTO();
        BeanUtils.copyProperties(prescriptionMedicineVO, prescriptionMedicineDTO);
        List<PrescriptionMedicineDTO> prescriptionMedicineDTOList = prescriptionMedicineService.queryList(prescriptionMedicineDTO);
        return new ResultInfo().success(prescriptionMedicineDTOList);
    }

}
