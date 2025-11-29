package com.example.ecommerce.request;

import com.example.ecommerce.dto.BasketDto;
import com.example.ecommerce.dto.BasketProductDto;
import com.example.ecommerce.dto.CustomerDto;
import com.example.ecommerce.dto.ProductDto;
import com.example.ecommerce.entity.BasketProduct;
import lombok.*;

import java.util.ArrayList;
import java.util.List;


@Builder
@Data
@NoArgsConstructor // Lombok Builder ile Data kullanıldığı için eklendi
@AllArgsConstructor // Lombok Builder ile Data kullanıldığı için eklendi
public class BasketRequest {

    private Long customerId; // int -> Long olarak düzeltildi
    private Long productId;  // int -> Long olarak düzeltildi
    private int count;

    public BasketDto toDto(){
        // ProductDto'nun id'si Long olduğu için Long ile oluşturmalıyız.
        ProductDto productDto = ProductDto.builder().id(productId).build();

        BasketProductDto dto = BasketProductDto.builder()
                .product(productDto)
                .count(count)
                .basketProductAmount(0.0) // İlk oluşturmada 0.0 olabilir
                .build();

        List<BasketProductDto> dtoList = new ArrayList<>();
        dtoList.add(dto);

        return BasketDto.builder()
                .customer(CustomerDto.builder().customerId(customerId).build())
                .basketProductList(dtoList)
                .build();
    }
}
