package com.example.ecommerce.mapper;

import com.example.ecommerce.dto.ProductDto;
import com.example.ecommerce.entity.Product;
import com.example.ecommerce.request.ProductRequest;
import com.example.ecommerce.response.ProductResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface ProductMapper {


    ProductDto toDto(Product product);

    Product toEntity(ProductDto productDto);

    ProductDto toDto(ProductRequest request);

    ProductResponse toResponse(ProductDto dto);

    @Mapping(target = "id", ignore = true)
    void updateEntity(@MappingTarget Product entity, ProductDto dto);
}
