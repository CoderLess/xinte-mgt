package com.ibn.xinte.service;

import com.github.pagehelper.PageInfo;
import com.ibn.xinte.domain.PrescriptionMedicineDTO;
import com.ibn.xinte.exception.IbnException;

import java.math.BigDecimal;
import java.util.List;

/**
 * @version 1.0
 * @description:
 * @projectName：xinte
 * @see: com.ibn.xinte.service
 * @author： RenBin
 * @createTime：2020年12月28日
 */
public interface PrescriptionMedicineService {

    /**
     * @description: 保存药方-药品信息
     * @author：RenBin
     * @createTime：2020年12月28日
     */
    Long save(PrescriptionMedicineDTO prescriptionMedicineDTO) throws IbnException;

    /**
     * @description: 批量保存药方-药品信息
     * @author：RenBin
     * @createTime：2020年12月28日
     */
    Long saveBatch(List<PrescriptionMedicineDTO> prescriptionMedicineDTOList);

    /**
     * @description: 更新药方-药品信息
     * @author：RenBin
     * @createTime：2020年12月28日
     */
    Integer updateById(PrescriptionMedicineDTO prescriptionMedicineDTO);

    /**
     * @description: 根据Id删除药方-药品信息
     * @author：RenBin
     * @createTime：2020年12月28日
     */
    Integer deleteById(Long id);

    /**
     * @description: 通过id查询药方-药品信息
     * @author：RenBin
     * @createTime：2020年12月28日
     */
    PrescriptionMedicineDTO queryById(Long id);

    /**
     * @description: 通过条件查询药方-药品信息
     * @author：RenBin
     * @createTime：2020年12月28日
     */
    List<PrescriptionMedicineDTO> queryList(PrescriptionMedicineDTO prescriptionMedicineDTO);
    /**
     * @description: 查询根据条件查询药品相关信息
     * @author：RenBin
     * @createTime：2021/1/11 23:02
     */
    List<PrescriptionMedicineDTO> queryInfoList(PrescriptionMedicineDTO prescriptionMedicineDTO);
    /**
     * @description: 通过条件查询管理员信息
     * @author：RenBin
     * @createTime：2020年12月28日
     */
    PageInfo<PrescriptionMedicineDTO> queryPageInfo(PrescriptionMedicineDTO prescriptionMedicineDTO, Integer pageNum, Integer pageSize);
    /**
     * @description: 计算并更新总价格
     * @author：RenBin
     * @createTime：2021/1/14 22:11
     */
    BigDecimal calculatePrice(Long prescriptionId);
}
