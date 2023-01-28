package com.imooc.mall.controller;

import com.github.pagehelper.PageInfo;
import com.imooc.mall.service.IProductService;
import com.imooc.mall.vo.ProductDetailVo;
import com.imooc.mall.vo.ResponseVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api(tags = "商品目录")
public class ProductController {

    @Autowired
    private IProductService iProductService;

    @GetMapping("/products")
    @ApiOperation("商品列表")
    public ResponseVo<PageInfo> list(@RequestParam(required = false) Integer categoryId,
                                     @RequestParam(required = false, defaultValue = "1") Integer pageNum,
                                     @RequestParam(required = false, defaultValue = "10") Integer pageSize) {

        return iProductService.list(categoryId, pageNum, pageSize);
    }

    @GetMapping("/products/{productId}")
    @ApiOperation("商品详情")
    public ResponseVo<ProductDetailVo> detail(@PathVariable Integer productId) {
        return iProductService.detail(productId);
    }
}
