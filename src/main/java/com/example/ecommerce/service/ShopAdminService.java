package com.example.ecommerce.service;

import com.example.ecommerce.dto.ShopAdminDto;

import java.util.List;

public interface ShopAdminService {
    ShopAdminDto save(ShopAdminDto shopAdminDto);

    ShopAdminDto getShopAdmin(Long id);

    List<ShopAdminDto> getAllShopAdmin();

    ShopAdminDto update(ShopAdminDto shopAdminDto, Long id);

    void delete(Long id);
}
