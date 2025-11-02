package com.example.ecommerce.service;

import com.example.ecommerce.dto.CategoryDto;
import com.example.ecommerce.dto.SuperAdminDto;

import java.util.List;

public interface SuperAdminService {

    SuperAdminDto save(SuperAdminDto superAdminDto);

    SuperAdminDto get(Long id);

    CategoryDto saveCategory(CategoryDto dto);

    List<CategoryDto> getAllCategory();

    List<SuperAdminDto> getAll();

    void delete(Long id);
}
