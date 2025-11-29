package com.example.ecommerce.mapper;

import com.example.ecommerce.dto.ShopAdminDto;
import com.example.ecommerce.entity.ShopAdmin;
import com.example.ecommerce.request.ShopAdminRequest;
import com.example.ecommerce.response.ShopAdminResponse;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface ShopAdminMapper {

    ShopAdminDto toDto(ShopAdmin shopAdmin);

    ShopAdmin toEntity(ShopAdminDto dto);

    ShopAdminDto toDto(ShopAdminRequest request);

    ShopAdminResponse toResponse(ShopAdminDto dto);

    void updateEntity(@MappingTarget ShopAdmin entity, ShopAdminDto dto);
}
