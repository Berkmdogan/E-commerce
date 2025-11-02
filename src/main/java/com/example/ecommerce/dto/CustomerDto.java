package com.example.ecommerce.dto;

import lombok.*;

import java.util.List;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CustomerDto {
    private int customerId;
    private String name;
    private String surname;
    private String email;
    private int phoneNumber;
    private String address;
    private String password;
    private List<BasketDto> basketList;
}
