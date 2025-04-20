package com.example.ecommerce.request;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BasketRequest {
    private Long userId;
    private  Long productId;
    private int count;
}
