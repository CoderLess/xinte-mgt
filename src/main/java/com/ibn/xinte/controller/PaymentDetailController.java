package com.ibn.xinte.controller;

import com.alibaba.fastjson.JSONObject;
import com.ibn.xinte.common.ResultInfo;
import com.ibn.xinte.domain.PaymentDetailDTO;
import com.ibn.xinte.service.PaymentDetailService;
import com.ibn.xinte.util.BeanUtils;
import com.ibn.xinte.vo.PaymentDetailVO;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @version 1.0
 * @description:
 * @projectName：demo
 * @see: com.ibn.demo.controller
 * @author： RenBin
 * @createTime：2021年1月5日
 */
@RestController
@RequestMapping("paymentDetail")
public class PaymentDetailController {

    private static final Logger logger = LoggerFactory.getLogger(PaymentDetailController.class);

    @Autowired
    private PaymentDetailService paymentDetailService;

    @ApiOperation("根据id更新支付详情信息")
    @PostMapping("updateById")
    public ResultInfo updateById(@RequestBody PaymentDetailVO paymentDetailVO) {
        if (null == paymentDetailVO) {
            return new ResultInfo().error("参数不能为空");
        }
        PaymentDetailDTO paymentDetailDTO = new PaymentDetailDTO();
        BeanUtils.copyProperties(paymentDetailVO, paymentDetailDTO);
        paymentDetailService.updateById(paymentDetailDTO);
        return new ResultInfo().success();
    }

    @ApiOperation("根据id删除支付详情信息")
    @PostMapping("deleteById")
    public ResultInfo deleteById(Long id) {
        if (null == id) {
            return new ResultInfo().error("参数不能为空");
        }
        paymentDetailService.deleteById(id);
        return new ResultInfo().success();
    }

    @ApiOperation("根据id查询支付详情信息")
    @GetMapping("queryById")
    public ResultInfo queryById(Long id) {
        if (null == id) {
            return new ResultInfo().error("参数不能为空");
        }
        PaymentDetailDTO paymentDetailDTO = paymentDetailService.queryById(id);
        return new ResultInfo().success(paymentDetailDTO);
    }

    @ApiOperation("根据条件查询支付详情信息")
    @GetMapping("queryList")
    public ResultInfo queryList(@ModelAttribute PaymentDetailVO paymentDetailVO) {
        if (null == paymentDetailVO) {
            return new ResultInfo().error("参数不能为空");
        }
        PaymentDetailDTO paymentDetailDTO = new PaymentDetailDTO();
        BeanUtils.copyProperties(paymentDetailVO, paymentDetailDTO);
        List<PaymentDetailDTO> paymentDetailDTOList = paymentDetailService.queryList(paymentDetailDTO);
        return new ResultInfo().success(paymentDetailDTOList);
    }

}
