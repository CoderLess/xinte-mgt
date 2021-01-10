package com.ibn.xinte.service;

import com.github.pagehelper.PageInfo;
import com.ibn.xinte.domain.AuthorityBaseDTO;

import java.util.List;

/**
 * @version 1.0
 * @description:
 * @projectName：xinte
 * @see: com.ibn.xinte.service
 * @author： RenBin
 * @createTime：2020年12月28日
 */
public interface AuthorityBaseService {

    /**
     * @description: 保存权限信息
     * @author：RenBin
     * @createTime：2020年12月28日
     */
    Long save(AuthorityBaseDTO authorityBaseDTO);

    /**
     * @description: 批量保存权限信息
     * @author：RenBin
     * @createTime：2020年12月28日
     */
    Long saveBatch(List<AuthorityBaseDTO> authorityBaseDTOList);

    /**
     * @description: 更新权限信息
     * @author：RenBin
     * @createTime：2020年12月28日
     */
    Integer updateById(AuthorityBaseDTO authorityBaseDTO);

    /**
     * @description: 根据Id删除权限信息
     * @author：RenBin
     * @createTime：2020年12月28日
     */
    Integer deleteById(Long id);

    /**
     * @description: 通过id查询权限信息
     * @author：RenBin
     * @createTime：2020年12月28日
     */
    AuthorityBaseDTO queryById(Long id);

    /**
     * @description: 通过条件查询权限信息
     * @author：RenBin
     * @createTime：2020年12月28日
     */
    List<AuthorityBaseDTO> queryList(AuthorityBaseDTO authorityBaseDTO);
    /**
     * @description: 通过条件分页查询管理员信息
     * @author：RenBin
     * @createTime：2020年12月28日
     */
    PageInfo<AuthorityBaseDTO> queryPageInfo(AuthorityBaseDTO authorityBaseDTO, Integer pageNum, Integer pageSize);
}
