package com.example.ecommerce.mapper;

import com.example.ecommerce.dto.ShopAdminDto;
import com.example.ecommerce.entity.ShopAdmin;
import com.example.ecommerce.request.ShopAdminRequest;
import com.example.ecommerce.response.ShopAdminResponse;

public class ShopAdminMapper {
    public static ShopAdminDto toDto(ShopAdminRequest shopAdminRequest) {
        return ShopAdminDto.builder()
                .name(shopAdminRequest.getName())
                .surname(shopAdminRequest.getSurname())
                .email(shopAdminRequest.getEmail())
                .phoneNumber(shopAdminRequest.getPhoneNumber())
                .address(shopAdminRequest.getAddress())
                .password(shopAdminRequest.getPassword())
                .shopName(shopAdminRequest.getShopName())
                .build();
    }

    public static ShopAdminResponse toResponse(ShopAdminDto shopAdminDto) {
        return ShopAdminResponse.builder()
                .id(shopAdminDto.getId())
                .name(shopAdminDto.getName())
                .surname(shopAdminDto.getSurname())
                .email(shopAdminDto.getEmail())
                .phoneNumber(shopAdminDto.getPhoneNumber())
                .address(shopAdminDto.getAddress())
                .password(shopAdminDto.getPassword())
                .shopName(shopAdminDto.getShopName())
                .build();
    }
    public static ShopAdmin toEntity(ShopAdminDto shopAdminDto) {
        return ShopAdmin.builder()
                .name(shopAdminDto.getName())
                .surname(shopAdminDto.getSurname())
                .email(shopAdminDto.getEmail())
                .phoneNumber(shopAdminDto.getPhoneNumber())
                .address(shopAdminDto.getAddress())
                .password(shopAdminDto.getPassword())
                .shopName(shopAdminDto.getShopName())
                .build();
    }

    public static ShopAdminDto toDto(ShopAdmin shopAdmin) {
        return ShopAdminDto.builder()
                .id(shopAdmin.getShopAdminId())
                .name(shopAdmin.getName())
                .surname(shopAdmin.getSurname())
                .email(shopAdmin.getEmail())
                .phoneNumber(shopAdmin.getPhoneNumber())
                .address(shopAdmin.getAddress())
                .password(shopAdmin.getPassword())
                .shopName(shopAdmin.getShopName())
                .build();
    }
}
