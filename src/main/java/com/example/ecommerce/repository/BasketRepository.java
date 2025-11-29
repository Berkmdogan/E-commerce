package com.example.ecommerce.repository;


import com.example.ecommerce.entity.Basket;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface BasketRepository extends JpaRepository<Basket, Long> {

    Optional<Basket> findByCustomerIdAndStatus(Long customerId, int status);

}