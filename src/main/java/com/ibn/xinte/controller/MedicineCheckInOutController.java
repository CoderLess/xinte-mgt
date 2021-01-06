package com.ibn.xinte.controller;

import com.alibaba.fastjson.JSONObject;
import com.ibn.xinte.common.ResultInfo;
import com.ibn.xinte.domain.MedicineCheckInOutDTO;
import com.ibn.xinte.enumeration.MedicineCheckInOutTypeEnum;
import com.ibn.xinte.service.MedicineCheckInOutService;
import com.ibn.xinte.util.BeanUtils;
import com.ibn.xinte.util.RequestUtils;
import com.ibn.xinte.vo.MedicineCheckInOutVO;
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

    @ApiOperation("保存出库、入库信息")
    @PostMapping("save")
    public ResultInfo save(@RequestBody MedicineCheckInOutVO medicineCheckInOutVO, HttpServletRequest request) {
        if (null == medicineCheckInOutVO) {
            return new ResultInfo().error("参数不能为空");
        }
        Long adminId = RequestUtils.getUserId(request);
        MedicineCheckInOutDTO medicineCheckInOutDTO = new MedicineCheckInOutDTO();
        BeanUtils.copyProperties(medicineCheckInOutVO, medicineCheckInOutDTO);
        medicineCheckInOutDTO.setCreateTime(System.currentTimeMillis());
        medicineCheckInOutDTO.setAdminId(adminId);
        Long id = medicineCheckInOutService.save(medicineCheckInOutDTO);
        return new ResultInfo().success(id);
    }

    @ApiOperation("根据id更新出库入库信息")
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

    @ApiOperation("根据id删除出库、入库信息")
    @PostMapping("deleteById")
    public ResultInfo deleteById(Long id) {
        if (null == id) {
            return new ResultInfo().error("参数不能为空");
        }
        medicineCheckInOutService.deleteById(id);
        return new ResultInfo().success();
    }

    @ApiOperation("根据id查询出库、入库信息")
    @GetMapping("queryById")
    public ResultInfo queryById(Long id) {
        if (null == id) {
            return new ResultInfo().error("参数不能为空");
        }
        MedicineCheckInOutDTO medicineCheckInOutDTO = medicineCheckInOutService.queryById(id);
        return new ResultInfo().success(medicineCheckInOutDTO);
    }

    @ApiOperation("根据条件查询出库、入库信息")
    @GetMapping("queryList")
    public ResultInfo queryList(@ModelAttribute MedicineCheckInOutVO medicineCheckInOutVO) {
        if (null == medicineCheckInOutVO) {
            return new ResultInfo().error("参数不能为空");
        }
        MedicineCheckInOutDTO medicineCheckInOutDTO = new MedicineCheckInOutDTO();
        BeanUtils.copyProperties(medicineCheckInOutVO, medicineCheckInOutDTO);
        List<MedicineCheckInOutDTO> medicineCheckInOutDTOList = medicineCheckInOutService.queryList(medicineCheckInOutDTO);
        return new ResultInfo().success(medicineCheckInOutDTOList);
    }

    @ApiOperation("出库、入库枚举")
    @GetMapping("typeEnum")
    public ResultInfo typeEnum() {
        return new ResultInfo().success(MedicineCheckInOutTypeEnum.allEnum());
    }

}
