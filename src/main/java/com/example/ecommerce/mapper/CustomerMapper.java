package com.example.ecommerce.mapper;

import com.example.ecommerce.dto.CustomerDto;
import com.example.ecommerce.dto.ShopAdminDto;
import com.example.ecommerce.entity.Customer;
import com.example.ecommerce.entity.ShopAdmin;
import com.example.ecommerce.request.CustomerRequest;
import com.example.ecommerce.request.ShopAdminRequest;
import com.example.ecommerce.response.CustomerResponse;
import com.example.ecommerce.response.ShopAdminResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface CustomerMapper {

    default CustomerDto map(Long customerId) {
        if (customerId == null) {
            return null;
        }
        return CustomerDto.builder().customerId(customerId).build();
    }

    @Mapping(target = "basketList", ignore = true)
    CustomerDto toDto(Customer customer);

    Customer toEntity(CustomerDto dto);

    @Mapping(target = "customerId", ignore = true)
    @Mapping(target = "basketList", ignore = true)
    CustomerDto toDto(CustomerRequest request);

    @Mapping(source = "customerId", target = "customerId")
    @Mapping(target = "code", ignore = true)
    @Mapping(target = "message", ignore = true)
    CustomerResponse toResponse(CustomerDto dto);

    @Mapping(target = "customerId", ignore = true)
    void updateEntity(@MappingTarget Customer entity, CustomerDto dto);
}
