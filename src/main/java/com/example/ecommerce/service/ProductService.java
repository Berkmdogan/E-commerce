package com.example.ecommerce.service;



import com.example.ecommerce.dto.ProductDto;

import java.util.List;

public interface ProductService {
    ProductDto save(ProductDto productDto);

    ProductDto getProduct(Long id);

    List<ProductDto> getAll();

    ProductDto update(Long id, ProductDto productDto);

    void  delete(Long id);
}
