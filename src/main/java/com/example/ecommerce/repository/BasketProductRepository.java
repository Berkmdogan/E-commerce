package com.example.ecommerce.repository;


import com.example.ecommerce.entity.BasketProduct;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BasketProductRepository extends JpaRepository<BasketProduct, Long> {

    BasketProduct findByBasket_IdAndProduct_Id(Long id, Long productId);
}