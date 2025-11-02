package com.example.ecommerce.service.impl;


import com.example.ecommerce.entity.BasketProduct;
import com.example.ecommerce.repository.BasketProductRepository;
import com.example.ecommerce.service.BasketProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BasketProductServiceImpl implements BasketProductService {

    private final BasketProductRepository repository;
    private final ProductServiceImpl productService;

    @Override
    public BasketProduct findBasketItemByBasketIdAndProductId(int basketId, int productId) {
        return repository.findBasketItemByBasket_BasketIdAndProduct_ProductId(basketId,productId);
    }

    @Override
    public BasketProduct save(BasketProduct basketItem) {
        return repository.save(basketItem);
    }

    @Override
    public void delete(int basketProductId) {

        BasketProduct basketProduct=repository.findById(Long.valueOf(basketProductId)).get();

    }
}
