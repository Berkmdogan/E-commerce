package com.example.ecommerce.mapper;

import com.example.ecommerce.dto.CategoryDto;
import com.example.ecommerce.entity.Category;
import com.example.ecommerce.request.CategoryRequest;
import com.example.ecommerce.response.CategoryResponse;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface CategoryMapper {


    CategoryDto toDto(Category category);


    Category toEntity(CategoryDto categoryDto);


    CategoryDto toDto(CategoryRequest request);


    CategoryResponse toResponse(CategoryDto dto);


    void updateEntity(@MappingTarget Category entity, CategoryDto dto);
}
