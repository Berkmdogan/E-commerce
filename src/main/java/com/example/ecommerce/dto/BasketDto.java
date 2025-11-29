package com.example.ecommerce.dto;

import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BasketDto {
    private Long basketId;
    private double totalPrice;
    private int status;
    private CustomerDto customer;
    private List<BasketProductDto> basketProductList;
}
