package com.ibn.xinte.dao;

import com.ibn.xinte.domain.UserBaseDTO;
import com.ibn.xinte.entity.UserBaseDO;

import java.util.List;

/**
 * @version 1.0
 * @description:
 * @projectName：xinte
 * @see: com.ibn.xinte.dao
 * @author： RenBin
 * @createTime：2020年12月28日
 */
public interface UserBaseDao extends BaseDao<UserBaseDO> {
    /**
     * @description: 根据条件查询
     * @author：RenBin
     * @createTime：2021/1/3 17:46
     */
    List<UserBaseDO> queryListByDTO(UserBaseDTO userBaseDTO);
}
