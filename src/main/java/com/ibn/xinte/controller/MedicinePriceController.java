package com.ibn.xinte.controller;

import com.alibaba.fastjson.JSONObject;
import com.ibn.xinte.common.ResultInfo;
import com.ibn.xinte.domain.MedicinePriceDTO;
import com.ibn.xinte.service.MedicinePriceService;
import com.ibn.xinte.util.BeanUtils;
import com.ibn.xinte.vo.MedicinePriceVO;
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
 * @createTime：2021年1月10日
 */
@RestController
@RequestMapping("medicinePrice")
public class MedicinePriceController {

    private static final Logger logger = LoggerFactory.getLogger(MedicinePriceController.class);

    @Autowired
    private MedicinePriceService medicinePriceService;

    @PostMapping("save")
    public ResultInfo save(@RequestBody MedicinePriceVO medicinePriceVO) {
        if (null == medicinePriceVO) {
            return new ResultInfo().error("参数不能为空");
        }
        MedicinePriceDTO medicinePriceDTO = new MedicinePriceDTO();
        BeanUtils.copyProperties(medicinePriceVO, medicinePriceDTO);
        Long id = medicinePriceService.save(medicinePriceDTO);
        return new ResultInfo().success(id);
    }

    @PostMapping("saveBatch")
    public ResultInfo save(@RequestBody List<MedicinePriceVO> medicinePriceVOList) {
        if (CollectionUtils.isEmpty(medicinePriceVOList)) {
            return new ResultInfo().error("参数不能为空");
        }
        List<MedicinePriceDTO> medicinePriceDTOList = null;
        try {
            medicinePriceDTOList = BeanUtils.convertList(medicinePriceVOList, MedicinePriceDTO.class);
        } catch (Exception e) {
            String msg = String.format("MedicinePriceController.save中list转换失败：%s", JSONObject.toJSONString(medicinePriceDTOList));
            logger.error(msg, e);
        }
        medicinePriceService.saveBatch(medicinePriceDTOList);
        return new ResultInfo().success();
    }

    @PostMapping("updateById")
    public ResultInfo updateById(@RequestBody MedicinePriceVO medicinePriceVO) {
        if (null == medicinePriceVO) {
            return new ResultInfo().error("参数不能为空");
        }
        MedicinePriceDTO medicinePriceDTO = new MedicinePriceDTO();
        BeanUtils.copyProperties(medicinePriceVO, medicinePriceDTO);
        medicinePriceService.updateById(medicinePriceDTO);
        return new ResultInfo().success();
    }

    @PostMapping("deleteById")
    public ResultInfo deleteById(Long id) {
        if (null == id) {
            return new ResultInfo().error("参数不能为空");
        }
        medicinePriceService.deleteById(id);
        return new ResultInfo().success();
    }

    @GetMapping("queryById")
    public ResultInfo queryById(Long id) {
        if (null == id) {
            return new ResultInfo().error("参数不能为空");
        }
        MedicinePriceDTO medicinePriceDTO = medicinePriceService.queryById(id);
        return new ResultInfo().success(medicinePriceDTO);
    }

    @GetMapping("queryList")
    public ResultInfo queryList(@ModelAttribute MedicinePriceVO medicinePriceVO) {
        if (null == medicinePriceVO) {
            return new ResultInfo().error("参数不能为空");
        }
        MedicinePriceDTO medicinePriceDTO = new MedicinePriceDTO();
        BeanUtils.copyProperties(medicinePriceVO, medicinePriceDTO);
        List<MedicinePriceDTO> medicinePriceDTOList = medicinePriceService.queryList(medicinePriceDTO);
        return new ResultInfo().success(medicinePriceDTOList);
    }

}
