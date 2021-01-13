package com.ibn.xinte.controller;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageInfo;
import com.ibn.xinte.common.ResultInfo;
import com.ibn.xinte.domain.PrescriptionBaseDTO;
import com.ibn.xinte.domain.PrescriptionMedicineDTO;
import com.ibn.xinte.service.PrescriptionBaseService;
import com.ibn.xinte.service.PrescriptionMedicineService;
import com.ibn.xinte.util.BeanUtils;
import com.ibn.xinte.util.RequestUtils;
import com.ibn.xinte.vo.PrescriptionBaseVO;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @version 1.0
 * @description: 药方基本信息
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
    @Autowired
    private PrescriptionMedicineService prescriptionMedicineService;

    @ApiOperation("保存药方信息")
    @PostMapping("save")
    public ResultInfo save(@RequestBody PrescriptionBaseVO prescriptionBaseVO, HttpServletRequest request) {
        if (null == prescriptionBaseVO) {
            return new ResultInfo().error("参数不能为空");
        }
        Long adminId = RequestUtils.getUserId(request);
        PrescriptionBaseDTO prescriptionBaseDTO = new PrescriptionBaseDTO();
        BeanUtils.copyProperties(prescriptionBaseVO, prescriptionBaseDTO);
        prescriptionBaseDTO.setAdminId(adminId);
        prescriptionBaseDTO.setCreateTime(System.currentTimeMillis());
        Long id = prescriptionBaseService.save(prescriptionBaseDTO);
        return new ResultInfo().success(id);
    }

    @ApiOperation("根据id更新药方信息")
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

    @ApiOperation("根据id删除药方信息")
    @PostMapping("deleteById")
    public ResultInfo deleteById(Long id) {
        if (null == id) {
            return new ResultInfo().error("参数不能为空");
        }
        prescriptionBaseService.deleteById(id);
        return new ResultInfo().success();
    }

    @ApiOperation("根据id查询药方信息")
    @GetMapping("queryById")
    public ResultInfo queryById(Long id) {
        if (null == id) {
            return new ResultInfo().error("参数不能为空");
        }
        PrescriptionBaseDTO prescriptionBaseDTO = prescriptionBaseService.queryById(id);
        return new ResultInfo().success(prescriptionBaseDTO);
    }

    @ApiOperation("根据id查询药方及药品信息")
    @GetMapping("queryInfoById")
    public ResultInfo queryInfoById(Long id) {
        if (null == id) {
            return new ResultInfo().error("参数不能为空");
        }
        PrescriptionBaseDTO prescriptionBaseDTO = prescriptionBaseService.queryById(id);
        // 获取药方明细信息
        PrescriptionMedicineDTO prescriptionMedicineDTO = new PrescriptionMedicineDTO();
        prescriptionMedicineDTO.setPrescriptionId(id);
        List<PrescriptionMedicineDTO> prescriptionMedicineDTOList = prescriptionMedicineService.queryInfoList(prescriptionMedicineDTO);
        prescriptionBaseDTO.setPrescriptionMedicineDTOList(prescriptionMedicineDTOList);
        return new ResultInfo().success(prescriptionBaseDTO);
    }

    @ApiOperation("根据条件查询药方信息")
    @GetMapping("queryList")
    public ResultInfo queryList(@ModelAttribute PrescriptionBaseVO prescriptionBaseVO) {
        if (null == prescriptionBaseVO) {
            return new ResultInfo().error("参数不能为空");
        }
        PrescriptionBaseDTO prescriptionBaseDTO = new PrescriptionBaseDTO();
        BeanUtils.copyProperties(prescriptionBaseVO, prescriptionBaseDTO);
        PageInfo<PrescriptionBaseDTO> prescriptionBaseDTOPageInfo = prescriptionBaseService.queryPageInfo(prescriptionBaseDTO, prescriptionBaseVO.getPageNum(), prescriptionBaseVO.getPageSize());
        return new ResultInfo().success(prescriptionBaseDTOPageInfo);
    }

}
