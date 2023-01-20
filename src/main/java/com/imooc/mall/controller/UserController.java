package com.imooc.mall.controller;

import com.imooc.mall.pojo.User;
import com.imooc.mall.vo.ResponseVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.log4j.Log4j;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@Slf4j
@Api(tags = "用户控制器")
public class UserController {

    @ApiOperation("注册")
    @PostMapping("/register")
    public ResponseVo register(@RequestBody User user) {
        log.info("username={}", user.getUsername());
        return ResponseVo.success("注册成功");
    }
}
