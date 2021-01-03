package com.ibn.xinte.controller;

import com.alibaba.fastjson.JSONObject;
import com.ibn.xinte.common.ResultInfo;
import com.ibn.xinte.domain.LoginLogDTO;
import com.ibn.xinte.service.LoginLogService;
import com.ibn.xinte.util.BeanUtils;
import com.ibn.xinte.vo.LoginLogVO;
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
@RequestMapping("loginLog")
public class LoginLogController {

    private static final Logger logger = LoggerFactory.getLogger(LoginLogController.class);

    @Autowired
    private LoginLogService loginLogService;

    @PostMapping("save")
    public ResultInfo save(@RequestBody LoginLogVO loginLogVO) {
        if (null == loginLogVO) {
            return new ResultInfo().error("参数不能为空");
        }
        LoginLogDTO loginLogDTO = new LoginLogDTO();
        BeanUtils.copyProperties(loginLogVO, loginLogDTO);
        Long id = loginLogService.save(loginLogDTO);
        return new ResultInfo().success(id);
    }

    @PostMapping("saveBatch")
    public ResultInfo save(@RequestBody List<LoginLogVO> loginLogVOList) {
        if (CollectionUtils.isEmpty(loginLogVOList)) {
            return new ResultInfo().error("参数不能为空");
        }
        List<LoginLogDTO> loginLogDTOList = null;
        try {
            loginLogDTOList = BeanUtils.convertList(loginLogVOList, LoginLogDTO.class);
        } catch (Exception e) {
            String msg = String.format("LoginLogController.save中list转换失败：%s", JSONObject.toJSONString(loginLogDTOList));
            logger.error(msg, e);
        }
        loginLogService.saveBatch(loginLogDTOList);
        return new ResultInfo().success();
    }

    @PostMapping("updateById")
    public ResultInfo updateById(@RequestBody LoginLogVO loginLogVO) {
        if (null == loginLogVO) {
            return new ResultInfo().error("参数不能为空");
        }
        LoginLogDTO loginLogDTO = new LoginLogDTO();
        BeanUtils.copyProperties(loginLogVO, loginLogDTO);
        loginLogService.updateById(loginLogDTO);
        return new ResultInfo().success();
    }

    @PostMapping("deleteById")
    public ResultInfo deleteById(Long id) {
        if (null == id) {
            return new ResultInfo().error("参数不能为空");
        }
        loginLogService.deleteById(id);
        return new ResultInfo().success();
    }

    @GetMapping("queryById")
    public ResultInfo queryById(Long id) {
        if (null == id) {
            return new ResultInfo().error("参数不能为空");
        }
        LoginLogDTO loginLogDTO = loginLogService.queryById(id);
        return new ResultInfo().success(loginLogDTO);
    }

    @GetMapping("queryList")
    public ResultInfo queryList(@ModelAttribute LoginLogVO loginLogVO) {
        if (null == loginLogVO) {
            return new ResultInfo().error("参数不能为空");
        }
        LoginLogDTO loginLogDTO = new LoginLogDTO();
        BeanUtils.copyProperties(loginLogVO, loginLogDTO);
        List<LoginLogDTO> loginLogDTOList = loginLogService.queryList(loginLogDTO);
        return new ResultInfo().success(loginLogDTOList);
    }

}
