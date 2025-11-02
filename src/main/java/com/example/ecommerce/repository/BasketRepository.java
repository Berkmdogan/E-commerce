package com.example.ecommerce.repository;


import com.example.ecommerce.entity.Basket;
import org.springframework.data.jpa.repository.JpaRepository;


public interface BasketRepository extends JpaRepository<Basket, Long> {

    Basket findBasketByCustomer_CustomerIdAndStatusEquals(int customerId, int status);

    Basket findBasketByBasketId(int basketId);
}
