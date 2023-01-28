package com.imooc.mall.pojo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
public class Product {
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

    @ApiModelProperty(value = "图片地址,json格式,扩展用")
    private String subImages;

    @ApiModelProperty(value = "商品详情")
    private String detail;

    @ApiModelProperty(value = "价格,单位-元保留两位小数")
    private BigDecimal price;

    @ApiModelProperty(value = "库存数量")
    private Integer stock;

    @ApiModelProperty(value = "商品状态.1-在售 2-下架 3-删除")
    private Integer status;

    @ApiModelProperty(value = "创建时间")
    private Date createTime;

    @ApiModelProperty(value = "更新时间")
    private Date updateTime;

}