package com.ibn.xinte.service;

import com.ibn.xinte.domain.AdminCommissionDTO;

import java.util.List;

/**
 * @version 1.0
 * @description:
 * @projectName：xinte
 * @see: com.ibn.xinte.service
 * @author： RenBin
 * @createTime：2021年1月10日
 */
public interface AdminCommissionService {

    /**
     * @description: 保存管理员提成信息
     * @author：RenBin
     * @createTime：2021年1月10日
     */
    Long save(AdminCommissionDTO adminCommissionDTO);

    /**
     * @description: 批量保存管理员提成信息
     * @author：RenBin
     * @createTime：2021年1月10日
     */
    Long saveBatch(List<AdminCommissionDTO> adminCommissionDTOList);

    /**
     * @description: 更新管理员提成信息
     * @author：RenBin
     * @createTime：2021年1月10日
     */
    Integer updateById(AdminCommissionDTO adminCommissionDTO);

    /**
     * @description: 根据Id删除管理员提成信息
     * @author：RenBin
     * @createTime：2021年1月10日
     */
    Integer deleteById(Long id);

    /**
     * @description: 通过id查询管理员提成信息
     * @author：RenBin
     * @createTime：2021年1月10日
     */
    AdminCommissionDTO queryById(Long id);

    /**
     * @description: 通过条件查询管理员提成信息
     * @author：RenBin
     * @createTime：2021年1月10日
     */
    List<AdminCommissionDTO> queryList(AdminCommissionDTO adminCommissionDTO);
}
