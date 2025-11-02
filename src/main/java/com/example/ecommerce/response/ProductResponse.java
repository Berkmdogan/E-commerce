package com.example.ecommerce.response;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductResponse {
    private int id;
    private String name;
    private String description;
    private double price;
    private Long categoryId;
}
