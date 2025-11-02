package com.example.ecommerce.mapper;

import com.example.ecommerce.dto.SuperAdminDto;
import com.example.ecommerce.entity.SuperAdmin;
import com.example.ecommerce.request.SuperAdminRequest;
import com.example.ecommerce.response.SuperAdminResponse;

public class SuperAdminMapper {
    public static SuperAdminDto toDto(SuperAdminRequest superAdminRequest) {
        return SuperAdminDto.builder()
                .superAdminId(superAdminRequest.getSuperAdminId())
                .username(superAdminRequest.getUsername())
                .password(superAdminRequest.getPassword())
                .build();
    }

    public static SuperAdminResponse toResponse(SuperAdminDto superAdminDto) {
        return SuperAdminResponse.builder()
                .superAdminId(superAdminDto.getSuperAdminId())
                .username(superAdminDto.getUsername())
                .password(superAdminDto.getPassword())
                .build();
    }
    public static SuperAdminDto toDto(SuperAdmin superAdmin) {
        return SuperAdminDto.builder()
                .superAdminId(superAdmin.getSuperAdminId())
                .username(superAdmin.getUsername())
                .password(superAdmin.getPassword())
                .build();
    }

    public static SuperAdmin toEntity(SuperAdminDto superAdminDto) {
        return SuperAdmin.builder()
                .superAdminId(superAdminDto.getSuperAdminId())
                .username(superAdminDto.getUsername())
                .password(superAdminDto.getPassword())
                .build();
    }
}
