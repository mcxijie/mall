package com.imooc.mall.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class ProductVo {
    @ApiModelProperty(value = "商品id")
    private Integer id;

    @ApiModelProperty(value = "分类id,对应mall_category表的主键")
    private Integer categoryId;

    @ApiModelProperty(value = "商品名称")
    private String name;

    @ApiModelProperty(value = "商品副标题")
    private String subtitle;

    @ApiModelProperty(value = "产品主图,url相对地址")
    private String mainImage;

    @ApiModelProperty(value = "商品状态.1-在售 2-下架 3-删除")
    private Integer status;

    @ApiModelProperty(value = "价格,单位-元保留两位小数")
    private BigDecimal price;


}