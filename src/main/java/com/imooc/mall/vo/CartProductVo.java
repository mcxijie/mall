package com.imooc.mall.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class CartProductVo {
    @ApiModelProperty(value = "商品id")
    private Integer productId;

    @ApiModelProperty(value = "购买的数量")
    private Integer quantity;

    @ApiModelProperty(value = "商品名称")
    private String productName;

    @ApiModelProperty(value = "商品副标题")
    private String productSubtitle;

    @ApiModelProperty(value = "产品主图,url相对地址")
    private String productMainImage;

    @ApiModelProperty(value = "价格,单位-元保留两位小数")
    private BigDecimal productPrice;

    @ApiModelProperty(value = "商品状态.1-在售 2-下架 3-删除")
    private Integer productStatus;

    @ApiModelProperty(value = "商品总价")
    private BigDecimal productTotalPrice;

    @ApiModelProperty(value = "库存数量")
    private Integer productStock;

    @ApiModelProperty(value = "是否选中该商品")
    private Boolean productSelected;
}
