package com.example.ecommerce.dto;

import lombok.*;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SuperAdminDto {
    private Long superAdminId;
    private String username;
    private String password;
}
