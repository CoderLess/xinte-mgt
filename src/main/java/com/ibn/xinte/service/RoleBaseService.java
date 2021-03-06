package com.ibn.xinte.service;

import com.github.pagehelper.PageInfo;
import com.ibn.xinte.domain.RoleBaseDTO;

import java.util.List;

/**
 * @version 1.0
 * @description:
 * @projectName：xinte
 * @see: com.ibn.xinte.service
 * @author： RenBin
 * @createTime：2020年12月28日
 */
public interface RoleBaseService {

    /**
     * @description: 保存角色信息
     * @author：RenBin
     * @createTime：2020年12月28日
     */
    Long save(RoleBaseDTO roleBaseDTO);

    /**
     * @description: 批量保存角色信息
     * @author：RenBin
     * @createTime：2020年12月28日
     */
    Long saveBatch(List<RoleBaseDTO> roleBaseDTOList);

    /**
     * @description: 更新角色信息
     * @author：RenBin
     * @createTime：2020年12月28日
     */
    Integer updateById(RoleBaseDTO roleBaseDTO);

    /**
     * @description: 根据Id删除角色信息
     * @author：RenBin
     * @createTime：2020年12月28日
     */
    Integer deleteById(Long id);

    /**
     * @description: 通过id查询角色信息
     * @author：RenBin
     * @createTime：2020年12月28日
     */
    RoleBaseDTO queryById(Long id);

    /**
     * @description: 通过条件查询角色信息
     * @author：RenBin
     * @createTime：2020年12月28日
     */
    List<RoleBaseDTO> queryList(RoleBaseDTO roleBaseDTO);
    /**
     * @description: 通过条件查询管理员信息
     * @author：RenBin
     * @createTime：2020年12月28日
     */
    PageInfo<RoleBaseDTO> queryPageInfo(RoleBaseDTO roleBaseDTO, Integer pageNum, Integer pageSize);
}
