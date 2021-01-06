package com.ibn.xinte.service;

import com.ibn.xinte.domain.UserBaseDTO;

import java.util.List;

/**
 * @version 1.0
 * @description:
 * @projectName：xinte
 * @see: com.ibn.xinte.service
 * @author： RenBin
 * @createTime：2020年12月28日
 */
public interface UserBaseService {

    /**
     * @description: 保存会员信息
     * @author：RenBin
     * @createTime：2020年12月28日
     */
    Long save(UserBaseDTO userBaseDTO);

    /**
     * @description: 批量保存会员信息
     * @author：RenBin
     * @createTime：2020年12月28日
     */
    Long saveBatch(List<UserBaseDTO> userBaseDTOList);

    /**
     * @description: 更新会员信息
     * @author：RenBin
     * @createTime：2020年12月28日
     */
    Integer updateById(UserBaseDTO userBaseDTO);

    /**
     * @description: 根据Id删除会员信息
     * @author：RenBin
     * @createTime：2020年12月28日
     */
    Integer deleteById(Long id);

    /**
     * @description: 通过id查询会员信息
     * @author：RenBin
     * @createTime：2020年12月28日
     */
    UserBaseDTO queryById(Long id);

    /**
     * @description: 通过条件查询会员信息
     * @author：RenBin
     * @createTime：2020年12月28日
     */
    List<UserBaseDTO> queryList(UserBaseDTO userBaseDTO);
    /**
     * @description: 分页查询会员信息
     * @author：RenBin
     * @createTime：2020年12月28日
     */
    List<UserBaseDTO> queryList(UserBaseDTO userBaseDTO, Integer pageNum, Integer pageSize);
    /**
     * @description: 查询会员总数
     * @author：RenBin
     * @createTime：2021/1/5 19:10
     */
    Integer total(UserBaseDTO userBaseDTO);
}
