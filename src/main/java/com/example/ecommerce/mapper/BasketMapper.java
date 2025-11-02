package com.example.ecommerce.mapper;


import com.example.ecommerce.dto.BasketDto;
import com.example.ecommerce.dto.ProductDto;
import com.example.ecommerce.entity.Basket;
import com.example.ecommerce.entity.Product;
import com.example.ecommerce.service.CategoryService;
import org.springframework.stereotype.Component;
import java.util.stream.Collectors;
@Component
public class BasketMapper {
    public static Product toEntity(CategoryService categoryService , ProductDto productDto) {
        return Product.builder()
                .ProductId(productDto.getId())
                .name(productDto.getName())
                .description(productDto.getDescription())
                .price(productDto.getPrice())
                .category(categoryService.getEntity(productDto.getCategoryId()))
                .stock(productDto.getStock())
                .build();
    }

    public static BasketDto toDto(Basket basket){

        return BasketDto.builder()
                .basketId(basket.getBasketId())
                .totalPrice(basket.getTotalPrice())
                .status(basket.getStatus())
                .customer(CustomerMapper.toDto(basket.getCustomer()))
                .basketProductList(basket.getBasketProductList()
                        .stream()
                        .map(BasketProductMapper::toDto)
                        .collect(Collectors.toList())
                )
                .build();
    }


}
