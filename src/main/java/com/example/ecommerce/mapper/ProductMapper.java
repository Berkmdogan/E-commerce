package com.example.ecommerce.mapper;



import com.example.ecommerce.dto.ProductDto;
import com.example.ecommerce.entity.Product;
import com.example.ecommerce.request.ProductRequest;
import com.example.ecommerce.response.ProductResponse;
import com.example.ecommerce.service.CategoryService;
import org.springframework.stereotype.Component;


@Component
public class ProductMapper {
    public static ProductDto toDto(ProductRequest productRequest) {
        return ProductDto.builder()
                .name(productRequest.getName())
                .description(productRequest.getDescription())
                .price(productRequest.getPrice())
                .categoryId(productRequest.getCategoryId())
                .build();
    }

    public static ProductResponse toResponse(ProductDto productDto) {
        return ProductResponse.builder()
                .id(productDto.getId())
                .name(productDto.getName())
                .description(productDto.getDescription())
                .price(productDto.getPrice())
                .categoryId(productDto.getCategoryId())
                .build();
    }
    public static Product toEntity(CategoryService categoryService , ProductDto productDto) {
        return Product.builder()
                .ProductId(productDto.getId())
                .name(productDto.getName())
                .description(productDto.getDescription())
                .price(productDto.getPrice())
                .category(categoryService.getEntity(productDto.getCategoryId()))
                .stock(productDto.getStock())
                .build();
    }

    public static ProductDto toDto(Product product) {
        return ProductDto.builder()
                .id(product.getProductId())
                .name(product.getName())
                .description(product.getDescription())
                .price(product.getPrice())
                .categoryId(product.getCategory().getCategoryId())
                .build();
    }
}
