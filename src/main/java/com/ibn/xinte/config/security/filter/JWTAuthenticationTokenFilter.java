package com.ibn.xinte.config.security.filter;

import com.ibn.xinte.constant.TokenConstants;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
import org.springframework.util.StringUtils;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

/**
 * @version 1.0
 * @description: JWT接口请求校验拦截器, 请求接口时会进入这里验证Token是否合法和过期
 * @projectName：xinte-mgt
 * @see: com.ibn.xinte.config.security.filter
 * @author： RenBin
 * @createTime：2021/01/08 21:12
 */
@Slf4j
public class JWTAuthenticationTokenFilter extends BasicAuthenticationFilter {

    public JWTAuthenticationTokenFilter(AuthenticationManager authenticationManager) {
        super(authenticationManager);
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

        String token = request.getHeader(TokenConstants.TOKEN);
        if (StringUtils.hasLength(token)) {
            Claims claims = Jwts.parser().setSigningKey(TokenConstants.KEY).parseClaimsJws(token).getBody();
            String adminId = claims.getId();
            Date issuedAt = claims.getIssuedAt();
//            if (null != issuedAt && issuedAt.getTime() + (1000 * 60 * 60 * 24) - System.currentTimeMillis() > 0) {
            if (null != issuedAt) {
                UsernamePasswordAuthenticationToken authentication =
                        new UsernamePasswordAuthenticationToken(adminId, adminId, null);
                // 告诉一下过滤器已经ok了
                SecurityContextHolder.getContext().setAuthentication(authentication);
            }

        }
        filterChain.doFilter(request, response);
        return;
    }
}
