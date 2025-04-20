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
    @Autowired
    private BasketServiceImpl basketService;
    @Autowired
    private ProductServiceImpl productService;

    public List<BasketProduct> mapDtosToEntities(List<BasketProductDto> basketProductDtoList) {
        if (basketProductDtoList == null) {
            return Collections.emptyList();
        }
        return basketProductDtoList.stream()
                .map(this::dtoToEntity)
                .collect(Collectors.toList());
    }

    public BasketProduct dtoToEntity(BasketProductDto basketProductDto) {
        return BasketProduct.builder()
                .count(basketProductDto.getCount())
                .id(basketProductDto.getId())
                .totalAmount(basketProductDto.getTotalAmount())
                .product(productService.findProductById(basketProductDto.getProductId()))
                .basket(basketService.findBasketById(basketProductDto.getBasketId()))
                .build();
    }
    public List<BasketProductDto> mapEntitesToDtos(List<BasketProduct> basketProductList){
        return basketProductList.stream()
                .map(this::entityToDto)
                .collect(Collectors.toList());
    }
    public BasketProductDto entityToDto(BasketProduct basketProduct){
        return BasketProductDto.builder()
                .basketId(basketProduct.getBasket().getId())
                .productId(basketProduct.getProduct().getId())
                .count(basketProduct.getCount())
                .id(basketProduct.getId())
                .build();
    }
}
