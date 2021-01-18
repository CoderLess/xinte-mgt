package com.ibn.xinte.controller;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageInfo;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.ibn.xinte.common.ResultInfo;
import com.ibn.xinte.domain.PrescriptionBaseDTO;
import com.ibn.xinte.domain.UserBaseDTO;
import com.ibn.xinte.enumeration.UserBaseLevelEnum;
import com.ibn.xinte.enumeration.UserBaseSexEnum;
import com.ibn.xinte.enumeration.YesOrNoEnum;
import com.ibn.xinte.service.PrescriptionBaseService;
import com.ibn.xinte.service.UserBaseService;
import com.ibn.xinte.util.BeanUtils;
import com.ibn.xinte.vo.*;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

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
    @Autowired
    private PrescriptionBaseService prescriptionBaseService;

    @ApiOperation("保存用户基本信息")
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

    @ApiOperation("批量保存用户基本信息")
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

    @ApiOperation("根据id更新用户基本信息")
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

    @ApiOperation("根据id查询用户基本信息")
    @GetMapping("queryById")
    public ResultInfo queryById(Long id) {
        if (null == id) {
            return new ResultInfo().error("参数不能为空");
        }
        UserBaseDTO userBaseDTO = userBaseService.queryById(id);
        return new ResultInfo().success(userBaseDTO);
    }

    @ApiOperation("根据条件查询用户基本信息")
    @GetMapping("queryList")
    public ResultInfo queryList(@ModelAttribute UserBaseVO userBaseVO) {
        if (null == userBaseVO) {
            return new ResultInfo().error("参数不能为空");
        }
        UserBaseDTO userBaseDTO = new UserBaseDTO();
        BeanUtils.copyProperties(userBaseVO, userBaseDTO);
        PageInfo<UserBaseDTO> userBaseDTOPageInfo = userBaseService.queryPageInfo(userBaseDTO, userBaseVO.getPageNum(), userBaseVO.getPageSize());
        if (YesOrNoEnum.YES.getCode().equals(userBaseVO.getQueryStatic()) && !CollectionUtils.isEmpty(userBaseDTOPageInfo.getList())) {
            List<Long> userIdList = userBaseDTOPageInfo.getList().stream().map(curUserBaseDTO -> curUserBaseDTO.getId()).collect(Collectors.toList());
            List<PrescriptionBaseDTO> prescriptionBaseDTOList = prescriptionBaseService.queryStaticByUserId(userIdList);
            if (!CollectionUtils.isEmpty(prescriptionBaseDTOList)) {
                Map<Long, PrescriptionBaseDTO> userIdStaticsMap = Maps.newHashMap();
                for (PrescriptionBaseDTO prescriptionBaseDTO : prescriptionBaseDTOList) {
                    userIdStaticsMap.put(prescriptionBaseDTO.getUserId(), prescriptionBaseDTO);
                }
                for (UserBaseDTO curUserBaseDTO : userBaseDTOPageInfo.getList()) {
                    PrescriptionBaseDTO prescriptionBaseDTO = userIdStaticsMap.get(curUserBaseDTO.getId());
                    curUserBaseDTO.setNumber(0);
                    curUserBaseDTO.setAmount(new BigDecimal(0));
                    if (null != prescriptionBaseDTO) {
                        curUserBaseDTO.setNumber(prescriptionBaseDTO.getNumber());
                        curUserBaseDTO.setAmount(prescriptionBaseDTO.getAmount());
                    }

                }
            }
        }
        return new ResultInfo().success(userBaseDTOPageInfo);
    }

    @ApiOperation("根据手机号模糊查询用户id、用户手机号")
    @GetMapping("queryUserMobile")
    public ResultInfo queryUserMobile(@ModelAttribute UserMobileQueryVO userMobileQueryVO) {
        if (null == userMobileQueryVO) {
            return new ResultInfo().error("参数不能为空");
        }
        if (!StringUtils.hasLength(userMobileQueryVO.getMobileLike())) {
            return new ResultInfo().success(Lists.newArrayList());
        }
        UserBaseDTO userBaseDTO = new UserBaseDTO();
        BeanUtils.copyProperties(userMobileQueryVO, userBaseDTO);
        List<UserBaseDTO> userBaseDTOList = userBaseService.queryList(userBaseDTO, userMobileQueryVO.getPageNum(),
                userMobileQueryVO.getPageSize());
        List<UserMobileVO> userMobileVOList;
        try {
            userMobileVOList = BeanUtils.convertList(userBaseDTOList, UserMobileVO.class);
        } catch (Exception e) {
            String msg = String.format("UserBaseController.queryUserMobile方法list转换失败：%s",
                    JSONObject.toJSONString(userBaseDTOList));
            logger.error(msg, e);
            return new ResultInfo().error("查询用户手机信息异常");
        }
        return new ResultInfo().success(userMobileVOList);
    }

    @ApiOperation("根据用户名模糊查询用户id、用户名信息")
    @GetMapping("queryUserName")
    public ResultInfo queryUserName(@ModelAttribute UserNameQueryVO userNameQueryVO) {
        if (null == userNameQueryVO) {
            return new ResultInfo().error("参数不能为空");
        }
        if (!StringUtils.hasLength(userNameQueryVO.getUsername())) {
            return new ResultInfo().success(Lists.newArrayList());
        }
        UserBaseDTO userBaseDTO = new UserBaseDTO();
        BeanUtils.copyProperties(userNameQueryVO, userBaseDTO);
        List<UserBaseDTO> userBaseDTOList = userBaseService.queryList(userBaseDTO, userNameQueryVO.getPageNum(), userNameQueryVO.getPageSize());
        List<UserNameVO> userNameVOList;
        try {
            userNameVOList = BeanUtils.convertList(userBaseDTOList, UserNameVO.class);
        } catch (Exception e) {
            String msg = String.format("UserBaseController.queryUserName方法list转换失败：%s",
                    JSONObject.toJSONString(userBaseDTOList));
            logger.error(msg, e);
            return new ResultInfo().error("查询用户信息异常");
        }
        return new ResultInfo().success(userNameVOList);
    }

    @ApiOperation("用户性别枚举")
    @GetMapping("sexEnum")
    public ResultInfo sexEnum() {
        return new ResultInfo().success(UserBaseSexEnum.allEnum());
    }

    @ApiOperation("会员级别枚举")
    @GetMapping("levelEnum")
    public ResultInfo levelEnum() {
        return new ResultInfo().success(UserBaseLevelEnum.allEnum());
    }

}
