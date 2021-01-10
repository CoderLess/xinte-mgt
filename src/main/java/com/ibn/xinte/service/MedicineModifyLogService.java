package com.ibn.xinte.service;

import com.github.pagehelper.PageInfo;
import com.ibn.xinte.domain.AdminBaseDTO;
import com.ibn.xinte.domain.MedicineModifyLogDTO;

import java.util.List;

/**
 * @version 1.0
 * @description:
 * @projectName：xinte
 * @see: com.ibn.xinte.service
 * @author： RenBin
 * @createTime：2020年12月28日
 */
public interface MedicineModifyLogService {

    /**
     * @description: 保存药品修改记录信息
     * @author：RenBin
     * @createTime：2020年12月28日
     */
    Long save(MedicineModifyLogDTO medicineModifyLogDTO);

    /**
     * @description: 批量保存药品修改记录信息
     * @author：RenBin
     * @createTime：2020年12月28日
     */
    Long saveBatch(List<MedicineModifyLogDTO> medicineModifyLogDTOList);

    /**
     * @description: 更新药品修改记录信息
     * @author：RenBin
     * @createTime：2020年12月28日
     */
    Integer updateById(MedicineModifyLogDTO medicineModifyLogDTO);

    /**
     * @description: 根据Id删除药品修改记录信息
     * @author：RenBin
     * @createTime：2020年12月28日
     */
    Integer deleteById(Long id);

    /**
     * @description: 通过id查询药品修改记录信息
     * @author：RenBin
     * @createTime：2020年12月28日
     */
    MedicineModifyLogDTO queryById(Long id);

    /**
     * @description: 通过条件查询药品修改记录信息
     * @author：RenBin
     * @createTime：2020年12月28日
     */
    List<MedicineModifyLogDTO> queryList(MedicineModifyLogDTO medicineModifyLogDTO);
    /**
     * @description: 通过条件查询管理员信息
     * @author：RenBin
     * @createTime：2020年12月28日
     */
    PageInfo<MedicineModifyLogDTO> queryPageInfo(MedicineModifyLogDTO medicineModifyLogDTO, Integer pageNum, Integer pageSize);
}
