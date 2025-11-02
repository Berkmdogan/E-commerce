package com.example.ecommerce.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductDto {
    private int id;
    private String name;
    private String description;
    private Double price;
    private Long categoryId;
    private int stock;
}
