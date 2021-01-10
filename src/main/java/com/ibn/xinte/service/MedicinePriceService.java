package com.ibn.xinte.service;

import com.ibn.xinte.domain.MedicinePriceDTO;

import java.util.List;

/**
 * @version 1.0
 * @description:
 * @projectName：xinte
 * @see: com.ibn.xinte.service
 * @author： RenBin
 * @createTime：2021年1月10日
 */
public interface MedicinePriceService {

    /**
     * @description: 保存药品价格信息
     * @author：RenBin
     * @createTime：2021年1月10日
     */
    Long save(MedicinePriceDTO medicinePriceDTO);

    /**
     * @description: 批量保存药品价格信息
     * @author：RenBin
     * @createTime：2021年1月10日
     */
    Long saveBatch(List<MedicinePriceDTO> medicinePriceDTOList);

    /**
     * @description: 更新药品价格信息
     * @author：RenBin
     * @createTime：2021年1月10日
     */
    Integer updateById(MedicinePriceDTO medicinePriceDTO);

    /**
     * @description: 根据Id删除药品价格信息
     * @author：RenBin
     * @createTime：2021年1月10日
     */
    Integer deleteById(Long id);

    /**
     * @description: 通过id查询药品价格信息
     * @author：RenBin
     * @createTime：2021年1月10日
     */
    MedicinePriceDTO queryById(Long id);

    /**
     * @description: 通过条件查询药品价格信息
     * @author：RenBin
     * @createTime：2021年1月10日
     */
    List<MedicinePriceDTO> queryList(MedicinePriceDTO medicinePriceDTO);

    /**
     * @description: 通过id和会员等级查询药品价格信息
     * @author：RenBin
     * @createTime：2021年1月10日
     */
    MedicinePriceDTO queryByIdLevel(Long id, Integer level);
}
