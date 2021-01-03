package com.ibn.xinte.config;

import com.ibn.xinte.interceptor.UserLoginVerifyInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.validation.MessageCodesResolver;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.HandlerMethodReturnValueHandler;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.config.annotation.*;

import java.util.List;

/**
 * @version 1.0
 * @description:
 * @projectName：xinte-mgt
 * @see: com.ibn.xinte.config
 * @author： RenBin
 * @createTime：2021/01/03 21:38
 */

//@Configuration
public class InterceptorCofig implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new UserLoginVerifyInterceptor())
                .addPathPatterns("/**")
                .excludePathPatterns("/adminBase/login","/swagger-ui.html*");
    }
}
