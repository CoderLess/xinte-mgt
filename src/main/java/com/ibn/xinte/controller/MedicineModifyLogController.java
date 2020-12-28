package com.ibn.xinte.controller;

import com.alibaba.fastjson.JSONObject;
import com.ibn.xinte.common.ResultInfo;
import com.ibn.xinte.domain.MedicineModifyLogDTO;
import com.ibn.xinte.service.MedicineModifyLogService;
import com.ibn.xinte.util.BeanUtils;
import com.ibn.xinte.vo.MedicineModifyLogVO;
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
@RequestMapping("medicineModifyLog")
public class MedicineModifyLogController {

    private static final Logger logger = LoggerFactory.getLogger(MedicineModifyLogController.class);

    @Autowired
    private MedicineModifyLogService medicineModifyLogService;

    @PostMapping("save")
    public ResultInfo save(@RequestBody MedicineModifyLogVO medicineModifyLogVO) {
        if (null == medicineModifyLogVO) {
            return new ResultInfo().error("参数不能为空");
        }
        MedicineModifyLogDTO medicineModifyLogDTO = new MedicineModifyLogDTO();
        BeanUtils.copyProperties(medicineModifyLogVO, medicineModifyLogDTO);
        Long id = medicineModifyLogService.save(medicineModifyLogDTO);
        return new ResultInfo().success(id);
    }

    @PostMapping("saveBatch")
    public ResultInfo save(@RequestBody List<MedicineModifyLogVO> medicineModifyLogVOList) {
        if (CollectionUtils.isEmpty(medicineModifyLogVOList)) {
            return new ResultInfo().error("参数不能为空");
        }
        List<MedicineModifyLogDTO> medicineModifyLogDTOList = null;
        try {
            medicineModifyLogDTOList = BeanUtils.convertList(medicineModifyLogVOList, MedicineModifyLogDTO.class);
        } catch (Exception e) {
            String msg = String.format("MedicineModifyLogController.save中list转换失败：%s", JSONObject.toJSONString(medicineModifyLogDTOList));
            logger.error(msg, e);
        }
        medicineModifyLogService.saveBatch(medicineModifyLogDTOList);
        return new ResultInfo().success();
    }

    @PostMapping("updateById")
    public ResultInfo updateById(@RequestBody MedicineModifyLogVO medicineModifyLogVO) {
        if (null == medicineModifyLogVO) {
            return new ResultInfo().error("参数不能为空");
        }
        MedicineModifyLogDTO medicineModifyLogDTO = new MedicineModifyLogDTO();
        BeanUtils.copyProperties(medicineModifyLogVO, medicineModifyLogDTO);
        medicineModifyLogService.updateById(medicineModifyLogDTO);
        return new ResultInfo().success();
    }

    @PostMapping("deleteById")
    public ResultInfo deleteById(Long id) {
        if (null == id) {
            return new ResultInfo().error("参数不能为空");
        }
        medicineModifyLogService.deleteById(id);
        return new ResultInfo().success();
    }

    @GetMapping("queryById")
    public ResultInfo queryById(Long id) {
        if (null == id) {
            return new ResultInfo().error("参数不能为空");
        }
        MedicineModifyLogDTO medicineModifyLogDTO = medicineModifyLogService.queryById(id);
        return new ResultInfo().success(medicineModifyLogDTO);
    }

    @GetMapping("queryList")
    public ResultInfo queryList(@RequestBody MedicineModifyLogVO medicineModifyLogVO) {
        if (null == medicineModifyLogVO) {
            return new ResultInfo().error("参数不能为空");
        }
        MedicineModifyLogDTO medicineModifyLogDTO = new MedicineModifyLogDTO();
        BeanUtils.copyProperties(medicineModifyLogVO, medicineModifyLogDTO);
        List<MedicineModifyLogDTO> medicineModifyLogDTOList = medicineModifyLogService.queryList(medicineModifyLogDTO);
        return new ResultInfo().success(medicineModifyLogDTOList);
    }

}
