package com.example.ecommerce.mapper;

import com.example.ecommerce.dto.BasketProductDto;
import com.example.ecommerce.entity.BasketProduct;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {ProductMapper.class})
public interface BasketProductMapper {


    @Mapping(source = "totalPrice", target = "basketProductAmount")
    BasketProductDto toDto(BasketProduct basketProduct);


    @Mapping(source = "basketProductAmount", target = "totalPrice")
    BasketProduct toEntity(BasketProductDto dto);
}
