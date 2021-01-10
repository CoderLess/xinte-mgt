package com.ibn.xinte.config.security.handler;

import com.ibn.xinte.common.ResultInfo;
import com.ibn.xinte.config.security.util.JWTUtils;
import com.ibn.xinte.config.security.util.ResultUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @version 1.0
 * @description: 登录成功处理类
 * @projectName：xinte-mgt
 * @see: com.ibn.xinte.config.security.handler
 * @author： RenBin
 * @createTime：2021/01/08 19:39
 */
@Slf4j
@Component
public class UserLoginSuccessHandler implements AuthenticationSuccessHandler {
    /**
     * @description: 登录成功返回结果
     * @author：RenBin
     * @createTime：2021/1/8 20:40
     */
    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication){
//        // 组装JWT
//        SelfUserEntity selfUserEntity =  (SelfUserEntity) authentication.getPrincipal();
//        String token = JWTTokenUtil.createAccessToken(selfUserEntity);
//        token = JWTConfig.tokenPrefix + token;
//        // 封装返回参数
//        Map<String,Object> resultData = new HashMap<>();
//        resultData.put("code","200");
//        resultData.put("msg", "登录成功");
//        resultData.put("token",token);
//        ResultUtil.responseJson(response,resultData);

        ResultInfo resultInfo = new ResultInfo();
        resultInfo.setStatus(200);
        resultInfo.setMessage("登录成功");
        Long adminId = (Long) authentication.getPrincipal();
        String token = JWTUtils.generateToken(adminId);
        resultInfo.setData(token);
        ResultUtils.responseJson(response, resultInfo);
    }
}