package com.imooc.mall.controller;

import com.imooc.mall.service.ICategoryService;
import com.imooc.mall.vo.CategoryVo;
import com.imooc.mall.vo.ResponseVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Api(tags = "分类目录")
public class CategoryController {

    @Autowired
    private ICategoryService iCategoryService;

    @GetMapping("/categories")
    @ApiOperation("列表")
    public ResponseVo<List<CategoryVo>> selectAll() {
        return iCategoryService.selectAll();
    }
}
