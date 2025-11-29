package com.example.ecommerce.response;

import lombok.*;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CustomerResponse {
    private Long customerId;
    private int code;
    private String message;
    private String name;
    private String surname;
    private String email;
    private int phoneNumber;
    private String address;
    private String password;
}
