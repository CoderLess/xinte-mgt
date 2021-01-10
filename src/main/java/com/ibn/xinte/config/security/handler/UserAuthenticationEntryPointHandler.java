package com.ibn.xinte.config.security.handler;

import com.ibn.xinte.common.ResultInfo;
import com.ibn.xinte.config.security.util.ResultUtils;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @version 1.0
 * @description: 用户未登录处理类
 * @projectName：xinte-mgt
 * @see: com.ibn.xinte.config.security.handler
 * @author： RenBin
 * @createTime：2021/01/08 19:39
 */
@Component
public class UserAuthenticationEntryPointHandler implements AuthenticationEntryPoint {
    /**
     * @description: 用户未登录返回结果
     * @author：RenBin
     * @createTime：2021/1/8 20:40
     */
    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception){
        ResultInfo resultInfo = new ResultInfo();
        resultInfo.setStatus(401);
        resultInfo.setMessage("未登录");
        ResultUtils.responseJson(response, resultInfo);
    }
}