package com.ibn.xinte.config.security.handler;

import com.ibn.xinte.common.ResultInfo;
import com.ibn.xinte.config.security.util.ResultUtils;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @version 1.0
 * @description: 未授权
 * @projectName：xinte-mgt
 * @see: com.ibn.xinte.config.security.handler
 * @author： RenBin
 * @createTime：2021/01/08 19:39
 */
@Component
public class UserAuthAccessDeniedHandler implements AccessDeniedHandler {
    /**
     * @description: 暂无权限返回结果
     * @author：RenBin
     * @createTime：2021/1/8 20:40
     */
    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response, AccessDeniedException exception) {
        ResultInfo resultInfo = new ResultInfo();
        resultInfo.setStatus(403);
        resultInfo.setMessage("未授权");
        ResultUtils.responseJson(response, resultInfo);
    }
}
