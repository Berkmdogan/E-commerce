package com.example.ecommerce.controller;



import com.example.ecommerce.dto.CategoryDto;
import com.example.ecommerce.mapper.CategoryMapper;
import com.example.ecommerce.request.CategoryRequest;
import com.example.ecommerce.response.CategoryResponse;
import com.example.ecommerce.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@RestController
@RequestMapping("/categories")
public class CategoryController {
    private final CategoryService categoryService;
    private final CategoryMapper CategoryMapper;

    @PostMapping("create")
    public ResponseEntity<CategoryResponse> createCategory(@RequestBody CategoryRequest categoryRequest) {
        CategoryDto categoryDto = CategoryMapper.toDto(categoryRequest);
        return ResponseEntity.ok(CategoryMapper.toResponse(categoryService.save(categoryDto)));
    }

    @PutMapping("{id}")
    public ResponseEntity<CategoryResponse> update(@PathVariable("id") Long categoryId, @RequestBody CategoryDto categoryDto) {
        CategoryDto category = categoryService.update(categoryId, categoryDto);
        return ResponseEntity.ok(CategoryMapper.toResponse(category));
    }

    @GetMapping("{id}")
    public ResponseEntity<CategoryResponse> getCategory(@PathVariable("id") Long id) {
        CategoryDto categoryDto = categoryService.getCategory(id);
        return ResponseEntity.ok(CategoryMapper.toResponse(categoryDto));
    }

    @GetMapping
    public ResponseEntity<List<CategoryResponse>> getAllCategories() {
        List<CategoryDto> categoryDtoList = categoryService.getAll();

        List<CategoryResponse> categoryResponseList = categoryDtoList.stream()
                .map(CategoryMapper::toResponse)
                .collect(Collectors.toList());

        return ResponseEntity.ok(categoryResponseList);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteCategory(@PathVariable("id") Long categoryId) {
        categoryService.delete(categoryId);
        return ResponseEntity.ok("Category deleted successfully");
    }

}
