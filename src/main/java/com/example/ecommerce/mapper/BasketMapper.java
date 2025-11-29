package com.example.ecommerce.mapper;

import com.example.ecommerce.dto.BasketDto;
import com.example.ecommerce.entity.Basket;
import com.example.ecommerce.response.BasketResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;


@Mapper(componentModel = "spring", uses = {BasketProductMapper.class, CustomerMapper.class})
public interface BasketMapper {

    BasketDto toDto(Basket basket);

    Basket toEntity(BasketDto dto);

    @Mapping(source = "customer.customerId", target = "customerId")
    BasketResponse toResponse(BasketDto dto);
}
