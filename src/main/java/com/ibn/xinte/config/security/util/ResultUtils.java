package com.ibn.xinte.config.security.util;

import com.alibaba.fastjson.JSON;
import com.ibn.xinte.common.ResultInfo;
import lombok.extern.slf4j.Slf4j;

import javax.servlet.ServletResponse;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

/**
 * @description: 返回结果工具类
 * @author：RenBin
 * @createTime：2021/1/8 19:41
 */
@Slf4j
public class ResultUtils {

    /**
     * 私有化构造器
     */
    private ResultUtils() {
    }

    /**
     * @description: 使用response输出JSON
     * @author：RenBin
     * @createTime：2021/1/8 19:43
     */
    public static void responseJson(ServletResponse response, ResultInfo resultInfo) {
        try (PrintWriter out = response.getWriter()) {
            response.setCharacterEncoding("UTF-8");
            response.setContentType("application/json");

            out.println(JSON.toJSONString(resultInfo));
        } catch (Exception e) {
            log.error("【JSON输出异常】", e);
        }
    }

}