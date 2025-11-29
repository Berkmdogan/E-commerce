package com.example.ecommerce.service.impl;

import com.example.ecommerce.dto.ShopAdminDto;
import com.example.ecommerce.entity.ShopAdmin;
import com.example.ecommerce.mapper.ShopAdminMapper;
import com.example.ecommerce.repository.ShopAdminRepository;
import com.example.ecommerce.service.ShopAdminService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class ShopAdminServiceImpl implements ShopAdminService {

    private final ShopAdminRepository shopAdminRepository;
    private final ShopAdminMapper shopAdminMapper;

    @Override
    public ShopAdminDto save(ShopAdminDto shopAdminDto) {
        ShopAdmin shopAdmin = shopAdminMapper.toEntity(shopAdminDto);
        shopAdmin = shopAdminRepository.save(shopAdmin);
        return shopAdminMapper.toDto(shopAdmin);
    }

    @Override
    public ShopAdminDto getShopAdmin(Long id) {
        ShopAdmin shopAdmin = shopAdminRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("ShopAdmin not found"));
        return shopAdminMapper.toDto(shopAdmin);
    }

    @Override
    public List<ShopAdminDto> getAllShopAdmin() {
        return shopAdminRepository.findAll().stream()
                .map(shopAdminMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public ShopAdminDto update(ShopAdminDto shopAdminDto, Long id) {
        ShopAdmin shopAdmin = shopAdminRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("ShopAdmin not found"));

        shopAdminMapper.updateEntity(shopAdmin, shopAdminDto);

        shopAdmin = shopAdminRepository.save(shopAdmin);
        return shopAdminMapper.toDto(shopAdmin);
    }

    @Override
    public void delete(Long id) {
        shopAdminRepository.deleteById(id);
    }
}