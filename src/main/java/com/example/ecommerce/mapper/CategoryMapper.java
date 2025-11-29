package com.example.ecommerce.mapper;

import com.example.ecommerce.dto.CategoryDto;
import com.example.ecommerce.dto.CustomerDto;
import com.example.ecommerce.entity.Category;
import com.example.ecommerce.request.CategoryRequest;
import com.example.ecommerce.response.CategoryResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface CategoryMapper {

    @Mapping(target = "productDtos", ignore = true)
    CategoryDto toDto(Category category);

    @Mapping(target = "products", ignore = true)
    Category toEntity(CategoryDto categoryDto);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "productDtos", ignore = true)
    CategoryDto toDto(CategoryRequest request);

    @Mapping(target = "products", ignore = true)
    CategoryResponse toResponse(CategoryDto dto);

    @Mapping(target = "products", ignore = true)
    void updateEntity(@MappingTarget Category entity, CategoryDto dto);

    default CustomerDto map(Long customerId) {
        if (customerId == null) {
            return null;
        }
        return CustomerDto.builder().customerId(customerId).build();
    }
}