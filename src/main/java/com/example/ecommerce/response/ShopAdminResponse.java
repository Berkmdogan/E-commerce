package com.example.ecommerce.response;

import lombok.*;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ShopAdminResponse {
    private int code;
    private String message;
    private Long id;
    private String name;
    private String surname;
    private String email;
    private int phoneNumber;
    private String address;
    private String password;
    private String shopName;
}
