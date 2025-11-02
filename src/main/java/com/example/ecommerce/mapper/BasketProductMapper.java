package com.example.ecommerce.mapper;


import com.example.ecommerce.dto.BasketProductDto;
import com.example.ecommerce.entity.BasketProduct;
import com.example.ecommerce.service.impl.BasketServiceImpl;
import com.example.ecommerce.service.impl.ProductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
@Component
public class BasketProductMapper {
    public static BasketProductDto toDto(BasketProduct basketProduct) {
        return BasketProductDto.builder()
                .basketProductId(basketProduct.getBasketProductId())
                .basketProductAmount(basketProduct.getBasketProductTotalPrice())
                .count(basketProduct.getCount())
                .product(ProductMapper.toDto(basketProduct.getProduct()))
                .build();
    }
}
