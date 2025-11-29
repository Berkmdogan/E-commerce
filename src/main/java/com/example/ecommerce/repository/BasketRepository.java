package com.example.ecommerce.repository;


import com.example.ecommerce.entity.Basket;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface BasketRepository extends JpaRepository<Basket, Long> {

    // Entity'de direkt "customerId" alanı olduğu için metod ismi kısaldı:
    // Eski: findBasketByCustomer_CustomerIdAndStatusEquals
    // Yeni:
    Optional<Basket> findByCustomerIdAndStatus(Long customerId, int status);

}