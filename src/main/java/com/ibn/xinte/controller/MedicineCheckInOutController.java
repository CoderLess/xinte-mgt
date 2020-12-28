package com.ibn.xinte.controller;

import com.alibaba.fastjson.JSONObject;
import com.ibn.xinte.common.ResultInfo;
import com.ibn.xinte.domain.MedicineCheckInOutDTO;
import com.ibn.xinte.service.MedicineCheckInOutService;
import com.ibn.xinte.util.BeanUtils;
import com.ibn.xinte.vo.MedicineCheckInOutVO;
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
@RequestMapping("medicineCheckInOut")
public class MedicineCheckInOutController {

    private static final Logger logger = LoggerFactory.getLogger(MedicineCheckInOutController.class);

    @Autowired
    private MedicineCheckInOutService medicineCheckInOutService;

    @PostMapping("save")
    public ResultInfo save(@RequestBody MedicineCheckInOutVO medicineCheckInOutVO) {
        if (null == medicineCheckInOutVO) {
            return new ResultInfo().error("参数不能为空");
        }
        MedicineCheckInOutDTO medicineCheckInOutDTO = new MedicineCheckInOutDTO();
        BeanUtils.copyProperties(medicineCheckInOutVO, medicineCheckInOutDTO);
        Long id = medicineCheckInOutService.save(medicineCheckInOutDTO);
        return new ResultInfo().success(id);
    }

    @PostMapping("saveBatch")
    public ResultInfo save(@RequestBody List<MedicineCheckInOutVO> medicineCheckInOutVOList) {
        if (CollectionUtils.isEmpty(medicineCheckInOutVOList)) {
            return new ResultInfo().error("参数不能为空");
        }
        List<MedicineCheckInOutDTO> medicineCheckInOutDTOList = null;
        try {
            medicineCheckInOutDTOList = BeanUtils.convertList(medicineCheckInOutVOList, MedicineCheckInOutDTO.class);
        } catch (Exception e) {
            String msg = String.format("MedicineCheckInOutController.save中list转换失败：%s", JSONObject.toJSONString(medicineCheckInOutDTOList));
            logger.error(msg, e);
        }
        medicineCheckInOutService.saveBatch(medicineCheckInOutDTOList);
        return new ResultInfo().success();
    }

    @PostMapping("updateById")
    public ResultInfo updateById(@RequestBody MedicineCheckInOutVO medicineCheckInOutVO) {
        if (null == medicineCheckInOutVO) {
            return new ResultInfo().error("参数不能为空");
        }
        MedicineCheckInOutDTO medicineCheckInOutDTO = new MedicineCheckInOutDTO();
        BeanUtils.copyProperties(medicineCheckInOutVO, medicineCheckInOutDTO);
        medicineCheckInOutService.updateById(medicineCheckInOutDTO);
        return new ResultInfo().success();
    }

    @PostMapping("deleteById")
    public ResultInfo deleteById(Long id) {
        if (null == id) {
            return new ResultInfo().error("参数不能为空");
        }
        medicineCheckInOutService.deleteById(id);
        return new ResultInfo().success();
    }

    @GetMapping("queryById")
    public ResultInfo queryById(Long id) {
        if (null == id) {
            return new ResultInfo().error("参数不能为空");
        }
        MedicineCheckInOutDTO medicineCheckInOutDTO = medicineCheckInOutService.queryById(id);
        return new ResultInfo().success(medicineCheckInOutDTO);
    }

    @GetMapping("queryList")
    public ResultInfo queryList(@RequestBody MedicineCheckInOutVO medicineCheckInOutVO) {
        if (null == medicineCheckInOutVO) {
            return new ResultInfo().error("参数不能为空");
        }
        MedicineCheckInOutDTO medicineCheckInOutDTO = new MedicineCheckInOutDTO();
        BeanUtils.copyProperties(medicineCheckInOutVO, medicineCheckInOutDTO);
        List<MedicineCheckInOutDTO> medicineCheckInOutDTOList = medicineCheckInOutService.queryList(medicineCheckInOutDTO);
        return new ResultInfo().success(medicineCheckInOutDTOList);
    }

}
