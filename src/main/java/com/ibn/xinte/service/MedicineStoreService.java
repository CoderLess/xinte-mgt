package com.ibn.xinte.service;

import com.ibn.xinte.domain.MedicineStoreDTO;

import java.util.List;

/**
 * @version 1.0
 * @description:
 * @projectName：xinte
 * @see: com.ibn.xinte.service
 * @author： RenBin
 * @createTime：2020年12月28日
 */
public interface MedicineStoreService {

    /**
     * @description: 保存用户信息
     * @author：RenBin
     * @createTime：2020年12月28日
     */
    Long save(MedicineStoreDTO medicineStoreDTO);

    /**
     * @description: 批量保存用户信息
     * @author：RenBin
     * @createTime：2020年12月28日
     */
    Long saveBatch(List<MedicineStoreDTO> medicineStoreDTOList);

    /**
     * @description: 更新用户信息
     * @author：RenBin
     * @createTime：2020年12月28日
     */
    Integer updateById(MedicineStoreDTO medicineStoreDTO);

    /**
     * @description: 根据Id删除用户信息
     * @author：RenBin
     * @createTime：2020年12月28日
     */
    Integer deleteById(Long id);

    /**
     * @description: 通过id查询用户信息
     * @author：RenBin
     * @createTime：2020年12月28日
     */
    MedicineStoreDTO queryById(Long id);

    /**
     * @description: 通过条件查询用户信息
     * @author：RenBin
     * @createTime：2020年12月28日
     */
    List<MedicineStoreDTO> queryList(MedicineStoreDTO medicineStoreDTO);
}
