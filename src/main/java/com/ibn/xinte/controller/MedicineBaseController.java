package com.ibn.xinte.controller;

import com.alibaba.fastjson.JSONObject;
import com.ibn.xinte.common.ResultInfo;
import com.ibn.xinte.domain.MedicineBaseDTO;
import com.ibn.xinte.service.MedicineBaseService;
import com.ibn.xinte.util.BeanUtils;
import com.ibn.xinte.util.PinYinUtils;
import com.ibn.xinte.util.RequestUtils;
import com.ibn.xinte.vo.MedicineBaseVO;
import io.swagger.annotations.ApiOperation;
import net.sourceforge.pinyin4j.format.HanyuPinyinOutputFormat;
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
@RequestMapping("medicineBase")
public class MedicineBaseController {

    private static final Logger logger = LoggerFactory.getLogger(MedicineBaseController.class);

    @Autowired
    private MedicineBaseService medicineBaseService;

    @ApiOperation("保存药品基本信息")
    @PostMapping("save")
    public ResultInfo save(@RequestBody MedicineBaseVO medicineBaseVO, HttpServletRequest request) {
        if (null == medicineBaseVO) {
            return new ResultInfo().error("参数不能为空");
        }
        Long adminId = RequestUtils.getUserId(request);
        MedicineBaseDTO medicineBaseDTO = new MedicineBaseDTO();
        BeanUtils.copyProperties(medicineBaseVO, medicineBaseDTO);
        // 获取药品简称
        if (null == medicineBaseDTO.getShortName()) {
            medicineBaseDTO.setShortName(PinYinUtils.getFirstSpell(medicineBaseDTO.getName()));
        }
        medicineBaseDTO.setCreatorId(adminId);
        medicineBaseDTO.setCreateTime(System.currentTimeMillis());
        // 保存记录
        Long id = medicineBaseService.save(medicineBaseDTO);
        return new ResultInfo().success(id);
    }

    @ApiOperation("根据id更新药品基本信息")
    @PostMapping("updateById")
    public ResultInfo updateById(@RequestBody MedicineBaseVO medicineBaseVO, HttpServletRequest request) {
        if (null == medicineBaseVO) {
            return new ResultInfo().error("参数不能为空");
        }
        Long adminId = RequestUtils.getUserId(request);
        MedicineBaseDTO medicineBaseDTO = new MedicineBaseDTO();
        BeanUtils.copyProperties(medicineBaseVO, medicineBaseDTO);
        medicineBaseDTO.setUpdateId(adminId);
        medicineBaseDTO.setUpdateTime(System.currentTimeMillis());
        medicineBaseService.updateById(medicineBaseDTO);
        return new ResultInfo().success();
    }

    @ApiOperation("根据ID查询药品基本信息")
    @GetMapping("queryById")
    public ResultInfo queryById(Long id) {
        if (null == id) {
            return new ResultInfo().error("参数不能为空");
        }
        MedicineBaseDTO medicineBaseDTO = medicineBaseService.queryById(id);
        return new ResultInfo().success(medicineBaseDTO);
    }

    @ApiOperation("根据条件查询药品基本信息")
    @GetMapping("queryList")
    public ResultInfo queryList(@ModelAttribute MedicineBaseVO medicineBaseVO) {
        if (null == medicineBaseVO) {
            return new ResultInfo().error("参数不能为空");
        }
        MedicineBaseDTO medicineBaseDTO = new MedicineBaseDTO();
        BeanUtils.copyProperties(medicineBaseVO, medicineBaseDTO);
        List<MedicineBaseDTO> medicineBaseDTOList = medicineBaseService.queryList(medicineBaseDTO, medicineBaseVO.getPageNum(), medicineBaseVO.getPageSize());
        return new ResultInfo().success(medicineBaseDTOList);
    }

}
