package com.ibn.xinte.service;

import com.ibn.xinte.domain.LoginLogDTO;

import java.util.List;

/**
 * @version 1.0
 * @description:
 * @projectName：xinte
 * @see: com.ibn.xinte.service
 * @author： RenBin
 * @createTime：2020年12月28日
 */
public interface LoginLogService {

    /**
     * @description: 保存用户登录记录信息
     * @author：RenBin
     * @createTime：2020年12月28日
     */
    Long save(LoginLogDTO loginLogDTO);

    /**
     * @description: 批量保存用户登录记录信息
     * @author：RenBin
     * @createTime：2020年12月28日
     */
    Long saveBatch(List<LoginLogDTO> loginLogDTOList);

    /**
     * @description: 更新用户登录记录信息
     * @author：RenBin
     * @createTime：2020年12月28日
     */
    Integer updateById(LoginLogDTO loginLogDTO);

    /**
     * @description: 根据Id删除用户登录记录信息
     * @author：RenBin
     * @createTime：2020年12月28日
     */
    Integer deleteById(Long id);

    /**
     * @description: 通过id查询用户登录记录信息
     * @author：RenBin
     * @createTime：2020年12月28日
     */
    LoginLogDTO queryById(Long id);

    /**
     * @description: 通过条件查询用户登录记录信息
     * @author：RenBin
     * @createTime：2020年12月28日
     */
    List<LoginLogDTO> queryList(LoginLogDTO loginLogDTO);
}
