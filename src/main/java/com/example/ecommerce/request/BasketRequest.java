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
@Data
public class BasketRequest {

    private int customerId;
    private int productId;
    private int count;

    public BasketDto toDto(){
        List<BasketProductDto> dtoList = new ArrayList<>();
        BasketProductDto dto = BasketProductDto.builder().
                product(new ProductDto(productId)).
                build();
        dto.setCount(count);
        dtoList.add(dto);
        return BasketDto.builder()
                .customer(CustomerDto.builder().customerId(customerId).build())
                .basketProductList(dtoList)
                .build();
    }
}
