package com.imooc.mall.pojo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

@Data
public class Shipping {
    private Integer id;

    @ApiModelProperty(value = "用户id")
    private Integer userId;

    @ApiModelProperty(value = "收货姓名")
    private String receiverName;

    @ApiModelProperty(value = "收货固定电话")
    private String receiverPhone;

    @ApiModelProperty(value = "收货移动电话")
    private String receiverMobile;

    @ApiModelProperty(value = "省份")
    private String receiverProvince;

    @ApiModelProperty(value = "城市")
    private String receiverCity;

    @ApiModelProperty(value = "区/县")
    private String receiverDistrict;

    @ApiModelProperty(value = "详细地址")
    private String receiverAddress;

    @ApiModelProperty(value = "邮编")
    private String receiverZip;

    @ApiModelProperty(value = "创建时间")
    private Date createTime;

    @ApiModelProperty(value = "修改时间")
    private Date updateTime;

}