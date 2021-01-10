package com.ibn.xinte.config.security.provider;

import com.ibn.xinte.domain.AdminBaseDTO;
import com.ibn.xinte.domain.LoginLogDTO;
import com.ibn.xinte.service.AdminBaseService;
import com.ibn.xinte.service.LoginLogService;
import com.ibn.xinte.util.MD5Utils;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.util.List;

/**
 * @version 1.0
 * @description:
 * @projectName：xinte-mgt
 * @see: com.ibn.xinte.config.security.provider
 * @author： RenBin
 * @createTime：2021/01/08 20:46
 */
@Component
public class UserAuthenticationProvider implements AuthenticationProvider {
    @Autowired
    private AdminBaseService adminBaseService;
    @Autowired
    private LoginLogService loginLogService;

    @SneakyThrows
    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        // 获取表单输入中返回的用户名
        String userName = (String) authentication.getPrincipal();
        // 获取表单中输入的密码
        String password = (String) authentication.getCredentials();
        // 查询用户是否存在
        AdminBaseDTO adminBaseDTO = new AdminBaseDTO();
        adminBaseDTO.setMobile(userName);
        adminBaseDTO.setPassword(MD5Utils.getMD5Str(password));
        List<AdminBaseDTO> adminBaseDTOList = adminBaseService.queryList(adminBaseDTO);
        if (CollectionUtils.isEmpty(adminBaseDTOList)) {
            throw new BadCredentialsException("密码不正确");
        }
        // 获取用户id
        Long adminId = adminBaseDTOList.get(0).getId();
        // 记录登录日志
        LoginLogDTO loginLogDTO = new LoginLogDTO();
        loginLogDTO.setAdminId(adminId);
        loginLogDTO.setLoginTime(System.currentTimeMillis());
        loginLogService.save(loginLogDTO);
        // 进行登录
        return new UsernamePasswordAuthenticationToken(adminId, password, null);
    }
    @Override
    public boolean supports(Class<?> authentication) {
        return true;
    }
}
