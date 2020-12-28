package com.ibn.xinte.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;
/**
 * @version 1.0
 * @description:
 * @projectName：xinte-mgt
 * @see: com.ibn.xinte.config
 * @author： RenBin
 * @createTime：2020/12/28 23:30
 */
@Configuration
public class CorsConfig {
    @Bean
    public CorsFilter corsFilter() {
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        CorsConfiguration corsConfiguration = new CorsConfiguration();
        //允许任何域名
        corsConfiguration.addAllowedOrigin("*");
        //允许任何头
        corsConfiguration.addAllowedHeader("*");
        //允许任何方法
        corsConfiguration.addAllowedMethod("*");
        //注册
        source.registerCorsConfiguration("/**", corsConfiguration);
        return new CorsFilter(source);
    }
}
