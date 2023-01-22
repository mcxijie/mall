package com.imooc.mall.controller;

import com.imooc.mall.form.UserLofinForm;
import com.imooc.mall.form.UserRegisterForm;
import com.imooc.mall.pojo.User;
import com.imooc.mall.service.IUserService;
import com.imooc.mall.vo.ResponseVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import static com.imooc.mall.consts.MallConst.CURRENT_USER;
import static com.imooc.mall.enums.ResponseEnum.PARAM_ERROR;

@RestController
@RequestMapping()
@Slf4j
@Api(tags = "用户控制器")
public class UserController {

    @Autowired
    private IUserService userService;

    @ApiOperation("注册")
    @PostMapping("/user/register")
    public ResponseVo<User> register(@Valid @RequestBody UserRegisterForm userForm, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            log.error("注册提交的参数有误，{}{}", bindingResult.getFieldError().getField(), bindingResult.getFieldError().getDefaultMessage());
            return ResponseVo.error(PARAM_ERROR, bindingResult);
        }
        User user = new User();
        BeanUtils.copyProperties(userForm, user);

        return userService.register(user);
    }

    @PostMapping("/user/login")
    @ApiOperation("登录")
    public ResponseVo<User> login(@Valid @RequestBody UserLofinForm userLofinForm, BindingResult bindingResult, HttpSession session) {
        if (bindingResult.hasErrors()) {
            return ResponseVo.error(PARAM_ERROR, bindingResult);
        }
        ResponseVo<User> userResponseVo = userService.login(userLofinForm.getUsername(), userLofinForm.getPassword());
        //设置Session
        session.setAttribute(CURRENT_USER, userResponseVo.getData());
        return userResponseVo;
    }

    //session保存在内存里，改进版，token+redis
    @GetMapping("/user")
    @ApiOperation("获取用户信息")
    public ResponseVo<User> userInfo(HttpSession session) {
        User user = (User) session.getAttribute(CURRENT_USER);

        return ResponseVo.success(user);
    }

    @PostMapping("/user/logout")
    @ApiOperation("登出")
    public ResponseVo logout(HttpSession session) {

        session.removeAttribute(CURRENT_USER);
        return ResponseVo.success();
    }

}
