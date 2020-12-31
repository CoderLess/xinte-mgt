package com.ibn.xinte.controller;

import com.ibn.xinte.common.ResultInfo;
import com.ibn.xinte.domain.LoginLogDTO;
import com.ibn.xinte.enumeration.YesOrNoEnum;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @version 1.0
 * @description: 公共服务接口
 * @projectName：xinte-mgt
 * @see: com.ibn.xinte.controller
 * @author： RenBin
 * @createTime：2021/01/01 01:12
 */
@RestController
@RequestMapping("authorityBase")
public class CommonController {

    @GetMapping("yesOrNoEnum")
    public ResultInfo yesOrNoEnum() {
        return new ResultInfo().success(YesOrNoEnum.allEnum());
    }
}
