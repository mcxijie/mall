package com.imooc.mall.controller;

import com.imooc.mall.form.ShippingForm;
import com.imooc.mall.pojo.User;
import com.imooc.mall.service.IShippingService;
import com.imooc.mall.vo.ResponseVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import static com.imooc.mall.consts.MallConst.CURRENT_USER;

@RestController
@Api(tags = "收货地址")
public class ShippingController {

    @Autowired
    private IShippingService shippingService;

    @PostMapping("/shippings")
    @ApiOperation("添加")
    public ResponseVo add(@Valid @RequestBody ShippingForm form, HttpSession session) {
        User user = (User) session.getAttribute(CURRENT_USER);
        return shippingService.add(user.getId(), form);
    }

    @DeleteMapping("/shippings/{shippingId}")
    @ApiOperation("删除")
    public ResponseVo delete(@PathVariable Integer shippingId, HttpSession session) {
        User user = (User) session.getAttribute(CURRENT_USER);
        return shippingService.delete(user.getId(), shippingId);
    }

    @PutMapping("/shippings/{shippingId}")
    @ApiOperation("修改")
    public ResponseVo update(@PathVariable Integer shippingId, @Valid @RequestBody ShippingForm form, HttpSession session) {
        User user = (User) session.getAttribute(CURRENT_USER);
        return shippingService.update(user.getId(), shippingId, form);
    }

    @GetMapping("/shippings")
    @ApiOperation("列表")
    public ResponseVo list(@RequestParam(required = false, defaultValue = "1") Integer pageNum,
                           @RequestParam(required = false, defaultValue = "10") Integer pageSize,
                           HttpSession session) {
        User user = (User) session.getAttribute(CURRENT_USER);
        return shippingService.list(user.getId(), pageNum, pageSize);
    }
}
