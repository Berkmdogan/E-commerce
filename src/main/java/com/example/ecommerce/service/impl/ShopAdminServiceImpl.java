package com.example.ecommerce.service.impl;

import com.example.ecommerce.dto.ProductDto;
import com.example.ecommerce.dto.ShopAdminDto;
import com.example.ecommerce.entity.ShopAdmin;
import com.example.ecommerce.mapper.ShopAdminMapper;
import com.example.ecommerce.repository.ShopAdminRepository;
import com.example.ecommerce.service.ShopAdminService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class ShopAdminServiceImpl implements ShopAdminService {

    private final ShopAdminRepository shopAdminRepository;

    @Override
    public ShopAdminDto save(ShopAdminDto shopAdminDto) {
        ShopAdmin shopAdmin = ShopAdminMapper.toEntity(shopAdminDto);
        shopAdmin = shopAdminRepository.save(shopAdmin);
        return ShopAdminMapper.toDto(shopAdmin);
    }

    @Override
    public ShopAdminDto getShopAdmin(Long id) {
        Optional<ShopAdmin> shopAdmin = shopAdminRepository.findById(id);
        return shopAdmin.map(ShopAdminMapper::toDto).orElse(null);
    }

    @Override
    public List<ShopAdminDto> getAllShopAdmin() {
        List<ShopAdmin> shopAdmins = shopAdminRepository.findAll();
        return shopAdmins.stream().map(ShopAdminMapper::toDto).collect(Collectors.toList());
    }

    @Override
    public ShopAdminDto update(ShopAdminDto shopAdminDto, Long id) {
        ShopAdmin shopAdmin = shopAdminRepository.findById(id)
                .map(existingShopAdmin -> {
                    existingShopAdmin.setName(shopAdminDto.getName());
                    existingShopAdmin.setSurname(shopAdminDto.getSurname());
                    existingShopAdmin.setEmail(shopAdminDto.getEmail());
                    existingShopAdmin.setPhoneNumber(shopAdminDto.getPhoneNumber());
                    existingShopAdmin.setAddress(shopAdminDto.getAddress());
                    existingShopAdmin.setPassword(shopAdminDto.getPassword());
                    existingShopAdmin.setShopName(shopAdminDto.getShopName());
                    return existingShopAdmin;
                })
                .orElseThrow(() -> new RuntimeException("ShopAdmin not found"));

        shopAdmin = shopAdminRepository.save(shopAdmin);
        return ShopAdminMapper.toDto(shopAdmin);
    }

    @Override
    public void delete(Long id) {
        shopAdminRepository.deleteById(id);
    }


    @Override
    public ProductDto addProduct(ProductDto productDto) {

        return null;
    }

    @Override
    public List<ProductDto> getAllProducts() {

        return null;
    }
}
