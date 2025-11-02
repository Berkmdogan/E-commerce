package com.example.ecommerce.service;


import com.example.ecommerce.entity.BasketProduct;

public interface BasketProductService {

    BasketProduct findBasketItemByBasketIdAndProductId(int basketId, int productId);

    BasketProduct save(BasketProduct basketProduct);

    void delete(int basketItemId);
}
