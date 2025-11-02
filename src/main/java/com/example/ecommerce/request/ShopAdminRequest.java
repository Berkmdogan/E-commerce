package com.example.ecommerce.request;

import lombok.*;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ShopAdminRequest {
    private String name;
    private String surname;
    private String email;
    private int phoneNumber;
    private String address;
    private String password;
    private String shopName;
}
