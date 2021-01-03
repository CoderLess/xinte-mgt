package com.ibn.xinte.controller;

import com.alibaba.fastjson.JSONObject;
import com.ibn.xinte.common.ResultInfo;
import com.ibn.xinte.domain.AuthorityBaseDTO;
import com.ibn.xinte.service.AuthorityBaseService;
import com.ibn.xinte.util.BeanUtils;
import com.ibn.xinte.vo.AuthorityBaseVO;
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
@RequestMapping("authorityBase")
public class AuthorityBaseController {

    private static final Logger logger = LoggerFactory.getLogger(AuthorityBaseController.class);

    @Autowired
    private AuthorityBaseService authorityBaseService;

    @PostMapping("save")
    public ResultInfo save(@RequestBody AuthorityBaseVO authorityBaseVO) {
        if (null == authorityBaseVO) {
            return new ResultInfo().error("参数不能为空");
        }
        AuthorityBaseDTO authorityBaseDTO = new AuthorityBaseDTO();
        BeanUtils.copyProperties(authorityBaseVO, authorityBaseDTO);
        Long id = authorityBaseService.save(authorityBaseDTO);
        return new ResultInfo().success(id);
    }

    @PostMapping("saveBatch")
    public ResultInfo save(@RequestBody List<AuthorityBaseVO> authorityBaseVOList) {
        if (CollectionUtils.isEmpty(authorityBaseVOList)) {
            return new ResultInfo().error("参数不能为空");
        }
        List<AuthorityBaseDTO> authorityBaseDTOList = null;
        try {
            authorityBaseDTOList = BeanUtils.convertList(authorityBaseVOList, AuthorityBaseDTO.class);
        } catch (Exception e) {
            String msg = String.format("AuthorityBaseController.save中list转换失败：%s", JSONObject.toJSONString(authorityBaseDTOList));
            logger.error(msg, e);
        }
        authorityBaseService.saveBatch(authorityBaseDTOList);
        return new ResultInfo().success();
    }

    @PostMapping("updateById")
    public ResultInfo updateById(@RequestBody AuthorityBaseVO authorityBaseVO) {
        if (null == authorityBaseVO) {
            return new ResultInfo().error("参数不能为空");
        }
        AuthorityBaseDTO authorityBaseDTO = new AuthorityBaseDTO();
        BeanUtils.copyProperties(authorityBaseVO, authorityBaseDTO);
        authorityBaseService.updateById(authorityBaseDTO);
        return new ResultInfo().success();
    }

    @PostMapping("deleteById")
    public ResultInfo deleteById(Long id) {
        if (null == id) {
            return new ResultInfo().error("参数不能为空");
        }
        authorityBaseService.deleteById(id);
        return new ResultInfo().success();
    }

    @GetMapping("queryById")
    public ResultInfo queryById(Long id) {
        if (null == id) {
            return new ResultInfo().error("参数不能为空");
        }
        AuthorityBaseDTO authorityBaseDTO = authorityBaseService.queryById(id);
        return new ResultInfo().success(authorityBaseDTO);
    }

    @GetMapping("queryList")
    public ResultInfo queryList(@ModelAttribute AuthorityBaseVO authorityBaseVO) {
        if (null == authorityBaseVO) {
            return new ResultInfo().error("参数不能为空");
        }
        AuthorityBaseDTO authorityBaseDTO = new AuthorityBaseDTO();
        BeanUtils.copyProperties(authorityBaseVO, authorityBaseDTO);
        List<AuthorityBaseDTO> authorityBaseDTOList = authorityBaseService.queryList(authorityBaseDTO);
        return new ResultInfo().success(authorityBaseDTOList);
    }

}
