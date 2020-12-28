package com.ibn.xinte.controller;

import com.alibaba.fastjson.JSONObject;
import com.ibn.xinte.common.ResultInfo;
import com.ibn.xinte.domain.UserBaseDTO;
import com.ibn.xinte.service.UserBaseService;
import com.ibn.xinte.util.BeanUtils;
import com.ibn.xinte.vo.UserBaseVO;
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
@RequestMapping("userBase")
public class UserBaseController {

    private static final Logger logger = LoggerFactory.getLogger(UserBaseController.class);

    @Autowired
    private UserBaseService userBaseService;

    @PostMapping("save")
    public ResultInfo save(@RequestBody UserBaseVO userBaseVO) {
        if (null == userBaseVO) {
            return new ResultInfo().error("参数不能为空");
        }
        UserBaseDTO userBaseDTO = new UserBaseDTO();
        BeanUtils.copyProperties(userBaseVO, userBaseDTO);
        Long id = userBaseService.save(userBaseDTO);
        return new ResultInfo().success(id);
    }

    @PostMapping("saveBatch")
    public ResultInfo save(@RequestBody List<UserBaseVO> userBaseVOList) {
        if (CollectionUtils.isEmpty(userBaseVOList)) {
            return new ResultInfo().error("参数不能为空");
        }
        List<UserBaseDTO> userBaseDTOList = null;
        try {
            userBaseDTOList = BeanUtils.convertList(userBaseVOList, UserBaseDTO.class);
        } catch (Exception e) {
            String msg = String.format("UserBaseController.save中list转换失败：%s", JSONObject.toJSONString(userBaseDTOList));
            logger.error(msg, e);
        }
        userBaseService.saveBatch(userBaseDTOList);
        return new ResultInfo().success();
    }

    @PostMapping("updateById")
    public ResultInfo updateById(@RequestBody UserBaseVO userBaseVO) {
        if (null == userBaseVO) {
            return new ResultInfo().error("参数不能为空");
        }
        UserBaseDTO userBaseDTO = new UserBaseDTO();
        BeanUtils.copyProperties(userBaseVO, userBaseDTO);
        userBaseService.updateById(userBaseDTO);
        return new ResultInfo().success();
    }

    @PostMapping("deleteById")
    public ResultInfo deleteById(Long id) {
        if (null == id) {
            return new ResultInfo().error("参数不能为空");
        }
        userBaseService.deleteById(id);
        return new ResultInfo().success();
    }

    @GetMapping("queryById")
    public ResultInfo queryById(Long id) {
        if (null == id) {
            return new ResultInfo().error("参数不能为空");
        }
        UserBaseDTO userBaseDTO = userBaseService.queryById(id);
        return new ResultInfo().success(userBaseDTO);
    }

    @GetMapping("queryList")
    public ResultInfo queryList(@RequestBody UserBaseVO userBaseVO) {
        if (null == userBaseVO) {
            return new ResultInfo().error("参数不能为空");
        }
        UserBaseDTO userBaseDTO = new UserBaseDTO();
        BeanUtils.copyProperties(userBaseVO, userBaseDTO);
        List<UserBaseDTO> userBaseDTOList = userBaseService.queryList(userBaseDTO);
        return new ResultInfo().success(userBaseDTOList);
    }

}
