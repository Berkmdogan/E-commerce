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
    private int basketId;
    private  int status;
    private double totalPrice;
    private int customerId;
    private List<BasketProductDto>basketProductList;
}
