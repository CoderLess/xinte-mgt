package com.ibn.xinte.controller;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageInfo;
import com.google.common.collect.Lists;
import com.ibn.xinte.common.ResultInfo;
import com.ibn.xinte.domain.MedicineBaseDTO;
import com.ibn.xinte.domain.MedicinePriceDTO;
import com.ibn.xinte.service.MedicineBaseService;
import com.ibn.xinte.service.MedicinePriceService;
import com.ibn.xinte.util.BeanUtils;
import com.ibn.xinte.util.PinYinUtils;
import com.ibn.xinte.util.RequestUtils;
import com.ibn.xinte.vo.MedicineBaseVO;
import com.ibn.xinte.vo.MedicineNameQueryVO;
import com.ibn.xinte.vo.MedicineNameVO;
import io.swagger.annotations.ApiOperation;
import net.sourceforge.pinyin4j.format.HanyuPinyinOutputFormat;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
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
    @Autowired
    private MedicinePriceService medicinePriceService;

    @ApiOperation("保存药品基本信息")
    @PostMapping("save")
    public ResultInfo save(@RequestBody MedicineBaseVO medicineBaseVO, HttpServletRequest request) {
        if (null == medicineBaseVO) {
            return new ResultInfo().error("参数不能为空");
        }
        if (!CollectionUtils.isEmpty(medicineBaseVO.getPriceList()) && medicineBaseVO.getPriceList().size() != 5) {
            return new ResultInfo().error("请设置5级会员的药品价格");
        }
        Long adminId = RequestUtils.getUserId(request);
        MedicineBaseDTO medicineBaseDTO = new MedicineBaseDTO();
        BeanUtils.copyProperties(medicineBaseVO, medicineBaseDTO);
        medicineBaseDTO.setCreatorId(adminId);
        medicineBaseDTO.setCreateTime(System.currentTimeMillis());
        medicineBaseDTO.setPriceList(medicineBaseVO.getPriceList());
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

    @ApiOperation("根据ID和会员级别查询药品基本信息")
    @GetMapping("queryByIdLevel")
    public ResultInfo queryById(Long id, Integer level) {
        if (null == id) {
            return new ResultInfo().error("参数不能为空");
        }
        MedicineBaseDTO medicineBaseDTO = medicineBaseService.queryById(id);
        MedicinePriceDTO medicinePriceDTO = medicinePriceService.queryByIdLevel(id, level);
        if (null != medicinePriceDTO) {
            medicineBaseDTO.setSellingPrice(medicinePriceDTO.getSellingPrice());
        }
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
        PageInfo<MedicineBaseDTO> medicineBaseDTOPageInfo = medicineBaseService.queryPageInfo(medicineBaseDTO, medicineBaseVO.getPageNum(), medicineBaseVO.getPageSize());
        return new ResultInfo().success(medicineBaseDTOPageInfo);
    }

    @ApiOperation("根据药品名模糊查询药品信息")
    @GetMapping("queryListByName")
    public ResultInfo queryListByName(@ModelAttribute MedicineNameQueryVO medicineNameQueryVO) {
        if (null == medicineNameQueryVO) {
            return new ResultInfo().error("参数不能为空");
        }
        if (!StringUtils.hasLength(medicineNameQueryVO.getName())) {
            return new ResultInfo().success(Lists.newArrayList());
        }
        MedicineBaseDTO medicineBaseDTO = new MedicineBaseDTO();
        medicineBaseDTO.setName(medicineNameQueryVO.getName());
        PageInfo<MedicineBaseDTO> medicineBaseDTOPageInfo = medicineBaseService.queryPageInfo(medicineBaseDTO, medicineNameQueryVO.getPageNum(), medicineNameQueryVO.getPageSize());
        if (null == medicineBaseDTOPageInfo || CollectionUtils.isEmpty(medicineBaseDTOPageInfo.getList())) {
            return new ResultInfo().success(Lists.newArrayList());
        }
        try {
            return new ResultInfo().success(medicineBaseDTOPageInfo.getList());
        } catch (Exception e) {
            String msg = String.format("MedicineBaseController.queryListByName：%s",
                    JSONObject.toJSONString(medicineBaseDTOPageInfo.getList()));
            logger.error(msg, e);
            return new ResultInfo().error("查询数据失败");
        }
    }

}
