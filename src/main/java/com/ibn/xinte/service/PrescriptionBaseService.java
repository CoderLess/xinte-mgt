package com.ibn.xinte.service;

import com.github.pagehelper.PageInfo;
import com.ibn.xinte.domain.AdminBaseDTO;
import com.ibn.xinte.domain.PrescriptionBaseDTO;

import java.util.List;

/**
 * @version 1.0
 * @description:
 * @projectName：xinte
 * @see: com.ibn.xinte.service
 * @author： RenBin
 * @createTime：2020年12月28日
 */
public interface PrescriptionBaseService {

    /**
     * @description: 保存药方信息
     * @author：RenBin
     * @createTime：2020年12月28日
     */
    Long save(PrescriptionBaseDTO prescriptionBaseDTO);

    /**
     * @description: 批量保存药方信息
     * @author：RenBin
     * @createTime：2020年12月28日
     */
    Long saveBatch(List<PrescriptionBaseDTO> prescriptionBaseDTOList);

    /**
     * @description: 更新药方信息
     * @author：RenBin
     * @createTime：2020年12月28日
     */
    Integer updateById(PrescriptionBaseDTO prescriptionBaseDTO);

    /**
     * @description: 根据Id删除药方信息
     * @author：RenBin
     * @createTime：2020年12月28日
     */
    Integer deleteById(Long id);

    /**
     * @description: 通过id查询药方信息
     * @author：RenBin
     * @createTime：2020年12月28日
     */
    PrescriptionBaseDTO queryById(Long id);

    /**
     * @description: 通过条件查询药方信息
     * @author：RenBin
     * @createTime：2020年12月28日
     */
    List<PrescriptionBaseDTO> queryList(PrescriptionBaseDTO prescriptionBaseDTO);
    /**
     * @description: 通过额外的条件查询
     * @author：RenBin
     * @createTime：2021/1/4 20:24
     */
    List<PrescriptionBaseDTO> queryListByDTO(PrescriptionBaseDTO prescriptionBaseDTO);
    /**
     * @description: 通过条件查询管理员信息
     * @author：RenBin
     * @createTime：2020年12月28日
     */
    PageInfo<PrescriptionBaseDTO> queryPageInfo(PrescriptionBaseDTO prescriptionBaseDTO, Integer pageNum, Integer pageSize);
}
