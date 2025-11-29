package com.example.ecommerce.request;

import com.example.ecommerce.dto.BasketDto;
import com.example.ecommerce.dto.BasketProductDto;
import com.example.ecommerce.dto.CustomerDto;
import com.example.ecommerce.dto.ProductDto;
import com.example.ecommerce.entity.BasketProduct;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BasketRequest {

    private Long customerId;
    private Long productId;
    private int count;

    public BasketDto toDto(){
        ProductDto productDto = ProductDto.builder().id(productId).build();
        BasketProductDto dto = BasketProductDto.builder()
                .product(productDto)
                .count(count)
                .build();
        List<BasketProductDto> dtoList = new ArrayList<>();
        dtoList.add(dto);
        return BasketDto.builder()
                .customer(CustomerDto.builder().customerId(customerId).build())
                .basketProductList(dtoList)
                .build();
    }
}
