package com.example.ecommerce.response;


import com.example.ecommerce.dto.BasketProductDto;
import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BasketResponse  {
    private Long basketId;
    private  int status;
    private double totalPrice;
    private Long customerId;
    private List<BasketProductDto>basketProductList;
}
