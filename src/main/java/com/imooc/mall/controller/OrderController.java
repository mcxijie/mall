package com.imooc.mall.controller;

import com.github.pagehelper.PageInfo;
import com.imooc.mall.form.OrderCreateForm;
import com.imooc.mall.pojo.User;
import com.imooc.mall.service.IOrderService;
import com.imooc.mall.vo.OrderVo;
import com.imooc.mall.vo.ResponseVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import static com.imooc.mall.consts.MallConst.CURRENT_USER;

@RestController
@Api(tags = "订单")
public class OrderController {

    @Autowired
    private IOrderService orderService;

    @PostMapping("/orders")
    @ApiOperation("添加订单")
    public ResponseVo<OrderVo> create(@Valid @RequestBody OrderCreateForm form, HttpSession session) {
        User user = (User) session.getAttribute(CURRENT_USER);
        return orderService.create(user.getId(), form.getShippingId());
    }

    @GetMapping("/orders")
    @ApiOperation("列表")
    public ResponseVo<PageInfo> list(@RequestParam Integer pageNum, @RequestParam Integer pageSize, HttpSession session) {
        User user = (User) session.getAttribute(CURRENT_USER);
        return orderService.list(user.getId(), pageNum, pageSize);
    }

    @GetMapping("/orders/{orderNo}")
    @ApiOperation("详情")
    public ResponseVo<OrderVo> detail(@PathVariable Long orderNo, HttpSession session) {
        User user = (User) session.getAttribute(CURRENT_USER);
        return orderService.detail(user.getId(), orderNo);
    }

    @PutMapping("/orders/{orderNo}")
    @ApiOperation("取消订单")
    public ResponseVo<OrderVo> cancel(@PathVariable Long orderNo, HttpSession session) {
        User user = (User) session.getAttribute(CURRENT_USER);
        return orderService.cancel(user.getId(), orderNo);
    }
}
