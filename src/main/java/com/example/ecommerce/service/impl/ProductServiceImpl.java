package com.example.ecommerce.service.impl;

import com.example.ecommerce.dto.ProductDto;
import com.example.ecommerce.entity.Category;
import com.example.ecommerce.entity.Product;
import com.example.ecommerce.mapper.ProductMapper;
import com.example.ecommerce.repository.CategoryRepository;
import com.example.ecommerce.repository.ProductRepository;
import com.example.ecommerce.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;
    private final ProductMapper productMapper;

    @Override
    @Transactional
    public ProductDto save(ProductDto productDto) {
        // 1. Önce Kategori var mı diye kontrol ediyoruz
        Category category = categoryRepository.findById(productDto.getCategoryId())
                .orElseThrow(() -> new RuntimeException("Kategori bulunamadı! ID: " + productDto.getCategoryId()));

        // 2. DTO -> Entity dönüşümü
        Product product = productMapper.toEntity(productDto);

        // 3. İlişkiyi set ediyoruz (Entity'deki Category objesini set etmeliyiz)
        product.setCategory(category);

        // 4. Kayıt
        Product savedProduct = productRepository.save(product);

        return productMapper.toDto(savedProduct);
    }

    @Override
    public ProductDto getProduct(Long id) { // Sadece Long parametreli metot kaldı
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Ürün bulunamadı! ID: " + id));
        return productMapper.toDto(product);
    }

    @Override
    public List<ProductDto> getAll() {
        return productRepository.findAll().stream()
                .map(productMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional
    public ProductDto update(Long id, ProductDto productDto) {
        Product existingProduct = productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Güncellenecek ürün bulunamadı! ID: " + id));

        // 1. MapStruct ile temel alanları güncelle
        productMapper.updateEntity(existingProduct, productDto);

        // 2. Eğer kategori değiştiyse veya null değilse güncelle
        if (productDto.getCategoryId() != null) {
            // Mevcut kategorisi ile yeni gelen kategori ID farklıysa:
            if (existingProduct.getCategory() == null || !existingProduct.getCategory().getId().equals(productDto.getCategoryId())) {
                Category newCategory = categoryRepository.findById(productDto.getCategoryId())
                        .orElseThrow(() -> new RuntimeException("Yeni kategori bulunamadı!"));
                existingProduct.setCategory(newCategory);
            }
        }

        Product updatedProduct = productRepository.save(existingProduct);
        return productMapper.toDto(updatedProduct);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        if (!productRepository.existsById(id)) {
            throw new RuntimeException("Silinecek ürün bulunamadı! ID: " + id);
        }
        productRepository.deleteById(id);
    }
}


