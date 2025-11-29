package com.example.ecommerce.response;


import com.example.ecommerce.dto.ProductDto;
import lombok.*;

import java.util.List;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CategoryResponse {
    private Long id;
    private String name;
    private String description;
    private List<ProductDto> products;
}
