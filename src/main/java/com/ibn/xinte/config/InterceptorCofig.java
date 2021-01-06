package com.ibn.xinte.config;

import com.ibn.xinte.interceptor.UserLoginVerifyInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

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
