package com.example.ecommerce.service;

import com.example.ecommerce.dto.CategoryDto;
import com.example.ecommerce.entity.Category;

import java.util.List;

public interface CategoryService {
    CategoryDto save(CategoryDto categoryDto);

    CategoryDto getCategory(Long id);

    Category getEntity(Long id);

    List<CategoryDto> getAll();

    CategoryDto update(Long id, CategoryDto categoryDto);

    void delete(Long id);
}
