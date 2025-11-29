package com.example.ecommerce.controller;


import com.example.ecommerce.dto.ProductDto;
import com.example.ecommerce.mapper.ProductMapper;
import com.example.ecommerce.request.ProductRequest;
import com.example.ecommerce.response.ProductResponse;
import com.example.ecommerce.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;


@RequiredArgsConstructor
@RestController
@RequestMapping("products")
public class ProductController {
    private final ProductService productService;
    private final ProductMapper ProductMapper;

    @PostMapping("create")
    public ResponseEntity<ProductResponse> createProduct(@RequestBody ProductRequest productRequest) {
        ProductDto productDto = ProductMapper.toDto(productRequest);
        return ResponseEntity.ok(ProductMapper.toResponse(productService.save(productDto)));
    }

    @PutMapping("{id}")
    public ResponseEntity<ProductResponse> update(@PathVariable("id") Long id, @RequestBody ProductRequest productRequest) { // ProductRequest kullanıldı
        ProductDto productDto = ProductMapper.toDto(productRequest);
        ProductDto updatedProduct = productService.update(id, productDto);
        return ResponseEntity.ok(ProductMapper.toResponse(updatedProduct));
    }

    @GetMapping("{id}")
    public ResponseEntity<ProductResponse> getProduct(@PathVariable("id") Long id) {
        ProductDto productDto = productService.getProduct(id);
        return ResponseEntity.ok(ProductMapper.toResponse(productDto));
    }

    @GetMapping
    public ResponseEntity<List<ProductResponse>> getAllProducts() {
        List<ProductDto> productDtoList = productService.getAll();
        List<ProductResponse> productResponseList = productDtoList.stream()
                .map(ProductMapper::toResponse)
                .collect(Collectors.toList());

        return ResponseEntity.ok(productResponseList);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteProduct(@PathVariable("id") Long id) {
        productService.delete(id);
        return ResponseEntity.ok("Product deleted successfully");
    }
}
