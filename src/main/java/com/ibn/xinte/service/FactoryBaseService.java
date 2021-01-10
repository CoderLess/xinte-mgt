package com.ibn.xinte.service;

import com.github.pagehelper.PageInfo;
import com.ibn.xinte.domain.FactoryBaseDTO;

import java.util.List;

/**
 * @version 1.0
 * @description: 生产商基本信息
 * @projectName：xinte
 * @see: com.ibn.xinte.service
 * @author： RenBin
 * @createTime：2021年1月10日
 */
public interface FactoryBaseService {

    /**
     * @description: 保存生产商信息
     * @author：RenBin
     * @createTime：2021年1月10日
     */
    Long save(FactoryBaseDTO factoryBaseDTO);

    /**
     * @description: 批量保存用户信息
     * @author：RenBin
     * @createTime：2021年1月10日
     */
    Long saveBatch(List<FactoryBaseDTO> factoryBaseDTOList);

    /**
     * @description: 更新生产商信息
     * @author：RenBin
     * @createTime：2021年1月10日
     */
    Integer updateById(FactoryBaseDTO factoryBaseDTO);

    /**
     * @description: 根据Id删除生产商信息
     * @author：RenBin
     * @createTime：2021年1月10日
     */
    Integer deleteById(Long id);

    /**
     * @description: 通过id查询生产商信息
     * @author：RenBin
     * @createTime：2021年1月10日
     */
    FactoryBaseDTO queryById(Long id);

    /**
     * @description: 通过条件查询生产商信息
     * @author：RenBin
     * @createTime：2021年1月10日
     */
    List<FactoryBaseDTO> queryList(FactoryBaseDTO factoryBaseDTO);
    /**
     * @description: 通过条件分页查询生产商信息
     * @author：RenBin
     * @createTime：2020年12月28日
     */
    PageInfo<FactoryBaseDTO> queryPageInfo(FactoryBaseDTO factoryBaseDTO, Integer pageNum, Integer pageSize);
}
