package com.imooc.mall.service.impl;

import com.google.gson.Gson;
import com.imooc.mall.dao.ProductMapper;
import com.imooc.mall.form.CartAddForm;
import com.imooc.mall.pojo.Cart;
import com.imooc.mall.pojo.Product;
import com.imooc.mall.service.ICartService;
import com.imooc.mall.vo.CartVo;
import com.imooc.mall.vo.ResponseVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import static com.imooc.mall.enums.ProductStatusEnum.ON_SALE;
import static com.imooc.mall.enums.ResponseEnum.*;

@Service
public class CartServiceImpl implements ICartService {

    private final static String CART_REDIS_KEY_TEMPLATE = "cart_%d";

    @Autowired
    private ProductMapper productMapper;

    @Autowired
    private StringRedisTemplate redisTemplate;

    private Gson gson = new Gson();

    @Override
    public ResponseVo<CartVo> add(Integer uid, CartAddForm form) {
        Integer quantity = 1;
        Product product = productMapper.selectByPrimaryKey(form.getProductId());
        //商品是否存在
        if (product == null) {
            return ResponseVo.error(PRODUCT_NOT_EXIST);
        }
        //商品是否是正常的在售状态
        if (!product.getStatus().equals(ON_SALE.getCode())) {
            return ResponseVo.error(PRODUCT_OFF_SALE_OR_DELETE);
        }
        //商品库存是否充足
        if (product.getStock() <= 0) {
            return ResponseVo.error(PRODUCT_STOCK_ERROR);
        }

        //写入到redis
        //key:cart_1
        HashOperations<String, String, String> opsForHash = redisTemplate.opsForHash();
        String redisKey = String.format(CART_REDIS_KEY_TEMPLATE, uid);

        Cart cart = new Cart();
        String value = opsForHash.get(redisKey, String.valueOf(product.getId()));
        if (StringUtils.isEmpty(value)) {
            //没有该商品，新增
            cart = new Cart(product.getId(), quantity, form.getSelected());

        } else {
            //已经有了，数量+1
            cart = gson.fromJson(value, Cart.class);
            cart.setQuantity(cart.getQuantity() + quantity);
        }

        opsForHash.put(redisKey, String.valueOf(product.getId()), gson.toJson(cart));

        return null;
    }
}
