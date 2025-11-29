package com.example.ecommerce.mapper;

import com.example.ecommerce.dto.CustomerDto;
import com.example.ecommerce.entity.Customer;
import com.example.ecommerce.request.CustomerRequest;
import com.example.ecommerce.response.CustomerResponse;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface CustomerMapper {

    CustomerDto toDto(Customer customer);

    Customer toEntity(CustomerDto dto);

    CustomerDto toDto(CustomerRequest request);

    CustomerResponse toResponse(CustomerDto dto);

    void updateEntity(@MappingTarget Customer entity, CustomerDto dto);
}
