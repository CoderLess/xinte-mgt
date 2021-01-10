package com.ibn.xinte.config.security.handler;

import com.ibn.xinte.common.ResultInfo;
import com.ibn.xinte.config.security.util.ResultUtils;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @version 1.0
 * @description: 登出成功处理类
 * @projectName：xinte-mgt
 * @see: com.ibn.xinte.config.security.handler
 * @author： RenBin
 * @createTime：2021/01/08 19:39
 */
@Component
public class UserLogoutSuccessHandler implements LogoutSuccessHandler {
    /**
     * @description: 用户登出返回结果、这里应该让前端清除掉Token
     * @author：RenBin
     * @createTime：2021/1/8 20:39
     */
    @Override
    public void onLogoutSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) {
        ResultInfo resultInfo = new ResultInfo();
        resultInfo.setStatus(200);
        resultInfo.setMessage("登录成功");
        ResultUtils.responseJson(response, resultInfo);
    }
}