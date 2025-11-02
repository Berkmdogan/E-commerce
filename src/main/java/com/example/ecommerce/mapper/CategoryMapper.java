package com.example.ecommerce.mapper;




import com.example.ecommerce.dto.CategoryDto;
import com.example.ecommerce.entity.Category;
import com.example.ecommerce.request.CategoryRequest;
import com.example.ecommerce.response.CategoryResponse;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;


@Component
public class CategoryMapper {

    public static CategoryDto toDto(CategoryRequest categoryRequest) {
        return CategoryDto.builder()
                .name(categoryRequest.getName())
                .description(categoryRequest.getDescription())
                .build();
    }

    public static CategoryResponse toResponse(CategoryDto categoryDto) {
        return CategoryResponse.builder()
                .id(categoryDto.getId())
                .name(categoryDto.getName())
                .description(categoryDto.getDescription())
                .productDtos(categoryDto.getProductDtos())
                .build();
    }
    public static Category toEntity(CategoryDto categoryDto) {

        Category category=new Category();
        category.setName(categoryDto.getName());
        category.setDescription(categoryDto.getDescription());

        return category;
    }

    public static CategoryDto toDto(Category category) {
        return CategoryDto.builder()
                .id(category.getCategoryId())
                .name(category.getName())
                .description(category.getDescription())
                .build();
    }

}
