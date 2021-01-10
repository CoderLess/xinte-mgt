package com.ibn.xinte.config.security.handler;

import com.ibn.xinte.common.ResultInfo;
import com.ibn.xinte.config.security.util.ResultUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @version 1.0
 * @description: 登录失败处理类
 * @projectName：xinte-mgt
 * @see: com.ibn.xinte.config.security.handler
 * @author： RenBin
 * @createTime：2021/01/08 19:39
 */
@Slf4j
@Component
public class UserLoginFailureHandler implements AuthenticationFailureHandler {
    /**
     * @description: 登录失败返回结果
     * @author：RenBin
     * @createTime：2021/1/8 20:40
     */
    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) {
        log.info("【登录失败】:{}", exception.getMessage());
        // 这些对于操作的处理类可以根据不同异常进行不同处理
        ResultInfo resultInfo = new ResultInfo();
        resultInfo.setStatus(500);
        if (exception instanceof BadCredentialsException) {
            resultInfo.setMessage("用户名密码不正确");
        } else {
            resultInfo.setMessage("登录失败");
        }
        ResultUtils.responseJson(response, resultInfo);
    }
}