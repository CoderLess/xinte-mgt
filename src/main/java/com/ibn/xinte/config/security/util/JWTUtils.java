package com.ibn.xinte.config.security.util;

import com.ibn.xinte.constant.TokenConstants;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.util.StringUtils;

import java.util.Date;

/**
 * @version 1.0
 * @description:
 * @projectName：xinte-mgt
 * @see: com.ibn.xinte.util
 * @author： RenBin
 * @createTime：2021/01/01 01:47
 */
public class JWTUtils {
    /**
     * @description: 生成key
     * @author：RenBin
     * @createTime：2021/1/1 1:47
     */
    public static String generateToken(Long userId) {
        JwtBuilder builder = Jwts.builder().setId(String.valueOf(userId))
                //用于设置签发时间
                .setIssuedAt(new Date())
                //用于设置签名秘钥
                .signWith(SignatureAlgorithm.HS256, TokenConstants.KEY);
        return builder.compact();
    }
    /**
     * @description: 解析key
     * @author：RenBin
     * @createTime：2021/1/1 1:47
     */
    public static Long parseToken(String token) {
        Claims claims =
                Jwts.parser().setSigningKey(TokenConstants.KEY).parseClaimsJws(token).getBody();
        String id = claims.getId();
        if (StringUtils.hasLength(id)) {
           return Long.valueOf(id);
        }
        return null;
    }
}
