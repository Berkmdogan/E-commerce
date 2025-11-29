package com.example.ecommerce.mapper;

import com.example.ecommerce.dto.BasketDto;
import com.example.ecommerce.entity.Basket;
import com.example.ecommerce.response.BasketResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;


@Mapper(componentModel = "spring", uses = {BasketProductMapper.class, CustomerMapper.class})
public interface BasketMapper {

    @Mapping(source = "id", target = "basketId")
    @Mapping(source = "customerId", target = "customer")
    @Mapping(source = "products", target = "basketProductList")
    BasketDto toDto(Basket basket);

    @Mapping(source = "basketId", target = "id")
    @Mapping(source = "customer.customerId", target = "customerId")
    @Mapping(source = "basketProductList", target = "products")
    Basket toEntity(BasketDto dto);

    @Mapping(source = "customer.customerId", target = "customerId")
    BasketResponse toResponse(BasketDto dto);
}
