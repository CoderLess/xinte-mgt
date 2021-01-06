package com.ibn.xinte.service;

import com.ibn.xinte.domain.AdminBaseDTO;

import java.util.List;

/**
 * @version 1.0
 * @description:
 * @projectName：xinte
 * @see: com.ibn.xinte.service
 * @author： RenBin
 * @createTime：2020年12月28日
 */
public interface AdminBaseService {

    /**
     * @description: 保存管理员信息
     * @author：RenBin
     * @createTime：2020年12月28日
     */
    Long save(AdminBaseDTO adminBaseDTO);

    /**
     * @description: 批量保存管理员信息
     * @author：RenBin
     * @createTime：2020年12月28日
     */
    Long saveBatch(List<AdminBaseDTO> adminBaseDTOList);

    /**
     * @description: 更新管理员信息
     * @author：RenBin
     * @createTime：2020年12月28日
     */
    Integer updateById(AdminBaseDTO adminBaseDTO);

    /**
     * @description: 根据Id删除管理员信息
     * @author：RenBin
     * @createTime：2020年12月28日
     */
    Integer deleteById(Long id);

    /**
     * @description: 通过id查询管理员信息
     * @author：RenBin
     * @createTime：2020年12月28日
     */
    AdminBaseDTO queryById(Long id);

    /**
     * @description: 通过条件查询管理员信息
     * @author：RenBin
     * @createTime：2020年12月28日
     */
    List<AdminBaseDTO> queryList(AdminBaseDTO adminBaseDTO);

    /**
     * @description: 通过条件查询管理员信息
     * @author：RenBin
     * @createTime：2020年12月28日
     */
    List<AdminBaseDTO> queryList(AdminBaseDTO adminBaseDTO, Integer pageNum, Integer pageSize);
}
