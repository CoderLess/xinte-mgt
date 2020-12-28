package com.ibn.xinte.controller;

import com.alibaba.fastjson.JSONObject;
import com.ibn.xinte.common.ResultInfo;
import com.ibn.xinte.domain.MedicineStoreDTO;
import com.ibn.xinte.service.MedicineStoreService;
import com.ibn.xinte.util.BeanUtils;
import com.ibn.xinte.vo.MedicineStoreVO;
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
@RequestMapping("medicineStore")
public class MedicineStoreController {

    private static final Logger logger = LoggerFactory.getLogger(MedicineStoreController.class);

    @Autowired
    private MedicineStoreService medicineStoreService;

    @PostMapping("save")
    public ResultInfo save(@RequestBody MedicineStoreVO medicineStoreVO) {
        if (null == medicineStoreVO) {
            return new ResultInfo().error("参数不能为空");
        }
        MedicineStoreDTO medicineStoreDTO = new MedicineStoreDTO();
        BeanUtils.copyProperties(medicineStoreVO, medicineStoreDTO);
        Long id = medicineStoreService.save(medicineStoreDTO);
        return new ResultInfo().success(id);
    }

    @PostMapping("saveBatch")
    public ResultInfo save(@RequestBody List<MedicineStoreVO> medicineStoreVOList) {
        if (CollectionUtils.isEmpty(medicineStoreVOList)) {
            return new ResultInfo().error("参数不能为空");
        }
        List<MedicineStoreDTO> medicineStoreDTOList = null;
        try {
            medicineStoreDTOList = BeanUtils.convertList(medicineStoreVOList, MedicineStoreDTO.class);
        } catch (Exception e) {
            String msg = String.format("MedicineStoreController.save中list转换失败：%s", JSONObject.toJSONString(medicineStoreDTOList));
            logger.error(msg, e);
        }
        medicineStoreService.saveBatch(medicineStoreDTOList);
        return new ResultInfo().success();
    }

    @PostMapping("updateById")
    public ResultInfo updateById(@RequestBody MedicineStoreVO medicineStoreVO) {
        if (null == medicineStoreVO) {
            return new ResultInfo().error("参数不能为空");
        }
        MedicineStoreDTO medicineStoreDTO = new MedicineStoreDTO();
        BeanUtils.copyProperties(medicineStoreVO, medicineStoreDTO);
        medicineStoreService.updateById(medicineStoreDTO);
        return new ResultInfo().success();
    }

    @PostMapping("deleteById")
    public ResultInfo deleteById(Long id) {
        if (null == id) {
            return new ResultInfo().error("参数不能为空");
        }
        medicineStoreService.deleteById(id);
        return new ResultInfo().success();
    }

    @GetMapping("queryById")
    public ResultInfo queryById(Long id) {
        if (null == id) {
            return new ResultInfo().error("参数不能为空");
        }
        MedicineStoreDTO medicineStoreDTO = medicineStoreService.queryById(id);
        return new ResultInfo().success(medicineStoreDTO);
    }

    @GetMapping("queryList")
    public ResultInfo queryList(@RequestBody MedicineStoreVO medicineStoreVO) {
        if (null == medicineStoreVO) {
            return new ResultInfo().error("参数不能为空");
        }
        MedicineStoreDTO medicineStoreDTO = new MedicineStoreDTO();
        BeanUtils.copyProperties(medicineStoreVO, medicineStoreDTO);
        List<MedicineStoreDTO> medicineStoreDTOList = medicineStoreService.queryList(medicineStoreDTO);
        return new ResultInfo().success(medicineStoreDTOList);
    }

}
