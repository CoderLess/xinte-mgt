package com.ibn.xinte.util;

import com.ibn.xinte.config.security.util.JWTUtils;
import com.ibn.xinte.constant.TokenConstants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class RequestUtils {
    private static final String UNKNOWN = "unknown";
    private static final String LOCAL_HOST = "127.0.0.1";

    private static Logger logger = LoggerFactory.getLogger(RequestUtils.class);
    private RequestUtils(){}

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

    /**
     * @description: 获取ip
     * @author：RenBin
     * @createTime：2021/1/5 20:28
     */
    public static String getIPAddress(HttpServletRequest request) {

        if (request == null) {
            return "";
        }

        String ip = request.getHeader("X-Forwarded-For");

        if (ip == null || ip.length() == 0 || UNKNOWN.equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }

        if (ip == null || ip.length() == 0 || UNKNOWN.equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }

        if (ip == null || ip.length() == 0 || UNKNOWN.equalsIgnoreCase(ip)) {
            ip = request.getHeader("HTTP_CLIENT_IP");
        }

        if (ip == null || ip.length() == 0 || UNKNOWN.equalsIgnoreCase(ip)) {
            ip = request.getHeader("HTTP_X_FORWARDED_FOR");
        }

        if (ip == null || ip.length() == 0 || UNKNOWN.equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
        }

        if (LOCAL_HOST.equals(ip) || "0:0:0:0:0:0:0:1".equals(ip)) {
            try {
                ip = InetAddress.getLocalHost().getHostAddress();
            } catch (UnknownHostException e) {
                logger.error("RequestUtils枚举的getIPAddress方法出现异常", e);

            }
        }
        return ip;
    }
}
