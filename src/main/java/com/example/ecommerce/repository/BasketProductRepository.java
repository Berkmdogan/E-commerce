package com.example.ecommerce.repository;


import com.example.ecommerce.entity.BasketProduct;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BasketProductRepository extends JpaRepository<BasketProduct, Long> {
    BasketProduct findBasketItemByBasket_BasketIdAndProduct_ProductId(int basketId, int productId);

}
