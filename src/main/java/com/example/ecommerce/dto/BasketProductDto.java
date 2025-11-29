package com.example.ecommerce.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@Builder
public class BasketProductDto {
    private Long basketProductId;
    private int count;
    private double basketProductAmount;
    private final ProductDto product;
}
