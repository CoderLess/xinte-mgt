package com.ibn.xinte.controller;

import com.ibn.xinte.common.ResultInfo;
import com.ibn.xinte.domain.AdminBaseDTO;
import com.ibn.xinte.exception.IbnException;
import com.ibn.xinte.service.AdminBaseService;
import com.ibn.xinte.util.BeanUtils;
import com.ibn.xinte.util.JWTUtils;
import com.ibn.xinte.util.MD5Utils;
import com.ibn.xinte.util.RequestUtils;
import com.ibn.xinte.vo.AdminBaseVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
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
@RequestMapping("adminBase")
@Api("后台管理员相关信息")
public class AdminBaseController {

    private static final Logger logger = LoggerFactory.getLogger(AdminBaseController.class);

    @Autowired
    private AdminBaseService adminBaseService;

    @PostMapping("register")
    public ResultInfo register(@RequestBody AdminBaseVO adminBaseVO) {
        if (null == adminBaseVO) {
            return new ResultInfo().error("参数不能为空");
        }
        if (null == adminBaseVO.getMobile() || null == adminBaseVO.getPassword()) {
            return new ResultInfo().error("手机号或密码不能为空");
        }
        AdminBaseDTO adminBaseDTO = new AdminBaseDTO();
        BeanUtils.copyProperties(adminBaseVO, adminBaseDTO);
        try {
            // 密码进行md5加密
            adminBaseDTO.setPassword(MD5Utils.getMD5Str(adminBaseVO.getPassword()));
        } catch (IbnException e) {
            return new ResultInfo().error(e.getMessage());
        }
        adminBaseDTO.setId(null);
        adminBaseDTO.setCreateTime(System.currentTimeMillis());
        adminBaseDTO.setLastAccess(System.currentTimeMillis());
        Long id = adminBaseService.save(adminBaseDTO);
        return new ResultInfo().success(id);
    }
    @PostMapping("login")
    public ResultInfo login(@RequestBody AdminBaseVO adminBaseVO) {
        if (null == adminBaseVO) {
            return new ResultInfo().error("参数不能为空");
        }
        if (!StringUtils.hasLength(adminBaseVO.getMobile()) || !StringUtils.hasLength(adminBaseVO.getPassword())) {
            return new ResultInfo().error("手机号或密码不能为空");
        }
        AdminBaseDTO adminBaseDTO = new AdminBaseDTO();
        adminBaseDTO.setMobile(adminBaseVO.getMobile());
        try {
            // 密码进行md5加密
            adminBaseDTO.setPassword(MD5Utils.getMD5Str(adminBaseVO.getPassword()));
        } catch (IbnException e) {
            return new ResultInfo().error(e.getMessage());
        }
        // 根据手机号和密码查询
        List<AdminBaseDTO> adminBaseDTOList = adminBaseService.queryList(adminBaseDTO);
        if (CollectionUtils.isEmpty(adminBaseDTOList)) {
            return new ResultInfo().error("手机号或密码错误");
        }
        Long id = adminBaseDTOList.get(0).getId();
        return new ResultInfo().success(JWTUtils.generateToken(id));
    }

    @PostMapping("updateById")
    public ResultInfo updateById(@RequestBody AdminBaseVO adminBaseVO) {
        if (null == adminBaseVO) {
            return new ResultInfo().error("参数不能为空");
        }
        AdminBaseDTO adminBaseDTO = new AdminBaseDTO();
        BeanUtils.copyProperties(adminBaseVO, adminBaseDTO);
        // 密码不为空
        if (StringUtils.hasLength(adminBaseDTO.getPassword())) {
            try {
                // 密码进行md5加密
                adminBaseVO.setPassword(MD5Utils.getMD5Str(adminBaseVO.getPassword()));
            } catch (IbnException e) {
                return new ResultInfo().error(e.getMessage());
            }
        }
        adminBaseService.updateById(adminBaseDTO);
        return new ResultInfo().success();
    }

    @ApiOperation("根据token获取用户id")
    @GetMapping("queryByToken")
    public ResultInfo queryById(HttpServletRequest request) {
        Long userId = RequestUtils.getUserId(request);
        if (null == userId) {
            return new ResultInfo().error("请先登入");
        }
        AdminBaseDTO adminBaseDTO = adminBaseService.queryById(userId);
        return new ResultInfo().success(adminBaseDTO);
    }

    @GetMapping("queryById")
    public ResultInfo queryById(Long id) {
        if (null == id) {
            return new ResultInfo().error("参数不能为空");
        }
        AdminBaseDTO adminBaseDTO = adminBaseService.queryById(id);
        return new ResultInfo().success(adminBaseDTO);
    }

    @GetMapping("queryList")
    public ResultInfo queryList(@ModelAttribute AdminBaseVO adminBaseVO) {
        if (null == adminBaseVO) {
            return new ResultInfo().error("参数不能为空");
        }
        AdminBaseDTO adminBaseDTO = new AdminBaseDTO();
        BeanUtils.copyProperties(adminBaseVO, adminBaseDTO);
        List<AdminBaseDTO> adminBaseDTOList = adminBaseService.queryList(adminBaseDTO, adminBaseVO.getPageNum(), adminBaseVO.getPageSize());
        return new ResultInfo().success(adminBaseDTOList);
    }

}
