package com.example.ecommerce.entity;

import jakarta.persistence.*;
import lombok.*;


@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BasketProduct {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int basketProductId;
    private int count;
    private double basketProductTotalPrice;


    @ManyToOne
    @JoinColumn(name = "basket_id")
    private Basket basket;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;
}
