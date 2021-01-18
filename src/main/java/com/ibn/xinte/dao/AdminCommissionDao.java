package com.ibn.xinte.dao;

import com.github.pagehelper.Page;
import com.ibn.xinte.domain.AdminCommissionDTO;
import com.ibn.xinte.domain.AdminCommissionStaticsDTO;
import com.ibn.xinte.entity.AdminCommissionDO;

/**
 * @version 1.0
 * @description:
 * @projectName：demo
 * @see: com.ibn.demo.dao
 * @author： RenBin
 * @createTime：2021年1月10日
 */
public interface AdminCommissionDao extends BaseDao<AdminCommissionDO> {
    /**
     * @description: 通过条件查询数据
     * @author：RenBin
     * @createTime：2020年12月28日
     * @param adminCommissionDTO
     * @return
     */
    Page<AdminCommissionStaticsDTO> queryPage(AdminCommissionDTO adminCommissionDTO);
}
