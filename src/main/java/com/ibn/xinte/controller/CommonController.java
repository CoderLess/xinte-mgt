package com.ibn.xinte.controller;

import com.ibn.xinte.common.ResultInfo;
import com.ibn.xinte.domain.PayStatisticDTO;
import com.ibn.xinte.domain.PaymentBaseDTO;
import com.ibn.xinte.domain.UserBaseDTO;
import com.ibn.xinte.enumeration.YesOrNoEnum;
import com.ibn.xinte.service.PaymentBaseService;
import com.ibn.xinte.service.UserBaseService;
import com.ibn.xinte.vo.StatisticsVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.TimeZone;

/**
 * @version 1.0
 * @description: 公共服务接口
 * @projectName：xinte-mgt
 * @see: com.ibn.xinte.controller
 * @author： RenBin
 * @createTime：2021/01/01 01:12
 */
@RestController
@RequestMapping("common")
@Api("公共接口")
public class CommonController {

    @Autowired
    private UserBaseService userBaseService;
    @Autowired
    private PaymentBaseService paymentBaseService;

    @ApiOperation("是否的枚举")
    @GetMapping("yesOrNoEnum")
    public ResultInfo yesOrNoEnum() {
        return new ResultInfo().success(YesOrNoEnum.allEnum());
    }

    @ApiOperation("获取总用户人数、当天注册人数、交易金额、交易单数")
    @GetMapping("statistics")
    public ResultInfo statistics() {
        UserBaseDTO userBaseDTO = new UserBaseDTO();
        // 查询总人数
        Integer total = userBaseService.total(userBaseDTO);
        //当前时间毫秒数
        long current=System.currentTimeMillis();
        //今天零点零分零秒的毫秒数
        long zero=current/(1000*3600*24)*(1000*3600*24)- TimeZone.getDefault().getRawOffset();
        //今天23点59分59秒的毫秒数
        long twelve=zero+24*60*60*1000-1;
        userBaseDTO.setCreateTimeStart(zero);
        userBaseDTO.setCreateTimeEnd(twelve);
        // 查询当日注册人数
        Integer todayTotal = userBaseService.total(userBaseDTO);
        PaymentBaseDTO paymentBaseDTO = new PaymentBaseDTO();
        paymentBaseDTO.setCreateTimeStart(zero);
        paymentBaseDTO.setCreateTimeEnd(twelve);
        // 查询交易单数和交易金额
        PayStatisticDTO payStatisticDTO = paymentBaseService.queryPayStatistic(paymentBaseDTO);
        StatisticsVO statisticsVO = new StatisticsVO();
        statisticsVO.setUserCount(total);
        statisticsVO.setUserCountTody(todayTotal);
        if (null == payStatisticDTO) {
            statisticsVO.setTotalNumber(0);
            statisticsVO.setTotalAmount(new BigDecimal("0.00"));
        } else {
            statisticsVO.setTotalNumber(payStatisticDTO.getTotalNumber());
            statisticsVO.setTotalAmount(payStatisticDTO.getTotalAmount());
        }
        return new ResultInfo().success(statisticsVO);
    }
}
