package com.example.ecommerce.request;

import lombok.*;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SuperAdminRequest {
    private String username;
    private String password;
}
