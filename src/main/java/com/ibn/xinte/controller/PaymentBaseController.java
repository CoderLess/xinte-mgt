package com.ibn.xinte.controller;

import com.ibn.xinte.common.ResultInfo;
import com.ibn.xinte.domain.PaymentBaseDTO;
import com.ibn.xinte.enumeration.PrescriptionBaseTypeEnum;
import com.ibn.xinte.enumeration.UserBaseSexEnum;
import com.ibn.xinte.service.PaymentBaseService;
import com.ibn.xinte.util.BeanUtils;
import com.ibn.xinte.util.RequestUtils;
import com.ibn.xinte.vo.PaymentBaseVO;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
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
@RequestMapping("paymentBase")
public class PaymentBaseController {

    private static final Logger logger = LoggerFactory.getLogger(PaymentBaseController.class);

    @Autowired
    private PaymentBaseService paymentBaseService;

    @ApiOperation("保存用户支付信息")
    @PostMapping("save")
    public ResultInfo save(@RequestBody PaymentBaseVO paymentBaseVO, HttpServletRequest request) {
        if (null == paymentBaseVO) {
            return new ResultInfo().error("参数不能为空");
        }
        if (null == paymentBaseVO.getPrescriptionId()) {
            return new ResultInfo().error("获取药单信息失败");
        }
        Long adminId = RequestUtils.getUserId(request);
        PaymentBaseDTO paymentBaseDTO = new PaymentBaseDTO();
        BeanUtils.copyProperties(paymentBaseVO, paymentBaseDTO);
        paymentBaseDTO.setCreator(adminId);
        paymentBaseDTO.setCreateTime(System.currentTimeMillis());
        Long id = paymentBaseService.save(paymentBaseDTO);
        return new ResultInfo().success(id);
    }

    @ApiOperation("根据id更新支付信息")
    @PostMapping("updateById")
    public ResultInfo updateById(@RequestBody PaymentBaseVO paymentBaseVO) {
        if (null == paymentBaseVO) {
            return new ResultInfo().error("参数不能为空");
        }
        PaymentBaseDTO paymentBaseDTO = new PaymentBaseDTO();
        BeanUtils.copyProperties(paymentBaseVO, paymentBaseDTO);
        paymentBaseService.updateById(paymentBaseDTO);
        return new ResultInfo().success();
    }

    @ApiOperation("根据id删除支付信息")
    @PostMapping("deleteById")
    public ResultInfo deleteById(Long id) {
        if (null == id) {
            return new ResultInfo().error("参数不能为空");
        }
        paymentBaseService.deleteById(id);
        return new ResultInfo().success();
    }

    @ApiOperation("根据id查询支付信息")
    @GetMapping("queryById")
    public ResultInfo queryById(Long id) {
        if (null == id) {
            return new ResultInfo().error("参数不能为空");
        }
        PaymentBaseDTO paymentBaseDTO = paymentBaseService.queryById(id);
        return new ResultInfo().success(paymentBaseDTO);
    }

    @ApiOperation("根据条件查询支付信息")
    @GetMapping("queryList")
    public ResultInfo queryList(@ModelAttribute PaymentBaseVO paymentBaseVO) {
        if (null == paymentBaseVO) {
            return new ResultInfo().error("参数不能为空");
        }
        PaymentBaseDTO paymentBaseDTO = new PaymentBaseDTO();
        BeanUtils.copyProperties(paymentBaseVO, paymentBaseDTO);
        List<PaymentBaseDTO> paymentBaseDTOList = paymentBaseService.queryList(paymentBaseDTO);
        return new ResultInfo().success(paymentBaseDTOList);
    }

    @ApiOperation("药方类型枚举")
    @GetMapping("paymentBaseTypeEnum")
    public ResultInfo paymentBaseTypeEnum() {
        return new ResultInfo().success(PrescriptionBaseTypeEnum.allEnum());
    }
}
