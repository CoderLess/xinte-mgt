package com.ibn.xinte.service;

import com.github.pagehelper.PageInfo;
import com.ibn.xinte.domain.AdminBaseDTO;
import com.ibn.xinte.domain.MedicineCheckInOutDTO;

import java.util.List;

/**
 * @version 1.0
 * @description:
 * @projectName：xinte
 * @see: com.ibn.xinte.service
 * @author： RenBin
 * @createTime：2020年12月28日
 */
public interface MedicineCheckInOutService {

    /**
     * @description: 保存药品出入库信息
     * @author：RenBin
     * @createTime：2020年12月28日
     */
    Long save(MedicineCheckInOutDTO medicineCheckInOutDTO);

    /**
     * @description: 批量保存药品出入库信息
     * @author：RenBin
     * @createTime：2020年12月28日
     */
    Long saveBatch(List<MedicineCheckInOutDTO> medicineCheckInOutDTOList);

    /**
     * @description: 更新药品出入库信息
     * @author：RenBin
     * @createTime：2020年12月28日
     */
    Integer updateById(MedicineCheckInOutDTO medicineCheckInOutDTO);

    /**
     * @description: 根据Id删除药品出入库信息
     * @author：RenBin
     * @createTime：2020年12月28日
     */
    Integer deleteById(Long id);

    /**
     * @description: 通过id查询药品出入库信息
     * @author：RenBin
     * @createTime：2020年12月28日
     */
    MedicineCheckInOutDTO queryById(Long id);

    /**
     * @description: 通过条件查询药品出入库信息
     * @author：RenBin
     * @createTime：2020年12月28日
     */
    List<MedicineCheckInOutDTO> queryList(MedicineCheckInOutDTO medicineCheckInOutDTO);
    /**
     * @description: 通过条件查询管理员信息
     * @author：RenBin
     * @createTime：2020年12月28日
     */
    PageInfo<MedicineCheckInOutDTO> queryPageInfo(MedicineCheckInOutDTO medicineCheckInOutDTO, Integer pageNum, Integer pageSize);
}
