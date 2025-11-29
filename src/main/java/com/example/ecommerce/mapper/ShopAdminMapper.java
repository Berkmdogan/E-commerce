package com.example.ecommerce.mapper;

import com.example.ecommerce.dto.ShopAdminDto;
import com.example.ecommerce.entity.ShopAdmin;
import com.example.ecommerce.request.ShopAdminRequest;
import com.example.ecommerce.response.ShopAdminResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface ShopAdminMapper {

    ShopAdminDto toDto(ShopAdmin shopAdmin);

    ShopAdmin toEntity(ShopAdminDto dto);

    @Mapping(target = "shopAdminId", ignore = true)
    ShopAdminDto toDto(ShopAdminRequest request);

    @Mapping(source = "shopAdminId", target = "id")
    @Mapping(target = "code", ignore = true)
    @Mapping(target = "message", ignore = true)
    ShopAdminResponse toResponse(ShopAdminDto dto);

    @Mapping(target = "shopAdminId", ignore = true)
    void updateEntity(@MappingTarget ShopAdmin entity, ShopAdminDto dto);
}
