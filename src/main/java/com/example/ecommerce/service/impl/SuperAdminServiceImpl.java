package com.example.ecommerce.service.impl;

import com.example.ecommerce.dto.CategoryDto;
import com.example.ecommerce.dto.SuperAdminDto;
import com.example.ecommerce.entity.SuperAdmin;
import com.example.ecommerce.mapper.SuperAdminMapper;
import com.example.ecommerce.repository.SuperAdminRepository;
import com.example.ecommerce.service.CategoryService;
import com.example.ecommerce.service.SuperAdminService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class SuperAdminServiceImpl implements SuperAdminService {

    private final SuperAdminRepository superAdminRepository;
    private final SuperAdminMapper superAdminMapper; // INJECT EDİLDİ
    private final CategoryService categoryService;
    @Override
    public SuperAdminDto save(SuperAdminDto superAdminDto) {
        SuperAdmin superAdmin = superAdminMapper.toEntity(superAdminDto);
        superAdmin = superAdminRepository.save(superAdmin);
        return superAdminMapper.toDto(superAdmin);
    }

    @Override
    public SuperAdminDto get(Long id) {
        SuperAdmin superAdmin = superAdminRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("SuperAdmin not found"));
        return superAdminMapper.toDto(superAdmin);
    }

    @Override
    public List<SuperAdminDto> getAll() {
        return superAdminRepository.findAll().stream()
                .map(superAdminMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public void delete(Long id) {
        superAdminRepository.deleteById(id);
    }

    @Override
    public CategoryDto saveCategory(CategoryDto dto) {
        return categoryService.save(dto);
    }

    @Override
    public List<CategoryDto> getAllCategory() {
        return categoryService.getAll();
    }
}