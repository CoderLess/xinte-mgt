package com.ibn.xinte.service;

import com.github.pagehelper.PageInfo;
import com.ibn.xinte.domain.MedicineBaseDTO;

import java.util.List;

/**
 * @version 1.0
 * @description:
 * @projectName：xinte
 * @see: com.ibn.xinte.service
 * @author： RenBin
 * @createTime：2020年12月28日
 */
public interface MedicineBaseService {

    /**
     * @description: 保存药品信息
     * @author：RenBin
     * @createTime：2020年12月28日
     */
    Long save(MedicineBaseDTO medicineBaseDTO);

    /**
     * @description: 批量保存药品信息
     * @author：RenBin
     * @createTime：2020年12月28日
     */
    Long saveBatch(List<MedicineBaseDTO> medicineBaseDTOList);

    /**
     * @description: 更新药品信息
     * @author：RenBin
     * @createTime：2020年12月28日
     */
    Integer updateById(MedicineBaseDTO medicineBaseDTO);

    /**
     * @description: 根据Id删除药品信息
     * @author：RenBin
     * @createTime：2020年12月28日
     */
    Integer deleteById(Long id);

    /**
     * @description: 通过id查询药品信息
     * @author：RenBin
     * @createTime：2020年12月28日
     */
    MedicineBaseDTO queryById(Long id);

    /**
     * @description: 通过条件查询药品信息
     * @author：RenBin
     * @createTime：2020年12月28日
     */
    List<MedicineBaseDTO> queryList(MedicineBaseDTO medicineBaseDTO, Integer pageNum, Integer pageSize);
    /**
     * @description: 通过条件分页查询管理员信息
     * @author：RenBin
     * @createTime：2020年12月28日
     */
    PageInfo<MedicineBaseDTO> queryPageInfo(MedicineBaseDTO medicineBaseDTO, Integer pageNum, Integer pageSize);
}
