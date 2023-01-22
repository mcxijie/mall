package com.imooc.mall.form;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class UserRegisterForm {
    //    @NotBlank  用于String 判断空格
//    @NotEmpty  用于集合
//    @NotNull
    @NotBlank(message = "用户名不能为空")
    @ApiModelProperty(value = "用户名")
    private String username;

    @NotBlank
    @ApiModelProperty(value = "用户密码，MD5加密")
    private String password;

    @NotBlank
    @ApiModelProperty(value = "邮件")
    private String email;
}
