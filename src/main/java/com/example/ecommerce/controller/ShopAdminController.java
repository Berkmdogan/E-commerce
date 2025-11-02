package com.example.ecommerce.controller;

import com.example.ecommerce.dto.ShopAdminDto;
import com.example.ecommerce.mapper.ShopAdminMapper;
import com.example.ecommerce.request.ShopAdminRequest;
import com.example.ecommerce.response.ShopAdminResponse;
import com.example.ecommerce.service.ShopAdminService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@RestController
@RequestMapping("/shop-admin")
public class ShopAdminController {
    private final ShopAdminService shopAdminService;

    @PostMapping("create")
    public ResponseEntity<ShopAdminResponse> createShopAdmin(@RequestBody ShopAdminRequest shopAdminRequest) {
        ShopAdminDto shopAdminDto = ShopAdminMapper.toDto(shopAdminRequest);
        return ResponseEntity.ok(ShopAdminMapper.toResponse(shopAdminService.save(shopAdminDto)));
    }

    @PutMapping("{id}")
    public ResponseEntity<ShopAdminResponse> update(@PathVariable("id") Long shopAdminId, @RequestBody ShopAdminDto shopAdminDto) {
        ShopAdminDto updatedShopAdmin = shopAdminService.update(shopAdminDto, shopAdminId);
        return ResponseEntity.ok(ShopAdminMapper.toResponse(updatedShopAdmin));
    }

    @GetMapping("{id}")
    public ResponseEntity<ShopAdminResponse> getShopAdmin(@PathVariable("id") Long id) {
        ShopAdminDto shopAdminDto = shopAdminService.getShopAdmin(id);
        return ResponseEntity.ok(ShopAdminMapper.toResponse(shopAdminDto));
    }

    @GetMapping
    public ResponseEntity<List<ShopAdminResponse>> getAllShopAdmins() {
        List<ShopAdminDto> shopAdminDtoList = shopAdminService.getAllShopAdmin();
        List<ShopAdminResponse> shopAdminResponseList = shopAdminDtoList.stream()
                .map(ShopAdminMapper::toResponse)
                .collect(Collectors.toList());

        return ResponseEntity.ok(shopAdminResponseList);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteShopAdmin(@PathVariable("id") Long shopAdminId) {
        shopAdminService.delete(shopAdminId);
        return ResponseEntity.ok("ShopAdmin deleted successfully");
    }
}
