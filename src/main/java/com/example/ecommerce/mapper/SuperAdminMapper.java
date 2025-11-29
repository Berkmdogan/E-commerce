package com.example.ecommerce.mapper;

import com.example.ecommerce.dto.SuperAdminDto;
import com.example.ecommerce.entity.SuperAdmin;
import com.example.ecommerce.request.SuperAdminRequest;
import com.example.ecommerce.response.SuperAdminResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface SuperAdminMapper {

    SuperAdminDto toDto(SuperAdmin superAdmin);

    SuperAdmin toEntity(SuperAdminDto dto);

    @Mapping(target = "superAdminId", ignore = true)
    SuperAdminDto toDto(SuperAdminRequest request);

    SuperAdminResponse toResponse(SuperAdminDto dto);

    void updateEntity(@MappingTarget SuperAdmin entity, SuperAdminDto dto);
}
