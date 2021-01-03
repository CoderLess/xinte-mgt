package com.ibn.xinte.interceptor;

import com.ibn.xinte.constant.TokenConstants;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;

/**
 * @version 1.0
 * @description: 用户登录拦截器
 * @projectName：xinte-mgt
 * @see: com.ibn.xinte.interceptor
 * @author： RenBin
 * @createTime：2021/01/03 21:33
 */
public class UserLoginVerifyInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String token = request.getHeader(TokenConstants.TOKEN);
        if (!StringUtils.hasLength(token)) {
            return false;
        }
        Claims claims =
                Jwts.parser().setSigningKey(TokenConstants.KEY).parseClaimsJws(token).getBody();
        Date issuedAt = claims.getIssuedAt();
        if (null == issuedAt) {
            return false;
        }

        if (issuedAt.getTime()+(1000*60*60*24)- System.currentTimeMillis()>0) {
            return true;
        }
        return false;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
