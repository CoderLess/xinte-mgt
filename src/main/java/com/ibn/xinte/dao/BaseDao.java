package com.ibn.xinte.dao;

import java.util.List;

/**
 * @version 1.0
 * @description:
 * @projectName：xinte
 * @see: com.ibn.xinte.dao
 * @author： RenBin
 * @createTime：2020年12月28日
 */
public interface BaseDao<T> {
    /**
     * @description: 保存数据
     * @author：RenBin
     * @createTime：2020年12月28日
     */
    Long save(T t);
    /**
     * @description: 批量保存数据
     * @author：RenBin
     * @createTime：2020年12月28日
     */
    Long saveBatch(List<T> list);
    /**
     * @description: 通过id更新数据
     * @author：RenBin
     * @createTime：2020年12月28日
     */
    Integer updateById(T t);
    /**
     * @description: 根据id删除数据
     * @author：RenBin
     * @createTime：2020年12月28日
     */
    Integer deleteById(Long id);
    /**
     * @description: 通过id查询数据
     * @author：RenBin
     * @createTime：2020年12月28日
     */
    T queryById(Long id);
    /**
     * @description: 通过条件查询数据
     * @author：RenBin
     * @createTime：2020年12月28日
     */
    List<T> queryList(T t);

}
