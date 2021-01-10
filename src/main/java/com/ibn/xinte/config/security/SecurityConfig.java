package com.ibn.xinte.config.security;

import com.ibn.xinte.config.security.filter.JWTAuthenticationTokenFilter;
import com.ibn.xinte.config.security.handler.*;
import com.ibn.xinte.config.security.provider.UserAuthenticationProvider;
import com.ibn.xinte.config.security.provider.UserPermissionEvaluator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.access.expression.DefaultWebSecurityExpressionHandler;

/**
 * @version 1.0
 * @description: spring security配置
 * @projectName：xinte-mgt
 * @see: com.ibn.xinte.config.security
 * @author： RenBin
 * @createTime：2021/01/08 19:34
 */
@Configuration
@EnableWebSecurity
//开启权限注解,默认是关闭的
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    /**
     * @description: 自定义登录成功处理器
     * @author：RenBin
     * @createTime：2021/1/8 21:06
     */
    @Autowired
    private UserLoginSuccessHandler userLoginSuccessHandler;
    /**
     * @description: 自定义登录失败处理器
     * @author：RenBin
     * @createTime：2021/1/8 21:06
     */
    @Autowired
    private UserLoginFailureHandler userLoginFailureHandler;
    /**
     * @description: 自定义注销成功处理器
     * @author：RenBin
     * @createTime：2021/1/8 21:06
     */
    @Autowired
    private UserLogoutSuccessHandler userLogoutSuccessHandler;
    /**
     * @description: 自定义暂无权限处理器
     * @author：RenBin
     * @createTime：2021/1/8 21:06
     */
    @Autowired
    private UserAuthAccessDeniedHandler userAuthAccessDeniedHandler;
    /**
     * @description: 自定义未登录的处理器
     * @author：RenBin
     * @createTime：2021/1/8 21:06
     */
    @Autowired
    private UserAuthenticationEntryPointHandler userAuthenticationEntryPointHandler;
    /**
     * @description: 自定义登录逻辑验证器
     * @author：RenBin
     * @createTime：2021/1/8 21:06
     */
    @Autowired
    private UserAuthenticationProvider userAuthenticationProvider;

    /**
     * @description: 注入自定义PermissionEvaluator
     * @author：RenBin
     * @createTime：2021/1/8 21:07
     */
    @Bean
    public DefaultWebSecurityExpressionHandler userSecurityExpressionHandler() {
        DefaultWebSecurityExpressionHandler handler = new DefaultWebSecurityExpressionHandler();
        handler.setPermissionEvaluator(new UserPermissionEvaluator());
        return handler;
    }

    /**
     * @description: 配置登录验证逻辑
     * @author：RenBin
     * @createTime：2021/1/8 21:08
     */
    @Override
    protected void configure(AuthenticationManagerBuilder auth) {
        //这里可启用我们自己的登陆验证逻辑
        auth.authenticationProvider(userAuthenticationProvider);
    }

    /**
     * @description: 配置security的控制逻辑
     * @author：RenBin
     * @createTime：2021/1/8 21:08
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                // 不进行权限验证的请求或资源(从配置文件中读取)
//                .antMatchers(new String[]{"/doc.html","/webjars/**"}).permitAll()
                .antMatchers(new String[]{"/**"}).permitAll()
//                .antMatchers(new String[]{"/index.html"}).permitAll()
                // 其他的需要登陆后才能访问
                .anyRequest().authenticated()
                .and()
                // 配置未登录自定义处理类
                .httpBasic().authenticationEntryPoint(userAuthenticationEntryPointHandler)
                .and()
                // 配置登录地址
                .formLogin()
                .usernameParameter("mobile")
                .passwordParameter("password")
                // 设置登录页面
                .loginPage("/index.html")
                // 设置登录的接口
                .loginProcessingUrl("/adminBase/login")
                // 配置登录成功自定义处理类
                .successHandler(userLoginSuccessHandler)
                // 配置登录失败自定义处理类
                .failureHandler(userLoginFailureHandler)
                .and()
                // 配置登出地址
                .logout()
//                .logoutUrl("/login/userLogout")
                // 配置用户登出自定义处理类
                .logoutSuccessHandler(userLogoutSuccessHandler)
                .and()
                // 配置没有权限自定义处理类
                .exceptionHandling().accessDeniedHandler(userAuthAccessDeniedHandler)
                .and()
                // 开启跨域
                .cors()
                .and()
                // 取消跨站请求伪造防护
                .csrf().disable();

        // 基于Token不需要session
        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
        // 禁用缓存
        http.headers().cacheControl();
        // 添加JWT过滤器
        http.addFilter(new JWTAuthenticationTokenFilter(authenticationManager()));
    }
}
