package com.imooc.mall.service.impl;


import com.imooc.mall.MallApplicationTests;
import com.imooc.mall.form.CartAddForm;
import com.imooc.mall.service.ICartService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

@Slf4j
public class CartServiceImplTest extends MallApplicationTests {

    @Autowired
    private ICartService cartService;

    @Test
    public void add() {
        CartAddForm form = new CartAddForm();
        form.setProductId(26);
        form.setSelected(true);
        cartService.add(1, form);
    }

    @Test
    public void list() {
    }
}