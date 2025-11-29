package com.example.ecommerce.service;


import com.example.ecommerce.entity.BasketProduct;

public interface BasketProductService {


    BasketProduct findBasketItemByBasketIdAndProductId(Long basketId, Long productId);

    BasketProduct save(BasketProduct basketProduct);

    void delete(Long basketProductId);
}
