package com.example.ecommerce.service;

import com.example.ecommerce.dto.CategoryDto;
import java.util.List;

public interface CategoryService {
    CategoryDto save(CategoryDto categoryDto);

    CategoryDto getCategory(Long id);

    List<CategoryDto> getAll();

    CategoryDto update(Long id, CategoryDto categoryDto);

    void delete(Long id);
}
