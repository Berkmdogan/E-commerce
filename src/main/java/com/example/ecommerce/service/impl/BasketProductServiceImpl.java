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



    @Override
    public BasketProduct findBasketItemByBasketIdAndProductId(Long basketId, Long productId) {
        return repository.findByBasket_IdAndProduct_Id(basketId, productId);
    }


    @Override
    public BasketProduct save(BasketProduct basketItem) {
        return repository.save(basketItem);
    }

    @Override
    public void delete(Long basketProductId) {
        repository.deleteById(basketProductId);
    }
}
