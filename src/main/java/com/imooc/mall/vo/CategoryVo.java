package com.imooc.mall.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

@Data
public class CategoryVo {
    @ApiModelProperty(value = "类别Id")
    private Integer id;

    @ApiModelProperty(value = "父类别id当id=0时说明是根节点,一级类别")
    private Integer parentId;

    @ApiModelProperty(value = "类别名称")
    private String name;

    @ApiModelProperty(value = "排序编号,同类展示顺序,数值相等则自然排序")
    private Integer sortOrder;

    @ApiModelProperty(value = "子目录")
    private List<CategoryVo> subCategories;
}
