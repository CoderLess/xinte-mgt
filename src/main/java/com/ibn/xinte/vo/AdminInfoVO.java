package com.ibn.xinte.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @version 1.0
 * @description:
 * @projectName：xinte
 * @see: com.ibn.xinte.vo
 * @author： RenBin
 * @createTime：2021/01/17 21:50
 */
@Data
public class AdminInfoVO {
    /**
     * @description: 姓名
     * @author：RenBin
     * @createTime：2020年12月28日
     */
    @ApiModelProperty(value = "姓名", name = "name")
    private String name;
}
