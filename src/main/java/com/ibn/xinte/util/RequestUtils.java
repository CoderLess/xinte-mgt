package com.ibn.xinte.util;

import com.ibn.xinte.constant.TokenConstants;

import javax.servlet.http.HttpServletRequest;

public class RequestUtils {

    /**
     * @description: 解析请求相关数据
     * @author：RenBin
     * @createTime：2021/1/3 10:45
     */
    public static Long getUserId(HttpServletRequest request) {
        String token = request.getHeader(TokenConstants.TOKEN);
        if (null != token) {
            return JWTUtils.parseToken(token);
        }
        return null;
    }
}
