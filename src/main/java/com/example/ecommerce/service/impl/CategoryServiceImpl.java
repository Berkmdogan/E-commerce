package com.example.ecommerce.service.impl;


import com.example.ecommerce.dto.CategoryDto;
import com.example.ecommerce.exception.RecordNotFoundExceptions;
import com.example.ecommerce.mapper.CategoryMapper;
import com.example.ecommerce.repository.CategoryRepository;
import com.example.ecommerce.service.CategoryService;

import jdk.jfr.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private CategoryRepository repository;
    @Autowired
    @Lazy
    private CategoryMapper categoryMapper;

    public CategoryServiceImpl(CategoryRepository repository, CategoryMapper categoryMapper) {
        this.repository = repository;
        this.categoryMapper = categoryMapper;
    }

    public CategoryDto save(CategoryDto dto) {
        return  categoryMapper.entityToDto(repository.save(categoryMapper.dtoToEntity(dto)));
    }
    @Override
    public CategoryDto get(String id) {
        return categoryMapper.entityToDto((com.example.ecommerce.entity.Category) repository.findById(Long.parseLong(id))
                .orElseThrow(()-> new RecordNotFoundExceptions(4000,"Category not found with id"+id)));
    }

    public void delete(String id) {
        repository.deleteById(Long.parseLong(id));
    }

    public CategoryDto update(String id, CategoryDto dto) {
        // String id'yi Long id'ye çeviriyoruz ve kategori var mı diye kontrol ediyoruz
        Category existCategory = repository.findById(Long.parseLong(id))
                .orElseThrow(()-> new RecordNotFoundExceptions(4000, "Category not found with id"+id));

        // Mevcut kategori bilgilerini dto'dan gelen bilgilerle güncelliyoruz
        Category updateCategory = (Category) categoryMapper.dtoToEntity(dto);
        ((com.example.ecommerce.entity.Category) updateCategory).setId(existCategory.getId());// ID'nin korunması gerekebilir, çünkü yeni bir entity yaratıyoruz


        return categoryMapper.entityToDto((com.example.ecommerce.entity.Category) repository.save(updateCategory));
    }

    @Override
    public List<CategoryDto> getAll() {
        List<CategoryDto> categoryDtoList = new ArrayList<>();

        for(Category category: repository.findAll()){
            categoryDtoList.add(categoryMapper.entityToDto((com.example.ecommerce.entity.Category) category));
        }
        return categoryDtoList;
    }

    public com.example.ecommerce.entity.Category findCategoryById(Long categoryId){
        if(categoryId == null){
            throw  new IllegalArgumentException("The given id must not be null");
        }
        return (com.example.ecommerce.entity.Category) repository.findById(categoryId).orElseThrow();    }





}
